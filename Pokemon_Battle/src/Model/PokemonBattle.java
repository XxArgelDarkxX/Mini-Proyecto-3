package Model;

import java.util.ArrayList;

/**
 * Manages Pokémon battle logic including:
 * - Turn order based on Pokémon speed
 * - Move execution and effects
 * - Battle outcome determination
 */
public class PokemonBattle {
    private final Trainer[] trainers;
    private final ArrayList<Pokemon> battlingPokemons;
    private byte trainer1Move = -1;
    private byte trainer2Move = -1;
    private byte trainer1CurrentIndex = 0;
    private byte trainer2CurrentIndex = 0;
    
    /**
     * Initializes a new battle between two trainers
     * @param trainers Array of exactly 2 trainers
     * @param initialPokemons Array of exactly 2 Pokémon (one for each trainer)
     * @throws IllegalArgumentException if parameters are invalid
     */
    public PokemonBattle(Trainer[] trainers, Pokemon[] initialPokemons) {
        if (trainers == null || trainers.length != 2 || 
            initialPokemons == null || initialPokemons.length != 2) {
            throw new IllegalArgumentException("Requires exactly 2 trainers and 2 Pokémon");
        }
        
        this.trainers = trainers;
        this.battlingPokemons = new ArrayList<>(2);
        this.battlingPokemons.add(initialPokemons[0]);
        this.battlingPokemons.add(initialPokemons[1]);
        
        initializeCurrentPokemonIndexes();
    }
    
    private void initializeCurrentPokemonIndexes() {
        trainer1CurrentIndex = findPokemonIndex(0, battlingPokemons.get(0));
        trainer2CurrentIndex = findPokemonIndex(1, battlingPokemons.get(1));
    }
    
    private byte findPokemonIndex(int trainer, Pokemon pokemon) {
        for (byte i = 0; i < trainers[trainer].getPokemonTeam().size(); i++) {
            if (pokemon.equals(trainers[trainer].getPokemonTeam().get(i))) {
                return i;
            }
        }
        throw new IllegalArgumentException("Pokémon not found in trainer's team");
    }
    
    /**
     * Selects a new Pokémon for a trainer
     * @param trainer 0 for first trainer, 1 for second
     * @param pokemonIndex Index in trainer's team
     */
    public void selectPokemon(int trainer, int pokemonIndex) {
        validateTrainerIndex(trainer);
        
        if (trainer == 0) {
            trainer1CurrentIndex = (byte) pokemonIndex;
            battlingPokemons.set(0, getCurrentPokemon(0));
        } else {
            trainer2CurrentIndex = (byte) pokemonIndex;
            battlingPokemons.set(1, getCurrentPokemon(1));
        }
    }
    
    private void validateTrainerIndex(int trainer) {
        if (trainer != 0 && trainer != 1) {
            throw new IllegalArgumentException("Trainer index must be 0 or 1");
        }
    }
    
    public void setMoveTrainer1(byte move) {
        this.trainer1Move = move;
    }
    
    public void setMoveTrainer2(byte move) {
        this.trainer2Move = move;
    }
    
    /**
     * Executes a battle turn based on Pokémon speed
     * @return Result of the turn including HP changes and fainting status
     */
    public BattleResult executeTurn() {
        if (trainer1Move == -1 || trainer2Move == -1) {
            throw new IllegalStateException("Both trainers must select a move first");
        }
        
        Pokemon pokemon1 = getCurrentPokemon(0);
        Pokemon pokemon2 = getCurrentPokemon(1);
        BattleResult result = new BattleResult();
        
        if (pokemon1.getSpeed() >= pokemon2.getSpeed()) {
            executeAttack(pokemon1, pokemon2, trainer1Move, result, true);
            if (!result.isPokemon2Fainted()) {
                executeAttack(pokemon2, pokemon1, trainer2Move, result, false);
            }
        } else {
            executeAttack(pokemon2, pokemon1, trainer2Move, result, false);
            if (!result.isPokemon1Fainted()) {
                executeAttack(pokemon1, pokemon2, trainer1Move, result, true);
            }
        }
        
        // Reset moves for next turn
        trainer1Move = -1;
        trainer2Move = -1;
        
        return result;
    }
    
    private void executeAttack(Pokemon attacker, Pokemon defender, byte move, 
                             BattleResult result, boolean isTrainer1Attacking) {
        attacker.executeMove(defender, move);
        
        if (isTrainer1Attacking) {
            result.setPokemon2HP(defender.getHp());
            if (defender.getHp() <= 0) {
                defender.setHp((short) 0);
                result.setPokemon2Fainted(true);
            }
        } else {
            result.setPokemon1HP(defender.getHp());
            if (defender.getHp() <= 0) {
                defender.setHp((short) 0);
                result.setPokemon1Fainted(true);
            }
        }
    }
    
    public boolean isBattleOver() {
        return !trainerHasLivePokemon(0) || !trainerHasLivePokemon(1);
    }
    
    private boolean trainerHasLivePokemon(int trainer) {
        for (Pokemon pokemon : trainers[trainer].getPokemonTeam()) {
            if (pokemon.getHp() > 0) {
                return true;
            }
        }
        return false;
    }
    
    public String getWinnerName() {
        if (!isBattleOver()) {
            return null;
        }
        return trainerHasLivePokemon(0) ? trainers[0].getName() : trainers[1].getName();
    }
    
    // Getters
    public Trainer[] getTrainers() { return trainers; }
    public ArrayList<Pokemon> getBattlingPokemons() { return battlingPokemons; }
    public byte getCurrentPokemonIndex(int trainer) { 
        return trainer == 0 ? trainer1CurrentIndex : trainer2CurrentIndex; 
    }
    public Pokemon getCurrentPokemon(int trainer) { 
        return trainers[trainer].getPokemonTeam().get(
            trainer == 0 ? trainer1CurrentIndex : trainer2CurrentIndex
        ); 
    }
}

class BattleResult {
    private int pokemon1HP;
    private int pokemon2HP;
    private boolean pokemon1Fainted;
    private boolean pokemon2Fainted;
    
    public int getPokemon1HP() { return pokemon1HP; }
    public void setPokemon1HP(int hp) { this.pokemon1HP = hp; }
    public int getPokemon2HP() { return pokemon2HP; }
    public void setPokemon2HP(int hp) { this.pokemon2HP = hp; }
    public boolean isPokemon1Fainted() { return pokemon1Fainted; }
    public void setPokemon1Fainted(boolean fainted) { this.pokemon1Fainted = fainted; }
    public boolean isPokemon2Fainted() { return pokemon2Fainted; }
    public void setPokemon2Fainted(boolean fainted) { this.pokemon2Fainted = fainted; }
}
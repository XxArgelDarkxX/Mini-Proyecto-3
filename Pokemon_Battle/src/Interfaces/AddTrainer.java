package Interfaces;
import Data.Data;
import Entrenador.Trainer;
import Pokemon.Pokemon;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.Color;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class AddTrainer extends javax.swing.JFrame {

    private Clip musicaFondo; // Variable para controlar la música

    // Método para iniciar la música de fondo
    private void iniciarMusicaFondo() {
        try {
            // Carga el archivo de música desde recursos
            InputStream audioSrc = getClass().getResourceAsStream("Pokemon-RubySapphireEmerald-Pokemon-Center.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(new BufferedInputStream(audioSrc));
            
            musicaFondo = AudioSystem.getClip();
            musicaFondo.open(audioStream);
            musicaFondo.loop(Clip.LOOP_CONTINUOUSLY); // Repite continuamente
            
        } catch (Exception e) {
            System.out.println("Error al cargar música: " + e.getMessage());
        }
    }

    // Método para detener la música al cerrar la ventana
    private void detenerMusicaFondo() {
        if (musicaFondo != null && musicaFondo.isRunning()) {
            musicaFondo.stop();
            musicaFondo.close();
        }
    }

    Trainer[] trainers = new Trainer[2];
    Data data = new Data();
    Pokemon pokemon = new Pokemon();

    public AddTrainer() {
        initComponents();
        iniciarMusicaFondo();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        trainerBox1 = new javax.swing.JTextField();
        trainer1 = new javax.swing.JLabel();
        trainer2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        title.setBackground(new java.awt.Color(255, 255, 255));
        title.setFont(new java.awt.Font("Roboto", 2, 18)); // NOI18N
        title.setForeground(new java.awt.Color(50, 50, 50));
        title.setText("Agregue los nombres de los entrenadores");
        title.setToolTipText("");
        title.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextField1.setForeground(new java.awt.Color(50, 50, 50));
        jTextField1.setToolTipText("Your name");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 113, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("2094425.png"))); // NOI18N
        image.setText("jLabel2");

        addButton.setBackground(new java.awt.Color(224, 255, 255));
        addButton.setForeground(new java.awt.Color(50, 50, 50));
        addButton.setText("Agregar");
        addButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addButtonMouseExited(evt);
            }
        });
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        trainerBox1.setForeground(new java.awt.Color(50, 50, 50));
        trainerBox1.setToolTipText("Your name");
        trainerBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                trainerBox1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                trainerBox1FocusLost(evt);
            }
        });
        trainerBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainerBox1ActionPerformed(evt);
            }
        });

        trainer1.setText("Entrenador 1°");

        trainer2.setText("Entrenador 2°");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(image, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(title))
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(48, 48, 48)
                                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(trainer2)
                                                                        .addComponent(trainer1))
                                                                .addGap(48, 48, 48)
                                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(175, 175, 175)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(trainerBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(image)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(title)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(trainer1)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(trainer2)
                                        .addComponent(trainerBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addGap(27, 27, 27))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {



    }

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {
        trainers[0] = new Trainer();
        String nombreEntrenador1 = jTextField1.getText().trim();
        trainers[0].setName(nombreEntrenador1);
    }

    private void trainerBox1FocusGained(java.awt.event.FocusEvent evt) {
        // TODO add your handling code here:
    }

    private void trainerBox1FocusLost(java.awt.event.FocusEvent evt) {
        trainers[1] = new Trainer();
        String nombreEntrenador2 = trainerBox1.getText().trim();
        trainers[1].setName(nombreEntrenador2);
    }

    private void trainerBox1ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        String nombreEntrenador1 = jTextField1.getText().trim();
        String nombreEntrenador2 = trainerBox1.getText().trim();

        if(nombreEntrenador1.isEmpty() || nombreEntrenador2.isEmpty()){
            JOptionPane.showMessageDialog(null, "El entrenador no puede estar vacio");
        }else if(nombreEntrenador1.equals(nombreEntrenador2)){
            JOptionPane.showMessageDialog(null, "El entrenador ya existe");
        }else{
            // Actualizar los objetos entrenador
            trainers[0].setName(nombreEntrenador1);
            trainers[1].setName(nombreEntrenador2);
            //agregar los pokemones
            data.initializeData();
            trainers[0].setRandomPokemonTeam(data.getPokemons());
            trainers[1].setRandomPokemonTeam(data.getPokemons());

            //se abre la otra ventana de pokemon
            detenerMusicaFondo(); // Detener la música de fondo

            this.dispose();
            Pokemons vista = new Pokemons(trainers);
            vista.setVisible(true);
        }

    }

    private void addButtonMouseEntered(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        addButton.setBackground(new Color (135, 206, 250));
    }

    private void addButtonMouseExited(java.awt.event.MouseEvent evt) {
        // TODO add your handling code here:
        addButton.setBackground(new Color (224, 255, 255));
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddTrainer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddTrainer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addButton;
    private javax.swing.JTextField trainerBox1;
    private javax.swing.JLabel trainer1;
    private javax.swing.JLabel trainer2;
    private javax.swing.JLabel image;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel title;
    // End of variables declaration                   
}

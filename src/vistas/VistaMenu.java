/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author grace
 */
public class VistaMenu extends javax.swing.JDialog {
 barra musica = new barra();
    String nombresonido ="src/musica/juego-de-tronos-2.wav";
    Clip clip = null;
      
      
    public VistaMenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
     
         initComponents();
         
         ImageIcon de = new ImageIcon("C:\\Users\\edgar\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\ayuda\\menu.gif");
         Icon ide = new ImageIcon(de.getImage().getScaledInstance(Jgiff.getWidth(), Jgiff.getHeight(), Image.SCALE_DEFAULT));
         Jgiff.setIcon(ide);
         ImageIcon d = new ImageIcon("C:\\Users\\edgar\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\ayuda\\j_1.png");
        Icon id = new ImageIcon(d.getImage().getScaledInstance(lb3.getWidth(), lb3.getHeight(), Image.SCALE_DEFAULT));
        lb3.setIcon(id);
         ImageIcon dee = new ImageIcon("C:\\Users\\edgar\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\ayuda\\sin.png");
        Icon idd = new ImageIcon(dee.getImage().getScaledInstance(lb4.getWidth(), lb4.getHeight(), Image.SCALE_DEFAULT));
        lb4.setIcon(idd);
         this.repaint();
         this.setLocationRelativeTo(this);
        
            try {
                clip = AudioSystem.getClip();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
           
                AudioInputStream audioInputStream =null;
            try {
                try {
                    audioInputStream = AudioSystem.getAudioInputStream(new File(nombresonido).getAbsoluteFile());
                } catch (IOException ex) {
                    Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(VistaInicial.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                clip.open(audioInputStream);
            } catch (LineUnavailableException ex) {
                Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
                clip.start();
    
    }
       
    

    VistaMenu() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lb3 = new javax.swing.JLabel();
        lb4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Jgiff = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        lb3.setBackground(new java.awt.Color(51, 51, 255));
        lb3.setFont(new java.awt.Font("Yu Gothic UI Light", 3, 18)); // NOI18N
        lb3.setForeground(new java.awt.Color(255, 255, 255));
        lb3.setText("Mute");
        lb3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb3MouseClicked(evt);
            }
        });
        getContentPane().add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 50, 40));

        lb4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lb4MouseClicked(evt);
            }
        });
        getContentPane().add(lb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 50, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("        Iniciar Juego");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 230, 50));
        getContentPane().add(Jgiff, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lb3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb3MouseClicked
            try {                                     
                clip.stop();
               
                
                try {
                    clip = AudioSystem.getClip();
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                AudioInputStream audioInputStream =null;
                try {
                    try {
                        audioInputStream = AudioSystem.getAudioInputStream(new File(nombresonido).getAbsoluteFile());
                    } catch (IOException ex) {
                        Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(VistaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
         Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }//GEN-LAST:event_lb3MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
       
    }//GEN-LAST:event_jLabel2MouseClicked

    private void lb4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lb4MouseClicked
      try {                                     
                clip.stop();
                String nombrs ="src/musica/haga-clic-en_4.wav";
                
                try {
                    clip = AudioSystem.getClip();
                } catch (LineUnavailableException ex) {
                    Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                AudioInputStream audioInputStream =null;
                try {
                    try {
                        audioInputStream = AudioSystem.getAudioInputStream(new File(nombrs).getAbsoluteFile());
                    } catch (IOException ex) {
                        Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (UnsupportedAudioFileException ex) {
                    Logger.getLogger(VistaInicial.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                clip.open(audioInputStream);
                clip.start();
            } catch (LineUnavailableException ex) {
                Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
         Logger.getLogger(VistaMenu.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_lb4MouseClicked

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
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaMenu dialog = new VistaMenu(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Jgiff;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lb3;
    private javax.swing.JLabel lb4;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.Reproducir;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;


/**
 *
 * @author grace
 */
public class VistaMenu extends javax.swing.JDialog {
    Reproducir des = new Reproducir();
    String nombresonido = "src/musica/juego-de-tronos-2.wav";
    Clip clip = null;

    public VistaMenu(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        ImageIcon de = new ImageIcon("C:\\Users\\edgar\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\ayuda\\menu.gif");
        Icon ide = new ImageIcon(de.getImage().getScaledInstance(Fondo.getWidth(), Fondo.getHeight(), Image.SCALE_DEFAULT));
        Fondo.setIcon(ide);
        ImageIcon d = new ImageIcon("C:\\Users\\edgar\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\ayuda\\j_1.png");
        Icon id = new ImageIcon(d.getImage().getScaledInstance(play.getWidth(), play.getHeight(), Image.SCALE_DEFAULT));
        play.setIcon(id);
        ImageIcon dee = new ImageIcon("C:\\Users\\edgar\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\ayuda\\sin.png");
        Icon idd = new ImageIcon(dee.getImage().getScaledInstance(pause.getWidth(), pause.getHeight(), Image.SCALE_DEFAULT));
        pause.setIcon(idd);
        this.repaint();
        this.setLocationRelativeTo(this);
        
        try {
            des.ReproducirSonido(nombresonido);
        } catch (Exception e) {
        }

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
        play = new javax.swing.JLabel();
        pause = new javax.swing.JLabel();
        iniciojuego = new javax.swing.JLabel();
        salir = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        play.setBackground(new java.awt.Color(51, 51, 255));
        play.setFont(new java.awt.Font("Yu Gothic UI Light", 3, 18)); // NOI18N
        play.setForeground(new java.awt.Color(255, 255, 255));
        play.setText("Mute");
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playMouseClicked(evt);
            }
        });
        getContentPane().add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 20, 20));

        pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseMouseClicked(evt);
            }
        });
        getContentPane().add(pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 20, 20));

        iniciojuego.setFont(new java.awt.Font("Segoe UI Semilight", 0, 24)); // NOI18N
        iniciojuego.setForeground(new java.awt.Color(255, 255, 255));
        iniciojuego.setText("        Iniciar Juego");
        iniciojuego.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iniciojuegoMouseClicked(evt);
            }
        });
        getContentPane().add(iniciojuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 230, 50));

        salir.setText("Salir");
        salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salirMouseClicked(evt);
            }
        });
        getContentPane().add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 30, 20));
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseClicked
        try {
           des.ReproducirSonido(nombresonido); 
        } catch (Exception e) {
        }

    }//GEN-LAST:event_playMouseClicked

    private void iniciojuegoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iniciojuegoMouseClicked

    }//GEN-LAST:event_iniciojuegoMouseClicked

    private void pauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseMouseClicked
       des.Pausa();
    }//GEN-LAST:event_pauseMouseClicked

    private void salirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salirMouseClicked
    System.exit(0);
    }//GEN-LAST:event_salirMouseClicked

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel iniciojuego;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel pause;
    private javax.swing.JLabel play;
    private javax.swing.JLabel salir;
    // End of variables declaration//GEN-END:variables
}

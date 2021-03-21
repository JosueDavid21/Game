/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.Ejecutable;
import control.Reproducir;
import java.awt.Color;
import java.awt.Image;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author edgar
 */
public class VistaIngresoNombre extends javax.swing.JFrame {

    Reproducir des = new Reproducir();
    Ejecutable d = new Ejecutable();
    String nombresonido = "src/musica/juego-de-tronos-2.wav";
    Clip clip = null;

    /**
     * Creates new form VistaIngresoNombre
     */
    public VistaIngresoNombre() {
        initComponents();
        person.setBackground(new Color(123, 95, 185, 150));
        ImageIcon de = new ImageIcon("src/fondos/vista.gif");
        Icon ide = new ImageIcon(de.getImage().getScaledInstance(Fondo.getWidth(), Fondo.getHeight(), Image.SCALE_DEFAULT));
        Fondo.setIcon(ide);
        ImageIcon d = new ImageIcon("src/fondos/con_sonido.png");
        Icon id = new ImageIcon(d.getImage().getScaledInstance(play.getWidth(), play.getHeight(), Image.SCALE_DEFAULT));
        play.setIcon(id);
        ImageIcon dee = new ImageIcon("src/fondos/sin_sonido.png");
        Icon idd = new ImageIcon(dee.getImage().getScaledInstance(pause.getWidth(), pause.getHeight(), Image.SCALE_DEFAULT));
        pause.setIcon(idd);
        ImageIcon per = new ImageIcon("src/imagenes/personajes/inicio.png");
        Icon aux = new ImageIcon(per.getImage().getScaledInstance(person.getWidth(), person.getHeight(), Image.SCALE_DEFAULT));
        person.setIcon(aux);
        this.repaint();
        this.setLocationRelativeTo(this);
        jPanel2.setBackground(new Color(150, 92, 40, 200));
        jPanel3.setBackground(new Color(122,214,189,220));
    
        try {          
            des.ReproducirSonido(nombresonido);
        } catch (Exception e) {
        }
        play.setVisible(false);
        
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
        jPanel2 = new javax.swing.JPanel();
        person = new javax.swing.JLabel();
        Inicio = new javax.swing.JLabel();
        Nombreper = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        pause = new javax.swing.JLabel();
        play = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(person, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(person, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, -1, -1));

        Inicio.setBackground(new java.awt.Color(167, 151, 151));
        Inicio.setForeground(new java.awt.Color(255, 255, 255));
        Inicio.setText("                                 Continuar");
        Inicio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        Inicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InicioMouseClicked(evt);
            }
        });
        jPanel1.add(Inicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 273, 32));

        Nombreper.setText("Ingrese Nombre para su personaje");
        Nombreper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NombreperMouseClicked(evt);
            }
        });
        Nombreper.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NombreperActionPerformed(evt);
            }
        });
        jPanel1.add(Nombreper, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, 213, 25));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));
        jPanel3.setLayout(null);

        pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseMouseClicked(evt);
            }
        });
        jPanel3.add(pause);
        pause.setBounds(10, 10, 30, 30);

        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playMouseClicked(evt);
            }
        });
        jPanel3.add(play);
        play.setBounds(10, 10, 30, 30);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 10, 50, 50));
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 290));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NombreperActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NombreperActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NombreperActionPerformed

    private void InicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InicioMouseClicked
        if (Nombreper.getText().isEmpty()|| Nombreper.getText().equals("Ingrese Nombre para su personaje")) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre para poder continuar ");
        } else {

            des.Pausa();
            this.dispose();
            new VistaEmpezar(Nombreper.getText()).setVisible(true);

        }
    }//GEN-LAST:event_InicioMouseClicked

    private void NombreperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NombreperMouseClicked
        Nombreper.setText("");
    }//GEN-LAST:event_NombreperMouseClicked

    private void playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseClicked
         try {
            des.ReproducirSonido(nombresonido);
            pause.setVisible(true);
            play.setVisible(false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_playMouseClicked

    private void pauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseMouseClicked
      des.Pausa();
      play.setVisible(true);
      pause.setVisible(false);
      
    }//GEN-LAST:event_pauseMouseClicked
    
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
            java.util.logging.Logger.getLogger(VistaIngresoNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaIngresoNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaIngresoNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaIngresoNombre.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaIngresoNombre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Inicio;
    private javax.swing.JTextField Nombreper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel pause;
    private javax.swing.JLabel person;
    private javax.swing.JLabel play;
    // End of variables declaration//GEN-END:variables
}

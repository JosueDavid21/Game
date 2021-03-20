/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import entes.Isla;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import listas.ListaMapas;

/**
 *
 * @author edgar
 */
public class VistaEmpezar extends javax.swing.JFrame {

    barra d = new barra();
    VistaIngresoNombre mu = new VistaIngresoNombre();
    String musica = "src/musica/sonido_1.wav";
    String temp;

    public VistaEmpezar() {
        initComponents();

    }

    public VistaEmpezar(String jugador) {
        initComponents();
        setLocationRelativeTo(null);
        ImageIcon de = new ImageIcon("src/fondos/inicio secion.gif");
        Icon ide = new ImageIcon(de.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(ide);
        jPanel1.setBackground(new Color(125, 188, 200, 180));
        jPanel2.setBackground(new Color(125, 52, 49, 180));
        Iniciar.setForeground(new Color(255, 255, 255));
        Iniciar.setBackground(Color.white);
        nombre.setBackground(new java.awt.Color(140, 210, 250));
        nombre.setText("Bienvenido " + jugador.toUpperCase().trim());
        nombre.setForeground(Color.WHITE);

        mu.des.Pausa();
        try {
            mu.des.ReproducirSonido(musica);
        } catch (Exception e) {
        }

    }

    public static String GuardarIsla(String g) {

        String isla = g;
        return isla;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Nivel = new javax.swing.ButtonGroup();
        nombre = new javax.swing.JLabel();
        Iniciar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        facil = new javax.swing.JRadioButton();
        dificil = new javax.swing.JRadioButton();
        medio = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        calavera = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        amor = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setBackground(new java.awt.Color(255, 51, 0));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 10, 140, 30));

        Iniciar.setBackground(new java.awt.Color(255, 255, 0));
        Iniciar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Iniciar.setForeground(new java.awt.Color(255, 255, 255));
        Iniciar.setText("   Iniciar Juego");
        Iniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IniciarMouseClicked(evt);
            }
        });
        getContentPane().add(Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 270, 110, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Elegir un nivel de dificultad");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        Nivel.add(facil);
        facil.setForeground(new java.awt.Color(255, 255, 255));
        facil.setText("Nivel Facil");
        facil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facilMouseClicked(evt);
            }
        });
        jPanel2.add(facil, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        Nivel.add(dificil);
        dificil.setForeground(new java.awt.Color(255, 255, 255));
        dificil.setText("Nivel Dificil");
        dificil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dificilMouseClicked(evt);
            }
        });
        jPanel2.add(dificil, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, -1));

        Nivel.add(medio);
        medio.setForeground(new java.awt.Color(255, 255, 255));
        medio.setText("Nivel Medio");
        medio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        medio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medioMouseClicked(evt);
            }
        });
        jPanel2.add(medio, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 50, 150, 190));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("jLabel1");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 50, 40));

        calavera.setText("Calavera");
        calavera.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(calavera, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 50, 40));

        jLabel1.setText("jLabel1");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 90, 50, 40));

        amor.setText("Amor");
        amor.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        amor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amorMouseClicked(evt);
            }
        });
        jPanel1.add(amor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 50, 40));

        jLabel9.setText("jLabel1");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 50, 40));

        jLabel6.setText("jLabel1");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 50, 40));

        jLabel7.setText("jLabel1");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 50, 40));

        jLabel8.setText("jLabel1");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 50, 40));

        jLabel10.setText("jLabel1");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 50, 40));

        jLabel4.setText("jLabel1");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 50, 40));

        p.setBackground(new java.awt.Color(0, 255, 255));
        p.setForeground(new java.awt.Color(255, 255, 255));
        p.setText("Elegir un mapa");
        jPanel1.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 260, 270));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void medioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medioMouseClicked
        d.Nivel(dificil.getLabel());
    }//GEN-LAST:event_medioMouseClicked

    private void dificilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dificilMouseClicked
        d.Nivel(medio.getLabel());
    }//GEN-LAST:event_dificilMouseClicked

    private void facilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facilMouseClicked
        d.Nivel(facil.getLabel());
    }//GEN-LAST:event_facilMouseClicked

    private void amorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amorMouseClicked
        temp="amor";
    }//GEN-LAST:event_amorMouseClicked

    private void IniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarMouseClicked
        HashMap lista = new ListaMapas().getLista();
        new VistaIsla((Isla) lista.get(temp), new Point(16, 10)).setVisible(true);
    }//GEN-LAST:event_IniciarMouseClicked

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
            java.util.logging.Logger.getLogger(VistaEmpezar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEmpezar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEmpezar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEmpezar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaEmpezar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Iniciar;
    private javax.swing.ButtonGroup Nivel;
    private javax.swing.JLabel amor;
    private javax.swing.JLabel calavera;
    private javax.swing.JRadioButton dificil;
    private javax.swing.JRadioButton facil;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton medio;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel p;
    // End of variables declaration//GEN-END:variables
}

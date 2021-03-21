/*
 * Uversidad Central del Ecuador 
 * Facultad de Ingenieria y CIencias aplicadas
 * Ingenieria en Sistemas de Informacion
 * Algoritmos
 * Grupo 9 
 * Integrantes: 
 *       - Bolaños Josue
 *       - Espinosa David
 *       - Teran Edgar
 * Este es un juego que implementa el algoritmo del camino mas corto
 */

package vistas;

import entes.Isla;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Grupo 9
 */

public class VistaCargar extends javax.swing.JFrame implements ActionListener {

    VistaIsla vistaIsla;
    Timer tiempo1 = new Timer(1, this);
    
    public VistaCargar(Isla isla, Point punto) {
        initComponents();
        this.setAlwaysOnTop(true);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.getContentPane().setBackground(Color.CYAN);
//        ImageIcon d = new ImageIcon("C:\\Users\\edgar\\Documents\\NetBeansProjects\\Game\\src\\imagenes\\ayuda\\cargando.gif");
//        Icon id = new ImageIcon(d.getImage().getScaledInstance(lb3.getWidth(), lb3.getHeight(), Image.SCALE_DEFAULT));
//        lb3.setIcon(id);
        vistaIsla = new VistaIsla(isla, punto);
        vistaIsla.setVisible(true);
        tiempo1.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent c) {
        if(vistaIsla.isActive()){
            this.dispose();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(lb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 684, 343));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lb3;
    // End of variables declaration//GEN-END:variables
}

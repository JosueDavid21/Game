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

import control.Ejecutable;
import control.Grafo;
import control.Pistas;
import control.Reproducir;
import entes.Inventario;
import entes.Isla;
import entes.Protagonista;
import java.awt.Color;
import java.awt.Image;
import java.awt.Point;
import java.util.HashMap;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import listas.ListaIslas;

/**
 *
 * @author Grupo 9
 */
public class VistaEmpezar extends javax.swing.JFrame {

    Ejecutable d = new Ejecutable();
    VistaIngresoNombre mu = new VistaIngresoNombre();
    Reproducir r = new Reproducir();
    String musica = "src/musica/sonido_1.wav";
    String temp = "";
    String nivel = "";
    Grafo g;

    public VistaEmpezar() {
        initComponents();

    }

    public VistaEmpezar(String jugador) {
        initComponents();
        g = new Grafo("abcdefghijk");
        g.iniciargrafo(g);
        new Protagonista().setNombre(jugador);
        setLocationRelativeTo(null);

        ImageIcon ds = new ImageIcon("src/fondos/inicio secion.gif");
        Icon isd = new ImageIcon(ds.getImage().getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(isd);
        ImageIcon d = new ImageIcon("src/fondos/sin_sonido.png");
        Icon id = new ImageIcon(d.getImage().getScaledInstance(play.getWidth(), play.getHeight(), Image.SCALE_DEFAULT));
        play.setIcon(id);
        ImageIcon dee = new ImageIcon("src/fondos/con_sonido.png");
        Icon idd = new ImageIcon(dee.getImage().getScaledInstance(pause.getWidth(), pause.getHeight(), Image.SCALE_DEFAULT));
        pause.setIcon(idd);
        jPanel1.setBackground(new Color(125, 188, 200, 180));
        jPanel2.setBackground(new Color(125, 52, 49, 180));
        Iniciar.setForeground(new Color(255, 255, 255));
        Iniciar.setBackground(Color.white);
        nombre.setBackground(new java.awt.Color(140, 210, 250));
        nombre.setText("Bienvenido " + jugador);
        facil.setBackground(new Color(255, 255, 255, 90));
        medio.setBackground(new Color(255, 255, 255, 90));
        dificil.setBackground(new Color(255, 255, 255, 90));
        ImageIcon sa = new ImageIcon("src/fondos/x.png");
        Icon xx = new ImageIcon(sa.getImage().getScaledInstance(exit.getWidth(), exit.getHeight(), Image.SCALE_DEFAULT));
        exit.setIcon(xx);
        nombre.setForeground(Color.WHITE);
        botones.setBackground(new Color(125, 158, 220, 180));
        play.setVisible(false);
        mu.des.Pausa();
        try {
            mu.des.ReproducirSonido(musica);
        } catch (Exception e) {
        }
        islaescogida.setForeground(Color.WHITE);
        escoNivel.setForeground(Color.WHITE);
        icono2(amor, "amor");
        icono2(circo, "circo");
        icono2(calavera, "calavera");
        icono2(desierto, "desierto");
        icono2(dulce, "dulce");
        icono2(flor, "flor");
        icono2(militar, "militar");
        icono2(playa, "playa");
        icono2(ruina, "ruina");
        icono2(selva, "selva");
        icono2(volcan, "volcan");
    }

    public void icono2(JLabel label, String name) {
        ImageIcon im = new ImageIcon("src/imagenes/menu/" + name + " icono.png");
        ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));

        label.setIcon(icono);
    }

    public void comprobar(JLabel selecionado, JLabel a, JLabel b, JLabel c, JLabel d, JLabel z, JLabel f, JLabel g, JLabel h, JLabel i, JLabel j) {

        selecionado.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        a.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        b.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        c.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        d.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        z.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        f.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        g.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        h.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        i.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        j.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
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
        botones = new javax.swing.JPanel();
        play = new javax.swing.JLabel();
        pause = new javax.swing.JLabel();
        Iniciar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        facil = new javax.swing.JRadioButton();
        dificil = new javax.swing.JRadioButton();
        medio = new javax.swing.JRadioButton();
        escoNivel = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        playa = new javax.swing.JLabel();
        calavera = new javax.swing.JLabel();
        flor = new javax.swing.JLabel();
        amor = new javax.swing.JLabel();
        volcan = new javax.swing.JLabel();
        selva = new javax.swing.JLabel();
        ruina = new javax.swing.JLabel();
        militar = new javax.swing.JLabel();
        circo = new javax.swing.JLabel();
        desierto = new javax.swing.JLabel();
        p = new javax.swing.JLabel();
        islaescogida = new javax.swing.JLabel();
        dulce = new javax.swing.JLabel();
        exit = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setBackground(new java.awt.Color(255, 51, 0));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 140, 20));

        botones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        play.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playMouseClicked(evt);
            }
        });
        botones.add(play, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        pause.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pause.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pauseMouseClicked(evt);
            }
        });
        botones.add(pause, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 40));

        getContentPane().add(botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 60, 50));

        Iniciar.setBackground(new java.awt.Color(255, 255, 0));
        Iniciar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        Iniciar.setForeground(new java.awt.Color(255, 255, 255));
        Iniciar.setText("   Iniciar Juego");
        Iniciar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Iniciar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Iniciar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                IniciarMouseClicked(evt);
            }
        });
        getContentPane().add(Iniciar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 110, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setBackground(new java.awt.Color(0, 255, 255));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Elegir un nivel de dificultad");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, -1));

        Nivel.add(facil);
        facil.setForeground(new java.awt.Color(255, 255, 255));
        facil.setText("Nivel Facil");
        facil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        facil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                facilMouseClicked(evt);
            }
        });
        facil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facilActionPerformed(evt);
            }
        });
        jPanel2.add(facil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        Nivel.add(dificil);
        dificil.setForeground(new java.awt.Color(255, 255, 255));
        dificil.setText("Nivel Dificil");
        dificil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dificil.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dificilMouseClicked(evt);
            }
        });
        dificil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dificilActionPerformed(evt);
            }
        });
        jPanel2.add(dificil, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        Nivel.add(medio);
        medio.setForeground(new java.awt.Color(255, 255, 255));
        medio.setText("Nivel Medio");
        medio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        medio.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        medio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                medioMouseClicked(evt);
            }
        });
        jPanel2.add(medio, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, -1));
        jPanel2.add(escoNivel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 164, 170, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 190, 190));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        playa.setText("playa");
        playa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        playa.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        playa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                playaMouseClicked(evt);
            }
        });
        jPanel1.add(playa, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, 50, 40));

        calavera.setText("calavera");
        calavera.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        calavera.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        calavera.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                calaveraMouseClicked(evt);
            }
        });
        jPanel1.add(calavera, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 40, 50, 40));

        flor.setText("flor");
        flor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        flor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        flor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                florMouseClicked(evt);
            }
        });
        jPanel1.add(flor, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 50, 40));

        amor.setText("amor");
        amor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        amor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        amor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                amorMouseClicked(evt);
            }
        });
        jPanel1.add(amor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 50, 40));

        volcan.setText("volcan");
        volcan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        volcan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        volcan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                volcanMouseClicked(evt);
            }
        });
        jPanel1.add(volcan, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 50, 40));

        selva.setText("selva");
        selva.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        selva.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        selva.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selvaMouseClicked(evt);
            }
        });
        jPanel1.add(selva, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 50, 40));

        ruina.setText("ruina");
        ruina.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        ruina.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ruina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ruinaMouseClicked(evt);
            }
        });
        jPanel1.add(ruina, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 50, 40));

        militar.setText("militar");
        militar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        militar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        militar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                militarMouseClicked(evt);
            }
        });
        jPanel1.add(militar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 50, 40));

        circo.setText("circo");
        circo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        circo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        circo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                circoMouseClicked(evt);
            }
        });
        jPanel1.add(circo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 110, 50, 40));

        desierto.setText("desierto");
        desierto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        desierto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        desierto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                desiertoMouseClicked(evt);
            }
        });
        jPanel1.add(desierto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 50, 40));

        p.setBackground(new java.awt.Color(0, 255, 255));
        p.setForeground(new java.awt.Color(255, 255, 255));
        p.setText("Elegir un mapa");
        jPanel1.add(p, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 130, 20));

        islaescogida.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.add(islaescogida, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 200, 30));

        dulce.setText("dulce");
        dulce.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        dulce.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dulce.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dulceMouseClicked(evt);
            }
        });
        jPanel1.add(dulce, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, 50, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 260, 320));

        exit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitMouseClicked(evt);
            }
        });
        getContentPane().add(exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 30, 30));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void medioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_medioMouseClicked
        nivel = "medio";
        escoNivel.setText("El nivel escojido es:" + nivel);
    }//GEN-LAST:event_medioMouseClicked

    private void dificilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dificilMouseClicked
        nivel = "dificil";
        escoNivel.setText("El nivel escojido es:" + nivel);
    }//GEN-LAST:event_dificilMouseClicked

    private void facilMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_facilMouseClicked
        nivel = "facil";
        escoNivel.setText("El nivel escojido es:" + nivel);
    }//GEN-LAST:event_facilMouseClicked

    private void amorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_amorMouseClicked
        temp = "amor";
        comprobar(amor, calavera, militar, volcan, flor, circo, desierto, playa, dulce, ruina, selva);
        islaescogida.setText("La isla escogida es:" + temp);
    }//GEN-LAST:event_amorMouseClicked

    private void IniciarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IniciarMouseClicked
        if (temp == "" || nivel == "") {
            JOptionPane.showMessageDialog(null, "Seleeccione todos los campos para iniciar el juego");
        } else {
            // agregar nivel de dificultad y nombre del personaje 
            new Pistas().setCamino_inicial(g.rutaDificultad(g.String_char(temp), nivel));
            new Pistas().setDificultad(nivel);
            if (Pistas.dificultad.equals("dificil")) {
                Inventario.setMonedas(g.dificil);
            } else if (Pistas.dificultad.equals("medio")) {
                Inventario.setMonedas(g.medio);
            } else {
                Inventario.setMonedas(g.facil+g.dificil);
            }
            new VistaCargar(temp, new Point(16, 10)).setVisible(true);
            mu.des.Pausa();
            this.dispose();
        }
    }//GEN-LAST:event_IniciarMouseClicked

    private void calaveraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_calaveraMouseClicked
        temp = "calavera";
        comprobar(calavera, militar, volcan, flor, circo, desierto, playa, ruina, selva, amor, dulce);
        islaescogida.setText("La isla escogida es:" + temp);

    }//GEN-LAST:event_calaveraMouseClicked

    private void militarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_militarMouseClicked
        temp = "militar";
        comprobar(militar, calavera, volcan, flor, circo, desierto, playa, ruina, selva, amor, dulce);
        islaescogida.setText("La isla escogida es:" + temp);
    }//GEN-LAST:event_militarMouseClicked

    private void volcanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_volcanMouseClicked
        temp = "volcan";
        comprobar(volcan, militar, calavera, flor, circo, desierto, playa, ruina, selva, amor, dulce);
        islaescogida.setText("La isla escogida es:" + temp);
    }//GEN-LAST:event_volcanMouseClicked

    private void florMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_florMouseClicked
        temp = "flor";
        comprobar(flor, militar, calavera, volcan, circo, desierto, playa, ruina, selva, amor, dulce);
        islaescogida.setText("La isla escogida es:" + temp);
    }//GEN-LAST:event_florMouseClicked

    private void circoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_circoMouseClicked
        temp = "circo";
        comprobar(circo, militar, calavera, volcan, flor, desierto, playa, ruina, selva, amor, dulce);
        islaescogida.setText("La isla escogida es:" + temp);
    }//GEN-LAST:event_circoMouseClicked

    private void desiertoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_desiertoMouseClicked
        temp = "desierto";
        comprobar(desierto, militar, calavera, volcan, flor, circo, playa, ruina, selva, amor, dulce);
        islaescogida.setText("La isla escogida es:" + temp);
    }//GEN-LAST:event_desiertoMouseClicked

    private void playaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playaMouseClicked
        temp = "playa";
        comprobar(playa, militar, calavera, volcan, flor, circo, desierto, ruina, selva, amor, dulce);
        islaescogida.setText("La isla escogida es:" + temp);
    }//GEN-LAST:event_playaMouseClicked

    private void ruinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ruinaMouseClicked
        temp = "ruina";
        comprobar(ruina, militar, calavera, volcan, flor, circo, desierto, playa, selva, amor, dulce);
        islaescogida.setText("La isla escogida es:" + temp);
    }//GEN-LAST:event_ruinaMouseClicked

    private void selvaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selvaMouseClicked
        temp = "selva";
        comprobar(selva, ruina, militar, calavera, volcan, flor, circo, desierto, playa, amor, dulce);
        islaescogida.setText("La isla escogida es:" + temp);
    }//GEN-LAST:event_selvaMouseClicked

    private void facilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facilActionPerformed

    }//GEN-LAST:event_facilActionPerformed

    private void dificilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dificilActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dificilActionPerformed

    private void dulceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dulceMouseClicked
        temp = "dulce";
        comprobar(dulce, ruina, militar, calavera, volcan, flor, circo, desierto, playa, selva, amor);
        islaescogida.setText("La isla escogida es:" + temp);
    }//GEN-LAST:event_dulceMouseClicked

    private void playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_playMouseClicked
        try {
            mu.des.ReproducirSonido(musica);
            pause.setVisible(true);
            play.setVisible(false);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_playMouseClicked

    private void pauseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pauseMouseClicked
        mu.des.Pausa();
        play.setVisible(true);
        pause.setVisible(false);
    }//GEN-LAST:event_pauseMouseClicked

    private void exitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitMouseClicked
        System.exit(WIDTH);
    }//GEN-LAST:event_exitMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Iniciar;
    private javax.swing.ButtonGroup Nivel;
    private javax.swing.JLabel amor;
    private javax.swing.JPanel botones;
    private javax.swing.JLabel calavera;
    private javax.swing.JLabel circo;
    private javax.swing.JLabel desierto;
    private javax.swing.JRadioButton dificil;
    private javax.swing.JLabel dulce;
    private javax.swing.JLabel escoNivel;
    private javax.swing.JLabel exit;
    private javax.swing.JRadioButton facil;
    private javax.swing.JLabel flor;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel islaescogida;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton medio;
    private javax.swing.JLabel militar;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel p;
    private javax.swing.JLabel pause;
    private javax.swing.JLabel play;
    private javax.swing.JLabel playa;
    private javax.swing.JLabel ruina;
    private javax.swing.JLabel selva;
    private javax.swing.JLabel volcan;
    // End of variables declaration//GEN-END:variables
}

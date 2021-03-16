/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.Tecla;
import entes.GenerarDimension;
import entes.Isla;
import entes.Tile;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public final class VistaIsla extends javax.swing.JFrame implements ActionListener {

    private static String rutaPersonaje;
    private static String rutaIsla;
    private final int[][] matrizIsla;

    GenerarDimension dimensiones;
//    private final Tecla arriba = new Tecla();
//    private final Tecla abajo = new Tecla();
//    private final Tecla izquierda = new Tecla();
//    private final Tecla derecha = new Tecla();
    boolean arriba;
    boolean abajo;
    boolean izquierda;
    boolean derecha;

    private final Timer tiempo1 = new Timer(1, this);

    private static final Rectangle recJug = new Rectangle(0, 0, 0, 0);
    JLabel jLfondo = new JLabel();
    JLabel personaje = new JLabel();
    JLabel jLMapa = new JLabel();

    private int x;
    private int y;
    private int animacion;
    private final int moveX = 1;
    private final int moveY = 1;
    private boolean recogiendo = false;

    boolean retorno;
    private final Point pSI = new Point();
    private final Point pSD = new Point();
    private final Point pII = new Point();
    private final Point pID = new Point();
    private final Tile t = new Tile();

    public VistaIsla(Isla isla, Point jug) {
        dimensiones = new GenerarDimension(jug);
        rutaPersonaje = "src/imagenes/personajes/inicio.png";
        rutaIsla = isla.getUrlImagen();
        matrizIsla = isla.getMatriz();

        initComponents();

        agregarMenu(isla.getNombre());

        jPanel1.setSize(dimensiones.getDimensionMenu());
        jPanel1.setLocation(dimensiones.getPuntoInicioMenu());

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(dimensiones.getWIDTH(), dimensiones.getHEIGHT());
        this.setResizable(false);
        this.setLocation(0, 0);
        this.getContentPane().setBackground(Color.black);
        generarPersonaje(rutaPersonaje);
        generarIsla();
        this.x = personaje.getLocation().x;
        this.y = personaje.getLocation().y;

        isla_nombre = isla.getNombre();
        jPanel1.updateUI();
    }
    
    //DAVID INICIO
    String isla_nombre;

    public void agregarMenu(String nombreisla) {
        String menu[] = {"jugador", "moneda", "mapa", nombreisla, "pista"};
        icono2(menu[0], jugador);
        icono2(menu[1], moneda);
        icono2(menu[2], mapa);
        icono2(menu[3], nombre_isla);
        icono2(menu[4], pista);
        jPanel1.updateUI();
    }

    public void actualizar() {
        if (animacion < 32000) {
            animacion++;
        } else {
            animacion = 0;
        }
    }

    public void icono_animacion(String nombre_animacion) {
        if (animacion % 20 > 8) {
            icono(personaje, nombre_animacion + "1");
        } else {
            icono(personaje, nombre_animacion + "2");
        }
    }

    public void icono(JLabel foto_icono, String nodo) {
        Dimension d = new Dimension(dimensiones.getDimensionPersonaje().width, dimensiones.getDimensionPersonaje().height);
        foto_icono.setSize(d);
        ImageIcon im = new ImageIcon("src/imagenes/personajes/" + nodo.toLowerCase().trim() + ".png");
        ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(foto_icono.getWidth(), foto_icono.getHeight(), Image.SCALE_SMOOTH));
        foto_icono.setIcon(icono);
    }

//DAVID FIN
    public void icono2(String name, JLabel label) {
        Dimension d = new Dimension(dimensiones.getDimensionMenu().width / 5, dimensiones.getDimensionMenu().height);
        ImageIcon im = new ImageIcon("src/imagenes/menu/" + name + " icono.png");
        ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(jugador.getWidth(), jugador.getHeight(), Image.SCALE_SMOOTH));
        label.setSize(d);
        label.setIcon(icono);
        jPanel1.add(label);
        jPanel1.updateUI();
    }

    private void generarIsla() {
        jLMapa.setLocation(dimensiones.getPuntoInicioJuego());
        jLMapa.setSize(dimensiones.getDimensionJuego());
        ImageIcon fot = new ImageIcon(rutaIsla);
        Icon icono = new ImageIcon(fot.getImage().getScaledInstance(dimensiones.getDimensionJuego().width, dimensiones.getDimensionJuego().height, Image.SCALE_DEFAULT));
        jLMapa.setIcon(icono);
        add(jLMapa);
        this.repaint();
    }

    private void generarPersonaje(String ruta) {
        Image imgEscalada = new ImageIcon(ruta).getImage().getScaledInstance(dimensiones.getDimensionPersonaje().width,
                dimensiones.getDimensionPersonaje().height, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        personaje.setSize(dimensiones.getDimensionPersonaje().width, dimensiones.getDimensionPersonaje().height);
        personaje.setIcon(iconoEscalado);
        personaje.setLocation(dimensiones.getPuntoInicioJugador());
        add(personaje);
    }

    @Override
    public void actionPerformed(ActionEvent c) {
        actualizar();
        mover();
    }

    private void mover() {
        if (izquierda & !derecha & !arriba & !abajo) {
            if (verificarMovimiento(x - moveX, y)) {
                x = x - moveX;
                personaje.setLocation(x, y);
                icono_animacion("izquierda");
            }
        } else if (derecha & !arriba & !abajo & !izquierda) {
            if (verificarMovimiento(x + moveX, y)) {
                x = x + moveX;
                personaje.setLocation(x, y);
                icono_animacion("derecha");
            }
        } else if (arriba & !abajo & !izquierda & !derecha) {
            if (verificarMovimiento(x, y - moveY)) {
                y = y - moveY;
                personaje.setLocation(x, y);
                icono_animacion("arriba");
            }
        } else if (abajo & !izquierda & !derecha & !arriba) {
            if (verificarMovimiento(x, y + moveY)) {
                y = y + moveY;
                personaje.setLocation(x, y);
                icono_animacion("abajo");
            }
        } else if (abajo & derecha) {
            if (verificarMovimiento(x + moveX, y + moveY)) {
                y = y + moveY;
                x = x + moveX;
                personaje.setLocation(x, y);
                icono_animacion("derecha");
            }
        } else if (abajo & izquierda) {
            if (verificarMovimiento(x - moveX, y + moveY)) {
                y = y + moveY;
                x = x - moveX;
                personaje.setLocation(x, y);
                icono_animacion("izquierda");
            }
        } else if (arriba & derecha) {
            if (verificarMovimiento(x + moveX, y - moveY)) {
                y = y - moveY;
                x = x + moveX;
                personaje.setLocation(x, y);
                icono_animacion("derecha");
            }
        } else if (arriba & izquierda) {
            if (verificarMovimiento(x - moveX, y - moveY)) {
                y = y - moveY;
                x = x - moveX;
                personaje.setLocation(x, y);
                icono_animacion("izquierda");
            }
        }
    }
    
    private boolean verificarMovimiento(int xSig, int ySig) {
        retorno = true;
        recJug.setLocation(xSig, ySig+(personaje.getHeight()/2));
        recJug.setSize(personaje.getWidth(), personaje.getHeight()/2);
        pSI.setLocation(dimensiones.getPuntoActual(recJug.x, recJug.y));
        pSD.setLocation(dimensiones.getPuntoActual(recJug.x + recJug.width, recJug.y));
        pII.setLocation(dimensiones.getPuntoActual(recJug.x, recJug.y + recJug.height));
        pID.setLocation(dimensiones.getPuntoActual(recJug.x + recJug.width, recJug.y + recJug.height));
        retorno = retorno && t.esCamino(matrizIsla[pSI.x][pSI.y]);
        retorno = retorno && t.esCamino(matrizIsla[pSD.x][pSD.y]);
        retorno = retorno && t.esCamino(matrizIsla[pII.x][pII.y]);
        retorno = retorno && t.esCamino(matrizIsla[pID.x][pID.y]);
        return retorno;
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
        jugador = new javax.swing.JLabel();
        mapa = new javax.swing.JLabel();
        moneda = new javax.swing.JLabel();
        nombre_isla = new javax.swing.JLabel();
        pista = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(0, 255, 0));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new java.awt.GridLayout());
        jPanel1.add(jugador);

        mapa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapaMouseClicked(evt);
            }
        });
        jPanel1.add(mapa);
        jPanel1.add(moneda);
        jPanel1.add(nombre_isla);
        jPanel1.add(pista);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 250, 400, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
//        tiempo1.start();
//        switch (evt.getKeyCode()) {
//            case KeyEvent.VK_W:
//                arriba.teclaPulsada();
//                icono(personaje, "arriba");
//                break;
//            case KeyEvent.VK_S:
//                abajo.teclaPulsada();
//                icono(personaje, "abajo");
//                break;
//            case KeyEvent.VK_A:
//                izquierda.teclaPulsada();
//                icono(personaje, "izquierda");
//                break;
//            case KeyEvent.VK_D:
//                derecha.teclaPulsada();
//                icono(personaje, "derecha");
//                break;
//            case KeyEvent.VK_E:
//                recogiendo = true;
//                break;
////            case KeyEvent.VK_I:
////                inventarioActivo = !inventarioActivo;
////                break;
//            case KeyEvent.VK_ESCAPE:
//                tiempo1.stop();
//                System.exit(0);
//        }
tiempo1.start();
        if (evt.getKeyCode() == 65) {
            izquierda = true;
        } else if (evt.getKeyCode() == 68) {
            derecha = true;
        } else if (evt.getKeyCode() == 87) {
            arriba = true;
        } else if (evt.getKeyCode() == 83) {
            abajo = true;

        }
        if (evt.getKeyCode() == evt.VK_ESCAPE) {
            System.exit(0);
        }
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
//        switch (evt.getKeyCode()) {
//            case KeyEvent.VK_W:
//                arriba=false;
//                break;
//            case KeyEvent.VK_S:
//                abajo=false;
//                break;
//            case KeyEvent.VK_A:
//                izquierda=false;
//                break;
//            case KeyEvent.VK_D:
//                derecha=false;
//                break;
//            case KeyEvent.VK_E:
//                recogiendo = false;
//                break;
//        }
//        if ((!arriba && !abajo && !izquierda && !derecha)) {
//            icono(personaje, "abajo");
//            tiempo1.stop();
//        }
if (evt.getKeyCode() == 65) {

            izquierda = false;
            icono(personaje, "izquierda");

        } else if (evt.getKeyCode() == 68) {
            derecha = false;
            icono(personaje, "derecha");
        } else if (evt.getKeyCode() == 87) {
            arriba = false;
            icono(personaje, "arriba");
        } else if (evt.getKeyCode() == 83) {
            abajo = false;
            icono(personaje, "abajo");
        }
        if ((!arriba && !abajo && !izquierda && !derecha)) {
            tiempo1.stop();
        }
    }//GEN-LAST:event_formKeyReleased
    
    
    Mapa_Vista mapa_pantalla;
    boolean map = false;

    public void validarvisible() {
        if (mapa_pantalla != null) {
            if (mapa_pantalla.isVisible()) {
                map = true;
            }
        }

    }
    boolean pmapa = false;
    private void mapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapaMouseClicked
        // TODO add your handling code here:
        validarvisible();
        System.out.println(map + " map+");
        if (map == false) {
            mapa_pantalla = new Mapa_Vista(isla_nombre);
            mapa_pantalla.setVisible(true);
            //
            System.out.println("mapa activado");
        }
    }//GEN-LAST:event_mapaMouseClicked

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel1MouseClicked

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        System.out.println(pmapa);
        if (mapa_pantalla != null) {
            pmapa = mapa_pantalla.isVisible();
            if (pmapa) {
                mapa_pantalla.dispose();
                pmapa = false;
                map = false;

            }
        }

    }//GEN-LAST:event_formMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jugador;
    private javax.swing.JLabel mapa;
    private javax.swing.JLabel moneda;
    private javax.swing.JLabel nombre_isla;
    private javax.swing.JLabel pista;
    // End of variables declaration//GEN-END:variables
}

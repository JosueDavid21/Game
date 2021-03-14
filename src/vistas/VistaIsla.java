/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import entes.GenerarDimension;
import entes.Isla;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class VistaIsla extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form Isla
     */
    private static int xJugador;
    private static int yJugador;
    private static String rutaPersonaje;
    private static String rutaIsla;
    private int[][] matrizIsla;

    GenerarDimension dimensiones;

    JLabel jLfondo = new JLabel();
    JLabel personaje = new JLabel();
    JLabel jLMapa = new JLabel();
    int x;
    int y;
    int animacion;
//movimiento en x y 
    int moveX = 1;
    int moveY = 1;

    Timer tiempo1 = new Timer(1, this);
    boolean izquierda = false;
    boolean derecha = false;
    boolean arriba = false;
    boolean abajo = false;

    public VistaIsla(Isla isla) {
        dimensiones = new GenerarDimension(new Point(16, 10));
        xJugador = dimensiones.getPuntoInicioJugador().x;
        yJugador = dimensiones.getPuntoInicioJugador().y;
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
        
        isla_nombre=isla.getNombre();
        jPanel1.updateUI();
    }
    //DAVID INICIO
String isla_nombre;
public void agregarMenu(String nombreisla){
    String menu[]={"jugador","moneda","mapa",nombreisla,"pista"};
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
    public void icono2(String name,JLabel label){
        Dimension d = new Dimension(dimensiones.getDimensionMenu().width/5,dimensiones.getDimensionMenu().height);
        ImageIcon im = new ImageIcon("src/imagenes/menu/"+name+" icono.png");
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

    private void mover(/*java.awt.event.KeyEvent evt*/) {
        if (izquierda & !derecha & !arriba & !abajo) {
            x = x - moveX;
            personaje.setLocation(x, y);
            icono_animacion("izquierda");
        } else if (derecha & !arriba & !abajo & !izquierda) {
            x = x + moveX;
            personaje.setLocation(x, y);
            icono_animacion("derecha");
        } else if (arriba & !abajo & !izquierda & !derecha) {
            y = y - moveY;
            personaje.setLocation(x, y);
            icono_animacion("arriba");
        } else if (abajo & !izquierda & !derecha & !arriba) {
            y = y + moveY;
            personaje.setLocation(x, y);
            icono_animacion("abajo");
        } else if (abajo & derecha) {
            y = y + moveY;
            x = x + moveX;
            personaje.setLocation(x, y);
            icono_animacion("abajo");
            icono_animacion("derecha");
        } else if (abajo & izquierda) {
            y = y + moveY;
            x = x - moveX;
            personaje.setLocation(x, y);
            icono_animacion("abajo");
            icono_animacion("izquierda");
        } else if (arriba & derecha) {
            y = y - moveY;
            x = x + moveX;
            personaje.setLocation(x, y);
            icono_animacion("arriba");
            icono_animacion("derecha");
        } else if (arriba & izquierda) {
            y = y - moveY;
            x = x - moveX;
            personaje.setLocation(x, y);
            icono_animacion("arriba");
            icono_animacion("izquierda");
        }
    }

//    public boolean comprobar(char tecla, int x, int y) {
//        int i = x / dimensiones.getDimensionPersonaje().width;
//        int j = y / dimensiones.getDimensionPersonaje().height;
//        int valorProximo = 0;
//        switch (String.valueOf(tecla)) {
//            case "w":
//                valorProximo = matrizIsla[i][j - 1];
//                break;
//            case "s":
//                valorProximo = matrizIsla[i][j + 1];
//                break;
//            case "a":
//                valorProximo = matrizIsla[i - 1][j];
//                break;
//            case "d":
//                valorProximo = matrizIsla[i + 1][j];
//                break;
//            default:
//                break;
//        }
//        return valorProximo < 11;
//    }

    public void actionPerformed(ActionEvent c) {
        x = personaje.getX();
        y = personaje.getY();
        actualizar();
        mover();
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
boolean map=false;
public void validarvisible(){
    if (mapa_pantalla!=null) {
        if (mapa_pantalla.isVisible()) {
        map=true;
    }
    }
    
}
boolean pmapa = false;
    private void mapaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapaMouseClicked
        // TODO add your handling code here:
        validarvisible();
        System.out.println(map+" map+");
        if (map==false) {
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
                pmapa=false;
                map=false;
            
                
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

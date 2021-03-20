/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import control.Grafo;
import control.Reproducir;
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
import java.util.Arrays;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
private String nombre_jugador ;
private int cant_moneda;
private int cant_tesoros;
    boolean retorno;
    private final Point pSI = new Point();
    private final Point pSD = new Point();
    private final Point pII = new Point();
    private final Point pID = new Point();
    private final Tile t = new Tile();
    Grafo g = new Grafo("abcdefghijk");
    Reproducir musica = new Reproducir();
    public VistaIsla(Isla isla, Point jug) {
        dimensiones = new GenerarDimension(jug);
        rutaPersonaje = "src/imagenes/personajes/inicio.png";
        rutaIsla = isla.getUrlImagen();
        matrizIsla = isla.getMatriz();

        initComponents();
        try {
            musica.ReproducirSonido("src/musica/sonido_1.wav");
        } catch (Exception e) {
        }
        
        g.iniciargrafo(g);
        isla_nombre = isla.getNombre();
nombre_jugador="david";
System.out.println(Arrays.toString(g.rutaDificultad(g.String_char(isla_nombre),"difiCil")));
cant_moneda=g.dificil;
cant_tesoros=0;

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

        
        jPanel1.updateUI();
        
    }
    
    //DAVID INICIO
    String isla_nombre;

    public void agregarMenu(String nombreisla) {
        fondo( jugador_fondo,1);
        posiciones(jugador_texto, jugador_icono,"jugador",1,null);
        fondo( moneda_fondo,1);
        posiciones(moneda_texto, moneda_icono,"moneda",2,moneda_texto1);
        fondo(tesoro_fondo,1);
        posiciones(tesoro_texto, tesoro_icono,"tesoro",2,tesoro_texto1);
        fondo(interaccion_fondo, 2);
        posiciones(interaccion_texto, interaccion_icono,"interaccion",4,null);
        fondo( mapa_fondo,1);
        posiciones(mapa_texto, mapa_icono,"mapa",1,null);
        fondo( nombreisla_fondo,1);
        posiciones(nombreisla_texto, nombreisla_icono,isla_nombre,1,null);
        fondo( mutehelp_fondo,1);
         posiciones(null, mutehelp_mute_icono,"mutehelp",3,mutehelp_help_icono);
        jPanel1.updateUI();
    }
public void posiciones(JLabel texto,JLabel icon,String nombre,int tipo,JLabel aux){
    double ancho=dimensiones.getDimensionMenu().width/7;
    double alto=dimensiones.getDimensionMenu().getHeight();
    double por_ancho_texto= 50*ancho/100;
    double por_alto_texto=85*alto/100;
         
        if (tipo==1) {
            icono2(icon, nombre);
        if (nombre=="jugador") {
            texto.setText(nombre_jugador.trim().toUpperCase());  
        }else if(nombre==isla_nombre){      
            texto.setText(nombre.trim().toUpperCase()); 
        }else if(nombre=="mapa"){      
            texto.setText(nombre.trim().toUpperCase()); 
        }
        texto.setSize(dimensiones.getDimensionMenu().width/7,20);
    double por_ancho_icono= 50*ancho/100;
    double por_alto_icono= 15*alto/100;
    icon.setLocation(new Point((int)por_ancho_icono-icon.getSize().width/2,(int)(por_alto_icono/*-icon.getSize().getHeight()/2*/)));
    texto.setLocation(new Point((int)por_ancho_texto-texto.getSize().width/2,(int)(por_alto_texto-texto.getSize().getHeight()/2)));
        }
    if (tipo==2) {
           
    double por_ancho_icono= 40*ancho/100;
    double por_alto_icono= 15*alto/100;
     double por_ancho_aux= 70*ancho/100;
    double por_alto_aux=35*alto/100;
        icono2(icon, nombre);
         texto.setText(nombre.trim().toUpperCase());
         
         if (nombre=="moneda") {
            aux.setText(String.valueOf(cant_moneda)); 
        }else  if (nombre=="tesoro"){
         aux.setText(String.valueOf(cant_tesoros)); 
        }
         aux.setSize(40,20);
         aux.setLocation(new Point((int)por_ancho_aux-aux.getSize().width/2,(int)(por_alto_aux-aux.getSize().getHeight()/2)));
        texto.setSize(dimensiones.getDimensionMenu().width/7,20);
        icon.setLocation(new Point((int)por_ancho_icono-icon.getSize().width/2,(int)(por_alto_icono/*-icon.getSize().getHeight()/2*/)));
         texto.setLocation(new Point((int)por_ancho_texto-texto.getSize().width/2,(int)(por_alto_texto-texto.getSize().getHeight()/2)));
}
    if (tipo==3) {
        double por_ancho_icono= 30*ancho/100;
    double por_alto_icono= 50*alto/100;
     double por_ancho_aux= 70*ancho/100;
    double por_alto_aux=50*alto/100;
        icono2(icon, "speaker");
         icono2(aux, "help");
        icon.setLocation(new Point((int)por_ancho_icono-icon.getSize().width/2,(int)(por_alto_icono-aux.getSize().getHeight()/2)));
        aux.setLocation(new Point((int)por_ancho_aux-aux.getSize().width/2,(int)(por_alto_aux-aux.getSize().getHeight()/2)));
    }
    if (tipo==4) {
        icono2(icon, "blanco");
//        jTextArea1.setText("HOLASKOLAMSDKL ALKDMKLAMD ALKWMDKLASMD ALKDMKLASMD ALKMDKALSMD ASKDM");
    double por_ancho_icono= 50*ancho/100;
    double por_alto_icono= 8*alto/100;
    texto.setSize(dimensiones.getDimensionMenu().width/7,20);
    icon.setLocation(new Point((int)por_ancho_icono-icon.getSize().width/2,(int)(por_alto_icono/*-icon.getSize().getHeight()/2*/)));
    texto.setLocation(new Point((int)por_ancho_texto-texto.getSize().width/2,(int)(por_alto_texto-texto.getSize().getHeight()/2)));
    }
}
    public void actualizar() {
        if (animacion < 32000) {
            animacion++;
        } else {
            animacion = 0;
        }
        // AQUI VA EL CAMBIO EN MONEDAS Y TESOROS
////        if (mapa_pantalla!=null) {
////            cant_moneda++;
////            moneda_texto1.setText(String.valueOf(cant_moneda));
////        }else{
////            cant_moneda--;
////            moneda_texto1.setText(String.valueOf(cant_moneda));
////        }
if (mapa_pantalla!=null) {
            icono2(interaccion_icono, "personaje1");
            interaccion_texto.setText("HOLLA PERRO");
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
    public void icono2(JLabel label,String name ) {
        Dimension d = new Dimension(dimensiones.getDimensionPersonaje().width+10 , dimensiones.getDimensionPersonaje().height+10);
        label.setSize(d);
        ImageIcon im = new ImageIcon("src/imagenes/menu/" + name + " icono.png");
        ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
        
        label.setIcon(icono);
    }
public void fondo(JLabel label,int tipo){
    Dimension d = new Dimension(dimensiones.getDimensionMenu().width / 7, dimensiones.getDimensionMenu().height);
    label.setSize(d);
    if (tipo==1) {
        ImageIcon im = new ImageIcon("src/imagenes/menu/fondo.png");
        ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance((int)d.getWidth(), (int)d.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
    } else{
        ImageIcon im = new ImageIcon("src/imagenes/menu/borde.png");
        ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance((int)d.getWidth(), (int)d.getHeight(), Image.SCALE_DEFAULT));
        label.setIcon(icono);
    }
    
        
        
        
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
        jugador_Panel = new javax.swing.JPanel();
        jugador_icono = new javax.swing.JLabel();
        jugador_texto = new javax.swing.JLabel();
        jugador_fondo = new javax.swing.JLabel();
        moneda_Panel = new javax.swing.JPanel();
        moneda_icono = new javax.swing.JLabel();
        moneda_texto = new javax.swing.JLabel();
        moneda_texto1 = new javax.swing.JLabel();
        moneda_fondo = new javax.swing.JLabel();
        tesoro_Panel = new javax.swing.JPanel();
        tesoro_icono = new javax.swing.JLabel();
        tesoro_texto = new javax.swing.JLabel();
        tesoro_texto1 = new javax.swing.JLabel();
        tesoro_fondo = new javax.swing.JLabel();
        interaccion_Panel = new javax.swing.JPanel();
        interaccion_icono = new javax.swing.JLabel();
        interaccion_texto = new javax.swing.JLabel();
        interaccion_fondo = new javax.swing.JLabel();
        mapa_Panel = new javax.swing.JPanel();
        mapa_icono = new javax.swing.JLabel();
        mapa_texto = new javax.swing.JLabel();
        mapa_fondo = new javax.swing.JLabel();
        nombreisla_Panel = new javax.swing.JPanel();
        nombreisla_icono = new javax.swing.JLabel();
        nombreisla_texto = new javax.swing.JLabel();
        nombreisla_fondo = new javax.swing.JLabel();
        mutehelp_Panel = new javax.swing.JPanel();
        mutehelp_mute_icono = new javax.swing.JLabel();
        mutehelp_help_icono = new javax.swing.JLabel();
        mutehelp_fondo = new javax.swing.JLabel();

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

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });
        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jugador_Panel.setBackground(new java.awt.Color(255, 255, 51));
        jugador_Panel.setLayout(null);

        jugador_icono.setText("jLabel1");
        jugador_Panel.add(jugador_icono);
        jugador_icono.setBounds(50, 20, 41, 16);

        jugador_texto.setForeground(new java.awt.Color(255, 255, 255));
        jugador_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jugador_texto.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jugador_Panel.add(jugador_texto);
        jugador_texto.setBounds(60, 180, 0, 0);
        jugador_Panel.add(jugador_fondo);
        jugador_fondo.setBounds(0, 0, 0, 0);

        jPanel1.add(jugador_Panel);

        moneda_Panel.setBackground(new java.awt.Color(255, 153, 0));
        moneda_Panel.setLayout(null);
        moneda_Panel.add(moneda_icono);
        moneda_icono.setBounds(0, 0, 0, 0);

        moneda_texto.setForeground(new java.awt.Color(255, 255, 255));
        moneda_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moneda_Panel.add(moneda_texto);
        moneda_texto.setBounds(0, 0, 0, 0);

        moneda_texto1.setForeground(new java.awt.Color(255, 255, 255));
        moneda_texto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        moneda_Panel.add(moneda_texto1);
        moneda_texto1.setBounds(0, 0, 0, 0);
        moneda_Panel.add(moneda_fondo);
        moneda_fondo.setBounds(0, 0, 0, 0);

        jPanel1.add(moneda_Panel);

        tesoro_Panel.setBackground(new java.awt.Color(153, 153, 0));
        tesoro_Panel.setLayout(null);
        tesoro_Panel.add(tesoro_icono);
        tesoro_icono.setBounds(0, 0, 0, 0);

        tesoro_texto.setForeground(new java.awt.Color(255, 255, 255));
        tesoro_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tesoro_Panel.add(tesoro_texto);
        tesoro_texto.setBounds(0, 0, 0, 0);

        tesoro_texto1.setForeground(new java.awt.Color(255, 255, 255));
        tesoro_texto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tesoro_Panel.add(tesoro_texto1);
        tesoro_texto1.setBounds(0, 0, 0, 0);
        tesoro_Panel.add(tesoro_fondo);
        tesoro_fondo.setBounds(0, 0, 0, 0);

        jPanel1.add(tesoro_Panel);

        interaccion_Panel.setBackground(new java.awt.Color(255, 255, 255));
        interaccion_Panel.setLayout(null);
        interaccion_Panel.add(interaccion_icono);
        interaccion_icono.setBounds(0, 0, 0, 0);

        interaccion_texto.setForeground(new java.awt.Color(0, 0, 0));
        interaccion_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        interaccion_Panel.add(interaccion_texto);
        interaccion_texto.setBounds(0, 0, 0, 0);
        interaccion_Panel.add(interaccion_fondo);
        interaccion_fondo.setBounds(0, 0, 0, 0);

        jPanel1.add(interaccion_Panel);

        mapa_Panel.setBackground(new java.awt.Color(0, 255, 51));
        mapa_Panel.setLayout(null);

        mapa_icono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapa_iconoMouseClicked(evt);
            }
        });
        mapa_Panel.add(mapa_icono);
        mapa_icono.setBounds(0, 0, 0, 0);

        mapa_texto.setForeground(new java.awt.Color(255, 255, 255));
        mapa_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mapa_Panel.add(mapa_texto);
        mapa_texto.setBounds(0, 0, 0, 0);
        mapa_Panel.add(mapa_fondo);
        mapa_fondo.setBounds(0, 0, 0, 0);

        jPanel1.add(mapa_Panel);

        nombreisla_Panel.setBackground(new java.awt.Color(255, 0, 255));
        nombreisla_Panel.setLayout(null);
        nombreisla_Panel.add(nombreisla_icono);
        nombreisla_icono.setBounds(0, 0, 0, 0);

        nombreisla_texto.setForeground(new java.awt.Color(255, 255, 255));
        nombreisla_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreisla_Panel.add(nombreisla_texto);
        nombreisla_texto.setBounds(0, 0, 0, 0);
        nombreisla_Panel.add(nombreisla_fondo);
        nombreisla_fondo.setBounds(0, 0, 0, 0);

        jPanel1.add(nombreisla_Panel);

        mutehelp_Panel.setBackground(new java.awt.Color(102, 255, 255));
        mutehelp_Panel.setLayout(null);

        mutehelp_mute_icono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mutehelp_mute_iconoMouseClicked(evt);
            }
        });
        mutehelp_Panel.add(mutehelp_mute_icono);
        mutehelp_mute_icono.setBounds(0, 0, 0, 0);

        mutehelp_help_icono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mutehelp_help_iconoMouseClicked(evt);
            }
        });
        mutehelp_Panel.add(mutehelp_help_icono);
        mutehelp_help_icono.setBounds(0, 0, 0, 0);
        mutehelp_Panel.add(mutehelp_fondo);
        mutehelp_fondo.setBounds(0, 0, 0, 0);

        jPanel1.add(mutehelp_Panel);

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

    private void mutehelp_help_iconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mutehelp_help_iconoMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_mutehelp_help_iconoMouseClicked

    private void mapa_iconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapa_iconoMouseClicked
        // TODO add your handling code here:
        validarvisible();
        System.out.println(map + " map+");
        if (map == false) {
            mapa_pantalla = new Mapa_Vista(isla_nombre);
            mapa_pantalla.setVisible(true);
            //
            System.out.println("mapa activado");
        }
    }//GEN-LAST:event_mapa_iconoMouseClicked

    private void mutehelp_mute_iconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mutehelp_mute_iconoMouseClicked
        // TODO add your handling code here:
        musica.Pausa();
    }//GEN-LAST:event_mutehelp_mute_iconoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel interaccion_Panel;
    private javax.swing.JLabel interaccion_fondo;
    private javax.swing.JLabel interaccion_icono;
    private javax.swing.JLabel interaccion_texto;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jugador_Panel;
    private javax.swing.JLabel jugador_fondo;
    private javax.swing.JLabel jugador_icono;
    private javax.swing.JLabel jugador_texto;
    private javax.swing.JPanel mapa_Panel;
    private javax.swing.JLabel mapa_fondo;
    private javax.swing.JLabel mapa_icono;
    private javax.swing.JLabel mapa_texto;
    private javax.swing.JPanel moneda_Panel;
    private javax.swing.JLabel moneda_fondo;
    private javax.swing.JLabel moneda_icono;
    private javax.swing.JLabel moneda_texto;
    private javax.swing.JLabel moneda_texto1;
    private javax.swing.JPanel mutehelp_Panel;
    private javax.swing.JLabel mutehelp_fondo;
    private javax.swing.JLabel mutehelp_help_icono;
    private javax.swing.JLabel mutehelp_mute_icono;
    private javax.swing.JPanel nombreisla_Panel;
    private javax.swing.JLabel nombreisla_fondo;
    private javax.swing.JLabel nombreisla_icono;
    private javax.swing.JLabel nombreisla_texto;
    private javax.swing.JPanel tesoro_Panel;
    private javax.swing.JLabel tesoro_fondo;
    private javax.swing.JLabel tesoro_icono;
    private javax.swing.JLabel tesoro_texto;
    private javax.swing.JLabel tesoro_texto1;
    // End of variables declaration//GEN-END:variables
}

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

import control.GestionTiles;
import control.Grafo;
import control.Pistas;
import control.Reproducir;
import java.util.Arrays;
import control.GenerarDimension;
import entes.Inventario;
import entes.Isla;
import entes.Protagonista;
import entes.Puente;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Grupo 9
 */
public final class VistaIsla extends javax.swing.JFrame implements ActionListener {

    private static String pista;
    private String rutaPersonaje;
    private String rutaIsla;
    private int[][] matrizIsla;

    GenerarDimension dimensiones;
    private GestionTiles gestionTile;
    Mapa_Vista mapa_pantalla;

    boolean map = false;
    boolean pmapa = false;
    boolean arriba;
    boolean abajo;
    boolean izquierda;
    boolean derecha;
    boolean fin_game = false;
    boolean fin_gameover = false;
    boolean cont = false;
    boolean retorno;

    private Timer tiempo1 = new Timer(10, this);

    JLabel jLfondo = new JLabel();
    JLabel personaje = new JLabel();
    JLabel personaje1 = new JLabel();
    JLabel personaje2 = new JLabel();
    JLabel personaje3 = new JLabel();
    JLabel jLMapa = new JLabel();

    private int x;
    private int y;
    private int animacion;
    private final int moveX = 1;
    private final int moveY = 1;
    private final String nombre_jugador;
    private int cont_pista = 0;

    String camino[];
    Grafo g = new Grafo("abcdefghijk");
    Reproducir musica = new Reproducir();

    public VistaIsla(Isla isla, Point jug) {
        dimensiones = new GenerarDimension(jug);
        rutaPersonaje = "src/imagenes/personajes/inicio.png";
        rutaIsla = isla.getUrlImagen();
        matrizIsla = isla.getMatriz();

        initComponents();
        Grafo g2 = new Grafo("abcdefghijk");
        g2.iniciargrafo(g2);
        if(!g2.validar_monedas(isla.getNombre())){
//            if(Inventario.getTesoros().get(moveX)){
//                
//            }
        }
        try {
            musica.ReproducirSonido("src/musica/sonido_1.wav");
        } catch (Exception e) {
        }

        g.iniciargrafo(g);

        isla_nombre = isla.getNombre();
        nombre_jugador = new Protagonista().getNombre();
        g.rutaDificultad(g.String_char(isla_nombre), new Pistas().getDificultad());
        camino = new Pistas().getCamino_inicial();
        System.out.println(Arrays.toString(camino) + "CAMINO INICIAL");

        agregarMenu(isla.getNombre());

        jPanel1.setSize(dimensiones.getDimensionMenu());
        jPanel1.setLocation(dimensiones.getPuntoInicioMenu());

        this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(dimensiones.getWIDTH(), dimensiones.getHEIGHT());
        this.setResizable(false);
        this.setLocation(0, 0);
        this.getContentPane().setBackground(Color.black);
        gestionTile = new GestionTiles(isla.getNombre(), matrizIsla, personaje);

        generarPersonaje(rutaPersonaje);
        ArrayList<Point> p = gestionTile.buscarPersonajes();
        generarP1(p.get(0).x, p.get(0).y);
        generarP2(p.get(1).x, p.get(1).y);
        if (p.size() == 3) {
            generarP3(p.get(2).x, p.get(2).y);
        }
        generarIsla();

        this.x = personaje.getLocation().x;
        this.y = personaje.getLocation().y;

        jPanel1.updateUI();

    }

    //DAVID INICIO
    String isla_nombre;

    public void agregarMenu(String nombreisla) {
        fondo(jugador_fondo, 1);
        posiciones(jugador_texto, jugador_icono, "jugador", 1, null);
        fondo(moneda_fondo, 1);
        posiciones(moneda_texto, moneda_icono, "moneda", 2, moneda_texto1);
        fondo(tesoro_fondo, 1);
        posiciones(tesoro_texto, tesoro_icono, "tesoro", 2, tesoro_texto1);
        fondo(interaccion_fondo, 2);
        posiciones(interaccion_texto, interaccion_icono, "interaccion", 4, null);
        fondo(mapa_fondo, 1);
        posiciones(mapa_texto, mapa_icono, "mapa", 1, null);
        fondo(nombreisla_fondo, 1);
        posiciones(nombreisla_texto, nombreisla_icono, isla_nombre, 5, nombreisla_icono1);
        fondo(mutehelp_fondo, 1);
        posiciones(mutehelp_mute_icono1, mutehelp_mute_icono, "mutehelp", 3, mutehelp_help_icono);
        jPanel1.updateUI();
    }

    public void posiciones(JLabel texto, JLabel icon, String nombre, int tipo, JLabel aux) {
        double ancho = dimensiones.getDimensionMenu().width / 7;
        double alto = dimensiones.getDimensionMenu().getHeight();
        double por_ancho_texto = 50 * ancho / 100;
        double por_alto_texto = 85 * alto / 100;

        if (tipo == 1) {
            icono2(icon, nombre);
            if (nombre == "jugador") {
                texto.setText(nombre_jugador.trim());
            } else if (nombre == "mapa") {
                texto.setText(nombre.trim().toUpperCase());
            }
            texto.setSize(dimensiones.getDimensionMenu().width / 7, 20);
            double por_ancho_icono = 50 * ancho / 100;
            double por_alto_icono = 15 * alto / 100;
            icon.setLocation(new Point((int) por_ancho_icono - icon.getSize().width / 2, (int) (por_alto_icono/*-icon.getSize().getHeight()/2*/)));
            texto.setLocation(new Point((int) por_ancho_texto - texto.getSize().width / 2, (int) (por_alto_texto - texto.getSize().getHeight() / 2)));
        }
        if (tipo == 2) {

            double por_ancho_icono = 40 * ancho / 100;
            double por_alto_icono = 15 * alto / 100;
            double por_ancho_aux = 70 * ancho / 100;
            double por_alto_aux = 35 * alto / 100;
            icono2(icon, nombre);
            texto.setText(nombre.trim().toUpperCase());

            if (nombre == "moneda") {
                aux.setText(String.valueOf(Inventario.monedas));
            } else if (nombre == "tesoro") {
                aux.setText(String.valueOf(Inventario.tesoros.size()));
            }
            aux.setSize(40, 20);
            aux.setLocation(new Point((int) por_ancho_aux - aux.getSize().width / 2, (int) (por_alto_aux - aux.getSize().getHeight() / 2)));
            texto.setSize(dimensiones.getDimensionMenu().width / 7, 20);
            icon.setLocation(new Point((int) por_ancho_icono - icon.getSize().width / 2, (int) (por_alto_icono/*-icon.getSize().getHeight()/2*/)));
            texto.setLocation(new Point((int) por_ancho_texto - texto.getSize().width / 2, (int) (por_alto_texto - texto.getSize().getHeight() / 2)));
        }
        if (tipo == 3) {
            double por_ancho_icono = 30 * ancho / 100;
            double por_alto_icono = 50 * alto / 100;
            double por_ancho_aux = 70 * ancho / 100;
            double por_alto_aux = 50 * alto / 100;
            icono2(icon, "speaker");
            icono2(texto, "speakeroff");
            icono2(aux, "help");
            icon.setLocation(new Point((int) por_ancho_icono - icon.getSize().width / 2, (int) (por_alto_icono - aux.getSize().getHeight() / 2)));
            texto.setVisible(false);
            aux.setLocation(new Point((int) por_ancho_aux - aux.getSize().width / 2, (int) (por_alto_aux - aux.getSize().getHeight() / 2)));
            texto.setLocation(new Point((int) por_ancho_icono - icon.getSize().width / 2, (int) (por_alto_icono - aux.getSize().getHeight() / 2)));
        }
        if (tipo == 4) {
            icono2(icon, "blanco");
//        jTextArea1.setText("HOLASKOLAMSDKL ALKDMKLAMD ALKWMDKLASMD ALKDMKLASMD ALKMDKALSMD ASKDM");
            double por_ancho_icono = 50 * ancho / 100;
            double por_alto_icono = 8 * alto / 100;
            texto.setSize(dimensiones.getDimensionMenu().width / 7, 20);
            icon.setLocation(new Point((int) por_ancho_icono - icon.getSize().width / 2, (int) (por_alto_icono/*-icon.getSize().getHeight()/2*/)));
            texto.setLocation(new Point((int) por_ancho_texto - texto.getSize().width / 2, (int) (por_alto_texto - texto.getSize().getHeight() / 2)));
        }
        if (tipo == 5) {
            icono2(icon, nombre);
            icono2(aux, camino[camino.length - 1]);
            texto.setText(nombre.trim().toUpperCase());
            texto.setSize(dimensiones.getDimensionMenu().width / 7, 20);
//            texto.setVisible(true);
            nombreisla_texto1.setText(camino[camino.length - 1].toUpperCase().trim());
            nombreisla_texto1.setSize(dimensiones.getDimensionMenu().width / 7, 20);
            icono2(nombreisla_icono_flecha, "flecha");
            nombreisla_icono_flecha.setLocation((int) (50 * ancho / 100 - icon.getSize().width / 2), (int) (50 * alto / 100) - icon.getSize().height / 2);
            double por_ancho_texto1 = 27 * ancho / 100;
            double por_alto_texto1 = 85 * alto / 100;
            double por_ancho_texto2 = 75 * ancho / 100;
            double por_alto_texto2 = 85 * alto / 100;
            double por_ancho_icono = 27 * ancho / 100;
            double por_alto_icono = 50 * alto / 100;
            double por_ancho_aux = 75 * ancho / 100;
            double por_alto_aux = 50 * alto / 100;
            icon.setLocation(new Point((int) por_ancho_icono - icon.getSize().width / 2, (int) (por_alto_icono - aux.getSize().getHeight() / 2)));

            aux.setLocation(new Point((int) por_ancho_aux - aux.getSize().width / 2, (int) (por_alto_aux - aux.getSize().getHeight() / 2)));
            texto.setLocation(new Point((int) por_ancho_texto1 - texto.getSize().width / 2, (int) (por_alto_texto1 - texto.getSize().getHeight() / 2)));
            nombreisla_texto1.setLocation(new Point((int) por_ancho_texto2 - texto.getSize().width / 2, (int) (por_alto_texto2 - texto.getSize().getHeight() / 2)));
            if (nombreisla_texto.getText() == null ? nombreisla_texto1.getText() == null : nombreisla_texto.getText().equals(nombreisla_texto1.getText())) {
                fin_game = true;
            }
        }
    }

    public void actualizar() {
        if (animacion < 32000) {
            animacion++;
        } else {
            animacion = 0;
        }
        Pistas p = new Pistas();
        // AQUI VA EL CAMBIO EN MONEDAS Y TESOROS
        if (nombreisla_texto.getText() == nombreisla_texto1.getText()) {
            fin_game = true;
        }
        if ("dificil".equals(new Pistas().getDificultad())) {
            String t1 = nombreisla_texto.getText().toLowerCase();
            String t2 = "";
            t2 = camino[new Pistas().getCont()];
            if (cont_pista > 0) {
                t2 = camino[new Pistas().getCont() - 1];
            }
            if (t1 == null ? t2 != null : !t1.equals(t2)) {
                System.out.println(nombreisla_texto.getText().toLowerCase());
                System.out.println(camino[new Pistas().getCont()]);
                fin_gameover = true;
            }
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
    public void icono2(JLabel label, String name) {
        Dimension d = new Dimension(dimensiones.getDimensionCuadro().width + 10, dimensiones.getDimensionCuadro().height + 10);
        label.setSize(d);
        ImageIcon im = new ImageIcon("src/imagenes/menu/" + name + " icono.png");
        ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));

        label.setIcon(icono);
    }

    public void iconoInteraccion(JLabel label, String name) {
        Dimension d = new Dimension(dimensiones.getDimensionPersonaje().width + 10, dimensiones.getDimensionPersonaje().height + 10);
        label.setSize(d);
        ImageIcon im = new ImageIcon("src/imagenes/" + name);
        ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH));
        label.setIcon(icono);
    }

    public void fondo(JLabel label, int tipo) {
        Dimension d = new Dimension(dimensiones.getDimensionMenu().width / 7, dimensiones.getDimensionMenu().height);
        label.setSize(d);
        if (tipo == 1) {
            ImageIcon im = new ImageIcon("src/imagenes/menu/fondo.png");
            ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance((int) d.getWidth(), (int) d.getHeight(), Image.SCALE_DEFAULT));
            label.setIcon(icono);
        } else {
            ImageIcon im = new ImageIcon("src/imagenes/menu/borde.png");
            ImageIcon icono = new ImageIcon(im.getImage().getScaledInstance((int) d.getWidth(), (int) d.getHeight(), Image.SCALE_DEFAULT));
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

    private void generarP1(int x, int y) {
        String ruta = "src/imagenes/personajes/" + isla_nombre + "/1.png";
        Image imgEscalada = new ImageIcon(ruta).getImage().getScaledInstance(dimensiones.getDimensionCuadro().width,
                dimensiones.getDimensionCuadro().height, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        personaje1.setSize(dimensiones.getDimensionCuadro());
        personaje1.setIcon(iconoEscalado);
        personaje1.setLocation((dimensiones.getDimensionCuadro().width * x) + (dimensiones.getSobraX() / 2),
                (dimensiones.getDimensionCuadro().height * y));
        add(personaje1);
    }

    private void generarP2(int x, int y) {
        String ruta = "src/imagenes/personajes/" + isla_nombre + "/2.png";
        Image imgEscalada = new ImageIcon(ruta).getImage().getScaledInstance(dimensiones.getDimensionCuadro().width,
                dimensiones.getDimensionCuadro().height, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        personaje2.setSize(dimensiones.getDimensionCuadro());
        personaje2.setIcon(iconoEscalado);
        personaje2.setLocation((dimensiones.getDimensionCuadro().width * x) + (dimensiones.getSobraX() / 2),
                (dimensiones.getDimensionCuadro().height * y));
        add(personaje2);
    }

    private void generarP3(int x, int y) {
        String ruta = "src/imagenes/personajes/" + isla_nombre + "/3.png";
        Image imgEscalada = new ImageIcon(ruta).getImage().getScaledInstance(dimensiones.getDimensionCuadro().width,
                dimensiones.getDimensionCuadro().height, Image.SCALE_SMOOTH);
        Icon iconoEscalado = new ImageIcon(imgEscalada);
        personaje3.setSize(dimensiones.getDimensionCuadro());
        personaje3.setIcon(iconoEscalado);
        personaje3.setLocation((dimensiones.getDimensionCuadro().width * x) + (dimensiones.getSobraX() / 2),
                (dimensiones.getDimensionCuadro().height * y));
        add(personaje3);
    }

    @Override
    public void actionPerformed(ActionEvent c) {
        actualizar();
        mover();
        if (fin_game) {
            JOptionPane.showMessageDialog(this, "Has llegado a tu isla destino HAS GANADO");
            System.exit(0);
        } else if (fin_gameover) {
//            System.out.println("hola");
            JOptionPane.showMessageDialog(this, "Has perdido no elegiste el camino mas corto ");
            System.exit(0);
        }
    }

    private void mostrarMensaje(String[] array) {
        tiempo1.stop();
        if (!array[0].equals("")) {
            moneda_texto1.setText(String.valueOf(Inventario.monedas));
            interaccion_texto.setText(array[0]);
            tesoro_texto1.setText(String.valueOf(Inventario.tesoros.size()));
            if (!array[1].equals("")) {
                iconoInteraccion(interaccion_icono, array[1]);
            }
        }
    }

    private void paseIsla() {
        Puente p = gestionTile.accionPasePuente(gestionTile.obtenerPuntoPASE());
        Grafo g1 = new Grafo("abcdefghijk");
        g1.iniciargrafo(g1);
        g1.encontrarRutaMinimaDijkstra(g1.String_char(isla_nombre), g1.String_char(p.getDestino()));
        int valor = g1.distanciatotal;
        if (Inventario.monedas>=valor) {
            Inventario.setMonedas(Inventario.monedas-valor);
            new VistaCargar(p.getDestino(), p.getPuntoLlegada()).setVisible(true);
            musica.Pausa();
            tiempo1.stop();
            this.dispose();
        }else{
            interaccion_texto.setText("Monedas insuficiente para cruzar");
        }
    }

    private void mover() {
        if (izquierda & !derecha & !arriba & !abajo) {
            if (gestionTile.verificarMovimiento(x - moveX, y).equals("camino")) {
                x = x - moveX;
                personaje.setLocation(x, y);
                icono_animacion("izquierda");
            } else if (gestionTile.verificarMovimiento(x - moveX, y).equals("pase")) {
                paseIsla();
            } else {
                mostrarMensaje(gestionTile.realizarAccion(-moveX, 0, personaje));
            }

        } else if (derecha & !arriba & !abajo & !izquierda) {
            if (gestionTile.verificarMovimiento(x + moveX, y).equals("camino")) {
                x = x + moveX;
                personaje.setLocation(x, y);
                icono_animacion("derecha");
            } else if (gestionTile.verificarMovimiento(x + moveX, y).equals("pase")) {
                paseIsla();
            } else {
                mostrarMensaje(gestionTile.realizarAccion(moveX, 0, personaje));
            }

        } else if (arriba & !abajo & !izquierda & !derecha) {
            if (gestionTile.verificarMovimiento(x, y - moveY).equals("camino")) {
                y = y - moveY;
                personaje.setLocation(x, y);
                icono_animacion("arriba");
            } else if (gestionTile.verificarMovimiento(x, y - moveY).equals("pase")) {
                paseIsla();
            } else {
                mostrarMensaje(gestionTile.realizarAccion(0, -moveY, personaje));
            }

        } else if (abajo & !izquierda & !derecha & !arriba) {
            if (gestionTile.verificarMovimiento(x, y + moveY).equals("camino")) {
                y = y + moveY;
                personaje.setLocation(x, y);
                icono_animacion("abajo");
            } else if (gestionTile.verificarMovimiento(x, y + moveY).equals("pase")) {
                paseIsla();
            } else {
                mostrarMensaje(gestionTile.realizarAccion(0, moveY, personaje));
            }

        } else if (abajo & derecha) {
            if (gestionTile.verificarMovimiento(x + moveX, y + moveY).equals("camino")) {
                y = y + moveY;
                x = x + moveX;
                personaje.setLocation(x, y);
                icono_animacion("derecha");
            } else if (gestionTile.verificarMovimiento(x + moveX, y + moveY).equals("pase")) {
                paseIsla();
            } else {
                mostrarMensaje(gestionTile.realizarAccion(moveX, moveY, personaje));
            }

        } else if (abajo & izquierda) {
            if (gestionTile.verificarMovimiento(x - moveX, y + moveY).equals("camino")) {
                y = y + moveY;
                x = x - moveX;
                personaje.setLocation(x, y);
                icono_animacion("izquierda");
            } else if (gestionTile.verificarMovimiento(x - moveX, y + moveY).equals("pase")) {
                paseIsla();
            } else {
                mostrarMensaje(gestionTile.realizarAccion(-moveX, moveY, personaje));
            }

        } else if (arriba & derecha) {
            if (gestionTile.verificarMovimiento(x + moveX, y - moveY).equals("camino")) {
                y = y - moveY;
                x = x + moveX;
                personaje.setLocation(x, y);
                icono_animacion("derecha");
            } else if (gestionTile.verificarMovimiento(x + moveX, y - moveY).equals("pase")) {
                paseIsla();
            } else {
                mostrarMensaje(gestionTile.realizarAccion(moveX, -moveY, personaje));
            }

        } else if (arriba & izquierda) {
            if (gestionTile.verificarMovimiento(x - moveX, y - moveY).equals("camino")) {
                y = y - moveY;
                x = x - moveX;
                personaje.setLocation(x, y);
                icono_animacion("izquierda");
            } else if (gestionTile.verificarMovimiento(x - moveX, y - moveY).equals("pase")) {
                paseIsla();
            } else {
                mostrarMensaje(gestionTile.realizarAccion(-moveX, -moveY, personaje));
            }
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
        nombreisla_icono1 = new javax.swing.JLabel();
        nombreisla_icono_flecha = new javax.swing.JLabel();
        nombreisla_texto = new javax.swing.JLabel();
        nombreisla_texto1 = new javax.swing.JLabel();
        nombreisla_fondo = new javax.swing.JLabel();
        mutehelp_Panel = new javax.swing.JPanel();
        mutehelp_mute_icono = new javax.swing.JLabel();
        mutehelp_mute_icono1 = new javax.swing.JLabel();
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

        tesoro_icono.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tesoro_iconoMouseClicked(evt);
            }
        });
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
        nombreisla_Panel.add(nombreisla_icono1);
        nombreisla_icono1.setBounds(0, 0, 0, 0);
        nombreisla_Panel.add(nombreisla_icono_flecha);
        nombreisla_icono_flecha.setBounds(0, 0, 0, 0);

        nombreisla_texto.setForeground(new java.awt.Color(255, 255, 255));
        nombreisla_texto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreisla_Panel.add(nombreisla_texto);
        nombreisla_texto.setBounds(0, 0, 0, 0);

        nombreisla_texto1.setForeground(new java.awt.Color(255, 255, 255));
        nombreisla_texto1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreisla_Panel.add(nombreisla_texto1);
        nombreisla_texto1.setBounds(0, 0, 0, 0);
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

        mutehelp_mute_icono1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mutehelp_mute_icono1MouseClicked(evt);
            }
        });
        mutehelp_Panel.add(mutehelp_mute_icono1);
        mutehelp_mute_icono1.setBounds(0, 0, 0, 0);

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
        interaccion_texto.setText("");
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
InventarioVista inv_vista;
boolean inv=false;
    public void validarvisible() {
        if (mapa_pantalla != null ) {
            if (mapa_pantalla.isVisible() ) {
                map = true;
            }
           
        }
        if ( inv_vista!=null) {
             if (inv_vista.isVisible()) {
                inv=true;
            }
        }
       

    }
//    public void validarvisible1() {
//         if ( inv_vista!=null) {
//             if (inv_vista.isVisible()) {
//                inv=true;
//            }
//        }
//
//    }


    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_jPanel1MouseClicked
boolean pinv=false;
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (mapa_pantalla != null  ) {
            pmapa = mapa_pantalla.isVisible();
            
            if (pmapa ) {
                mapa_pantalla.dispose();
                pmapa = false;
                map = false;
            }
        }
        if (inv_vista!=null) {
                pinv=inv_vista.isVisible();
            if (pinv) {
                inv_vista.dispose();
                pinv = false;
                inv = false;
            }
        }
//        if (mapa_pantalla != null) {
//            pmapa = mapa_pantalla.isVisible();
//            if (pmapa) {
//                mapa_pantalla.dispose();
//                pmapa = false;
//                map = false;
//            }
//        }

    }//GEN-LAST:event_formMouseClicked

    private void mutehelp_help_iconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mutehelp_help_iconoMouseClicked
        // TODO add your handling code here:
        Pistas p = new Pistas();
        icono2(interaccion_icono, "help");

        if (!cont) {

            pista = p.pistas_cruzadas(p.getDificultad(), isla_nombre);
            if (p.getDificultad() == "facil" || p.getDificultad() == "medio") {
                interaccion_texto.setText(pista);
            } else if (p.getDificultad() == "dificil") {
//                System.out.println(nombreisla_texto.getText().toLowerCase()+" "+camino[cont_pista-1].toLowerCase());
                cont_pista++;
                interaccion_texto.setText(pista);
            }

            cont = true;
        } else {
            interaccion_texto.setText(pista);
        }
    }//GEN-LAST:event_mutehelp_help_iconoMouseClicked

    private void mapa_iconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapa_iconoMouseClicked
        // TODO add your handling code here:
        validarvisible();
        if (map == false) {
            mapa_pantalla = new Mapa_Vista(isla_nombre);
            mapa_pantalla.setVisible(true);
        }
    }//GEN-LAST:event_mapa_iconoMouseClicked
    boolean muc = true;
    private void mutehelp_mute_iconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mutehelp_mute_iconoMouseClicked
        // TODO add your handling code here:

        mutehelp_mute_icono.setVisible(false);
        mutehelp_mute_icono1.setVisible(true);
        musica.Pausa();
        muc = false;
    }//GEN-LAST:event_mutehelp_mute_iconoMouseClicked

    private void mutehelp_mute_icono1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mutehelp_mute_icono1MouseClicked
        // TODO add your handling code here:
        if (!muc) {
            try {
                musica.ReproducirSonido("src/musica/sonido_1.wav");
            } catch (Exception e) {
            }
            mutehelp_mute_icono1.setVisible(false);
            mutehelp_mute_icono.setVisible(true);
        }
    }//GEN-LAST:event_mutehelp_mute_icono1MouseClicked

    private void tesoro_iconoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tesoro_iconoMouseClicked
        // TODO add your handling code here:
        validarvisible();
        if (inv == false) {
           inv_vista = new InventarioVista();
            inv_vista.setVisible(true);
        }
    }//GEN-LAST:event_tesoro_iconoMouseClicked

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
    private javax.swing.JLabel mutehelp_mute_icono1;
    private javax.swing.JPanel nombreisla_Panel;
    private javax.swing.JLabel nombreisla_fondo;
    private javax.swing.JLabel nombreisla_icono;
    private javax.swing.JLabel nombreisla_icono1;
    private javax.swing.JLabel nombreisla_icono_flecha;
    private javax.swing.JLabel nombreisla_texto;
    private javax.swing.JLabel nombreisla_texto1;
    private javax.swing.JPanel tesoro_Panel;
    private javax.swing.JLabel tesoro_fondo;
    private javax.swing.JLabel tesoro_icono;
    private javax.swing.JLabel tesoro_texto;
    private javax.swing.JLabel tesoro_texto1;
    // End of variables declaration//GEN-END:variables
}

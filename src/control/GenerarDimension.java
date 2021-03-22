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

package control;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

/**
 *
 * @author Grupo 9
 */

public class GenerarDimension {
    
    public static final int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;
    private final int CUADROS_V = 20;
    private final int CUADROS_H = 32;
    private final int SOBRA_PersonajeY = 4;
    private final int SOBRA_PersonajeX = 24;
    private static final double POS_MENU = 0.1;
    private final int sobraX;
    private final int sobraY;

    //   Dimensiones de las pantallas
    private final Point puntoInicioMenu;
    private final Point puntoInicioJuego;
    private final Point puntoInicioJugador;
    
    private static Dimension dimensionMenu , dimensionCuadro, dimensionPersonaje, dimensionJuego;
    
    public GenerarDimension(Point puntoInicial) {
        sobraY = (HEIGHT - (int)(HEIGHT*POS_MENU)) % CUADROS_V;
        sobraX = WIDTH%CUADROS_H;
        dimensionMenu = new Dimension(WIDTH-sobraX, (int)(HEIGHT*POS_MENU)+sobraY);
        dimensionCuadro = new Dimension(WIDTH/CUADROS_H , (HEIGHT-dimensionMenu.height)/CUADROS_V);
        dimensionPersonaje = new Dimension(dimensionCuadro.width-SOBRA_PersonajeX, dimensionCuadro.height-SOBRA_PersonajeY);
        dimensionJuego = new Dimension(WIDTH-sobraX, HEIGHT-dimensionMenu.height);
        puntoInicioMenu = new Point(sobraX/2, dimensionJuego.height);
        puntoInicioJuego = new Point(sobraX/2, 0);
        puntoInicioJugador = new Point((puntoInicial.x*dimensionCuadro.width)+(SOBRA_PersonajeX/2)+(sobraX/2), (puntoInicial.y*dimensionCuadro.height)+(SOBRA_PersonajeY/2));
    }

    public Point getPuntoInicioMenu() {
        return puntoInicioMenu;
    }

    public Point getPuntoInicioJuego() {
        return puntoInicioJuego;
    }

    public Point getPuntoInicioJugador() {
        return puntoInicioJugador;
    }

    public Dimension getDimensionMenu() {
        return dimensionMenu;
    }

    public Dimension getDimensionPersonaje() {
        return dimensionPersonaje;
    }

    public Dimension getDimensionJuego() {
        return dimensionJuego;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public static Dimension getDimensionCuadro() {
        return dimensionCuadro;
    }
    
    public int getSobraX() {
        return sobraX;
    }
    
    public Point getPuntoActual(int xV, int yV){
        return new Point((xV-(sobraX/2))/dimensionCuadro.width, yV/dimensionCuadro.height);
    }
}
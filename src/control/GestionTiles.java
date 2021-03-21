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

import entes.GenerarDimension;
import entes.Inventario;
import entes.Personaje;
import entes.Puente;
import entes.Tile;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import javax.swing.JLabel;
import listas.ListaPersonajes;
import listas.ListaPuentes;
import listas.ListaTesoros;

/**
 *
 * @author Grupo 9
 */
public class GestionTiles {

    private final int[][] matrizIsla;
    private final GenerarDimension dimensiones = new GenerarDimension(new Point(0, 0));
    private final Rectangle recJug = new Rectangle(0, 0, 0, 0);
    private String nombreIsla = "";
    private JLabel personaje = new JLabel();
    private final ListaTesoros tesoros = new ListaTesoros();
    private final ListaPuentes puentes = new ListaPuentes();
    private final ListaPersonajes personajes = new ListaPersonajes();
    private String mensajeRetorno;
    private String rutaRetorno;
    private String tipo;
    private boolean auxRetorno;
    private final Point pSI = new Point();
    private final Point pSD = new Point();
    private final Point pII = new Point();
    private final Point pID = new Point();
    private final static Tile t = new Tile();

    public GestionTiles(String nombreIsla, int[][] matriz, JLabel personaje) {
        this.matrizIsla = matriz;
        this.personaje = personaje;
        this.nombreIsla = nombreIsla;
    }

    public String verificarMovimiento(int xSig, int ySig) {
        tipo = "";
        recJug.setLocation(xSig, ySig + (personaje.getHeight() / 2));
        recJug.setSize(personaje.getWidth(), personaje.getHeight() / 2);
        pSI.setLocation(dimensiones.getPuntoActual(recJug.x, recJug.y));
        pSD.setLocation(dimensiones.getPuntoActual(recJug.x + recJug.width, recJug.y));
        pII.setLocation(dimensiones.getPuntoActual(recJug.x, recJug.y + recJug.height));
        pID.setLocation(dimensiones.getPuntoActual(recJug.x + recJug.width, recJug.y + recJug.height));
        if(esCamino()){
            tipo = "camino";
        }else if(esPase()){
            tipo = "pase";
        }
        return tipo;
    }
    
    private boolean esCamino(){
        auxRetorno = true;
        auxRetorno = auxRetorno && t.esCamino(matrizIsla[pSI.x][pSI.y]);
        auxRetorno = auxRetorno && t.esCamino(matrizIsla[pSD.x][pSD.y]);
        auxRetorno = auxRetorno && t.esCamino(matrizIsla[pII.x][pII.y]);
        auxRetorno = auxRetorno && t.esCamino(matrizIsla[pID.x][pID.y]);
        return auxRetorno;
    }
    
    private boolean esPase(){
        auxRetorno = false;
        auxRetorno = auxRetorno || t.esPasePuente(matrizIsla[pSI.x][pSI.y]);
        auxRetorno = auxRetorno || t.esPasePuente(matrizIsla[pSD.x][pSD.y]);
        auxRetorno = auxRetorno || t.esPasePuente(matrizIsla[pII.x][pII.y]);
        auxRetorno = auxRetorno || t.esPasePuente(matrizIsla[pID.x][pID.y]);
        return auxRetorno;
    }
    
    public Point obtenerPuntoPASE(){
        Point retorno = new Point(0, 0);
        auxRetorno = t.esPasePuente(matrizIsla[pSI.x][pSI.y]);
        retorno.setLocation(pSI.x, pSI.y);
        if(!auxRetorno){
            auxRetorno = t.esPasePuente(matrizIsla[pSD.x][pSD.y]);
            retorno.setLocation(pSD.x, pSD.y);
        }
        if(!auxRetorno){
            auxRetorno = t.esPasePuente(matrizIsla[pII.x][pII.y]);
            retorno.setLocation(pII.x, pII.y);
        }
        if(!auxRetorno){
            auxRetorno = t.esPasePuente(matrizIsla[pID.x][pID.y]);
            retorno.setLocation(pID.x, pID.y);
        }
        return retorno;
    }
    
    public String[] realizarAccion(int x, int y, JLabel  mensaje){
        mensajeRetorno = "";
        rutaRetorno = "";
        if(x==-1 && y==0){   // Izquierda
            if(t.esTesoro(matrizIsla[pSI.x][pSI.y]) || t.esTesoro(matrizIsla[pII.x][pII.y])){
                if(!accionTesoros(pSI.x, pSI.y)){
                    accionTesoros(pII.x, pII.y);
                }
            }else if(t.esPersonaje(matrizIsla[pSI.x][pSI.y]) || t.esPersonaje(matrizIsla[pII.x][pII.y])){
                if(!accionPersonaje(pSI.x, pSI.y)){
                    accionPersonaje(pII.x, pII.y);
                }
            }
            
        }else if(x==1 && y==0){   // Derecha
            if(t.esTesoro(matrizIsla[pSD.x][pSD.y]) || t.esTesoro(matrizIsla[pID.x][pID.y])){
                if(!accionTesoros(pSD.x, pSD.y)){
                    accionTesoros(pID.x, pID.y);
                }
            }else if(t.esPersonaje(matrizIsla[pSD.x][pSD.y]) || t.esPersonaje(matrizIsla[pID.x][pID.y])){
                if(!accionPersonaje(pSD.x, pSD.y)){
                    accionPersonaje(pID.x, pID.y);
                }
            }
            
        }else if(x==0 && y==-1){   // Arriba
            if(t.esTesoro(matrizIsla[pSI.x][pSI.y]) || t.esTesoro(matrizIsla[pSD.x][pSD.y])){
                if(!accionTesoros(pSI.x, pSI.y)){
                    accionTesoros(pSD.x, pSD.y);
                }
            }else if(t.esPersonaje(matrizIsla[pSI.x][pSI.y]) || t.esPersonaje(matrizIsla[pSD.x][pSD.y])){
                if(!accionPersonaje(pSI.x, pSI.y)){
                    accionPersonaje(pSD.x, pSD.y);
                }
            }
            
        }else if(x==0 && y==1){   // Abajo
            if(t.esTesoro(matrizIsla[pII.x][pII.y]) || t.esTesoro(matrizIsla[pID.x][pID.y])){
                if(!accionTesoros(pII.x, pII.y)){
                    accionTesoros(pID.x, pID.y);
                }
            }else if(t.esPersonaje(matrizIsla[pII.x][pII.y]) || t.esPersonaje(matrizIsla[pID.x][pID.y])){ 
                if(!accionPersonaje(pII.x, pII.y)){
                    accionPersonaje(pID.x, pID.y);
                }
            }
            
        }
        return new String[]{mensajeRetorno, rutaRetorno};
    }
    
    private boolean accionTesoros(int x, int y){
        if(tesoros.getUbicacion(nombreIsla).equals(new Point(x, y))){
            if(tesoros.getTesoro(nombreIsla).isEstado()){
                mensajeRetorno = "No hay nada aqui";
                rutaRetorno = "";
            }else{
                tesoros.getTesoro(nombreIsla).setEstado(true);
                Inventario.addTesoro(tesoros.getTesoro(nombreIsla));
                Inventario.setMonedas(Inventario.monedas+10);
                mensajeRetorno = "Encontraste: " + tesoros.getTesoro(nombreIsla).getNombre();
                rutaRetorno = tesoros.getTesoro(nombreIsla).getRutaIMG();
            }
            return true;
        }else{
            return false;
        }
    }
    
    public Puente accionPasePuente(Point puntoActual){
        return puentes.getPuente(nombreIsla, matrizIsla[puntoActual.x][puntoActual.y]);
    }
    
    private boolean accionPersonaje(int x, int y){
        rutaRetorno = "";
        mensajeRetorno = personajes.getFrase(nombreIsla, matrizIsla[x][y]);
        return !mensajeRetorno.equals("");
    }
    
    public ArrayList<Point> buscarPersonajes(){
        ArrayList<Point> retorno = new ArrayList();
        for (int i = 0; i < matrizIsla.length; i++) {
            for (int j = 0; j < matrizIsla[0].length; j++) {
                if(t.esPersonaje(matrizIsla[i][j])){
                    retorno.add(new Point(i, j));
                }
            }
        }
        return retorno;
    }
}

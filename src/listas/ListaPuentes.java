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

package listas;

import entes.Puente;
import java.awt.Point;

/**
 *
 * @author Grupo 9
 */

public class ListaPuentes {
    
    public ListaPuentes() {
    }
    
    private Puente[] getAmorPuentes(){
        return new Puente[]{new Puente("calavera", new Point(27, 1)), new Puente("militar", new Point(30, 18)), new Puente("volcan", new Point(1, 14)), 
            new Puente("desierto", new Point(1, 3))};
    } 
    
    private Puente[] getCalaveraPuentes(){
        return new Puente[]{new Puente("circo", new Point(28, 1)), new Puente("militar", new Point(30, 18)), new Puente("amor", new Point(8, 18)), 
            new Puente("flor", new Point(1, 5))};
    } 
    
    private Puente[] getVolcanPuentes(){
        return new Puente[]{new Puente("flor", new Point(11, 1)), new Puente("desierto", new Point(28, 2)), new Puente("amor", new Point(30, 6))};
    } 
    
    private Puente[] getCircoPuentes(){
        return new Puente[]{new Puente("flor", new Point(1, 1)), new Puente("selva", new Point(30, 1)), new Puente("ruina", new Point(21, 18)), 
            new Puente("calavera", new Point(1, 18))};
    } 
    
    private Puente[] getDulcePuentes(){
        return new Puente[]{new Puente("ruina", new Point(1, 1)), new Puente("playa", new Point(30, 1)), new Puente("militar", new Point(1, 16))};
    } 
    
    private Puente[] getPlayaPuentes(){
        return new Puente[]{new Puente("selva", new Point(1, 1)), new Puente("dulce", new Point(13, 18)), new Puente("ruina", new Point(1, 18))};
    } 
    
    private Puente[] getSelvaPuentes(){
        return new Puente[]{new Puente("playa", new Point(12, 18)), new Puente("ruinas", new Point(1, 18)), new Puente("circo", new Point(1, 4))};
    } 
    
    private Puente[] getRuinaPuentes(){
        return new Puente[]{new Puente("circo", new Point(1, 1)), new Puente("selva", new Point(14, 1)), new Puente("playa", new Point(30, 1)), 
            new Puente("dulce", new Point(30, 18)), new Puente("militar", new Point(1, 18))};
    } 
    
    private Puente[] getDesiertoPuentes(){
        return new Puente[]{new Puente("flor", new Point(25, 1)), new Puente("amor", new Point(30, 16)), new Puente("volcan", new Point(1, 16))};
    } 
    
    private Puente[] getFlorPuentes(){
        return new Puente[]{new Puente("circo", new Point(30, 12)), new Puente("calavera", new Point(18, 18)), new Puente("desierto", new Point(6, 18)), 
            new Puente("volcan", new Point(1, 10))};
    } 
    
    private Puente[] getMilitarPuentes(){
        return new Puente[]{new Puente("calavera", new Point(1, 1)), new Puente("ruina", new Point(19, 1)), new Puente("dulce", new Point(30, 16)),
            new Puente("amor", new Point(1, 11))};
    } 
    
    public Puente getPuente(String islaActual, int tile){
        int indice = 0;
        if(tile==53 || tile==54){
            indice = 0;
        }else if(tile==55 || tile==56){
            indice = 1;
        }else if(tile==57 || tile==58){
            indice = 2;
        }else if(tile==59 || tile==60){
            indice = 3;
        }else if(tile==51 || tile==62){
            indice = 4;
        }
        String islaDestino = obtenerPuentesIslaActual(islaActual)[indice].getDestino();
        Point p = obtenerPuenteRetorno(islaDestino, islaActual);
        return new Puente(islaDestino, p);
    }
    
    private Point obtenerPuenteRetorno(String islaDestino, String islaRetorno){
        Puente[] listaPuentesIslaDestino = obtenerPuentesIslaActual(islaDestino);
        Point punto = new Point(0, 0);
        for (Puente p : listaPuentesIslaDestino) {
            if(p.getDestino().equals(islaRetorno)){
                punto.setLocation(p.getPuntoLlegada());
                break;
            }
        }
        return punto;
    }
    
    private Puente[] obtenerPuentesIslaActual(String islaActual){
        Puente[] list = null;
        switch(islaActual){
            case "amor":
                list = getAmorPuentes();
                break;
            case "calavera":
                list = getCalaveraPuentes();
                break;
            case "volcan":
                list =getVolcanPuentes();
                break;
            case "circo":
                list = getCircoPuentes();
                break;
            case "dulce":
                list = getDulcePuentes();
                break;
            case "playa":
                list = getPlayaPuentes();
                break;
            case "selva":
                list = getSelvaPuentes();
                break;
            case "ruina":
                list = getRuinaPuentes();
                break;
            case "desierto":
                list = getDesiertoPuentes();
                break;
            case "flor":
                list = getFlorPuentes();
                break;
            case "militar":
                list = getMilitarPuentes();
                break;
        }
        return list;
    }
}

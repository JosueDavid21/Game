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

import entes.Tesoro;
import java.awt.Point;
import java.util.HashMap;

/**
 *
 * @author Grupo 9
 */

public class ListaTesoros {

    private final HashMap<String, Tesoro> lista = new HashMap<>();
    private final String ruta = "tesoros" + System.getProperty("file.separator"); 
    
    public ListaTesoros() {
        cargarTesoros();
    }
    
    private void cargarTesoros(){
        lista.put("amor", new Tesoro("Corazon de esmeralda", 
                3, 6, ruta+"Tamor.png", false, "amor"));
        lista.put("calavera", new Tesoro("Espada real", 
                10, 7, ruta+"Tcalavera.png", false, "calavera"));
        lista.put("volcan", new Tesoro("Roca de diamantes", 
                3, 9, ruta+"Tvolcan.png", false, "volcan"));
        lista.put("circo", new Tesoro("Entrada VIP", 
                6, 16, ruta+"Tcirco.png", false, "circo"));
        lista.put("dulce", new Tesoro("Galleta de jengibre", 
                18, 16, ruta+"Tdulce.png", false, "dulce"));
        lista.put("playa", new Tesoro("Perla", 
                13, 12, ruta+"Tplaya.png", false, "playa"));
        lista.put("selva", new Tesoro("Zafiro", 
                13, 14, ruta+"Tselva.png", false, "selva"));
        lista.put("ruina", new Tesoro("Craneo de cristal", 
                13, 16, ruta+"Truina.png", false, "ruina"));
        lista.put("desierto", new Tesoro("Lampara de oro", 
                15, 6, ruta+"Tdesierto.png", false, "desierto"));
        lista.put("flor", new Tesoro("Orquidea Lareal", 
                9, 4, ruta+"Tflor.png", false, "flor"));
        lista.put("militar", new Tesoro("Medalla de honor", 
                14, 14, ruta+"Tmilitar.png", false, "militar"));
    }
    
    public Point getUbicacion(String isla){
        return new Point(lista.get(isla).getPosicionX(), lista.get(isla).getPosicionY());
    }
    
    public Tesoro getTesoro(String isla){
        return lista.get(isla);
    }
}    
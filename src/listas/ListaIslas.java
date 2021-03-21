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

import control.GestionIslaJSON;
import entes.Isla;
import java.util.HashMap;

/**
 *
 * @author Grupo 9
 */

public class ListaIslas {
    
    private final HashMap<String, Isla> lista = new HashMap<>();
    private final String separador = System.getProperty("file.separator");
    
    public ListaIslas() {
    }
    
    private String getRutaIMG(){
        return "src" + separador + "imagenes" + separador + "islas" + separador;
    }
    
    private String getRutaJSON(){
        return "src" + separador + "json" + separador;
    }
    
    public HashMap<String, Isla> getLista() {
        lista.put("amor", new Isla("amor", getRutaIMG()+"amor.png", new GestionIslaJSON(getRutaJSON().concat("amor.json")).obtenerMatriz()));
        lista.put("calavera", new Isla("calavera", getRutaIMG()+"calavera.png", new GestionIslaJSON(getRutaJSON().concat("calavera.json")).obtenerMatriz()));
        lista.put("volcan", new Isla("volcan", getRutaIMG()+"volcan.png", new GestionIslaJSON(getRutaJSON().concat("volcan.json")).obtenerMatriz()));
        lista.put("playa", new Isla("playa", getRutaIMG()+"playa.png", new GestionIslaJSON(getRutaJSON().concat("playa.json")).obtenerMatriz()));
        lista.put("selva", new Isla("selva", getRutaIMG()+"selva.png", new GestionIslaJSON(getRutaJSON().concat("selva.json")).obtenerMatriz()));
        lista.put("circo", new Isla("circo", getRutaIMG()+"circo.png", new GestionIslaJSON(getRutaJSON().concat("circo.json")).obtenerMatriz()));
        lista.put("dulce", new Isla("dulce", getRutaIMG()+"dulce.png", new GestionIslaJSON(getRutaJSON().concat("dulce.json")).obtenerMatriz()));
        lista.put("ruina", new Isla("ruina", getRutaIMG()+"ruina.png", new GestionIslaJSON(getRutaJSON().concat("ruina.json")).obtenerMatriz()));
        lista.put("desierto", new Isla("desierto", getRutaIMG()+"desierto.png", new GestionIslaJSON(getRutaJSON().concat("desierto.json")).obtenerMatriz()));
        lista.put("militar", new Isla("militar", getRutaIMG()+"militar.png", new GestionIslaJSON(getRutaJSON().concat("militar.json")).obtenerMatriz()));
        lista.put("flor", new Isla("flor", getRutaIMG()+"flor.png", new GestionIslaJSON(getRutaJSON().concat("flor.json")).obtenerMatriz()));
        return lista;
    }
    
    
}

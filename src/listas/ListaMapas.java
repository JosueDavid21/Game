/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listas;

import control.GenerarIsla;
import entes.Isla;
import java.util.HashMap;

/**
 *
 * @author grace
 */
public class ListaMapas {
    
    private final HashMap<String, Isla> lista = new HashMap<>();
    private final String separador = System.getProperty("file.separator");
    
    public ListaMapas() {
    }
    
    private String getRutaIMG(){
        return "src" + separador + "imagenes" + separador + "islas" + separador;
    }
    
    private String getRutaJSON(){
        return "src" + separador + "json" + separador;
    }
    
    public HashMap<String, Isla> getLista() {
        lista.put("amor", new Isla("amor", getRutaIMG()+"amor.png", new GenerarIsla(getRutaJSON().concat("amor.json")).obtenerMatriz()));
        lista.put("calavera", new Isla("calavera", getRutaIMG()+"calavera.png", new GenerarIsla(getRutaJSON().concat("calavera.json")).obtenerMatriz()));
        lista.put("volcan", new Isla("volcan", getRutaIMG()+"volcan.png", new GenerarIsla(getRutaJSON().concat("volcan.json")).obtenerMatriz()));
        lista.put("playa", new Isla("playa", getRutaIMG()+"playa.png", new GenerarIsla(getRutaJSON().concat("playa.json")).obtenerMatriz()));
        lista.put("selva", new Isla("selva", getRutaIMG()+"selva.png", new GenerarIsla(getRutaJSON().concat("selva.json")).obtenerMatriz()));
        lista.put("circo", new Isla("circo", getRutaIMG()+"circo.png", new GenerarIsla(getRutaJSON().concat("circo.json")).obtenerMatriz()));
        lista.put("dulce", new Isla("dulce", getRutaIMG()+"dulce.png", new GenerarIsla(getRutaJSON().concat("dulce.json")).obtenerMatriz()));
        lista.put("ruina", new Isla("ruina", getRutaIMG()+"ruina.png", new GenerarIsla(getRutaJSON().concat("ruina.json")).obtenerMatriz()));
        lista.put("militar", new Isla("militar", getRutaIMG()+"militar.png", new GenerarIsla(getRutaJSON().concat("militar.json")).obtenerMatriz()));
        lista.put("flor", new Isla("flor", getRutaIMG()+"flor.png", new GenerarIsla(getRutaJSON().concat("flor.json")).obtenerMatriz()));
        lista.put("desierto", new Isla("desierto", getRutaIMG()+"desierto.png", new GenerarIsla(getRutaJSON().concat("desierto.json")).obtenerMatriz()));

        
        
        
        return lista;
    }
    
    
}

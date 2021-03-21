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

/**
 *
 * @author Grupo 9
 */

public class Pistas {
    String pista;
    String destino;

    public Pistas() {
    }

    public String pista_texto(String nom_isla){
        String txt_pista="";
        if (nom_isla.equals("volcan")) {
            txt_pista="La lava es peligrosa!";
        }else if(nom_isla.equals("flor")){
            txt_pista="Son bonitas y huelen bien!";
        }else if(nom_isla.equals("desierto")){
            txt_pista="Hay agua y mucha arena!";
        }else if(nom_isla.equals("amor")){
            txt_pista="Te amo!";
        }else if(nom_isla.equals("calavera")){
            txt_pista="Tengo miedo!";
        }else if(nom_isla.equals("militar")){
            txt_pista="De frente maaarrch..!";
        }else if(nom_isla.equals("circo")){
            txt_pista="Compremos Boletos!";
        }else if(nom_isla.equals("ruina")){
            txt_pista="Todo es esta destruido!";
        }else if(nom_isla.equals("selva")){
            txt_pista="Hay muchos arboles y animales!";
        }else if(nom_isla.equals("playa")){
            txt_pista="Hagamos un castillo de arena!";
        }else if(nom_isla.equals("dulce")){
            txt_pista="Tienen mucha azucar!";
        }
        return txt_pista;
    }
    
}

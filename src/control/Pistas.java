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

import java.util.Arrays;

/**
 *
 * @author Grupo 9
 */

public class Pistas {
    public static String[] camino_inicial;
    public static int cont=1;
    public static String dificultad;

    public  String getDificultad() {
        return dificultad;
    }

    public static void setDificultad(String dificultad) {
        Pistas.dificultad = dificultad;
    }

    public Pistas() {
    }

    public  void setCamino_inicial(String[] camino_inicial) {
        Pistas.camino_inicial = camino_inicial;
    }


    public  String[] getCamino_inicial() {
        return camino_inicial;
    }

    public static int getCont() {
        return cont;
    }

    public static void setCont(int cont) {
        Pistas.cont = cont;
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
    public String pistas_cruzadas(String dificultad,String isla){
        Grafo g= new Grafo("abcdefghijk");
        g.iniciargrafo(g);
        String psta="";
        g.encontrarRutaMinimaDijkstra(g.String_char(isla),g.String_char(camino_inicial[camino_inicial.length-1]));
        if (dificultad=="facil" || dificultad=="medio") {
            new Pistas().setCamino_inicial(g.rutaisla(g.arregloruta));
            System.out.println(Arrays.toString(camino_inicial)+"NUEVO CAMINO");
            psta=pista_texto(camino_inicial[1]);
        }else if(dificultad=="dificil"){
            System.out.println("camino dificil "+Arrays.toString(camino_inicial)+"CONT "+cont);
            psta=(pista_texto(camino_inicial[cont]));
            cont++;
        }
        
        return psta;
    }
    
}

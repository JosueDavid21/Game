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

package entes;

import java.util.ArrayList;

/**
 *
 * @author Grupo 9
 */

public class Inventario {
    
    public static int monedas = 0;
    public static ArrayList<Tesoro> tesoros = new ArrayList();
    
    public Inventario() {
    }

    public static int getMonedas() {
        return monedas;
    }

    public static void setMonedas(int monedas) {
        Inventario.monedas = monedas;
    }

    public static ArrayList<Tesoro> getTesoros() {
        return tesoros;
    }
    
    public static void addTesoro(Tesoro t) {
        tesoros.add(t);
    }
    
}

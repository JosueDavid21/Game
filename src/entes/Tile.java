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

/**
 *
 * @author Grupo 9
 */

public class Tile {

   public Tile() {
    }
    
    public boolean esCamino(int tile){
        return (tile<=10 || tile>=66);
    }
    
    public boolean esTesoro(int tile){
        return (tile>=51 && tile<=52);
    }
    
    public boolean esPasePuente(int tile){
        return (tile>=53 && tile<=62);
    }
    
    public boolean esPersonaje(int tile){
        return (tile>=63 && tile<=65);
    }
}

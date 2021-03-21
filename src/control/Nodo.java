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

public class Nodo implements Comparable<Nodo> {
    char id;
    int  distancia   = Integer.MAX_VALUE;
    Nodo procedencia = null;
    Nodo(char x, int d, Nodo p) { id=x; distancia=d; procedencia=p; }
    Nodo(char x) { this(x, 0, null); }
    public int compareTo(Nodo tmp) { return this.distancia-tmp.distancia; }
    public boolean equals(Object o) {
        Nodo tmp = (Nodo) o;
        if(tmp.id==this.id) return true;
        return false;
    }
}

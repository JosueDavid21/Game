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

public class Isla {
    
    private final String nombre;
    private final String imagen;
    private final int[][] matriz;

    public Isla(final String nombre, final String imagen, final int [][] matriz) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.matriz = matriz;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUrlImagen() {
        return imagen;
    }

    public int[][] getMatriz() {
        return matriz;
    }
}

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

public class Tesoro {

    private final String nombre;
    private final int posicionX;
    private final int posicionY;
    private final String rutaIMG;
    private boolean estado;

    public Tesoro(final String nombre, final int posicionX, final int posicionY, final String rutaIMG, final boolean estado) {
        this.nombre = nombre;
        this.posicionX = posicionX;
        this.posicionY = posicionY;
        this.rutaIMG = rutaIMG;
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }

    
    public String getRutaIMG() {
        return rutaIMG;
    }
    
    /**
     * Determina el estado del tesoro, si este ya ha sido encontrado o no.
     * @return true si el tesoro ya fue encontrado, caso contrario false
     */
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
}
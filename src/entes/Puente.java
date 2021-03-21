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

import java.awt.Point;

/**
 *
 * @author Grupo 9
 */

public class Puente {
    
    private final String destino;
    private final Point puntoLlegada;

    public Puente(String destino, Point puntoInicio) {
        this.destino = destino;
        this.puntoLlegada = puntoInicio;
    }

    public String getDestino() {
        return destino;
    }

    public Point getPuntoLlegada() {
        return puntoLlegada;
    }
    
}

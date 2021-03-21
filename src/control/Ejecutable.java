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

import vistas.VistaInicial;

/**
 *
 * @author Grupo 9
 */

public class Ejecutable {
   
    public String g;
   
    public Ejecutable() {
    }

    public static void main(String[] args) throws Exception {
        String musica = "src/musica/juego-de-tronos.wav";
        VistaInicial pre = new VistaInicial();
        pre.setVisible(true);
        pre.progres();
    }   
    
    public void Nivel(String niv){
        String nivel=niv;
    }

    public void GuardarNombre (String nombre){
       g=nombre;
    }
}



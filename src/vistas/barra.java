/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

/**
 *
 * @author edgar
 */
public class barra {
    public String g;
    /**
     * @param args the command line arguments
     */
    public barra() {

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



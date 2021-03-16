/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entes;

/**
 *
 * @author Josue
 */
public class Tile {

    public Tile() {
    }
    
    public boolean esCamino(int tile){
        return (tile<=10 || tile>=66);
    }
    
    public boolean esTesoro(int tile){
        return (tile>=51 || tile<=52);
    }
    
    public boolean esPuente(int tile){
        return (tile>=53 || tile<=62);
    }
    
    public boolean esPersonaje(int tile){
        return (tile>=63 || tile<=65);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import java.awt.Frame;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;

/**
 *
 * @author edgar
 */
public class barra {

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

    public void ReproducirSonido(String nombreSonido) throws LineUnavailableException, UnsupportedAudioFileException {

        try {
            Clip clip = AudioSystem.getClip();
           
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());

                clip.open(audioInputStream);
                clip.start();
            
                clip.stop();
            

        } catch (IOException | LineUnavailableException ex) {
            System.out.println("Error al reproducir el sonido.");
        }

    }
    
    public void mute (String direccion,JButton bot) throws LineUnavailableException {
    boolean bandera ;
        if (bot.isSelected()) {
            bandera = true;
        try {
            ReproducirSonido(direccion);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(barra.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else {
          Clip clip = AudioSystem.getClip();
          clip.stop();
        }
    
    
    
    
    }

    
}

//}


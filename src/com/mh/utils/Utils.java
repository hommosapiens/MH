/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.utils;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author enriquenogal
 */
public class Utils {

    public static double redondeoDosDecimales(double d) {
        return 1.0d * Math.round(d * 100.0d) / 100.0d;
    }

    public static void playSound(String ruta) {

        try {
            File sound = new File(ruta);
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static String keepMonedaFormato(String entrada) {

        if (entrada.length() == 4) {
            return entrada + " €";
        } else {
            return entrada + "0 €";
        }
    }
}

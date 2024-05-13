/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mh.utils;

import java.io.File;
import java.text.DecimalFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Juan Pedro Rodriguez Aranda
 */
public class Utils {

    public static double redondeoDosDecimales(double d) {
        return 1.0d * Math.round(d * 100.0d) / 100.0d;
    }

    public static void playSound(String ruta) {
        //Para reproducir sonidos
        try {
            File sound = new File(ruta);
            Clip c = AudioSystem.getClip();
            c.open(AudioSystem.getAudioInputStream(sound));
            c.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public static String keepMonedaFormato(Double dinero) {
        //Mantiene el formato de monedas (0,00 €)
        DecimalFormat df = new DecimalFormat("0.00");
        String entrada = String.valueOf(df.format(dinero)) + " €";

        return entrada;
    }
}

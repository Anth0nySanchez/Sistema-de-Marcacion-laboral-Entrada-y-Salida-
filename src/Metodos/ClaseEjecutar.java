/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import GUI.FrameMarcador;
import com.sun.awt.AWTUtilities;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Anthony
 */
public class ClaseEjecutar {
    public static void main(String[] args) {
        FrameMarcador frame = new FrameMarcador();
        AWTUtilities.setWindowOpaque(frame, false);
        frame.setVisible(true);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Anthony
 */
public class MetodosCalendarios {
    
    public static String hora(){
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        return hourFormat.format(date);
    }
    
    public static java.sql.Date Fecha(){
        Date date = new Date();
        java.sql.Date fecha = new java.sql.Date(date.getTime());
        return fecha;
    }
}

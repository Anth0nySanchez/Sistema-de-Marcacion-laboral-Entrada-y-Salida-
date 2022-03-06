/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

/**
 *
 * @author anthony
 */
public class Tablas {
     public static String tablaUsuario = " (ID_MIEMBRO int(4) PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                            + "NOMBRE nvarchar(100),"
                            + "APELLIDO nvarchar(100),"
                            + "EMAIL nvarchar(150),"
                            + "CODIGO nvarchar(4),"
                            + "CEDULA nvarchar(13),"
                            + "DEPARTAMENTO int(2))";
     
    public static String tablaRegistro = " (ID_REGISTRO int(11) PRIMARY KEY AUTO_INCREMENT NOT NULL,"
                            + "USUARIO int(4),"
                            + "URL_FOTO blob,"
                            + "FECHA Date,"
                            + "HORA nvarchar(20),"
                            + "TIPO_IN_OUT nvarchar(1))";
    
    public static String tablaDepartamento = " (ID_DEPARTAMENTO int(2) PRIMARY KEY NOT NULL,"
                            + "NOMBRE nvarchar (150))";
}

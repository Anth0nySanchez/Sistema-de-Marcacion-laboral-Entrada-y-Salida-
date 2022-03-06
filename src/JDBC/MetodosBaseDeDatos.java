/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author anthony
 */
public class MetodosBaseDeDatos {
    
    /*
            Este procedimiento CrearBD crea la Base de datos, previamente ya se ha detectado que no existe.
    */
    public void crearBD(){
        Connection cn = null;
            try {
                Class.forName("com.mysql.jdbc.Driver");
                cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
                PreparedStatement pst = cn.prepareStatement("CREATE DATABASE ProyectoMarcador");
                int cont = pst.executeUpdate();
                if (cont > 0) {   
                    System.out.println("Base de datos creada con exito");
                }
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
    }
    
    /*
            Este procedimiento crearTabla crea las tablas de la base de datos, recibe 2 parámetos
            el primero es el nombre de la tabla a crear y el otro son todas las columnas que vayamos
            a crear en la tabla.
    */
    public void crearTabla(String nombreTabla, String args){
        String ruta = "create table "+nombreTabla+args;
        Conexion cnx = new Conexion();
        Connection cn = cnx.Conec();
        try {
                PreparedStatement ps = cn.prepareStatement(ruta);
                ps.execute();
                ps.close();
                System.out.println("Tabla "+nombreTabla+"creada correctamente");
        } 
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public boolean existe(String tabla, String campo, String comparar, String msg){
        Conexion cn = new Conexion();
        Connection link = cn.Conec();
        try{
            PreparedStatement usu = link.prepareStatement("SELECT * FROM "+tabla+" WHERE "+campo+" = '"+comparar+"'");
            ResultSet rs = usu.executeQuery();
            if(rs.next())
                return true;
            else{
                JOptionPane.showMessageDialog(null, msg);
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean noExiste(String tabla, String campo, String comparar, String msg) throws SQLException{
        Conexion cn = new Conexion();
        Connection link = cn.Conec();
        try{
            PreparedStatement usu = link.prepareStatement("SELECT * FROM "+tabla+" WHERE "+campo+" = '"+comparar+"'");
            ResultSet rs = usu.executeQuery();
            if(!rs.next())
                return false;
            else{
                JOptionPane.showMessageDialog(null, msg);
                return true;
            }  
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
        finally{
            link.close();
        }
    }
    
    
}

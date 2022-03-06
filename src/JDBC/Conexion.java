/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import java.sql.*;
import javax.swing.JOptionPane;

public class Conexion {

    private String link = "jdbc:mysql://localhost:3306/ProyectoMarcador";
    private String usuario = "root";
    private String contraseña = "";
   
    /* 
        Este método conecta a la base de datos y en caso de que no exista, comprueba y la
       crea automaticamente junto con sus tablas
    */
    
    public Connection Conec() {
       Connection cn = null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(link, usuario, contraseña);
            System.out.println("Conectado a la base de datos");
        } 
        catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "Driver Erroneo", "Error", JOptionPane.ERROR_MESSAGE);
        }
        catch(MySQLSyntaxErrorException e){
            System.out.println("Base de datos no encontrada");
            MetodosBaseDeDatos metJDBC = new MetodosBaseDeDatos();
            metJDBC.crearBD();
            metJDBC.crearTabla("tblUsuario", Tablas.tablaUsuario);
            metJDBC.crearTabla("tblRegistro", Tablas.tablaRegistro);
            metJDBC.crearTabla("tblDepartamento", Tablas.tablaDepartamento);   
        }
        catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error en la conexion", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return cn;
    }
}

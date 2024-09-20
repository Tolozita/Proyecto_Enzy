/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class CConexion {
    Connection conectar = null;
    
    String usuario = "root";
    String contrasenia = "#Aprendiz2024";
    String bd = "petcare";
    String ip = "localhost";
    String puerto = "3306";
    
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;
    
     
    public Connection estableceConexion(){
    try{
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
//        JOptionPane.showMessageDialog(null,"La Conexion se ha realizado con exito");
    
    }catch(Exception e){
       JOptionPane.showMessageDialog(null,"Error al Conectarse a la base de datos "+e.toString());
    }
    return conectar;
    }
}

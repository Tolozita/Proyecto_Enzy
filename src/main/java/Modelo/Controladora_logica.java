/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Controlador.CConexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Propietario
 */
public class Controladora_logica {
    
    
public boolean petExists(String pet) {
    CConexion objetoConexion = new CConexion();
    String consulta = "SELECT COUNT(*) FROM mascotas WHERE nombre = ?";
    try (CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta)) {
        cs.setString(1, pet);
        ResultSet rs = cs.executeQuery();
        if (rs.next()) {
            if (rs.getInt(1) > 0) {
                return true; // Nombre ya existe
            }
        }
    } catch (SQLException e) {
    }
    return false; // Nombre no existe
}


    
    
         public String ValidatePassword(String documento) {
    CConexion objetoConexion = new CConexion();
    String consulta = "SELECT u.upwd "+ 
                      "FROM users u  "+         
                      "WHERE u.user_doc = ?;";
    

    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(consulta)) {
        ps.setString(1, documento);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("upwd"); // Retorna el nombre del dueño
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener la contraseña del usuario : ");
    }
    return null; // Retorna null en caso de error
}
    
    

    
        public boolean validateUser(String Documento, String contrasena)  {
        CConexion objetoConexion = new CConexion();
        String consulta = "SELECT * FROM users WHERE user_doc = ? AND upwd = ?";
        
        try (Connection conn = objetoConexion.estableceConexion();
             PreparedStatement ps = conn.prepareStatement(consulta)) {
            ps.setString(1, Documento);
            ps.setString(2, contrasena);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next(); // Retorna true si hay una fila que coincide con el usuario y contraseña
            }
        } catch (SQLException e) {
            
            return false;
        }
    }
        
        
        public int getUserRole(String Documento) {
        CConexion objetoConexion = new CConexion();
        String consulta = "SELECT role_id FROM users WHERE user_doc = ?";
        
        try (Connection conn = objetoConexion.estableceConexion();
             PreparedStatement ps = conn.prepareStatement(consulta)) {
            ps.setString(1, Documento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("role_id"); // Retorna el rol del usuario
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el rol del usuario: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1; // Retorna un valor por defecto en caso de error
    }
        
          
        
         public String getUserName(String documento) {
    CConexion objetoConexion = new CConexion();
    String consulta = "SELECT u.user_name " +
                      "FROM users u " +                       
                      "WHERE u.user_doc = ?";
    

    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(consulta)) {
        ps.setString(1, documento);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("user_name"); // Retorna el nombre del dueño
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el nombre del usuario: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null; // Retorna null en caso de error
}
         
         
         
public String getUserEmail(String documento) {
    CConexion objetoConexion = new CConexion();
    String consulta = "SELECT user_email FROM users WHERE user_doc = ?";
    

    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(consulta)) {
        ps.setString(1, documento);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("user_email"); // Retorna el nombre del dueño
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el nombre del usuario: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null; // Retorna null en caso de error
}


public String getUserAddress(String documento) {
    CConexion objetoConexion = new CConexion();
    String consulta = "SELECT user_address FROM users WHERE user_doc = ?";
    

    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(consulta)) {
        ps.setString(1, documento);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("user_address"); // Retorna el nombre del dueño
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el nombre del usuario: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null; // Retorna null en caso de error
}
     

public String getUserPhone(String documento) {
    CConexion objetoConexion = new CConexion();
    String consulta = "SELECT user_phone FROM users WHERE user_doc = ?";
    

    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(consulta)) {
        ps.setString(1, documento);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getString("user_phone"); // Retorna el nombre del dueño
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el nombre del usuario: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return null; // Retorna null en caso de error
}
       
         
         
 public int getDueñoID(String Documento) {
    CConexion objetoConexion = new CConexion();
    String consulta = "SELECT dueño_id FROM dueños d " + // Espacio agregado
                      "INNER JOIN users u ON d.UsuarioID = u.user_id " + // Espacio agregado
                      "WHERE u.user_doc = ?;";

    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(consulta)) {
        ps.setString(1, Documento);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("dueño_id"); 
            }
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al obtener el ID del dueño: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    return 0; // Retorna 0 si no se encontró el ID
    }   


        public int getUserID(String Documento) {
        CConexion objetoConexion = new CConexion();
        String consulta = "SELECT user_id FROM users WHERE user_doc = ?";
        
        try (Connection conn = objetoConexion.estableceConexion();
             PreparedStatement ps = conn.prepareStatement(consulta)) {
            ps.setString(1, Documento);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("user_id"); // Retorna el rol del usuario
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener el rol del usuario: " + e.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return -1; // Retorna un valor por defecto en caso de error
    }         
         
        
        
        
}

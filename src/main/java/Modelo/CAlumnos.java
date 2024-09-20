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
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CAlumnos {
    
    int codigo;
    String nombreAlumno;
    String CorreoAlumnos;
    String PassAlumnos;
    String DocAlumnos;
    String RolAlumno;

    public String getCorreoAlumnos() {
        return CorreoAlumnos;
    }

    public void setCorreoAlumnos(String CorreoAlumnos) {
        this.CorreoAlumnos = CorreoAlumnos;
    }

    public String getPassAlumnos() {
        return PassAlumnos;
    }

    public void setPassAlumnos(String PassAlumnos) {
        this.PassAlumnos = PassAlumnos;
    }

    public String getDocAlumnos() {
        return DocAlumnos;
    }

    public void setDocAlumnos(String DocAlumnos) {
        this.DocAlumnos = DocAlumnos;
    }

    public String getRolAlumno() {
        return RolAlumno;
    }

    public void setRolAlumno(String RolAlumno) {
        this.RolAlumno = RolAlumno;
    }
    
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public void setNombreAlumno(String nombreAlumno) {
        this.nombreAlumno = nombreAlumno;
    }
    
    
     // Método para verificar si el correo electrónico ya está registrado
    public boolean emailExists(String email) {
        CConexion objetoConexion = new CConexion();
        String consulta = "SELECT COUNT(*) FROM users WHERE user_email = ?";
        try (CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta)) {
            cs.setString(1, email);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
        return false;
    }
    

    
    
    
    
    
    

    // Método para verificar si el número de documento ya está registrado
    public boolean documentExists(String documento) {
            CConexion objetoConexion = new CConexion();
        String consulta = "SELECT COUNT(*) FROM users WHERE user_doc = ?";
        try (CallableStatement cs = objetoConexion.estableceConexion().prepareCall(consulta)) {
            cs.setString(1, documento);
            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+e.toString());
        }
        return false;
    }

    


    public void InsertarAlumno(JTextField txtUser_id, JTextField paraNombres, JTextField paraContrasenia, JTextField paraCorreos, JTextField paraDocumento, JTextField txtRol, JTextField txtDireccion, JTextField txtRol, JComboBox<String> Jc_EstadoUser) {
        
        txtUser_id,txtNombres,txtUPWD,txtCorreo,txtDocument, txtRol,txtTelefono,txtDireccion,Jc_EstadoUser
        
 // Obtener valores de los campos
    String nombre = paraNombres.getText().trim();
    String contrasena = paraContrasenia.getText().trim();
    String correo = paraCorreos.getText().trim();
    String documento = paraDocumento.getText().trim();
    String telefono = txtTelefono.getText().trim();
    String direccion = txtDireccion.getText().trim();
    String rol = txtRol.getText().trim();
    
    String estado = (String) Jc_EstadoUser.getSelectedItem(); // Estado del JComboBox
    
    // Validar campos vacíos
    if (nombre.isEmpty() || contrasena.isEmpty() || correo.isEmpty() || documento.isEmpty() || telefono.isEmpty() || direccion.isEmpty() || estado == null) {
        JOptionPane.showMessageDialog(null, "Todos los campos deben ser llenados.");
        return;
    }
    
    // Preparar la consulta para la tabla `users`
    String consultaUsers = "INSERT INTO users (user_doc, upwd, role_id, estado_user, user_name, user_phone, user_address, user_email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    // Preparar la consulta para la tabla `dueños`
    String consultaDueños = "INSERT INTO dueños (usuarioID) VALUES (?)";
    
    try {
        CConexion objetoConexion = new CConexion();
        Connection conn = objetoConexion.estableceConexion();
        
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
            return;
        }
        
        // Insertar en la tabla `users`
        PreparedStatement psUsers = conn.prepareStatement(consultaUsers, Statement.RETURN_GENERATED_KEYS);
        psUsers.setString(1, documento);
        psUsers.setString(2, contrasena);
        psUsers.setString(3, rol);
        psUsers.setString(4, estado);
        psUsers.setString(5, nombre);
        psUsers.setString(6, telefono);
        psUsers.setString(7, direccion);
        psUsers.setString(8, correo);
        psUsers.executeUpdate();
        
        // Recuperar el ID autogenerado
        ResultSet generatedKeys = psUsers.getGeneratedKeys();
        if (generatedKeys.next()) {
            int userId = generatedKeys.getInt(1);
            
            // Solo insertar en la tabla `dueños` si el rol es 2
            if (rol.equals("2")) { // Asegúrate de que la comparación sea correcta
                PreparedStatement psDueños = conn.prepareStatement(consultaDueños);
                psDueños.setInt(1, userId); // Usa el ID autogenerado
                psDueños.executeUpdate();
                psDueños.close();
            }
            
            // Confirmación de la operación
            JOptionPane.showMessageDialog(null, "Datos del usuario guardados exitosamente.");
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo obtener el ID del usuario.");
        }
        
        // Cerrar el statement y la conexión
        psUsers.close();
        conn.close();
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se insertaron correctamente los datos del usuario, error: " + e.getMessage());
        e.printStackTrace();
    }
    }



public void cargarDueños(JComboBox<String> dueños) {
    CConexion objetoConexion = new CConexion();
    String consulta = "SELECT dueño_id, u.user_name FROM dueños d " +
                      "INNER JOIN users u ON d.UsuarioID = u.user_id;"; // Cambia 'nombre' por el campo real

    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(consulta);
         ResultSet rs = ps.executeQuery()) {
        
        // Limpiar el JComboBox antes de agregar nuevos elementos
        dueños.removeAllItems();

        while (rs.next()) {
            int dueñoId = rs.getInt("dueño_id");
            String nombre = rs.getString("user_name"); // Cambia 'nombre' por el campo real

            // Agregar el dueño al JComboBox en el formato "nombre (ID)"
            dueños.addItem(nombre + " (" + dueñoId + ")");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al cargar los dueños: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}

   
public void InsertarMascota(String NombreMascota, String Especie, String Raza, String F_Nacimiento, String peso, String color, int dueño_id) {
    // Obtener valores de los campos
    
    JOptionPane.showMessageDialog(null, dueño_id);

    // Preparar la consulta para la tabla `mascotas`
    String consultaMascotas = "INSERT INTO mascotas (nombre, especie, raza, fecha_nacimiento, peso, color, id_dueño) VALUES (?, ?, ?, ?, ?, ?, ?)";

    try {
        CConexion objetoConexion = new CConexion();
        Connection conn = objetoConexion.estableceConexion();
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer conexión con la base de datos.");
            return;
        }

        // Insertar en la tabla `mascotas`
        PreparedStatement psMascota = conn.prepareStatement(consultaMascotas);
        psMascota.setString(1, NombreMascota);
        psMascota.setString(2, Especie);
        psMascota.setString(3, Raza);
        psMascota.setString(4, F_Nacimiento);
        psMascota.setString(5, peso);
        psMascota.setString(6, color);
        psMascota.setInt(7, dueño_id);

        // Ejecutar la inserción
        psMascota.executeUpdate();
        JOptionPane.showMessageDialog(null, "Datos de la mascota guardados exitosamente.");

        // Cerrar el statement y la conexión
        psMascota.close();
        conn.close();

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se insertaron correctamente los datos de la mascota, error: " + e.toString());
        e.printStackTrace();
    }
}




















public void MostrarDatosMascotas_Admin(JTable TablaMascotas) {
       CConexion objetoConexion = new CConexion();
    
    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
    TablaMascotas.setRowSorter(OrdenarTabla);
    
    // Definir las columnas del modelo de tabla
    modelo.addColumn("Mascota_id");
    modelo.addColumn("Nombre_Mascota");
    modelo.addColumn("Especie");
    modelo.addColumn("Raza");
    modelo.addColumn("Edad");
    modelo.addColumn("Peso");
    modelo.addColumn("Color");
    modelo.addColumn("id_dueño"); 
    modelo.addColumn("Nombre_dueño"); 
    
    TablaMascotas.setModel(modelo);

    // Consulta SQL con filtro por documento del usuario
    String sql = "SELECT " +
                 "m.mascota_id AS Mascota_id, " +
                 "m.nombre AS Nombre_Mascota, " +
                 "m.especie AS Especie, " +
                 "m.raza AS Raza, " +
                 "m.edad AS Edad, " +
                 "m.peso AS Peso, " +
                 "m.color AS Color, " +
                 "m.id_dueño AS id_dueño, " +
                 "u.user_name AS Nombre_dueño " +
                 "FROM mascotas m " +
                 "INNER JOIN dueños d ON m.id_dueño = d.dueño_id " +
                 "INNER JOIN Users u ON d.UsuarioID = u.user_id;";

    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        // Establecer el parámetro del documento del usuario

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                // Crear un array con un elemento por cada columna definida
                Object[] datos = new Object[9];  // 9 en total, ya que hay 9 columnas
                
                datos[0] = rs.getString("Mascota_id");
                datos[1] = rs.getString("Nombre_Mascota");
                datos[2] = rs.getString("Especie");
                datos[3] = rs.getString("Raza");
                datos[4] = rs.getInt("Edad");
                datos[5] = rs.getString("Peso");
                datos[6] = rs.getString("Color");
                datos[7] = rs.getString("id_dueño");
                datos[8] = rs.getString("Nombre_dueño");

                modelo.addRow(datos);
            }
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se pudieron mostrar los datos de las mascotas, error: " + e.toString());
    }
}


public void MostrarDatosMascotas(JTable TablaMascotas, String userDoc) {
       CConexion objetoConexion = new CConexion();
    
    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
    TablaMascotas.setRowSorter(OrdenarTabla);
    
    // Definir las columnas del modelo de tabla
    modelo.addColumn("Pet_id");
    modelo.addColumn("Pet_Name");
    modelo.addColumn("Especie");
    modelo.addColumn("Raza");
    modelo.addColumn("Edad");
    modelo.addColumn("Peso");
    modelo.addColumn("Color");
    modelo.addColumn("id_dueño"); 
    modelo.addColumn("Nombre_dueño"); 
    
    TablaMascotas.setModel(modelo);

    // Consulta SQL con filtro por documento del usuario
    String sql = "SELECT " +
                 "m.mascota_id AS Pet_id, " +
                 "m.nombre AS Pet_Name, " +
                 "m.especie AS Especie, " +
                 "m.raza AS Raza, " +
                 "m.edad AS Edad, " +
                 "m.peso AS Peso, " +
                 "m.color AS Color, " +
                 "m.id_dueño AS id_dueño, " +
                 "u.user_name AS Nombre_dueño " +
                 "FROM mascotas m " +
                 "INNER JOIN dueños d ON m.id_dueño = d.dueño_id " +
                 "INNER JOIN Users u ON d.UsuarioID = u.user_id " +
                 "WHERE u.user_doc = ?;";  // Correcta parametrización

    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {

        // Establecer el parámetro del documento del usuario
        ps.setString(1, userDoc);

        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                // Crear un array con un elemento por cada columna definida
                Object[] datos = new Object[9];  // 9 en total, ya que hay 9 columnas
                
                datos[0] = rs.getString("Pet_id");
                datos[1] = rs.getString("Pet_Name");
                datos[2] = rs.getString("Especie");
                datos[3] = rs.getString("Raza");
                datos[4] = rs.getInt("Edad");
                datos[5] = rs.getString("Peso");
                datos[6] = rs.getString("Color");
                datos[7] = rs.getString("id_dueño");
                datos[8] = rs.getString("Nombre_dueño");

                modelo.addRow(datos);
            }
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se pudieron mostrar los datos de las mascotas, error: " + e.toString());
    }
}





public void MostrarDatosVacunas(JTable tablavacunas, String documento, String userName) {
 CConexion objetoConexion = new CConexion();
    
    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
    tablavacunas.setRowSorter(OrdenarTabla);
    
    // Definir las columnas del modelo de tabla
    modelo.addColumn("Nombre_Mascota");
    modelo.addColumn("Vacunas");
    modelo.addColumn("Fecha Aplicacion");
    modelo.addColumn("Proxima Fecha A Aplicar");
    
    tablavacunas.setModel(modelo);
    
    // Consulta SQL ajustada para incluir el estado
    String sql = "SELECT " +
                 "m.nombre AS NombreMascota, " +
                 "v.nombre_vacuna AS Vacuna, " +
                 "av.fecha_aplicacion AS Fecha_Aplicacion, " +
                 "av.proxima_fecha AS Proxima_Fecha_Vacuna " +
                 "FROM " +
                 "users u " +
                 "INNER JOIN dueños d ON u.user_id = d.UsuarioID " +
                 "INNER JOIN mascotas m ON d.dueño_id = m.id_dueño " +
                 "INNER JOIN aplicacion_vacuna av ON m.mascota_id = av.mascota_id " +
                 "INNER JOIN vacunas v ON av.vacuna_id = v.vacuna_id " +
                 "WHERE u.user_doc = ? AND m.nombre = ?;";
    
    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
         
        // Establecer los valores de los parámetros en el PreparedStatement
        ps.setString(1, documento);
        ps.setString(2, userName);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                // Crear un array con los datos
                String[] datos = new String[4];
                datos[0] = rs.getString("NombreMascota");
                datos[1] = rs.getString("Vacuna");
                datos[2] = rs.getString("Fecha_Aplicacion");
                datos[3] = rs.getString("Proxima_Fecha_Vacuna");
                modelo.addRow(datos);
            }
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se pudieron mostrar los datos de las vacunas, error: " + e.toString());
    }
}




public void MostrarDatosClinicos(JTable tablavacunas, String documento, String userName) {
    CConexion objetoConexion = new CConexion();
    
    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
    tablavacunas.setRowSorter(OrdenarTabla);
    
    // Definir las columnas del modelo de tabla
    modelo.addColumn("Nombre_Mascota");
    modelo.addColumn("Fecha_Consulta");
    modelo.addColumn("Tratamiento_Realizado");
    modelo.addColumn("Nombre_Veterinario");
    modelo.addColumn("Centro_Veterinario");
    modelo.addColumn("Direccion_Centro");
    
    tablavacunas.setModel(modelo);
    
    // Consulta SQL ajustada para incluir la información del centro veterinario
    String sql = "SELECT " +
                 "m.nombre AS NombreMascota, " +
                 "h.fecha_consulta AS Fecha_Consulta, " +
                 "h.tratamiento_realizado AS Tratamiento_Realizado, " +
                 "v2.nombre_veterinario AS Nombre_Veterinario, " +
                 "v2.centro_veterinario AS Centro_Veterinario, " +
                 "v2.direccion_centro AS Direccion_Centro " +
                 "FROM " +
                 "users u " +
                 "INNER JOIN dueños d ON u.user_id = d.UsuarioID " +
                 "INNER JOIN mascotas m ON d.dueño_id = m.id_dueño " +
                 "INNER JOIN historia_clinica h ON m.mascota_id = h.mascota_id " +
                 "INNER JOIN centro_veterinario v2 ON h.veterinario_id = v2.veterinario_id " +
                 "WHERE u.user_doc = ? AND m.nombre = ?;";
    
    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(sql)) {
         
        // Establecer los valores de los parámetros en el PreparedStatement
        ps.setString(1, documento);
        ps.setString(2, userName);
        
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                // Crear un array con los datos
                String[] datos = new String[6];
                datos[0] = rs.getString("NombreMascota");
                datos[1] = rs.getString("Fecha_Consulta");
                datos[2] = rs.getString("Tratamiento_Realizado");
                datos[3] = rs.getString("Nombre_Veterinario");
                datos[4] = rs.getString("Centro_Veterinario");
                datos[5] = rs.getString("Direccion_Centro");
                modelo.addRow(datos);
            }
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se pudieron mostrar los datos clínicos, error: " + e.toString());
    }
}













public void MostrarDatosUsuarios(JTable tablaUsuarios) {
    CConexion objetoConexion = new CConexion();
    
    DefaultTableModel modelo = new DefaultTableModel();
    TableRowSorter<TableModel> OrdenarTabla = new TableRowSorter<>(modelo);
    tablaUsuarios.setRowSorter(OrdenarTabla);
    
    // Definir las columnas del modelo de tabla, ahora incluyendo el estado
    modelo.addColumn("Dueño_id");
    modelo.addColumn("User_id");
    modelo.addColumn("Nombres");
    modelo.addColumn("Telefono");
    modelo.addColumn("Direccion");
    modelo.addColumn("Correo");
    modelo.addColumn("Documento");
    modelo.addColumn("Rol");
    modelo.addColumn("Contraseña");  // Nueva columna para la contraseña
    modelo.addColumn("Estado");  // Nueva columna para el estado
    
    tablaUsuarios.setModel(modelo);
    
    // Consulta SQL ajustada para incluir el estado
    String sql ="SELECT "
           + "d.dueño_id AS DueñoID, "
           + "u.user_id AS UsuarioID, "
           + "u.user_name AS NombreDueño, "
           + "u.user_phone AS TelefonoDueño, "
           + "u.user_address AS DireccionDueño, "
           + "u.user_email AS CorreoDueño, "
           + "u.user_doc AS DocumentoUsuario, "
           + "u.role_id AS Rol, "
           + "u.estado_user AS Estado, "
           + "u.upwd AS Contraseña "
           + "FROM users u "
           + "INNER JOIN dueños d ON u.user_id = d.UsuarioID "
           + "WHERE u.role_id IN (1, 2) AND u.estado_user = 'Activo'";
    
    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            // Crear un array con un elemento adicional para el estado
            String[] datos = new String[10];  // Ahora 10 en lugar de 9
            datos[0] = rs.getString("DueñoID");
            datos[1] = rs.getString("UsuarioID");
            datos[2] = rs.getString("NombreDueño");
            datos[3] = rs.getString("TelefonoDueño");
            datos[4] = rs.getString("DireccionDueño");
            datos[5] = rs.getString("CorreoDueño");
            datos[6] = rs.getString("DocumentoUsuario");
            datos[7] = rs.getString("Rol");
            datos[8] = rs.getString("Contraseña");
            datos[9] = rs.getString("Estado");

            modelo.addRow(datos);
        }
        
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se pudieron mostrar los datos de los usuarios, error: " + e.toString());
    }
}
public void SeleccionarAlumno(JTable paraTablaAlumnos, JTextField txtId, JTextField txtUser_id, JTextField txtNombres, JTextField txtTelefono, JTextField txtDireccion, JTextField txtCorreo, JTextField txtDocument, JTextField txtRol, JTextField txtUPWD, JComboBox<String> Jc_EstadoUser) {
    try {
        // Obtener la fila seleccionada
        int fila = paraTablaAlumnos.getSelectedRow();

        if (fila >= 0) {
            // Obtener los valores de la fila seleccionada y asignarlos a los campos de texto en el orden deseado
            txtId.setText(paraTablaAlumnos.getValueAt(fila, 0).toString());        // Asigna el ID
            txtUser_id.setText(paraTablaAlumnos.getValueAt(fila, 1).toString());   // Asigna el User ID
            txtNombres.setText(paraTablaAlumnos.getValueAt(fila, 2).toString());    // Asigna el Nombre
            txtTelefono.setText(paraTablaAlumnos.getValueAt(fila, 3).toString());   // Asigna el Teléfono
            txtDireccion.setText(paraTablaAlumnos.getValueAt(fila, 4).toString());  // Asigna la Dirección
            txtCorreo.setText(paraTablaAlumnos.getValueAt(fila, 5).toString());     // Asigna el Correo
            txtDocument.setText(paraTablaAlumnos.getValueAt(fila, 6).toString());   // Asigna el Documento
            txtRol.setText(paraTablaAlumnos.getValueAt(fila, 7).toString());        // Asigna el Rol
            txtUPWD.setText(paraTablaAlumnos.getValueAt(fila, 8).toString());       // Asigna la Contraseña
                       // Obtén el valor de la columna para el JComboBox y selecciónalo
            String estado = paraTablaAlumnos.getValueAt(fila, 9).toString(); // Obtener el estado
            Jc_EstadoUser.setSelectedItem(estado); // Seleccionar el item en el JComboBox

        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al seleccionar la fila: " + e.toString());
    }
}


public void SeleccionarMascota_User(JTable paraTablaMascotas, JTextField txtId) {
    try {
        // Obtener la fila seleccionada
        int fila = paraTablaMascotas.getSelectedRow();

        if (fila >= 0) {
            // Obtener los valores de la fila seleccionada y asignarlos a los campos de texto en el orden deseado
            txtId.setText(paraTablaMascotas.getValueAt(fila, 1).toString());// Asigna el ID
            
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al seleccionar la fila: " + e.toString());
    }
}


public void SeleccionarMascota(JTable paraTablaMascotas, JTextField txtMascota_Id, JTextField txtNombre, JTextField txtEspecie, JTextField txtRaza, JTextField txtEdad, JTextField txtPeso, JTextField txtColor) {
    try {
        // Obtener la fila seleccionada
        int fila = paraTablaMascotas.getSelectedRow();

        if (fila >= 0) {
            // Obtener los valores de la fila seleccionada y asignarlos a los campos de texto en el orden deseado
            txtMascota_Id.setText(paraTablaMascotas.getValueAt(fila, 0).toString());        // Asigna el ID
            txtNombre.setText(paraTablaMascotas.getValueAt(fila, 1).toString());   // Asigna el User ID
            txtEspecie.setText(paraTablaMascotas.getValueAt(fila, 2).toString());    // Asigna el Nombre
            txtRaza.setText(paraTablaMascotas.getValueAt(fila, 3).toString());   // Asigna el Teléfono
            txtEdad.setText(paraTablaMascotas.getValueAt(fila, 4).toString());  // Asigna la Dirección
            txtPeso.setText(paraTablaMascotas.getValueAt(fila, 5).toString());     // Asigna el Correo
            txtColor.setText(paraTablaMascotas.getValueAt(fila, 6).toString());   // Asigna el Documento
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
        }

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al seleccionar la fila: " + e.toString());
    }
}

   
public void ModificarAlumnos(
        JTextField txtId,
        JTextField txtUser_id,
        JTextField txtNombres,
        JTextField txtTelefono,
        JTextField txtDireccion,
        JTextField txtCorreo,
        JTextField txtDocument,
        JTextField txtRol,
        JTextField txtUPWD,
        JComboBox<String> Jc_EstadoUser) {

    // Obtener los valores de los campos
    int codigo = Integer.parseInt(txtId.getText());
    String userId = txtUser_id.getText();
    String nombres = txtNombres.getText();
    String telefono = txtTelefono.getText();
    String direccion = txtDireccion.getText();
    String correo = txtCorreo.getText();
    String documento = txtDocument.getText();
    String rol = txtRol.getText();
    String upwd = txtUPWD.getText();
    String estado = (String) Jc_EstadoUser.getSelectedItem();
    
    // Validar si el estado seleccionado es válido
    if (estado == null) {
        JOptionPane.showMessageDialog(null, "Debe seleccionar un estado.");
        return;
    }

    CConexion objetoConexion = new CConexion();
    
 String consulta = "UPDATE users u "
                     + "INNER JOIN dueños d ON u.user_id = d.UsuarioID "
                     + "SET u.user_doc = ?, "
                     + "    u.role_id = ?, "
                     + "    u.estado_user = ?, "
                     + "    u.upwd = ?, "
                     + "    u.user_name = ?, "
                     + "    u.user_phone = ?, "
                     + "    u.user_address = ?, "
                     + "    u.user_email = ? "
                     + "WHERE u.user_id = ?";
    
    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(consulta)) {

        // Establecer los valores de los parámetros en el PreparedStatement
        ps.setString(1, documento);        // Documento del usuario
        ps.setString(2, rol);              // Rol del usuario
        ps.setString(3, estado);           // Estado del usuario
        ps.setString(4, upwd);             // Contraseña del usuario
        ps.setString(5, nombres);          // Nombre del dueño
        ps.setString(6, telefono);         // Teléfono del dueño
        ps.setString(7, direccion);        // Dirección del dueño
        ps.setString(8, correo);           // Correo del dueño
        ps.setString(9, userId);           // ID del usuario para la cláusula WHERE
        
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Modificación exitosa");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
    }
}












public void ModificarMascota(
        JTextField txtPetID, JTextField txtNombrePet, JTextField txtEspeciePet, JTextField txtRazaPet, JTextField txtEdadPet, JTextField txtPesoPet, JTextField txtColorPet, JComboBox<String> JcDueñosPets) {


    // Obtener los valores de los campos
    int petId = Integer.parseInt(txtPetID.getText());
    String petName = txtNombrePet.getText();
    String especie = txtEspeciePet.getText();
    String raza = txtRazaPet.getText();
    String edad = txtEdadPet.getText();
    String peso = txtPesoPet.getText();
    String color = txtColorPet.getText();
    
      // Extraer el ID del dueño seleccionado
    String dueñoSeleccionado = (String) JcDueñosPets.getSelectedItem();
    int dueño_id = Integer.parseInt(dueñoSeleccionado.substring(dueñoSeleccionado.lastIndexOf('(') + 1, dueñoSeleccionado.length() - 1));



    CConexion objetoConexion = new CConexion();
    
 String consulta = "UPDATE mascotas SET "
                         + "nombre = ?, "
                         + "especie = ?, "
                         + "raza = ?, "
                         + "edad = ?, "
                         + "peso = ?, "
                         + "color = ?, "
                         + "dueño_id = ?, "
                         + "WHERE pet_id = ?";
    
    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(consulta)) {

        // Establecer los valores de los parámetros en el PreparedStatement
        ps.setString(1, petName);        
        ps.setString(2, especie);              
        ps.setString(3, raza);           
        ps.setString(4, edad);             
        ps.setString(5, peso);         
        ps.setString(6, color);         
        ps.setInt(7, dueño_id);                    
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Modificación exitosa");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
    }
}




















   
public void ModificarUsuario(
 JTextField txtUser_id,
    JTextField txtNombres,
    JTextField txtTelefono,
    JTextField txtDireccion,
    JTextField txtCorreo,
    JTextField txtDocument,
    int rol, // Rol como int
    String upwd, // Contraseña
    String estado) { // Estado como String

    // Obtener los valores de los campos
    String userId = txtUser_id.getText();
    String nombres = txtNombres.getText();
    String telefono = txtTelefono.getText();
    String direccion = txtDireccion.getText();
    String correo = txtCorreo.getText();
    String documento = txtDocument.getText();

    CConexion objetoConexion = new CConexion();
    
    // Consulta SQL para actualizar los datos del usuario
    String consulta = "UPDATE users u "
                     + "INNER JOIN dueños d ON u.user_id = d.UsuarioID "
                     + "SET u.user_doc = ?, "
                     + "    u.role_id = ?, "
                     + "    u.estado_user = ?, "
                     + "    u.upwd = ?, "
                     + "    u.user_name = ?, "
                     + "    u.user_phone = ?, "
                     + "    u.user_address = ?, "
                     + "    u.user_email = ? "
                     + "WHERE u.user_id = ?";

    try (Connection conn = objetoConexion.estableceConexion();
         PreparedStatement ps = conn.prepareStatement(consulta)) {

        // Establecer los valores de los parámetros en el PreparedStatement
        ps.setString(1, documento); // Documento del usuario
        ps.setInt(2, rol); // Rol del usuario (debe ser un int)
        ps.setString(3, estado); // Estado del usuario
        ps.setString(4, upwd); // Contraseña del usuario
        ps.setString(5, nombres); // Nombre del dueño
        ps.setString(6, telefono); // Teléfono del dueño
        ps.setString(7, direccion); // Dirección del dueño
        ps.setString(8, correo); // Correo del dueño
        ps.setString(9, userId); // ID del usuario para la cláusula WHERE
        
        // Ejecutar la actualización
        int filasActualizadas = ps.executeUpdate();
        
        if (filasActualizadas > 0) {
            JOptionPane.showMessageDialog(null, "Modificación exitosa");
        } else {
            JOptionPane.showMessageDialog(null, "No se encontró el usuario con el ID proporcionado");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "No se modificó, error: " + e.toString());
    }
}

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Modelo.CAlumnos;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import Vista.Login; // Ajusta el paquete según la ubicación de tu clase Login



/**
 *
 * @author Propietario
 */
public class Registro_User extends javax.swing.JFrame {
    private CAlumnos cAlumnos;

    /**
     * Creates new form Registro_User
     */
    public Registro_User() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.cAlumnos = new CAlumnos(); // Asegúrate de que esta línea esté aquí
        Jc_EstadoUser.setVisible(false);  // Cambia 'jcEstadoUser' por el nombre de tu JComboBox
        txtRol.setVisible(false); 
        txtUser_id.setVisible(false);

    }
    
     private boolean validateTextField(JTextField textField, String fieldName) {
        String text = textField.getText().trim();

        // Validar que el campo no esté vacío
        if (text.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo '" + fieldName + "' no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar longitud mínima para nombres
        if (fieldName.equals("Nombre")) {
            if (text.length() < 3) {
                JOptionPane.showMessageDialog(this, "El campo '" + fieldName + "' debe tener al menos 3 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
            if (!text.matches("[a-zA-Z ]+")) {
                JOptionPane.showMessageDialog(this, "El campo '" + fieldName + "' solo puede contener letras.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Validar longitud mínima para contraseñas
        if (fieldName.equals("Contrasena")) {
            if (text.length() < 3) {
                JOptionPane.showMessageDialog(this, "El campo '" + fieldName + "' debe tener al menos 3 caracteres.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

        // Validación específica para correos electrónicos
        if (fieldName.equals("Correo")) {
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            if (!text.matches(emailRegex)) {
                JOptionPane.showMessageDialog(this, "El campo 'Correo' no tiene un formato válido.", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }

         // Validación para campos que deben contener solo números
    if (fieldName.equals("Doc")) {
        
    // Validar que la cédula solo contenga dígitos
    if (!text.matches("\\d{10}")) {
        JOptionPane.showMessageDialog(this, "La cédula de ciudadanía debe contener exactamente 10 Numeros.", "Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
       
    }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDocumento = new javax.swing.JTextField();
        txtContrasena = new javax.swing.JTextField();
        btnRegister = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        Jc_EstadoUser = new javax.swing.JComboBox<>();
        txtRol = new javax.swing.JTextField();
        txtUser_id = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre Completo");

        jLabel2.setText("Correo");

        jLabel3.setText("Documento");

        jLabel4.setText("Contraseña");

        btnRegister.setText("Registrarse");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });

        btnVolver.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnVolver.setText("<");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel5.setText("Telefono");

        jLabel6.setText("Direccion");

        Jc_EstadoUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Activo" }));

        txtRol.setText("2");

        jLabel7.setText("user _id");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnVolver)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(txtContrasena)
                    .addComponent(jLabel4)
                    .addComponent(txtDocumento)
                    .addComponent(jLabel3)
                    .addComponent(txtCorreo)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(btnRegister)
                    .addComponent(jLabel5)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Jc_EstadoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtUser_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Jc_EstadoUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUser_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnVolver)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegister)
                        .addGap(40, 40, 40))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
   // Obtén el texto de los campos
    String nombre = txtNombre.getText().trim();
    String correo = txtCorreo.getText().trim();
    String direccion = txtDireccion.getText().trim(); // Cambiar nombre de variable a minúscula
    String telefono = txtTelefono.getText().trim();
    String documento = txtDocumento.getText().trim();
    String contrasena = txtContrasena.getText().trim(); // Cambiar nombre de variable a minúscula
    String rol = txtRol.getText().trim();
    String estado = (String) Jc_EstadoUser.getSelectedItem(); // Obtén el estado del JComboBox    

    // Valida todos los campos necesarios
    if (!validateTextField(txtNombre, "Nombre") ||
        !validateTextField(txtCorreo, "Correo") ||
        !validateTextField(txtDocumento, "Documento") ||
        !validateTextField(txtContrasena, "Contraseña")) {
        return; // Si alguna validación falla, no continúa con el registro
    }

    if (cAlumnos.emailExists(correo)) {
        JOptionPane.showMessageDialog(this, "El correo electrónico ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (cAlumnos.documentExists(documento)) {
        JOptionPane.showMessageDialog(this, "El número de documento ya está registrado.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Crear objeto de alumno con los datos obtenidos
    CAlumnos objetoAlumno = new CAlumnos();
    
    // Asume que el método InsertarAlumno recibe los datos del alumno
    objetoAlumno.InsertarAlumno(txtUser_id,txtNombre,txtContrasena, txtCorreo,txtDocumento,txtRol,txtTelefono, txtDireccion,Jc_EstadoUser); // Asegúrate de que este método existe y acepta estos parámetros

    JOptionPane.showMessageDialog(this, "Usuario registrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

    // Cierra el formulario de registro
    this.dispose();

    // Abre la vista de login
    Login login = new Login(); // Cambia a tu clase de login si es necesario
    login.setVisible(true);
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
            // Crea una nueva instancia de la ventana de Login
    Login login = new Login();
    
    // Hace visible la ventana de Login
    login.setVisible(true);
    
    // Opcionalmente, puedes cerrar la ventana actual si no deseas que el usuario vuelva a ella
    this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Registro_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro_User.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro_User().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Jc_EstadoUser;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtContrasena;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtDocumento;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRol;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUser_id;
    // End of variables declaration//GEN-END:variables
}

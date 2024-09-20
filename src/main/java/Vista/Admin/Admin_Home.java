/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista.Admin;

import Vista.Admin.EditUsers_Admin;
import Vista.Login;
import javax.swing.JOptionPane;
/**
 *
 * @author Propietario
 */
public class Admin_Home extends javax.swing.JFrame {
    
    
     private String userName;
     private String userDoc;
     
     
     public void setUserName(String userName) {
        this.userName = userName;
        txtAdmin1.setText(userName);
    }
     
         public void setUserDoc(String userDoc){
         this.userDoc = userDoc;
         txtDoc.setText(userDoc);
     }
     
     
    /**
     * Creates new form Admin_Home
     */
    public Admin_Home() {
        initComponents();
        this.setLocationRelativeTo(null);
        btnEdit_Pets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mascota.png")));
        btnEdit_Users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/users.png")));

        
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
        btnEdit_Pets = new javax.swing.JButton();
        btnEdit_Users = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtAdmin1 = new javax.swing.JLabel();
        txtDoc = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(109, 141, 227));

        btnEdit_Pets.setBackground(new java.awt.Color(39, 69, 144));
        btnEdit_Pets.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEdit_Pets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Mascota.png"))); // NOI18N
        btnEdit_Pets.setText("Editar Mascotas");
        btnEdit_Pets.setBorderPainted(false);
        btnEdit_Pets.setHideActionText(true);
        btnEdit_Pets.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit_Pets.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit_Pets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit_PetsActionPerformed(evt);
            }
        });

        btnEdit_Users.setBackground(new java.awt.Color(39, 70, 144));
        btnEdit_Users.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEdit_Users.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/users.png"))); // NOI18N
        btnEdit_Users.setText("Editar Usuarios");
        btnEdit_Users.setBorderPainted(false);
        btnEdit_Users.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnEdit_Users.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnEdit_Users.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnEdit_Users.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEdit_UsersActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Administrador");

        txtAdmin1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtAdmin1.setForeground(new java.awt.Color(255, 255, 255));
        txtAdmin1.setText("                   ");

        txtDoc.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtDoc.setForeground(new java.awt.Color(255, 255, 255));
        txtDoc.setText("                                                 ");

        btnSalir.setBackground(new java.awt.Color(51, 51, 255));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSalir.setForeground(new java.awt.Color(255, 255, 255));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnSalir)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(btnEdit_Users)
                    .addComponent(btnEdit_Pets)
                    .addComponent(txtDoc)
                    .addComponent(txtAdmin1))
                .addGap(120, 120, 120))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtDoc)
                .addGap(18, 18, 18)
                .addComponent(txtAdmin1)
                .addGap(26, 26, 26)
                .addComponent(btnEdit_Users)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(btnEdit_Pets, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalir)
                        .addGap(15, 15, 15))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEdit_UsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit_UsersActionPerformed
       // Obtén los valores del usuario y la contraseña
     this.userDoc = txtDoc.getText().trim();
     this.userName = txtAdmin1.getText().trim();
        
            // Abre la vista de EditUsers_Admin y pasa el nombre, rol y documento
            Vista.Admin.EditUsers_Admin formAdmin = new Vista.Admin.EditUsers_Admin();
            formAdmin.setUserName(this.userName);
            formAdmin.setUserDoc( this.userDoc); // Pasar el número de documento aquí
            formAdmin.setVisible(true);
            this.dispose(); // Cierra la ventana de login
          
    }//GEN-LAST:event_btnEdit_UsersActionPerformed

    private void btnEdit_PetsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEdit_PetsActionPerformed
        // TODO add your handling code here:
               // Obtén los valores del usuario y la contraseña
     this.userDoc = txtDoc.getText().trim();
        
            // Abre la vista de EditUsers_Admin y pasa el nombre, rol y documento
            Vista.Admin.EditPets_Admin formAdmin = new Vista.Admin.EditPets_Admin();
            formAdmin.setUserDoc( this.userDoc); // Pasar el número de documento aquí
            formAdmin.setVisible(true);
            this.dispose(); // Cierra la ventana de login
    }//GEN-LAST:event_btnEdit_PetsActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        // TODO add your handling code here:
                // TODO add your handling code here:
            // Crea una nueva instancia de la ventana de Login
    Login login = new Login();
    
    // Hace visible la ventana de Login
    login.setVisible(true);
    
    // Opcionalmente, puedes cerrar la ventana actual si no deseas que el usuario vuelva a ella
    this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit_Pets;
    private javax.swing.JButton btnEdit_Users;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel txtAdmin1;
    private javax.swing.JLabel txtDoc;
    // End of variables declaration//GEN-END:variables
}

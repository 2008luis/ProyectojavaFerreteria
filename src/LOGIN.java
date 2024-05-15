
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LOGIN extends javax.swing.JFrame {

String user, pass;    
Conexiones conex;

    public LOGIN() {
     this.setUndecorated(true);
        initComponents();
        txtusuario.setText("");
        this.setLocationRelativeTo(null);
        txtpass.setText("");
        conex = new Conexiones();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtusuario = new javax.swing.JTextField();
        lbUsuario = new javax.swing.JLabel();
        lbpassword = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        lbImagenLogin = new javax.swing.JLabel();
        lbSalir = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("LOGIN");

        jPanel1.setBackground(new java.awt.Color(0, 51, 204));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtusuario.setBackground(new java.awt.Color(204, 204, 204));
        txtusuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(txtusuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 200, 30));

        lbUsuario.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lbUsuario.setText("USUARIO");
        jPanel1.add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        lbpassword.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        lbpassword.setForeground(new java.awt.Color(255, 255, 255));
        lbpassword.setText("CONTRASEÑA");
        jPanel1.add(lbpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 130, -1));

        btnRegistrar.setBackground(new java.awt.Color(0, 153, 255));
        btnRegistrar.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrar.setText("INGRESAR");
        btnRegistrar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, 280, 40));

        txtpass.setBackground(new java.awt.Color(204, 204, 204));
        txtpass.setText("jPasswordField1");
        txtpass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 200, 30));

        lbImagenLogin.setBackground(new java.awt.Color(51, 204, 255));
        lbImagenLogin.setForeground(new java.awt.Color(51, 204, 255));
        lbImagenLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbImagenLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuariologin.png"))); // NOI18N
        lbImagenLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lbImagenLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 200, 130));
        lbImagenLogin.getAccessibleContext().setAccessibleName("imagenlogin");

        lbSalir.setBackground(new java.awt.Color(0, 0, 0));
        lbSalir.setForeground(new java.awt.Color(255, 0, 51));
        lbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Eliminar2.0.png"))); // NOI18N
        lbSalir.setText("SALIR");
        lbSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbSalirMouseClicked(evt);
            }
        });
        jPanel1.add(lbSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        inicioSesion();
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void lbSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbSalirMouseClicked
        // TODO add your handling code here:
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Quieres salir del programa?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (respuesta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_lbSalirMouseClicked
 public void inicioSesion() {
    try (Connection connection = DriverManager.getConnection(conex.getUrl(), conex.getUser(), conex.getPass())) {
             user = txtusuario.getText().toUpperCase();
             pass = String.valueOf(txtpass.getPassword());

            PreparedStatement stmt = connection.prepareCall("call validarLogin(?,?)");
            stmt.setString(1, user);
            stmt.setString(2, pass);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int IdUsuario = rs.getInt("fk_rol");
               int  idEmpleado = rs.getInt("id_empleado");
                Inicio ini = new Inicio(IdUsuario, user, idEmpleado);
                ini.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
                txtpass.setText("");
                txtusuario.setText("");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
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
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LOGIN.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LOGIN().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbImagenLogin;
    private javax.swing.JLabel lbSalir;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lbpassword;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JTextField txtusuario;
    // End of variables declaration//GEN-END:variables
}

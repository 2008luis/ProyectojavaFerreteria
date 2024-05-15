import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class RegistroEmpleados extends javax.swing.JFrame {
    String pass,  passdos, nombre, usuario;
    public RegistroEmpleados() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        txtnombre = new javax.swing.JTextField();
        lbUsuario = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnRegistro = new javax.swing.JButton();
        txtpass = new javax.swing.JPasswordField();
        txtpassdos = new javax.swing.JPasswordField();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("REGISTRO EMPLEADO");

        jPanel1.setBackground(new java.awt.Color(102, 204, 255));
        jPanel1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNombre.setForeground(new java.awt.Color(0, 0, 0));
        lbNombre.setText("NOMBRE DEL EMPLEADO");
        jPanel1.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 166, -1));

        txtnombre.setBackground(new java.awt.Color(204, 204, 204));
        txtnombre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtnombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 190, -1));

        lbUsuario.setForeground(new java.awt.Color(0, 0, 0));
        lbUsuario.setText("USUARIO");
        jPanel1.add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(204, 204, 204));
        txtUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 190, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("CONTRASEÑA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 210, -1, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("REGISTRO DE EMPLEADOS");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("CONTRASEÑA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 270, -1, -1));

        btnRegistro.setBackground(new java.awt.Color(0, 51, 204));
        btnRegistro.setText("REGISTRAR");
        btnRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistroActionPerformed(evt);
            }
        });
        jPanel1.add(btnRegistro, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 160, 50));

        txtpass.setBackground(new java.awt.Color(204, 204, 204));
        txtpass.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 190, -1));

        txtpassdos.setBackground(new java.awt.Color(204, 204, 204));
        txtpassdos.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtpassdos, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 190, -1));

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo ferreteria.jpeg"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 160));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void btnRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistroActionPerformed
        if (txtnombre.getText().isEmpty()
                || txtUsuario.getText().isEmpty()
                || String.valueOf(txtpass.getPassword()).isEmpty()
                || String.valueOf(txtpassdos.getPassword()).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos. Por favor, diligéncialos para el registro. Gracias.");
            return;
        }

        nombre = txtnombre.getText().toUpperCase();
        usuario = txtUsuario.getText().toUpperCase();
        pass = String.valueOf(txtpass.getPassword());
        passdos = String.valueOf(txtpassdos.getPassword());

        if (!pass.equals(passdos)) {
            JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
            return;
        }
       
        try {
            Conexiones con = new Conexiones();
            Connection connection = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPass());
            PreparedStatement stmt = connection.prepareStatement("call registrarEmpleados(?,?,?,?)");
            stmt.setString(1, nombre);
            stmt.setString(2, usuario);
            stmt.setString(3, passdos); 
            stmt.setInt(4, 2);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(rootPane, "Registro de empleado con éxito");
            txtnombre.setText("");
            txtUsuario.setText("");
            txtpass.setText("");
            txtpassdos.setText("");
            dispose();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error de base de datos: " + e.getMessage());
        }
    }//GEN-LAST:event_btnRegistroActionPerformed

 
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
            java.util.logging.Logger.getLogger(RegistroEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JTextField txtUsuario;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JPasswordField txtpass;
    private javax.swing.JPasswordField txtpassdos;
    // End of variables declaration//GEN-END:variables
}

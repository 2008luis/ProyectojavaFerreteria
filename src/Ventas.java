import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Ventas extends javax.swing.JFrame {

  
    ArrayList<Productos> listaproducto;
    private int idCliente;
    String nit, producto, nombreClientes;
    double valorApagar;
    int cantidad;
    int idEmpleados;
    int item;
    int idprofile;
    String usua;
    double TotalPagar = 0.00;

    public Ventas(int idEmpleado, String usuario, int iD) {
         this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.idEmpleados = idEmpleado;
        this.usua = usuario;
        this.idprofile=iD;
        listaproducto = new ArrayList();
        llenarComboProductos();
        btnVender.setVisible(false);
    }

    private Ventas() {
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtnombreClie = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcedula = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cbProducto = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        Txtcantidad = new javax.swing.JTextField();
        btnVender = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        txtApellido = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTelefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        LabelTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        btnDevolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE CLIENTE");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, -1));

        txtnombreClie.setEditable(false);
        txtnombreClie.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.add(txtnombreClie, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 180, 30));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Numero Identificacion");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, -1, -1));

        txtcedula.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.add(txtcedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 180, 30));

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("PRODUCTO");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        cbProducto.setBackground(new java.awt.Color(153, 204, 255));
        cbProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel1.add(cbProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 180, 30));

        jLabel6.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CANTIDAD");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, -1));

        Txtcantidad.setBackground(new java.awt.Color(153, 204, 255));
        Txtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtcantidadKeyPressed(evt);
            }
        });
        jPanel1.add(Txtcantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 190, 30));

        btnVender.setBackground(new java.awt.Color(0, 0, 0));
        btnVender.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        btnVender.setForeground(new java.awt.Color(255, 255, 255));
        btnVender.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Vender.png"))); // NOI18N
        btnVender.setText("VENDER");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });
        jPanel1.add(btnVender, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 530, 220, 70));

        btnBuscar.setBackground(new java.awt.Color(51, 153, 255));
        btnBuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Buscar.png"))); // NOI18N
        btnBuscar.setText("BUSCAR CLIENTE");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, 210, 60));

        txtApellido.setEditable(false);
        txtApellido.setBackground(new java.awt.Color(153, 204, 255));
        jPanel1.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 180, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("APELLIDO");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        txtTelefono.setEditable(false);
        txtTelefono.setBackground(new java.awt.Color(153, 204, 255));
        txtTelefono.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 180, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TELEFONO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 100, -1));

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("VENDER");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Nombre", "Cantidad", "Precio Unitario", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(tblProductos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 480, 250));

        jLabel9.setText("Total a pagar: ");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 540, -1, -1));

        LabelTotal.setText("_____");
        jPanel1.add(LabelTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 540, -1, -1));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));
        jPanel3.setForeground(new java.awt.Color(153, 204, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logoFerreteria.jpeg"))); // NOI18N
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 150, -1));

        btnDevolver.setBackground(new java.awt.Color(153, 255, 204));
        btnDevolver.setForeground(new java.awt.Color(0, 0, 0));
        btnDevolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Devolver.png"))); // NOI18N
        btnDevolver.setText("DEVOLVER");
        btnDevolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDevolverActionPerformed(evt);
            }
        });
        jPanel3.add(btnDevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 130, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
     DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
        if (modelo.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "No hay productos para vender");
            return;
        }
        for (int i = 0; i < modelo.getRowCount(); i++) {
            String nombreProducto = (String) modelo.getValueAt(i, 1);
            int cantidad = (int) modelo.getValueAt(i, 2);
            vender(nombreProducto, cantidad);
        }
        JOptionPane.showMessageDialog(rootPane, "Venta registrada");
        try {
            generarPDF();
        } catch (DocumentException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
        modelo.setRowCount(0);
        txtnombreClie.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtcedula.setText("");
        Txtcantidad.setText("");
        LabelTotal.setText("_____");
        cbProducto.setSelectedIndex(0);
        btnVender.setVisible(false);
        
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        if (txtcedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ingrese la cedula para buscar el cliente");
            return;
        }
        Conexiones con = new Conexiones();
        try (Connection connection = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPass())) {
            String cedula = txtcedula.getText();

            PreparedStatement stmtcedula = connection.prepareStatement("CALL busquedaCedula(?)");
            stmtcedula.setString(1, cedula);
            ResultSet rs = stmtcedula.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = rs.getString("telefono");
                idCliente = rs.getInt("id_cliente");

                txtnombreClie.setText(nombre);
                txtTelefono.setText(telefono);
                txtApellido.setText(apellido);
                btnVender.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No se encontró ningún cliente con la cédula, registrese");
                RegistroCliente cli = new RegistroCliente();
                cli.setVisible(true);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void TxtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtcantidadKeyPressed
        Conexiones con = new Conexiones();

        try {
            Connection connection = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPass());
            String nombre = (String) cbProducto.getSelectedItem();
            PreparedStatement stmtCantidad = connection.prepareStatement("CALL obtenerCantidadPrecio(?)");
            stmtCantidad.setString(1, nombre);
            ResultSet rs = stmtCantidad.executeQuery(); 

            if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
                if (!"".equals(Txtcantidad.getText())) {
                    int can = Integer.parseInt(Txtcantidad.getText());
                    boolean productoExistente = false;
                    DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
                    for (int i = 0; i < modelo.getRowCount(); i++) {
                        String nombreExistente = (String) modelo.getValueAt(i, 1);
                        if (nombreExistente.equals(nombre)) {
                            productoExistente = true;
                            break;
                        }
                    }
                    if (!productoExistente) {
                        if (rs.next()) {
                            int cantidadDisponible = rs.getInt("cantidad");
                            double precioProducto = rs.getDouble("precioVenta");
                            double precioTotal;
                            precioTotal = precioProducto*can;
                            if (cantidadDisponible >= can) {
                                item = item + 1;
                                ArrayList lista = new ArrayList();
                                lista.add(item);
                                lista.add(nombre);
                                lista.add(can);
                                lista.add(precioProducto);
                                lista.add(precioTotal);
                                Object[] o = new Object[5];
                                o[0] = lista.get(0);
                                o[1] = lista.get(1);
                                o[2] = lista.get(2);
                                o[3] = lista.get(3);
                                o[4] = lista.get(4);
                                modelo.addRow(o);
                                tblProductos.setModel(modelo);
                                totalPagar();
                            } else {
                                JOptionPane.showMessageDialog(rootPane, "No hay la cantidad disponible ");
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "No se encontró el producto en la base de datos");
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "El producto ya está en la tabla");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Ingrese la cantidad");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error de base de datos: " + e.getMessage());
        }
    }//GEN-LAST:event_TxtcantidadKeyPressed

    private void btnDevolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDevolverActionPerformed
     Inicio ini = new Inicio(idEmpleados,usua, idprofile);
        ini.setVisible(true);
          dispose();
    }//GEN-LAST:event_btnDevolverActionPerformed

    public void vender(String producto, int cantidad) {
        Conexiones con = new Conexiones();
        nombreClientes = txtnombreClie.getText();
        nit = txtcedula.getText();

        try {
            Connection connection = DriverManager.getConnection(con.getUrl(), con.getUser(), con.getPass());
            PreparedStatement stmtCantidad = connection.prepareStatement("CALL obtenerCantidadProducto(?)");
            stmtCantidad.setString(1, producto);
            ResultSet rs = stmtCantidad.executeQuery();
            if (rs.next()) {
                int cantidadDisponible = rs.getInt("cantidad");
                if (cantidadDisponible < cantidad) {
                    JOptionPane.showMessageDialog(rootPane, "No hay suficiente cantidad disponible para realizar la venta del producto: " + producto);
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "El producto seleccionado no existe.");
                return;
            }
            Date fecha = Calendar.getInstance().getTime();
            java.sql.Date Fechavender = new java.sql.Date(fecha.getTime());

            PreparedStatement stmtVenta = connection.prepareStatement("CALL agregarVenta(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmtVenta.setString(1, nombreClientes);
            stmtVenta.setString(2, nit);
            stmtVenta.setString(3, producto);
            stmtVenta.setInt(4, cantidad);
            stmtVenta.setDate(5, Fechavender);
            stmtVenta.setDouble(6, valorApagar);
            stmtVenta.setString(7, usua);
            stmtVenta.setInt(8, idEmpleados);
            stmtVenta.setInt(9, idCliente);
            stmtVenta.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(rootPane, "Error de base de datos: " + e.getMessage());
        }
    }

    public void generarPDF() throws DocumentException {
        try {
            String Apellido = txtApellido.getText().toUpperCase();
            String nombreArchivo = "Factura_" + nombreClientes + "_" + Apellido + ".pdf";
            String relativePath = "src/Facturas/" + nombreArchivo;
            File file = new File(relativePath);
            file.getParentFile().mkdirs(); // Crea el directorio si no existe

            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();

            // Agregar logo de la ferretería
            String imagePath = "src/Imagenes/logoFerreteria.jpeg";
            Image img = Image.getInstance(imagePath);
            img.scaleToFit(100, 100);
            img.setAlignment(Element.ALIGN_RIGHT);
            doc.add(img);

            // Título de la factura
            Paragraph titulo = new Paragraph("Factura de Venta", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20, Font.BOLD, BaseColor.BLACK));
            titulo.setAlignment(Element.ALIGN_CENTER);
            doc.add(titulo);

            // Fecha de emisión
            String fechaEmision = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            Paragraph fecha = new Paragraph("Fecha de Emisión: " + fechaEmision, FontFactory.getFont(FontFactory.HELVETICA, 12));
            fecha.setAlignment(Element.ALIGN_RIGHT);
            doc.add(fecha);

            // Información del Emisor
            Paragraph emisor = new Paragraph();
            emisor.add(new Phrase("Emisor: PINTUACCESORIOS LA PERLA S.A.S.", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
            emisor.add(Chunk.NEWLINE);
            emisor.add(new Phrase("NIT: 123456789-1"));
            emisor.add(Chunk.NEWLINE);
            emisor.add(new Phrase("Teléfono: (57) 300 7684783 -- (57) 301 4659906"));
            emisor.add(Chunk.NEWLINE);
            emisor.add(new Phrase("Correo Electrónico: camilocamilo122002@gmail.com -- correaluisam3789@gmail.com"));
            emisor.add(Chunk.NEWLINE);
            emisor.add(new Phrase("Dirección: CR 19 29 D 15 CA 1 BRR VILLA BELLA, MAGDALENA, SANTA MARTA"));
            emisor.setSpacingBefore(20);
            doc.add(emisor);

            // Información del cliente
            Paragraph datosCliente = new Paragraph();
            datosCliente.add(new Phrase("Receptor: " + nombreClientes, FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12)));
            datosCliente.add(Chunk.NEWLINE);
            datosCliente.add(new Phrase("Apellido: " + Apellido));
            datosCliente.add(Chunk.NEWLINE);
            datosCliente.add(new Phrase("Cédula: " + nit));
            datosCliente.setSpacingBefore(20);
            doc.add(datosCliente);

            // Tabla de productos
            PdfPTable pdfTable = new PdfPTable(tblProductos.getColumnCount());
            for (int i = 0; i < tblProductos.getColumnCount(); i++) {
                PdfPCell header = new PdfPCell(new Phrase(tblProductos.getColumnName(i), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 12, BaseColor.WHITE)));
                header.setBackgroundColor(BaseColor.DARK_GRAY);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                pdfTable.addCell(header);
            }
            for (int row = 0; row < tblProductos.getRowCount(); row++) {
                for (int col = 0; col < tblProductos.getColumnCount(); col++) {
                    Object value = tblProductos.getValueAt(row, col);
                    PdfPCell cell = new PdfPCell(new Phrase(value != null ? value.toString() : "", FontFactory.getFont(FontFactory.HELVETICA, 12)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    pdfTable.addCell(cell);
                }
            }
            pdfTable.setSpacingBefore(20);
            doc.add(pdfTable);

            // Valor total a pagar
            totalPagar(); // Calcular el total a pagar
            Paragraph total = new Paragraph("Total a Pagar: $" + LabelTotal.getText(), FontFactory.getFont(FontFactory.HELVETICA_BOLD, 14, Font.BOLD, BaseColor.BLACK));
            total.setAlignment(Element.ALIGN_RIGHT);
            total.setSpacingBefore(20);
            doc.add(total);

            // Mensaje de agradecimiento
            Paragraph agradecimiento = new Paragraph("Gracias por ser parte de nuestra familia.", FontFactory.getFont(FontFactory.HELVETICA, 12, Font.ITALIC, BaseColor.GRAY));
            agradecimiento.setAlignment(Element.ALIGN_CENTER);
            agradecimiento.setSpacingBefore(20);
            doc.add(agradecimiento);

            // Cerrar documento
            doc.close();

            System.out.println("PDF creado exitosamente en: " + file.getAbsolutePath());
            if (file.exists()) {
                if (Desktop.isDesktopSupported()) {
                    Desktop.getDesktop().open(file);
                } else {
                    System.out.println("Awt Desktop is not supported!");
                }
            } else {
                System.out.println("File does not exist!");
            }
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void llenarComboProductos() {
        Conexiones conex = new Conexiones();
        try (
                Connection con = DriverManager.getConnection(conex.getUrl(),
         conex.getUser(), conex.getPass())) {
            cbProducto.removeAllItems();
            cbProducto.addItem("Seleccione");
            listaproducto.clear();
            Statement statement = con.createStatement();
            String query = "call comboProducto()";
            ResultSet resultset = statement.executeQuery(query);

            while (resultset.next()) {
                String nombreProductos = resultset.getString("nombreProducto");
                listaproducto.add(new Productos(resultset.getInt("id_producto"),
                        resultset.getString("nombreProducto")));
                cbProducto.addItem(nombreProductos);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
    
    public void totalPagar(){
        TotalPagar = 0.00;
        int numFila  = tblProductos.getRowCount();
        for (int i = 0; i < numFila; i++) {
            double cal = Double.parseDouble(String.valueOf(tblProductos.getModel().getValueAt(i, 4)));
            TotalPagar = TotalPagar + cal;
        }
        LabelTotal.setText(String.format("%.2f", TotalPagar));
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
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
            
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabelTotal;
    private javax.swing.JTextField Txtcantidad;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnDevolver;
    private javax.swing.JButton btnVender;
    private javax.swing.JComboBox<String> cbProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtcedula;
    private javax.swing.JTextField txtnombreClie;
    // End of variables declaration//GEN-END:variables

}

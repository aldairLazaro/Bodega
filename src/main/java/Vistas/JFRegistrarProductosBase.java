/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Conexion.Conexion;
import Controllers.ControllersProducto;
import Models.Productos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author haitr
 */
public class JFRegistrarProductosBase extends javax.swing.JFrame {

    /**
     * Creates new form JFRegistrarProductosBase
     */
    public JFRegistrarProductosBase() {
        initComponents();        
        setExtendedState(MAXIMIZED_BOTH);  
        ListarProductosBase();
    }
    
    public void BuscarProductoPorCodigo(){
        
    }
    
    public void ListarProductosBase(){
//        ControllersProducto ctProductos = new ControllersProducto();
//        
//        DefaultTableModel tablaProductosBase = (DefaultTableModel) tbProductosBase.getModel();
//        tablaProductosBase.getDataVector().removeAllElements();
//        tablaProductosBase.fireTableDataChanged();
//        
//        
//        for(Productos pro : ctProductos.ListarProductosBase()){
//            Object[] item = {
//                pro.getCodigo(),
//                pro.getDescripcion(),
//                pro.getCantidad()
//            };
//            
//            tablaProductosBase.addRow(item);
//        }
//        
//        tbProductosBase.getColumnModel().getColumn(0).setMinWidth(0);
//        tbProductosBase.getColumnModel().getColumn(0).setMaxWidth(0);
//        tbProductosBase.getColumnModel().getColumn(1).setMinWidth(0);
//        tbProductosBase.getColumnModel().getColumn(1).setMaxWidth(0);
//        tbProductosBase.getColumnModel().getColumn(2).setMinWidth(0);
//        tbProductosBase.getColumnModel().getColumn(2).setMaxWidth(0);

        try {
            DefaultTableModel tablaProductos = new DefaultTableModel();
            tbProductosBase.setModel(tablaProductos);
            
            PreparedStatement ps = null;
            ResultSet rs = null;
            Conexion conn = new Conexion();
            Connection con = conn.getConexion();
            
            
            String sql = "SELECT  codigo, descripcion, cantidad FROM productos";
            
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            ResultSetMetaData meta = rs.getMetaData();
            
            int cantidad= meta.getColumnCount();
            
            tablaProductos.addColumn("Codigo");
            tablaProductos.addColumn("Descripcion");
            tablaProductos.addColumn("Cantidad");
            while (rs.next()) {                
                Object[] filas = new Object[cantidad];
                
                for(int i = 0; i < cantidad; i++){
                    filas[i] = rs.getObject(i + 1);              
                }
                tablaProductos.addRow(filas);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        

   
    }
    
    public Boolean AgregarProductosBase(){
        Boolean exito=false;
        
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String descripcion = txtDescripcion.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            ControllersProducto ctProductos = new ControllersProducto();
            Productos productos = new Productos();
            
            productos.setCodigo(codigo);
            productos.setDescripcion(descripcion);
            productos.setCantidad(cantidad);
            
            exito=ctProductos.AgregarProductosBase(productos);
        } catch (Exception e) {
            System.out.println(e);
            exito=false;
        }
        return exito;
    }
    
    public Boolean UpdateProductosBase(){
        Boolean exito = false;
        try {
            int codigo = Integer.parseInt(txtCodigo.getText());
            String descripcion = txtDescripcion.getText();
            int cantidad = Integer.parseInt(txtCantidad.getText());
            
            ControllersProducto ctProductos = new ControllersProducto();
            Productos productos = new Productos();
            
            productos.setCodigo(codigo);
            productos.setDescripcion(descripcion);
            productos.setCantidad(cantidad);
            
            exito = ctProductos.UpdateProductosbase(productos);
        } catch (Exception e) {
            System.out.println(e);
            exito = false;
        }
        
        return exito;
    }
    
    public void LimpiarCasillas(){
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtCantidad.setText("");
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
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtCantidad = new javax.swing.JTextField();
        btnRegistrarProductosBase = new javax.swing.JButton();
        btnEditarProductoBase = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtBuscadorProductosbase = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbProductosBase = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        subMenuInventario = new javax.swing.JMenuItem();
        subMenuIngresoProductos = new javax.swing.JMenuItem();
        subMenuSalidaProductos = new javax.swing.JMenuItem();
        subMenuProductosBase = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1320, 660));
        setPreferredSize(new java.awt.Dimension(1320, 660));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("Registrar Productos Nuevos");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Codigo Sap:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Descripcion del Producto:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Cantidad de Inicio:");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        btnRegistrarProductosBase.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnRegistrarProductosBase.setText("Ingresar Producto");
        btnRegistrarProductosBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarProductosBaseActionPerformed(evt);
            }
        });

        btnEditarProductoBase.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnEditarProductoBase.setText("Editar Producto");
        btnEditarProductoBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoBaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2)
                                .addComponent(txtCodigo)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.DEFAULT_SIZE, 407, Short.MAX_VALUE)
                                .addComponent(txtDescripcion))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnRegistrarProductosBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarProductoBase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel1)
                .addGap(68, 68, 68)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnRegistrarProductosBase, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btnEditarProductoBase, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 510, 640));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Buscador:");

        txtBuscadorProductosbase.setPreferredSize(new java.awt.Dimension(60, 25));
        txtBuscadorProductosbase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorProductosbaseActionPerformed(evt);
            }
        });

        tbProductosBase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion del Producto", "Cantidad Inicial"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbProductosBase.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProductosBaseMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbProductosBase);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 777, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscadorProductosbase, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscadorProductosbase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(154, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 810, 640));

        jMenu1.setText("Administracion de Bodega");

        subMenuInventario.setText("Inventario");
        subMenuInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuInventarioActionPerformed(evt);
            }
        });
        jMenu1.add(subMenuInventario);

        subMenuIngresoProductos.setText("Ingreso de Productos");
        subMenuIngresoProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuIngresoProductosActionPerformed(evt);
            }
        });
        jMenu1.add(subMenuIngresoProductos);

        subMenuSalidaProductos.setText("Salida de Productos");
        subMenuSalidaProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuSalidaProductosActionPerformed(evt);
            }
        });
        jMenu1.add(subMenuSalidaProductos);

        subMenuProductosBase.setText("Productos Base");
        subMenuProductosBase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subMenuProductosBaseActionPerformed(evt);
            }
        });
        jMenu1.add(subMenuProductosBase);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Administracion de Usuarios");

        jMenuItem4.setText("jMenuItem4");
        jMenu2.add(jMenuItem4);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Exit");
        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtBuscadorProductosbaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorProductosbaseActionPerformed
        
    }//GEN-LAST:event_txtBuscadorProductosbaseActionPerformed

    private void subMenuSalidaProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuSalidaProductosActionPerformed
        JFSalidaProductos salidaProductos = new JFSalidaProductos();
        salidaProductos.setVisible(true);
        dispose();
    }//GEN-LAST:event_subMenuSalidaProductosActionPerformed

    private void subMenuInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuInventarioActionPerformed
        JFInventario inventario = new JFInventario();
        inventario.setVisible(true);
        dispose();
    }//GEN-LAST:event_subMenuInventarioActionPerformed

    private void subMenuIngresoProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuIngresoProductosActionPerformed
        JFIngresoProductos ingresoProductos = new JFIngresoProductos();
        ingresoProductos.setVisible(true);
        dispose();
    }//GEN-LAST:event_subMenuIngresoProductosActionPerformed

    private void subMenuProductosBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subMenuProductosBaseActionPerformed
        JFProductosBase productosBase = new JFProductosBase();
        productosBase.setVisible(true);
        dispose();
    }//GEN-LAST:event_subMenuProductosBaseActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnRegistrarProductosBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarProductosBaseActionPerformed
        if (AgregarProductosBase() == true) {
            JOptionPane.showMessageDialog(null, "Registro Exitoso", "Registro", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Registro Fallido", "Registro", JOptionPane.ERROR_MESSAGE);
        }
        
        ListarProductosBase();
        
        LimpiarCasillas();
        
    }//GEN-LAST:event_btnRegistrarProductosBaseActionPerformed

    private void tbProductosBaseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProductosBaseMouseClicked
        
        String codigo = tbProductosBase.getValueAt(tbProductosBase.getSelectedRow(), 0).toString();
        String desripcion = tbProductosBase.getValueAt(tbProductosBase.getSelectedRow(), 1).toString();
        String cantidad = tbProductosBase.getValueAt(tbProductosBase.getSelectedRow(), 2).toString();
        
        txtCodigo.setText(codigo);
        txtDescripcion.setText(desripcion);
        txtCantidad.setText(cantidad);
    }//GEN-LAST:event_tbProductosBaseMouseClicked

    private void btnEditarProductoBaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoBaseActionPerformed
        if (UpdateProductosBase()== true) {
            JOptionPane.showMessageDialog(null, "Actualizacion Exitosa", "Actualizacion", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Actualizacion Fallida", "Actualizacion", JOptionPane.ERROR_MESSAGE);
        }
        
        ListarProductosBase();
        
        LimpiarCasillas();
    }//GEN-LAST:event_btnEditarProductoBaseActionPerformed

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
            java.util.logging.Logger.getLogger(JFRegistrarProductosBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFRegistrarProductosBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFRegistrarProductosBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFRegistrarProductosBase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFRegistrarProductosBase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarProductoBase;
    private javax.swing.JButton btnRegistrarProductosBase;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem subMenuIngresoProductos;
    private javax.swing.JMenuItem subMenuInventario;
    private javax.swing.JMenuItem subMenuProductosBase;
    private javax.swing.JMenuItem subMenuSalidaProductos;
    private javax.swing.JTable tbProductosBase;
    private javax.swing.JTextField txtBuscadorProductosbase;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    // End of variables declaration//GEN-END:variables
}

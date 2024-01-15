package vistas;

import accesoADatos.ProductoData;
import entidades.Producto;
import java.awt.*;
import javax.swing.*;

public class VistaCrearProducto extends javax.swing.JInternalFrame {

    FondoPanel fondo = new FondoPanel();
    private ProductoData pd = null;

    public VistaCrearProducto() {
        this.setContentPane(fondo);
        initComponents();
        pd = new ProductoData();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpVistaCrearProducto = new FondoPanel();
        jlTitulo = new javax.swing.JLabel();
        jlNombre = new javax.swing.JLabel();
        jtfNombre = new javax.swing.JTextField();
        jlPrecio = new javax.swing.JLabel();
        jlStock = new javax.swing.JLabel();
        jbNuevo = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jtfPrecio = new javax.swing.JTextField();
        jtfStock = new javax.swing.JTextField();

        setClosable(true);

        jlTitulo.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setText("Crear producto");

        jlNombre.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlNombre.setForeground(new java.awt.Color(255, 255, 255));
        jlNombre.setText("Nombre");

        jlPrecio.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlPrecio.setForeground(new java.awt.Color(255, 255, 255));
        jlPrecio.setText("Precio");

        jlStock.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlStock.setForeground(new java.awt.Color(255, 255, 255));
        jlStock.setText("Stock");

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpVistaCrearProductoLayout = new javax.swing.GroupLayout(jpVistaCrearProducto);
        jpVistaCrearProducto.setLayout(jpVistaCrearProductoLayout);
        jpVistaCrearProductoLayout.setHorizontalGroup(
            jpVistaCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVistaCrearProductoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpVistaCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVistaCrearProductoLayout.createSequentialGroup()
                        .addComponent(jbNuevo)
                        .addGap(18, 18, 18)
                        .addComponent(jbCancelar))
                    .addGroup(jpVistaCrearProductoLayout.createSequentialGroup()
                        .addGroup(jpVistaCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlNombre)
                            .addComponent(jlPrecio)
                            .addComponent(jlStock))
                        .addGap(18, 18, 18)
                        .addGroup(jpVistaCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfPrecio)
                            .addComponent(jtfStock)
                            .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpVistaCrearProductoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jlTitulo)
                        .addGap(40, 40, 40)))
                .addContainerGap())
        );
        jpVistaCrearProductoLayout.setVerticalGroup(
            jpVistaCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVistaCrearProductoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpVistaCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlNombre)
                    .addComponent(jtfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpVistaCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPrecio)
                    .addComponent(jtfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpVistaCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlStock)
                    .addComponent(jtfStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpVistaCrearProductoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbCancelar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpVistaCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jpVistaCrearProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        try {
            String nom = jtfNombre.getText();
            double precio = Double.parseDouble(jtfPrecio.getText());
            int stock = Integer.parseInt(jtfStock.getText());
            int res = JOptionPane.showConfirmDialog(this, "¿Desea crear este nuevo producto?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                Producto producto = new Producto(nom, precio, stock, true);
                pd.nuevoProducto(producto);
                jtfNombre.setText("");
                jtfPrecio.setText("");
                jtfStock.setText("");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error. Los campos precio y stock únicamente reconocen dígitos. | " + e, "Formato erróneo.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "¿Desea cancelar la operación?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jbCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlPrecio;
    private javax.swing.JLabel jlStock;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JPanel jpVistaCrearProducto;
    private javax.swing.JTextField jtfNombre;
    private javax.swing.JTextField jtfPrecio;
    private javax.swing.JTextField jtfStock;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Fondo2.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }

}

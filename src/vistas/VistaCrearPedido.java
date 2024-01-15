package vistas;

import accesoADatos.*;
import entidades.*;
import java.awt.*;
import java.time.*;
import java.util.*;
import javax.swing.*;

public class VistaCrearPedido extends javax.swing.JInternalFrame {

    FondoPanel fondo = new FondoPanel();
    private PedidoData pd = null;
    private ProductoData prd = null;
    private PedidoProductoData ppd = null;
    private LogIn lg = null;
    private int idPedido = -1;

    public VistaCrearPedido() {
        this.setContentPane(fondo);
        initComponents();
        pd = new PedidoData();
        prd = new ProductoData();
        ppd = new PedidoProductoData();
        lg = new LogIn();
        initComponents();
        cargarComboBox();
        cargarComboBox2();
        jcbProductos.setEnabled(false);
        jsfCant.setEnabled(false);
        jbAñadir.setEnabled(false);
        jbFin.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpVistaCrearPedido = new FondoPanel();
        jLabel1 = new javax.swing.JLabel();
        jtMesa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jrbCobrada = new javax.swing.JRadioButton();
        jbSiguiente = new javax.swing.JButton();
        jbCancelar = new javax.swing.JButton();
        jcbMesero = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jsfCant = new com.toedter.components.JSpinField();
        jcbProductos = new javax.swing.JComboBox<>();
        jbAñadir = new javax.swing.JButton();
        jbFin = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Id Mesa");

        jtMesa.setForeground(new java.awt.Color(102, 102, 102));
        jtMesa.setText("Ingrese el id de la mesa.");
        jtMesa.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtMesaFocusGained(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mesero");

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cobrado");

        jrbCobrada.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jrbCobrada.setForeground(new java.awt.Color(255, 255, 255));
        jrbCobrada.setText("No");
        jrbCobrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbCobradaActionPerformed(evt);
            }
        });

        jbSiguiente.setText("Siguiente");
        jbSiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSiguienteActionPerformed(evt);
            }
        });

        jbCancelar.setText("Cancelar");
        jbCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCancelarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Producto");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Cantidad");

        jsfCant.setMinimum(1);

        jcbProductos.setToolTipText("");

        jbAñadir.setText("Añadir");
        jbAñadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAñadirActionPerformed(evt);
            }
        });

        jbFin.setText("Finalizar");
        jbFin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbFinActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpVistaCrearPedidoLayout = new javax.swing.GroupLayout(jpVistaCrearPedido);
        jpVistaCrearPedido.setLayout(jpVistaCrearPedidoLayout);
        jpVistaCrearPedidoLayout.setHorizontalGroup(
            jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVistaCrearPedidoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVistaCrearPedidoLayout.createSequentialGroup()
                        .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(30, 30, 30)
                        .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtMesa, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                            .addComponent(jcbMesero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jpVistaCrearPedidoLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jrbCobrada))
                    .addGroup(jpVistaCrearPedidoLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpVistaCrearPedidoLayout.createSequentialGroup()
                                .addComponent(jbAñadir)
                                .addGap(22, 22, 22)
                                .addComponent(jbFin))
                            .addComponent(jsfCant, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jpVistaCrearPedidoLayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpVistaCrearPedidoLayout.createSequentialGroup()
                                .addComponent(jbSiguiente)
                                .addGap(18, 18, 18)
                                .addComponent(jbCancelar))
                            .addComponent(jcbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpVistaCrearPedidoLayout.setVerticalGroup(
            jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpVistaCrearPedidoLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpVistaCrearPedidoLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2))
                    .addGroup(jpVistaCrearPedidoLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jcbMesero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jrbCobrada))
                .addGap(18, 18, 18)
                .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbSiguiente)
                    .addComponent(jbCancelar))
                .addGap(18, 18, 18)
                .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jcbProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jsfCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpVistaCrearPedidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAñadir)
                    .addComponent(jbFin))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpVistaCrearPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpVistaCrearPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrbCobradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbCobradaActionPerformed
        if (jrbCobrada.isSelected()) {
            jrbCobrada.setText("Sí.");
        } else {
            jrbCobrada.setText("No.");
        }
    }//GEN-LAST:event_jrbCobradaActionPerformed

    private void jbCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCancelarActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "¿Desea cancelar la operación?", "Confirmación", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jbCancelarActionPerformed

    private void jtMesaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtMesaFocusGained
        jtMesa.setText("");
    }//GEN-LAST:event_jtMesaFocusGained

    private void jbSiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSiguienteActionPerformed

        try {
            if (jtMesa.getText().isEmpty() || jtMesa.getText().equals("Ingrese el id de la mesa.") || jcbMesero.getSelectedIndex()==0) {
                JOptionPane.showMessageDialog(this, "El campo no puede estar vacio");
            } else {
                int mesa = Integer.parseInt(jtMesa.getText());
                Mesero mesero = new Mesero();
                mesero = (Mesero) jcbMesero.getSelectedItem();
                int importe = 0;
                boolean c = false;
                if (jrbCobrada.isSelected()) {
                    c = true;
                }
                int resul = JOptionPane.showConfirmDialog(this, "¿Desea crear este nuevo pedido? ", "Confirmacion", JOptionPane.YES_NO_OPTION);
                if (resul == JOptionPane.YES_OPTION) {
                    Pedido pedido = new Pedido(mesa, mesero.getId(), LocalDateTime.now(), importe, c);
                    idPedido = pd.nuevoPedido(pedido);
                    jtMesa.setText("Ingrese el id de la mesa.");
                    jcbMesero.setSelectedIndex(0);
                    jtMesa.setEnabled(false);
                    jcbMesero.setEnabled(false);
                    jrbCobrada.setEnabled(false);
                    jbCancelar.setEnabled(false);
                    jbSiguiente.setEnabled(false);
                    jcbProductos.setEnabled(true);
                    jsfCant.setEnabled(true);
                    jbAñadir.setEnabled(true);
                    jbFin.setEnabled(true);
                    JOptionPane.showMessageDialog(this, "Su número de orden es " + idPedido, "Número de orden", JOptionPane.PLAIN_MESSAGE);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error. El campo IdMesa espera digitos " + e.getMessage());
        }


    }//GEN-LAST:event_jbSiguienteActionPerformed

    private void jbAñadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAñadirActionPerformed
        if (jcbProductos.getSelectedIndex() != 0) {
            int res = JOptionPane.showConfirmDialog(this, "¿Desea añadir este producto a su pedido?", "Confirmación", JOptionPane.YES_NO_OPTION);
            if (res == JOptionPane.YES_OPTION) {
                Producto p = (Producto) jcbProductos.getSelectedItem();
                ppd.nuevoPedidoProd(new PedidoProducto(idPedido, p.getIdProd(), jsfCant.getValue()));
                pd.calcularImporte(idPedido);
                JOptionPane.showMessageDialog(this, "Se ha añadido " + p + " a su pedido.", "Producto añadido", JOptionPane.PLAIN_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Debe seleccionar un item", "Campo vacío", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbAñadirActionPerformed

    private void jbFinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbFinActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "¿Desea finalizar su pedido?", "Finalizar Pedido", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jbFinActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbAñadir;
    private javax.swing.JButton jbCancelar;
    private javax.swing.JButton jbFin;
    private javax.swing.JButton jbSiguiente;
    private javax.swing.JComboBox<Mesero> jcbMesero;
    private javax.swing.JComboBox<Producto> jcbProductos;
    private javax.swing.JPanel jpVistaCrearPedido;
    private javax.swing.JRadioButton jrbCobrada;
    private com.toedter.components.JSpinField jsfCant;
    private javax.swing.JTextField jtMesa;
    // End of variables declaration//GEN-END:variables

    private void cargarComboBox() {
        jcbProductos.removeAllItems();
        ArrayList<Producto> lista = new ArrayList<>();
        lista = prd.listarProductos();
        jcbProductos.addItem(new Producto("-Seleccione un item-", 0, 0, false));
        for (Producto producto : lista) {
            jcbProductos.addItem(producto);
        }
    }

    private void cargarComboBox2() {
        jcbMesero.removeAllItems();
        ArrayList<Mesero> lista = new ArrayList<>();
        lista = lg.listarMeseros();
        jcbMesero.addItem(new Mesero(0, 0, "-Seleccione un item-"));
        for (Mesero mesero : lista) {
            jcbMesero.addItem(mesero);
        }
    }
    
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

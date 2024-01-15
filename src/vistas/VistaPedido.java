package vistas;

import accesoADatos.*;
import entidades.*;
import java.awt.event.KeyEvent;
import java.time.*;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaPedido extends javax.swing.JInternalFrame {

    FondoPanel fondo = new FondoPanel();
    private PedidoData pd = null;
    private MesaData md = null;
    private LogIn lg = null;

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    private DefaultTableModel modelo2 = new DefaultTableModel() {
        public boolean isCellEditable(int f, int c) {
            return false;
        }
    };

    public VistaPedido() {
        this.setContentPane(fondo);
        initComponents();
        pd = new PedidoData();
        md = new MesaData();
        lg = new LogIn();
        jbCobrar.setEnabled(false);
        armarCabecera();
        armarCabecera2();
        mostrarBotones();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new FondoPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtPedidos = new javax.swing.JTable();
        jbNuevo = new javax.swing.JButton();
        jbAnular = new javax.swing.JButton();
        jcbPedidos = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        jcbListarPedidos = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtListarPedidos = new javax.swing.JTable();
        jbBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jtfIdPedido = new javax.swing.JTextField();
        jtfIdMesa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jdcFecha = new com.toedter.calendar.JDateChooser();
        jsfHora1 = new com.toedter.components.JSpinField();
        jsfMin1 = new com.toedter.components.JSpinField();
        jLabel7 = new javax.swing.JLabel();
        jsfHora2 = new com.toedter.components.JSpinField();
        jsfMin2 = new com.toedter.components.JSpinField();
        jSeparator1 = new javax.swing.JSeparator();
        jlFactura = new javax.swing.JLabel();
        jtfFactura = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jbCobrar = new javax.swing.JButton();

        setClosable(true);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pedidos");

        jtPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jtPedidos);

        jbNuevo.setText("Nuevo");
        jbNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevoActionPerformed(evt);
            }
        });

        jbAnular.setText("Anular");
        jbAnular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAnularActionPerformed(evt);
            }
        });

        jcbPedidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Pedidos", "Pedidos Pagados", "Pedidos sin Pagar" }));
        jcbPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPedidosActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Listar Pedidos Por:");

        jcbListarPedidos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "idMesa", "nombreMesero", "FechaYHora" }));
        jcbListarPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbListarPedidosActionPerformed(evt);
            }
        });

        jtListarPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jtListarPedidos);

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Id Pedido →");

        jtfIdMesa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfIdMesaKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Id Mesa →");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha →");

        jLabel6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("¿Entre que horas?");

        jsfHora1.setMaximum(23);
        jsfHora1.setMaximumSize(new java.awt.Dimension(23, 23));
        jsfHora1.setMinimum(0);
        jsfHora1.setMinimumSize(new java.awt.Dimension(0, 0));

        jsfMin1.setMaximum(59);
        jsfMin1.setMaximumSize(new java.awt.Dimension(59, 59));
        jsfMin1.setMinimum(0);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("&");

        jsfHora2.setMaximum(23);
        jsfHora2.setMaximumSize(new java.awt.Dimension(23, 23));
        jsfHora2.setMinimum(0);

        jsfMin2.setMaximum(59);
        jsfMin2.setMaximumSize(new java.awt.Dimension(59, 59));
        jsfMin2.setMinimum(0);

        jlFactura.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jlFactura.setForeground(new java.awt.Color(255, 255, 255));
        jlFactura.setText("Buscar productos adquiridos:");

        jtfFactura.setText("Ingrese el número de su pedido.");
        jtfFactura.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfFacturaFocusGained(evt);
            }
        });
        jtfFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfFacturaKeyPressed(evt);
            }
        });

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jbCobrar.setText("Cobrar");
        jbCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCobrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(538, 538, 538)
                        .addComponent(jButton1)
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(jcbPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(263, 263, 263)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbAnular)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbCobrar))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlFactura)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jtfFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(jtfIdMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jcbListarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jsfHora1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jsfMin1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jsfHora2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jsfMin2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jScrollPane2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbBuscar)
                                .addGap(60, 60, 60)))))
                .addGap(15, 15, 15))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 312, Short.MAX_VALUE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 312, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addComponent(jcbPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbNuevo)
                    .addComponent(jbAnular)
                    .addComponent(jbBuscar)
                    .addComponent(jtfIdPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jbCobrar))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbListarPedidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfIdMesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jdcFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addGap(3, 3, 3)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jsfHora2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jsfMin2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsfMin1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jsfHora1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFactura)
                    .addComponent(jtfFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 242, Short.MAX_VALUE)
                    .addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 243, Short.MAX_VALUE)))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jcbListarPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbListarPedidosActionPerformed
        mostrarBotones();
        if (jcbListarPedidos.getSelectedIndex() == 1) {
            cargarPorMesa();
        } else if (jcbListarPedidos.getSelectedIndex() == 2) {
            cargarPorMesero();
        } else if (jcbListarPedidos.getSelectedIndex() == 3) {
            cargarPorFechaHora();
        }
    }//GEN-LAST:event_jcbListarPedidosActionPerformed

    private void jcbPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPedidosActionPerformed
        ArrayList<Pedido> ped = new ArrayList<>();
        if (jcbPedidos.getSelectedIndex() == 1) {
            ped = pd.listarPedidos();
            jbCobrar.setEnabled(false);
        } else if (jcbPedidos.getSelectedIndex() == 2) {
            ped = pd.listarPedidosPagados();
            jbCobrar.setEnabled(false);
        } else if (jcbPedidos.getSelectedIndex() == 3) {
            ped = pd.listarPedidosSinPagar();
            jbCobrar.setEnabled(true);
        } else if(jcbPedidos.getSelectedIndex()==0){
            jbCobrar.setEnabled(false);
        }
        cargarTablas(ped);
    }//GEN-LAST:event_jcbPedidosActionPerformed

    private void jbAnularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAnularActionPerformed
        if (jtPedidos.getSelectedRowCount() != 0) {
            int conf = JOptionPane.showConfirmDialog(this, "¿Desea anular pedido?", "Confirmar anulacion de pedido.", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (jtPedidos.isCellSelected(i, 0)) {
                        pd.anularPedido(Integer.parseInt(modelo.getValueAt(i, 0).toString()));
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un pedido de la tabla.", "Anulación de pedido.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbAnularActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            if (jtfIdPedido.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Debe ingresar un ID", "Campo vacío", JOptionPane.WARNING_MESSAGE);
            } else {
                int id = Integer.parseInt(jtfIdPedido.getText());
                Pedido p = pd.buscarPedido(id);
                if (p != null) {
                    int e;
                    if (p.isCobrada()) {
                        e = 1;
                    } else {
                        e = 0;
                    }
                    borrarFilas();
                    modelo.addRow(new Object[]{p.getIdPedido(), md.buscarMesaPorID(p.getIdMesa()).getNumero(), p.getIdMesero(), p.getFechaHora(), p.getImporte(), e});
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Solo puede ingresar números | " + e.getLocalizedMessage(), "Formato erroneo.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtfIdMesaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfIdMesaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (jcbListarPedidos.getSelectedIndex() == 1) {
                cargarPorMesa();
            } else if (jcbListarPedidos.getSelectedIndex() == 2) {
                cargarPorMesero();
            }
        }
    }//GEN-LAST:event_jtfIdMesaKeyPressed

    private void jtfFacturaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfFacturaKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                int idPedido=Integer.parseInt(jtfFactura.getText());
                cargarFactura(pd.listarFactura(idPedido));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error en el formato, ingrese números únicamente. - "+e,"Formato Erróneo",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtfFacturaKeyPressed

    private void jtfFacturaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfFacturaFocusGained
        if (jtfFactura.getText().equalsIgnoreCase("Ingrese el número de su pedido.")) {
            jtfFactura.setText("");
        }
    }//GEN-LAST:event_jtfFacturaFocusGained

    private void jbNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevoActionPerformed
        jDesktopPane1.repaint();
        VistaCrearPedido vcp = new VistaCrearPedido();
        vcp.setVisible(true);
        jDesktopPane1.add(vcp);
        jDesktopPane1.moveToFront(vcp);
        
    }//GEN-LAST:event_jbNuevoActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "¿Desea salir de la vista de pedidos?", "Salir", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCobrarActionPerformed
        if (jtPedidos.getSelectedRowCount() != 0) {
            int conf = JOptionPane.showConfirmDialog(this, "¿Desea cobrar el/los pedido/s?", "Confirmar cobro de pedido/s.", JOptionPane.YES_NO_OPTION);
            if (conf == JOptionPane.YES_OPTION) {
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    if (jtPedidos.isCellSelected(i, 0)) {
                        pd.cobrarPedido(Integer.parseInt(modelo.getValueAt(i, 0).toString()));
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un pedido de la tabla.", "Cobro de pedido.", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jbCobrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton jButton1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbAnular;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbCobrar;
    private javax.swing.JButton jbNuevo;
    private javax.swing.JComboBox<String> jcbListarPedidos;
    private javax.swing.JComboBox<String> jcbPedidos;
    private com.toedter.calendar.JDateChooser jdcFecha;
    private javax.swing.JLabel jlFactura;
    private com.toedter.components.JSpinField jsfHora1;
    private com.toedter.components.JSpinField jsfHora2;
    private com.toedter.components.JSpinField jsfMin1;
    private com.toedter.components.JSpinField jsfMin2;
    private javax.swing.JTable jtListarPedidos;
    private javax.swing.JTable jtPedidos;
    private javax.swing.JTextField jtfFactura;
    private javax.swing.JTextField jtfIdMesa;
    private javax.swing.JTextField jtfIdPedido;
    // End of variables declaration//GEN-END:variables

    private void ocultarFechaHora() {
        jLabel4.setVisible(false);
        jdcFecha.setVisible(false);
        jLabel6.setVisible(false);
        jsfHora1.setVisible(false);
        jsfMin1.setVisible(false);
        jsfHora2.setVisible(false);
        jsfMin2.setVisible(false);
        jLabel7.setVisible(false);
    }

    private void mostrarFechaHora() {
        jLabel4.setVisible(true);
        jdcFecha.setVisible(true);
        jLabel6.setVisible(true);
        jsfHora1.setVisible(true);
        jsfMin1.setVisible(true);
        jsfHora2.setVisible(true);
        jsfMin2.setVisible(true);
        jLabel3.setVisible(false);
        jtfIdMesa.setVisible(false);
        jLabel7.setVisible(true);
    }

    private void mostrarBotones() {
        if (jcbListarPedidos.getSelectedIndex() == 0) {
            ocultarTodo();
        }
        if (jcbListarPedidos.getSelectedIndex() == 1) {
            mostrarIdMesa();
            ocultarFechaHora();
        } else if (jcbListarPedidos.getSelectedIndex() == 2) {
            mostrarMesero();
            ocultarFechaHora();
        } else if (jcbListarPedidos.getSelectedIndex() == 3) {
            mostrarFechaHora();
        }
    }

    private void mostrarIdMesa() {
        jLabel3.setText("Id Mesa →");
        jLabel3.setVisible(true);
        jtfIdMesa.setVisible(true);
        jLabel7.setVisible(false);
    }

    private void mostrarMesero() {
        jLabel3.setText("Mesero →");
        jLabel3.setVisible(true);
        jtfIdMesa.setVisible(true);
        jLabel7.setVisible(false);
    }

    private void ocultarTodo() {
        ocultarFechaHora();
        jLabel3.setVisible(false);
        jtfIdMesa.setVisible(false);
    }

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("N° Mesa");
        modelo.addColumn("Mesero");
        modelo.addColumn("Fecha-Hora");
        modelo.addColumn("Importe");
        modelo.addColumn("Cobrado");
        jtPedidos.setModel(modelo);
    }

    private void armarCabecera2() {
        modelo2.addColumn("NOMBRE PRODUCTO");
        modelo2.addColumn("CANTIDAD");
        modelo2.addColumn("PRECIO UNITARIO");
        jtListarPedidos.setModel(modelo2);
    }

    private void borrarFilas() {
        int filas = jtPedidos.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    private void borrarFilas2() {
        int filas = jtListarPedidos.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            modelo2.removeRow(f);
        }
    }

    public void cargarTablas(ArrayList<Pedido> lista) {
        borrarFilas();
        for (Pedido pedido : lista) {
            int e;
            if (pedido.isCobrada()) {
                e = 1;
            } else {
                e = 0;
            }
            modelo.addRow(new Object[]{pedido.getIdPedido(), md.buscarMesaPorID(pedido.getIdMesa()).getNumero(), pedido.getIdMesero()+" - " +lg.buscarNombreID(pedido.getIdMesero()), pedido.getFechaHora(), pedido.getImporte(), e});
        }
    }

    public void cargarFactura(ArrayList<Factura> lista) {
        borrarFilas2();
        for (Factura fac : lista) {
            modelo2.addRow(new Object[]{fac.getNom(), fac.getCant(), fac.precio});
        }
    }

    private void cargarPorMesa() {
        try {
            ArrayList<Pedido> lista = new ArrayList<>();
            if (jtfIdMesa.getText().isEmpty()) {
                if (jcbPedidos.getSelectedIndex() == 2) {
                    lista = null;
                    lista = pd.listarPedidosPagados();
                    cargarTablas(lista);
                } else if (jcbPedidos.getSelectedIndex() == 3) {
                    lista = null;
                    lista = pd.listarPedidosSinPagar();
                    cargarTablas(lista);
                } else if (jcbPedidos.getSelectedIndex() == 1) {
                    lista = null;
                    lista = pd.listarPedidos();
                    cargarTablas(lista);
                }
            } else {
                int mesa = Integer.parseInt(jtfIdMesa.getText());
                if (jcbPedidos.getSelectedIndex() == 2) {
                    lista = null;
                    lista = pd.listarPedidosPagadosPorMesa(mesa);
                    cargarTablas(lista);
                } else if (jcbPedidos.getSelectedIndex() == 3) {
                    lista = null;
                    lista = pd.listarPedidosSinPagarPorMesa(mesa);
                    cargarTablas(lista);
                } else if (jcbPedidos.getSelectedIndex() == 1) {
                    lista = null;
                    lista = pd.listarPedidosPorMesa(mesa);
                    cargarTablas(lista);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error en el formato, solo se aceptan números. - " + e.getMessage() + ".", "Formato erróneo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarPorMesero() {
         try {
            ArrayList<Pedido> lista = new ArrayList<>();
            if (jtfIdMesa.getText().isEmpty()) {
                lista = pd.listarPedidos();
            } else {
                lista = pd.listarPedidoPorMesero(Integer.parseInt(jtfIdMesa.getText()));
            }
            cargarTablas(lista);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error | Ingrese el id del mesero. --- " + e.getLocalizedMessage(), "Formato erróneo", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarPorFechaHora() {
        try {
            ArrayList<Pedido> lista = new ArrayList<>();
            if (jdcFecha.getDate() == null) {
                lista = pd.listarPedidos();
                cargarTablas(lista);
            } else {
                int hi = jsfHora1.getValue(), mi = jsfMin1.getValue(), hf = jsfHora2.getValue(), mf = jsfMin2.getValue();
                LocalTime in = LocalTime.of(hi, mi), fin = LocalTime.of(hf, mf);
                LocalDate f = jdcFecha.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                System.out.println(f);
                LocalDateTime fhi = LocalDateTime.of(f, in);
                LocalDateTime fhf = LocalDateTime.of(f, fin);
                lista = pd.listarPedidosPorHorario(in, fin);
                cargarTablas(lista);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "error - " + e);
        }
    }
    
    class FondoPanel extends JPanel {
        private Image imagen;
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Imagenes/Fondo2.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}

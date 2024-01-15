package vistas;

import accesoADatos.*;
import entidades.*;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gon_k
 */
public class VistaMesa extends javax.swing.JInternalFrame {

    private DefaultTableModel modelo = new DefaultTableModel() {
        public boolean isCellEditable(int fila, int celda) {
            if (celda != 0) {
                return true;
            } else {
                return false;
            }
        }
    };

    FondoPanel fondo = new FondoPanel();
    private MesaData mesaData = new MesaData();

    public VistaMesa() {
        this.setContentPane(fondo);
        initComponents();
        armarCabecera();
        jbEliminar.setEnabled(false);
        cargarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel1 = new FondoPanel();
        jlTitulo = new javax.swing.JLabel();
        jrbDisp = new javax.swing.JRadioButton();
        jrbOcu = new javax.swing.JRadioButton();
        jrbTodas = new javax.swing.JRadioButton();
        jtfBuscar = new javax.swing.JTextField();
        jbBuscar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbModificar = new javax.swing.JButton();
        jbNueva = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtMesas = new javax.swing.JTable();

        setClosable(true);

        jlTitulo.setFont(new java.awt.Font("Corbel", 1, 24)); // NOI18N
        jlTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jlTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlTitulo.setText("Administrar Mesas");

        buttonGroup1.add(jrbDisp);
        jrbDisp.setForeground(new java.awt.Color(255, 255, 255));
        jrbDisp.setText("Disponibles");
        jrbDisp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbDispActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbOcu);
        jrbOcu.setForeground(new java.awt.Color(255, 255, 255));
        jrbOcu.setText("Ocupadas");
        jrbOcu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbOcuActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbTodas);
        jrbTodas.setForeground(new java.awt.Color(255, 255, 255));
        jrbTodas.setText("Todas");
        jrbTodas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbTodasActionPerformed(evt);
            }
        });

        jtfBuscar.setText("Inserte el número de mesa.");
        jtfBuscar.setToolTipText("");
        jtfBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfBuscarFocusLost(evt);
            }
        });
        jtfBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfBuscarActionPerformed(evt);
            }
        });

        jbBuscar.setText("Buscar");
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbEliminar.setText("Eliminar");
        jbEliminar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jbEliminarFocusGained(evt);
            }
        });
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbModificar.setText("Modificar");
        jbModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbModificarActionPerformed(evt);
            }
        });

        jbNueva.setText("Nueva");
        jbNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbNuevaActionPerformed(evt);
            }
        });

        jbSalir.setText("Salir");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jtMesas.setModel(new javax.swing.table.DefaultTableModel(
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
        jtMesas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtMesasFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(jtMesas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jbBuscar)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jlTitulo)
                                .addGap(115, 115, 115))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(jbModificar)
                                .addGap(18, 18, 18)
                                .addComponent(jbNueva)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                                .addComponent(jbSalir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbDisp)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbOcu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jrbTodas)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlTitulo)
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jrbDisp)
                    .addComponent(jrbOcu)
                    .addComponent(jrbTodas))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbBuscar))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbEliminar)
                    .addComponent(jbModificar)
                    .addComponent(jbNueva)
                    .addComponent(jbSalir))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jDesktopPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscarFocusGained
        jtfBuscar.setText("");
    }//GEN-LAST:event_jtfBuscarFocusGained

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "¿Desea salir de la vista de mesas?", "Salir", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            dispose();
        }
    }//GEN-LAST:event_jbSalirActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int filaS = jtMesas.getSelectedRow();
        int res = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la mesa seleccionada?", "Eliminar mesa", JOptionPane.YES_NO_OPTION);
        if (res == JOptionPane.YES_OPTION) {
            for (int i = 0; i < modelo.getRowCount(); i++) {
                if (jtMesas.isCellSelected(i, 0)) {
                    mesaData.eliminarMesa(Integer.parseInt(modelo.getValueAt(i, 1).toString()));
                }
            }
            cargarTabla();
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbModificarActionPerformed
        int res = JOptionPane.showConfirmDialog(this, "¿Desea modificar la mesa?", "Modificar mesa", JOptionPane.YES_NO_OPTION);
        try {
            if (res == JOptionPane.YES_OPTION) {
                for (int i = 0; i < modelo.getRowCount(); i++) {
                    Mesa mesaNueva = new Mesa(Integer.parseInt(modelo.getValueAt(i, 0).toString()), Integer.parseInt(modelo.getValueAt(i, 1).toString()), Boolean.parseBoolean(modelo.getValueAt(i, 4).toString()), Boolean.parseBoolean(modelo.getValueAt(i, 3).toString()), Integer.parseInt(modelo.getValueAt(i, 2).toString()));
                    mesaData.modificarMesa(mesaNueva);
                }
                cargarTabla();
                JOptionPane.showMessageDialog(this, "Modificado exitósamente.", "Modificación completa.", JOptionPane.PLAIN_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "La modificación se ha cancelado.", "Modificación cancelada.", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error. Formato incorrecto. | " + e.getLocalizedMessage(), "Formato erróneo.", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbModificarActionPerformed

    private void jrbTodasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbTodasActionPerformed
        borrarFilas();
        ArrayList<Mesa> lista = new ArrayList<>();
        lista = mesaData.listarMesas();
        for (Mesa mesa : lista) {
            modelo.addRow(new Object[]{mesa.getIdMesa(), mesa.getNumero(), mesa.getCapacidad(), mesa.isLibre(), mesa.isEstadoMesa()});
        }
    }//GEN-LAST:event_jrbTodasActionPerformed

    private void jrbOcuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbOcuActionPerformed
        borrarFilas();
        ArrayList<Mesa> lista = new ArrayList<>();
        lista = mesaData.listarMesasOcupadas();
        for (Mesa mesa : lista) {

            modelo.addRow(new Object[]{mesa.getIdMesa(), mesa.getNumero(), mesa.getCapacidad(), mesa.isLibre(), mesa.isEstadoMesa()});
        }
    }//GEN-LAST:event_jrbOcuActionPerformed

    private void jrbDispActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbDispActionPerformed
        borrarFilas();
        ArrayList<Mesa> lista = new ArrayList<>();
        lista = mesaData.listarMesasDisponibles();
        for (Mesa mesa : lista) {
            modelo.addRow(new Object[]{mesa.getIdMesa(), mesa.getNumero(), mesa.getCapacidad(), mesa.isLibre(), mesa.isEstadoMesa()});
        }
    }//GEN-LAST:event_jrbDispActionPerformed

    private void jbNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbNuevaActionPerformed
        jDesktopPane1.repaint();
        VistaCrearMesa vcm = new VistaCrearMesa();
        vcm.setVisible(true);
        jDesktopPane1.add(vcm);
        jDesktopPane1.moveToFront(vcm);
        cargarTabla();
    }//GEN-LAST:event_jbNuevaActionPerformed

    private void jtfBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfBuscarActionPerformed
    }//GEN-LAST:event_jtfBuscarActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        try {
            if (jtfBuscar.getText().equals("Ingrese el número de mesa.") || jtfBuscar.getText().isEmpty()) {
                cargarTabla();
                JOptionPane.showMessageDialog(this, "El campo no puede estar vacío.", "Campo vacío.", JOptionPane.WARNING_MESSAGE);
            } else {
                int num = Integer.parseInt(jtfBuscar.getText());
                Mesa mesa = mesaData.buscarMesa(num);
                if (mesa != null) {
                    borrarFilas();
                    modelo.addRow(new Object[]{mesa.getIdMesa(), mesa.getNumero(), mesa.getCapacidad(), mesa.isLibre(), mesa.isEstadoMesa()});
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error. Únicamente debe ingresar dígitos. | " + e.getLocalizedMessage(), "Formato erróneo.", JOptionPane.ERROR_MESSAGE);
            cargarTabla();
        }
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtfBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfBuscarFocusLost
        if (!jtfBuscar.getText().equals("Ingrese el número de mesa.") && jtfBuscar.getText().isEmpty()) {
            jtfBuscar.setText("Ingrese el número de mesa.");
        }
    }//GEN-LAST:event_jtfBuscarFocusLost

    private void jbEliminarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jbEliminarFocusGained
        jbEliminar.setEnabled(true);
    }//GEN-LAST:event_jbEliminarFocusGained

    private void jtMesasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtMesasFocusGained
        jbEliminar.setEnabled(true);
    }//GEN-LAST:event_jtMesasFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbModificar;
    private javax.swing.JButton jbNueva;
    private javax.swing.JButton jbSalir;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JRadioButton jrbDisp;
    private javax.swing.JRadioButton jrbOcu;
    private javax.swing.JRadioButton jrbTodas;
    private javax.swing.JTable jtMesas;
    private javax.swing.JTextField jtfBuscar;
    // End of variables declaration//GEN-END:variables

    private void armarCabecera() {
        modelo.addColumn("ID");
        modelo.addColumn("Número");
        modelo.addColumn("Capacidad");
        modelo.addColumn("Libre");
        modelo.addColumn("Estado");
        jtMesas.setModel(modelo);
    }

    private void borrarFilas() {
        int filas = jtMesas.getRowCount() - 1;
        for (int f = filas; f >= 0; f--) {
            modelo.removeRow(f);
        }
    }

    public void cargarTabla() {
        borrarFilas();
        ArrayList<Mesa> lista = new ArrayList<>();
        lista = mesaData.listarMesas();
        for (Mesa mesa : lista) {
            modelo.addRow(new Object[]{mesa.getIdMesa(), mesa.getNumero(), mesa.getCapacidad(), mesa.isLibre(), mesa.isEstadoMesa()});
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

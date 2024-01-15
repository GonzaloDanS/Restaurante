package vistas;

import java.awt.*;
import javax.swing.*;

public class Restaurante extends javax.swing.JFrame {

    FondoPanel fondo = new FondoPanel();

    public Restaurante() {
        this.setContentPane(fondo);
        initComponents();
        jbMesa.setIcon(setIcono("/Imagenes/Mesas.jpeg", jbMesa));
        jbMesa.setIcon(setIconoPresionado("/Imagenes/Mesas.jpeg", jbMesa, 10, 10));

        jbPedido.setIcon(setIcono("/Imagenes/Pedidos.jpeg", jbPedido));
        jbPedido.setIcon(setIconoPresionado("/Imagenes/Pedidos.jpeg", jbPedido, 10, 10));

        jbProducto.setIcon(setIcono("/Imagenes/Productos.jpeg", jbProducto));
        jbProducto.setIcon(setIconoPresionado("/Imagenes/Productos.jpeg", jbProducto, 10, 10));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jpRestaurante = new FondoPanel();
        jbMesa = new javax.swing.JButton();
        jbProducto = new javax.swing.JButton();
        jbPedido = new javax.swing.JButton();
        jbVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbMesa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbMesaActionPerformed(evt);
            }
        });

        jbProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbProductoActionPerformed(evt);
            }
        });

        jbPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbPedidoActionPerformed(evt);
            }
        });

        jbVolver.setText("Volver");
        jbVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpRestauranteLayout = new javax.swing.GroupLayout(jpRestaurante);
        jpRestaurante.setLayout(jpRestauranteLayout);
        jpRestauranteLayout.setHorizontalGroup(
            jpRestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpRestauranteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbVolver)
                .addGap(33, 33, 33))
            .addGroup(jpRestauranteLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 298, Short.MAX_VALUE)
                .addComponent(jbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(jpRestauranteLayout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(jbMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpRestauranteLayout.setVerticalGroup(
            jpRestauranteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRestauranteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addComponent(jbVolver)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpRestauranteLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jbMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addComponent(jbProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
        );

        jDesktopPane1.setLayer(jpRestaurante, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRestaurante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpRestaurante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbPedidoActionPerformed
        jDesktopPane1.repaint();
        VistaPedido vp = new VistaPedido();
        vp.setVisible(true);
        jDesktopPane1.add(vp);
        jDesktopPane1.moveToFront(vp);
    }//GEN-LAST:event_jbPedidoActionPerformed

    private void jbVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbVolverActionPerformed
        int volver = JOptionPane.showConfirmDialog(this, "¿Desea salir y volver a iniciar sesión?", "volver", JOptionPane.YES_NO_OPTION);
        if (volver == JOptionPane.YES_OPTION) {
            Login in = new Login();
            in.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jbVolverActionPerformed

    private void jbProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbProductoActionPerformed
        jDesktopPane1.repaint();
        VistaProducto vpro = new VistaProducto();
        vpro.setVisible(true);
        jDesktopPane1.add(vpro);
        jDesktopPane1.moveToFront(vpro);
    }//GEN-LAST:event_jbProductoActionPerformed

    private void jbMesaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbMesaActionPerformed
        jDesktopPane1.repaint();
        VistaMesa vm = new VistaMesa();
        vm.setVisible(true);
        jDesktopPane1.add(vm);
        jDesktopPane1.moveToFront(vm);
    }//GEN-LAST:event_jbMesaActionPerformed

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
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Restaurante.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Restaurante().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JButton jbMesa;
    private javax.swing.JButton jbPedido;
    private javax.swing.JButton jbProducto;
    private javax.swing.JButton jbVolver;
    private javax.swing.JPanel jpRestaurante;
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

    public Icon setIcono(String url, JButton boton) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        int ancho = boton.getWidth();
        int alto = boton.getHeight();
        ImageIcon icono = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return icono;
    }

    public Icon setIconoPresionado(String url, JButton boton, int an, int al) {
        ImageIcon icon = new ImageIcon(getClass().getResource(url));
        int ancho = boton.getWidth() - an;
        int alto = boton.getHeight() - al;
        ImageIcon ic = new ImageIcon(icon.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return ic;
    }

}

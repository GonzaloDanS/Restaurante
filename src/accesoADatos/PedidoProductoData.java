/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoADatos;

import entidades.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Equipo
 */
public class PedidoProductoData {

    private Connection con = null;
    private ProductoData pd = null;

    public PedidoProductoData() {
        con = Conexion.getConnection();
        pd = new ProductoData();
    }

    public void nuevoPedidoProd(PedidoProducto pedProd) {
        String sql = "INSERT INTO pedidoproducto VALUES (null, ?, ?, ?)";
        PreparedStatement ps;
        try {
            ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedProd.getIdPedido());
            ps.setInt(2, pedProd.getIdProducto());
            ps.setInt(3, pedProd.getCantidad());
            int mostrar = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedProd.setIdPedidoProducto(rs.getInt(1));
//                JOptionPane.showMessageDialog(null, "El producto se ha agregado a la orden.");
//                tengo que agregar un if para restar al stock la cantidad ingresada por el mesero.
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de productos. - " + e.getMessage() + ". ");
        }
    }

    public void modificarPedidoProducto(PedidoProducto pedProd) {
        try {
            String sql = "UPDATE pedidoproducto SET idPedido = ?, idProducto = ?, cantidad = ? WHERE idPedidoProducto=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, pedProd.getIdPedido());
            ps.setInt(2, pedProd.getIdProducto());
            ps.setInt(3, pedProd.getCantidad());
            int mostrar = ps.executeUpdate();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                pedProd.setIdPedidoProducto(rs.getInt("idPedidoProducto"));
                JOptionPane.showMessageDialog(null, "Se ha modificado la orden");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Pedido Producto. - " + e.getMessage());
        }
    }

    public double calcularSubtotal(PedidoProducto pedProd) {
        double sub = pedProd.getCantidad() * pd.buscarProducto(pedProd.getIdProducto()).getPrecio();
        return sub;
    }

    public void eliminarPedidoProducto(int idProducto, int idPedido) {
        try {
            String sql = "DELETE FROM `pedidoproducto` WHERE idProducto = ? AND idPedido = ?";
            if (buscarPedidoProducto(idProducto) != null) {
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idProducto);
                ps.setInt(2, idPedido);
                int filas = ps.executeUpdate();
                if (filas == 1) {
                    JOptionPane.showMessageDialog(null, "Se canceló el producto " + idProducto + " de la orden.");
                }else{
                    JOptionPane.showMessageDialog(null, "No se encontró ese pedido. Intente nuevamente.");
                }
                ps.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Pedido Producto. - " + e.getMessage());
        }
    }
    
    public void eliminarPedidoProducto(int idPedido) {
        try {
            String sql = "DELETE FROM `pedidoproducto` WHERE idPedido = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, idPedido);
                int filas = ps.executeUpdate();
                ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Pedido Producto. - " + e.getMessage());
        }
    }

    public PedidoProducto buscarPedidoProducto(int id) {
        PedidoProducto p = null;
        try {
            String sql = "SELECT * FROM pedidoProducto WHERE idPedidoProd = ? ";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new PedidoProducto();
                p.setIdPedido(rs.getInt(1));
                p.setIdPedido(rs.getInt(2));
                p.setIdProducto(rs.getInt(3));
                p.setCantidad(rs.getInt(4));
            } else {
                JOptionPane.showMessageDialog(null, "El id indicado no pertenece a ningún pedido registrado.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Pedido Producto. - " + e.getMessage());
        }
        return p;
    }
    
    public ArrayList<PedidoProducto> listarPedidoProducto(){
        ArrayList<PedidoProducto> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedidoProducto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PedidoProducto pp = new PedidoProducto();
                pp.setIdPedidoProducto(rs.getInt(1));
                pp.setIdPedido(rs.getInt(2));
                pp.setIdProducto(rs.getInt(3));
                pp.setCantidad(rs.getInt(4));
                listado.add(pp);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Pedido Producto. - " + e.getMessage());
        }
        return listado;
    }
    
    public ArrayList<PedidoProducto> listarPedidoProducto(int idPedido){
        ArrayList<PedidoProducto> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedidoProducto WHERE idPedido = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PedidoProducto pp = new PedidoProducto();
                pp.setIdPedidoProducto(rs.getInt(1));
                pp.setIdPedido(rs.getInt(2));
                pp.setIdProducto(rs.getInt(3));
                pp.setCantidad(rs.getInt(4));
                listado.add(pp);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Pedido Producto. - " + e.getMessage());
        }
        return listado;
    }
    
    public ArrayList<PedidoProducto> listarPedidoProductoPorMesa(int idMesa){
        ArrayList<PedidoProducto> listado = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedidoProducto WHERE idPedido IN (SELECT idPedido FROM pedido WHERE idMesa = ?) ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                PedidoProducto pp = new PedidoProducto();
                pp.setIdPedidoProducto(rs.getInt(1));
                pp.setIdPedido(rs.getInt(2));
                pp.setIdProducto(rs.getInt(3));
                pp.setCantidad(rs.getInt(4));
                listado.add(pp);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de Pedido Producto. - " + e.getMessage());
        }
        return listado;
    }
}

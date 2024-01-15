package accesoADatos;

import entidades.*;
import java.sql.*;
import java.time.*;
import java.util.*;
import javax.swing.*;

public class PedidoData {

    Connection con = null;
    PedidoProductoData ppd = null;
    ProductoData pd = null;
    MesaData md = null;
    

    public PedidoData() {
        con = Conexion.getConnection();
        ppd = new PedidoProductoData();
        pd = new ProductoData();
        md = new MesaData();
    }

    public int nuevoPedido(Pedido pedido) {
        int idPedido=-1;
        try {
            String sql = "INSERT INTO pedido (idPedido, idMesa, idMesero, fechaHora, importe, cobrada) "
                    + "VALUES (null,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getIdMesa());
            ps.setInt(2, pedido.getIdMesero());
            ps.setTimestamp(3, Timestamp.valueOf(pedido.getFechaHora()));
            ps.setDouble(4, pedido.getImporte());
            ps.setBoolean(5, pedido.isCobrada());
            int agregar = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                pedido.setIdPedido(rs.getInt(1));
                idPedido=pedido.getIdPedido();
                JOptionPane.showMessageDialog(null, "Pedido añadido con éxito.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }
        return idPedido;
    }

    public void agregarProducto(int idPedido, int idProd, int cantidad) {
        PedidoProducto npp = new PedidoProducto();
        npp.setIdPedido(idPedido);
        npp.setIdProducto(idProd);
        npp.setCantidad(cantidad);
        ppd.nuevoPedidoProd(npp);
    }

    public void anularPedido(int idPedido) {
        try {
            String sql = "DELETE FROM pedido WHERE idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            int mostrar = ps.executeUpdate();
            if (mostrar == 1) {
                JOptionPane.showMessageDialog(null, "Se ha eliminado el pedido correctamente.");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla 'pedido'. - " + e.getLocalizedMessage());
        }
    }

    public void quitarProducto(int idPedido, int idProd, int cantidad) {
//        PedidoProducto npp = new PedidoProducto();
//        npp.setIdPedido(idPedido);
//        npp.setIdProducto(idProd);
//        npp.setCantidad(cantidad);
        ppd.eliminarPedidoProducto(idProd, idPedido);
    }

    public ArrayList<Pedido> listarPedidos() {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de pedidos" + ex.getMessage());
        }
        return pedido;
    }

    public Pedido buscarPedido(int id) {
        Pedido p = null;
        try {
            String sql = "SELECT * FROM pedido WHERE idPedido =?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Pedido();
                p.setIdPedido(id);
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
            } else {
                JOptionPane.showMessageDialog(null, "No hay pedido registrado con el ID proporcionado");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }
        return p;
    }

    public ArrayList<Pedido> listarPedidosPorHorario(LocalTime inicio, LocalTime fin) {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM `pedido` WHERE HOUR(fechaHora)>=? AND MINUTE(fechaHora)>=? "
                    + "AND HOUR(fechaHora)<=? AND MINUTE(fechaHora)<=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, inicio.getHour());
            ps.setInt(2, inicio.getMinute());
            ps.setInt(3, fin.getHour());
            ps.setInt(4, fin.getMinute());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }
        return pedido;
    }

    public ArrayList<Pedido> listarPedidosPagados() {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido WHERE cobrada=1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }
        return pedido;
    }

    public ArrayList<Pedido> listarPedidosSinPagar() {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido WHERE cobrada=0";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }
        return pedido;
    }

    public ArrayList<Pedido> listarPedidosPorMesa(int idMesa) {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido WHERE idMesa=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }
        return pedido;
    }

    public ArrayList<Pedido> listarPedidosPagadosPorMesa(int idMesa) {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido WHERE cobrada=1 AND idMesa=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }
        return pedido;
    }

    public ArrayList<Pedido> listarPedidosSinPagarPorMesa(int idMesa) {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido WHERE cobrada=0 AND idMesa=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }
        return pedido;
    }

    public ArrayList<Pedido> listarPedidoPorMesero(int idMesero) {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido WHERE idMesero=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesero);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }
        return pedido;
    }

    public ArrayList<Pedido> listarIngresos(LocalDate fecha) {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT importe FROM pedido WHERE DATE(fechaHora)=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDate(1, java.sql.Date.valueOf(fecha));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setImporte(rs.getDouble("importe"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }

        return pedido;
    }

    public ArrayList<Pedido> listarPedidoPagoPorMesero(int idMesero) {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido WHERE idMesero=? AND cobrada=1";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesero);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }

        return pedido;
    }

    public ArrayList<Pedido> listarPedido(int idMesa, LocalDate fecha, LocalTime inicio, LocalTime fin) {
        ArrayList<Pedido> pedido = new ArrayList<>();
        try {
            String sql = "SELECT * FROM pedido WHERE idMesa=? AND DATE(fechaHora)=? AND "
                    + "HOUR(fechaHora)>=? AND MINUTE(fechaHora)>=? AND HOUR(fechaHora)<=? "
                    + "AND MINUTE(fechaHora)<=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ps.setDate(2, java.sql.Date.valueOf(fecha));
            ps.setInt(3, inicio.getHour());
            ps.setInt(4, inicio.getMinute());
            ps.setInt(5, fin.getHour());
            ps.setInt(6, fin.getMinute());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pedido p = new Pedido();
                p.setIdPedido(rs.getInt("idPedido"));
                p.setIdMesa(rs.getInt("idMesa"));
                p.setIdMesero(rs.getInt("idMesero"));
                p.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime());
                p.setImporte(rs.getDouble("importe"));
                p.setCobrada(rs.getBoolean("cobrada"));
                pedido.add(p);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + ex.getMessage());
        }

        return pedido;
    }

    public ArrayList<Factura> listarFactura(int idPedido) {
        ArrayList<Factura> lista = new ArrayList<>();
        try {
            String sql = "SELECT nombreProducto , cantidad , precio FROM pedidoproducto, producto WHERE pedidoproducto.idProducto = producto.idProducto AND pedidoproducto.idPedido IN (SELECT idPedido FROM pedidoproducto WHERE idPedido = ?); ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            ResultSet rs = ps.executeQuery();
//            lista = "NOMBRE PRODUCTO\t\tCANT.\tPRECIO UNIT.\n";
            while (rs.next()) {
                Factura factura = new Factura();
                factura.setNom(rs.getString(1));
                factura.setCant(rs.getInt(2));
                factura.setPrecio(rs.getDouble(3));
                lista.add(factura);
//                lista += rs.getString(1) + "\t" + rs.getString(2) + "\t$" + rs.getString(3) + "\n";
            }
//            lista += "\nIMPORTE FINAL \t\t $"+calcularImp(idPedido);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error. No se pudo acceder a la tabla de pedidos. " + e.getLocalizedMessage());
        }
        return lista;
    }

    public void calcularImporte(int idPedido) {
        try {
            String sql = "UPDATE pedido SET importe = ? WHERE idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(2, idPedido);
            double imp = 0;
            for (PedidoProducto pedidoProducto : ppd.listarPedidoProducto(idPedido)) {
                imp += ppd.calcularSubtotal(pedidoProducto);
            }
            ps.setDouble(1, imp);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido - " + e.getMessage());
        }
    }

    public double calcularImp(int idPedido) {
        double imp = 0;
        for (PedidoProducto pedidoProducto : ppd.listarPedidoProducto(idPedido)) {
            imp += ppd.calcularSubtotal(pedidoProducto);
        }
        return imp;
    }

    public void cobrarPedido(int idPedido) {
        try {
            String sql = "UPDATE pedido SET cobrada = 1 WHERE idPedido = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idPedido);
            int filas = ps.executeUpdate();
            if (filas == 1) {
//                JOptionPane.showMessageDialog(null, "Pedido cobrado.");
                for (PedidoProducto pedidoProducto : ppd.listarPedidoProducto(idPedido)) {
                    Producto p = pd.buscarProducto(pedidoProducto.getIdProducto());
                    p.setStock(p.getStock() - pedidoProducto.getCantidad());
                    pd.modificarProducto(p);
                }
//                md.cobrarMesa(this.buscarPedido(idPedido).getIdMesa());
            } else {
                JOptionPane.showMessageDialog(null, "El pedido no existe o ya ha sido cobrado.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla pedido" + e.getMessage());
        }

    }
}

package accesoADatos;

import java.sql.*;
import entidades.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ProductoData {
    Connection con = null;
    
    public ProductoData(){
        con = Conexion.getConnection();
    }
    
    public void nuevoProducto(Producto producto){
        try {
            String sql = "INSERT INTO producto( idProducto , nombreProducto , precio , stock , estado ) VALUES (null,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNom());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setBoolean(4, producto.isEstado());
            int mostrar = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                producto.setIdProd(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Producto añadido con éxito.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de productos. - "+e.getMessage()+". ");
        }
    }
    
    public void modificarProducto(Producto producto){
        try {
            String sql = "UPDATE producto SET nombreProducto = ? , precio = ? , stock = ? , estado = ? WHERE idProducto = ?";
            PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNom());
            ps.setDouble(2, producto.getPrecio());
            ps.setInt(3, producto.getStock());
            ps.setBoolean(4, producto.isEstado());
            ps.setInt(5, producto.getIdProd());
            int mostrar = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (mostrar == 1) {
                System.out.println("Éxito.");
//                producto.setIdProd(rs.getInt("idProducto"));
//                JOptionPane.showMessageDialog(null, "Producto modificado con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Código inválido. Intente nuevamente o cree un nuevo producto.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de productos. - "+e.getMessage()+". ");
        }
    }
    
    public void eliminarProducto(int id){
        try {
            String sql = "UPDATE producto SET estado = 0 WHERE idProducto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int filas = ps.executeUpdate();
            if (filas ==1) {
                JOptionPane.showMessageDialog(null, "Se eliminó el producto correctamente.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de productos. - "+e.getMessage());
        }
    }
    
    public Producto buscarProducto(int id){
        Producto p = null;
        try {
            String sql = "SELECT * FROM producto WHERE idProducto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                p = new Producto();
                p.setIdProd(rs.getInt("idProducto"));
                p.setNom(rs.getString("nombreProducto"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setEstado(rs.getBoolean("estado"));
            } else {
                JOptionPane.showMessageDialog(null, "El id indicado no pertenece a ningún producto registrado.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de productos. - "+e.getMessage()+". ");
        }
        return p;
    }
    
    public ArrayList<Producto> listarProductos(){
        ArrayList<Producto> carta = new ArrayList();
        try {
            String sql = "SELECT * FROM producto WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setIdProd(rs.getInt("idProducto"));
                p.setNom(rs.getString("nombreProducto"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setEstado(rs.getBoolean("estado"));
                carta.add(p);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de productos. - "+e.getMessage());
        }
        return carta;
    }
    
    public ArrayList<Producto> listarProductosTODO(){
        ArrayList<Producto> carta = new ArrayList();
        try {
            String sql = "SELECT * FROM producto";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Producto p = new Producto();
                p.setIdProd(rs.getInt("idProducto"));
                p.setNom(rs.getString("nombreProducto"));
                p.setPrecio(rs.getDouble("precio"));
                p.setStock(rs.getInt("stock"));
                p.setEstado(rs.getBoolean("estado"));
                carta.add(p);
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla de productos. - "+e.getMessage());
        }
        return carta;
    }
}

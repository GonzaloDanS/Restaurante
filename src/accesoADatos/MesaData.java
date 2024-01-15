package accesoADatos;

import entidades.Mesa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.mariadb.jdbc.Statement;

public class MesaData {

    Connection con = null;

    public MesaData() {
        con = Conexion.getConnection();

    }

    public void nuevaMesa(Mesa mesa) {
        String sql = "INSERT INTO mesa VALUES (null,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, mesa.getNumero());
            ps.setBoolean(2, mesa.isEstadoMesa());
            ps.setBoolean(3, mesa.isLibre());
            ps.setInt(4, mesa.getCapacidad());
            int mostrar = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                mesa.setIdMesa(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Mesa añadida con éxito");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa" + ex.getMessage());
        }

    }

    public void modificarMesa(Mesa mesa) {
        try {
            String sql = "UPDATE mesa SET numero = ? , estadoMesa = ? , libre = ? , capacidad = ?  WHERE idMesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(5, mesa.getIdMesa());
            ps.setInt(1, mesa.getNumero());
            ps.setBoolean(2, mesa.isEstadoMesa());
            ps.setBoolean(3, mesa.isLibre());
            ps.setInt(4, mesa.getCapacidad());
            int mostrar = ps.executeUpdate();
            if (mostrar == 1) {
//                mesa.setIdMesa(rs.getInt("idMesa"));
//                JOptionPane.showMessageDialog(null, "La mesa fue modificada con éxito.");
            } else {
                JOptionPane.showMessageDialog(null, "Código invalido. Intente nuevamente o cree una nueva mesa.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa " + ex.getMessage());
        }
    }

    public void eliminarMesa(int numero) {
        try {
            String sql = "DELETE FROM mesa WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            int filas = ps.executeUpdate();
            if (filas == 1) {
                JOptionPane.showMessageDialog(null, "La mesa se eliminó correctamente.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa. - " + e.getMessage());
        }
    }

    public Mesa buscarMesaPorID(int idMesa) {
        Mesa m = null;
        try {
            String sql = "SELECT * FROM mesa WHERE idMesa = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m = new Mesa();
                m.setIdMesa(rs.getInt("idMesa"));
                m.setNumero(rs.getInt("numero"));
                m.setEstadoMesa(rs.getBoolean("estadoMesa"));
                m.setLibre(rs.getBoolean("libre"));
                m.setCapacidad(rs.getInt("capacidad"));
            } else {
                JOptionPane.showMessageDialog(null, "El id indicado no pertenece a ninguna mesa registrada.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa. - " + e.getMessage() + ". ");
        }
        return m;
    }
    
    public Mesa buscarMesa(int numero) {
        Mesa m = null;
        try {
            String sql = "SELECT * FROM mesa WHERE numero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                m = new Mesa();
                m.setIdMesa(rs.getInt("idMesa"));
                m.setNumero(rs.getInt("numero"));
                m.setEstadoMesa(rs.getBoolean("estadoMesa"));
                m.setLibre(rs.getBoolean("libre"));
                m.setCapacidad(rs.getInt("capacidad"));
            } else {
                JOptionPane.showMessageDialog(null, "El id indicado no pertenece a ninguna mesa registrada.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Mesa. - " + e.getMessage() + ". ");
        }
        return m;
    }

    public ArrayList<Mesa> listarMesas() {
        ArrayList<Mesa> todas = new ArrayList();

        try {
            String sql = "SELECT * FROM mesa";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Mesa m = new Mesa();
                m.setIdMesa(rs.getInt("idMesa"));
                m.setNumero(rs.getInt("numero"));
                m.setEstadoMesa(rs.getBoolean("estadoMesa"));
                m.setLibre(rs.getBoolean("libre"));
                m.setCapacidad(rs.getInt("capacidad"));
                todas.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa. -" + ex.getMessage());

        }
        return todas;
    }

    public ArrayList<Mesa> listarMesasDisponibles() {
        ArrayList<Mesa> todas = new ArrayList();

        try {
            String sql = "SELECT * FROM mesa WHERE libre = 1";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa m = new Mesa();
                m.setIdMesa(rs.getInt("idMesa"));
                m.setNumero(rs.getInt("numero"));
                m.setEstadoMesa(rs.getBoolean("estadoMesa"));
                m.setLibre(rs.getBoolean("libre"));
                m.setCapacidad(rs.getInt("capacidad"));
                todas.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa. -" + ex.getMessage());
        }
        return todas;
    }

    public ArrayList<Mesa> listarMesasOcupadas() {
        ArrayList<Mesa> todas = new ArrayList();

        try {
            String sql = "SELECT * FROM mesa WHERE libre = 0";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa m = new Mesa();
                m.setIdMesa(rs.getInt("idMesa"));
                m.setNumero(rs.getInt("numero"));
                m.setEstadoMesa(rs.getBoolean("estadoMesa"));
                m.setLibre(rs.getBoolean("libre"));
                m.setCapacidad(rs.getInt("capacidad"));
                todas.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa. -" + ex.getMessage());
        }
        return todas;
    }

    public ArrayList<Mesa> listarMesasAtendidas() {
        ArrayList<Mesa> todas = new ArrayList();
        try {
            String sql = "SELECT * FROM mesa WHERE estadoMesa = 1 AND libre = 0";
            PreparedStatement ps;
            ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Mesa m = new Mesa();
                m.setIdMesa(rs.getInt("idMesa"));
                m.setNumero(rs.getInt("numero"));
                m.setEstadoMesa(rs.getBoolean("estadoMesa"));
                m.setLibre(rs.getBoolean("libre"));
                m.setCapacidad(rs.getInt("capacidad"));
                todas.add(m);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa. -" + ex.getMessage());
        }
        return todas;
    }

    public void cobrarMesa(int idMesa) {
        try {
            String sql = "UPDATE mesa SET estadoMesa = 0 , libre = 1 WHERE idMesa = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesa);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Mesa cobrada.");
            }
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla mesa. -" + e.getMessage());
        }
    }

}

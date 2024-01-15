package accesoADatos;

import entidades.Mesero;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class LogIn {

    private Connection con;

    public LogIn() {
        con = Conexion.getConnection();
    }

    public void guardarUsuario(String user, String nom, String pass) {
        try {
            String sql = "INSERT INTO mesero VALUES (?,?,?,1)";
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user);
            ps.setString(2, sql);
            ps.setString(3, pass);
            int mostrar = ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (mostrar == 1) {
                System.out.println("Usuario guardado exitosamente.");
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla meseros. | " + ex.getLocalizedMessage(), "Error de acceso", JOptionPane.ERROR_MESSAGE);
        }
    }

    public int acceso(String user, String pass) {
        int log = 0;
        try {
            String usuarioC = null, contraseñaC = null;
            String sql = "SELECT dni, contrasenia FROM login WHERE dni = ? AND contrasenia = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
//            do {
            if (rs.next()) {
                usuarioC = rs.getString(1);
                contraseñaC = rs.getString(2);
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña o usuario erróneos.", "Información errónea.", JOptionPane.WARNING_MESSAGE);
            }
            if (user.equals(usuarioC) && pass.equals(contraseñaC)) {
                JOptionPane.showMessageDialog(null, "Ingreso correcto. Bienvenido " + buscarNombre(Integer.parseInt(user)) + ".", "Datos correctos.", JOptionPane.PLAIN_MESSAGE);
                log = 1;
//                    break;
            }
            /*else if (user.equals(usuarioC) && !pass.equals(contraseñaC)) {
                    JOptionPane.showMessageDialog(null, "Contraseña errónea.", "Datos incorrectos.", JOptionPane.WARNING_MESSAGE);
                } else if (pass.equals(contraseñaC) && !user.equals(usuarioC)) {
                    JOptionPane.showMessageDialog(null, "Usuario erróneo.", "Datos incorrectos.", JOptionPane.WARNING_MESSAGE);
                }*/
//            } while (rs.next());
        } catch (SQLException e) {
            JOptionPane.showConfirmDialog(null, "Error al acceder a la base de datos. | " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showConfirmDialog(null, "Error, el usuario debe ser un DNI. | " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return log;
    }

    public String buscarNombreID(int idMesero) {
        String nom = null;
        try {
            String sql = "SELECT nombre FROM mesero WHERE idMesero = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMesero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nom = rs.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error al acceder a la base de datos. | " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return nom;
    }

    public String buscarNombre(int dni) {
        String nom = null;
        try {
            String sql = "SELECT nombre FROM mesero WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, dni);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                nom = rs.getString(1);
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "Error al acceder a la base de datos. | " + e.getLocalizedMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return nom;
    }

    public ArrayList<Mesero> listarMeseros() {
        ArrayList<Mesero> lista = new ArrayList<>();
        try {
            String sql = "SELECT idMesero, dni, nombre FROM mesero WHERE estado = 1";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(new Mesero(rs.getInt("idMesero"), rs.getInt("dni"), rs.getString("nombre")));
            }
        } catch (Exception e) {
        }

        return lista;
    }
}

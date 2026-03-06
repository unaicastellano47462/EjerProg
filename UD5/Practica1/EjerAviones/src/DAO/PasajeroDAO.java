package DAO;

import Modelo.Pasajero;
import Utilidades.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasajeroDAO {

    public boolean insertar(Pasajero pasajero) {
        String sql = "INSERT INTO pasajeros (DNI, nombre, telefono, cod_vuelo) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pasajero.getDni());
            ps.setString(2, pasajero.getNombre());
            ps.setString(3, pasajero.getTelefono());
            ps.setString(4, pasajero.getCod_vuelo());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.out.println("Error al insertar pasajero: " + e.getMessage());
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public int borrar(String dni) throws Exception {
        String sql = "DELETE FROM pasajeros WHERE DNI = ?";
        int n = 0;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dni);
            n = ps.executeUpdate();

            if (n != 1) {
                System.out.println("No se encontró ningún pasajero con ese DNI.");
            } else {
                System.out.println("Pasajero borrado correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el pasajero: " + e.getMessage());
            throw e;
        } finally {
            DBConnection.closeConnection();
        }
        return n;
    }

    public Pasajero buscarPorDni(String dni) {
        String sql = "SELECT * FROM pasajeros WHERE DNI = ?";
        Pasajero pasajeroEncontrado = null;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                pasajeroEncontrado = new Pasajero(
                        rs.getString("DNI"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("cod_vuelo")
                );
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el pasajero: " + e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
        return pasajeroEncontrado;
    }

    public List<Pasajero> buscarPorVuelo(String cod_vuelo) {
        String sql = "SELECT * FROM pasajeros WHERE cod_vuelo = ?";
        List<Pasajero> lista = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cod_vuelo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Pasajero(
                        rs.getString("DNI"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("cod_vuelo")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error al buscar pasajeros del vuelo: " + e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
        return lista;
    }

    public boolean modificar(Pasajero pasajero) {
        String sql = "UPDATE pasajeros SET nombre = ?, telefono = ?, cod_vuelo = ? WHERE DNI = ?";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, pasajero.getNombre());
            ps.setString(2, pasajero.getTelefono());
            ps.setString(3, pasajero.getCod_vuelo());
            ps.setString(4, pasajero.getDni());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.out.println("Error al modificar el pasajero: " + e.getMessage());
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public List<Pasajero> listarTodos() {
        List<Pasajero> lista = new ArrayList<>();
        String sql = "SELECT * FROM pasajeros";

        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(new Pasajero(
                        rs.getString("DNI"),
                        rs.getString("nombre"),
                        rs.getString("telefono"),
                        rs.getString("cod_vuelo")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error al listar pasajeros: " + e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
        return lista;
    }
}
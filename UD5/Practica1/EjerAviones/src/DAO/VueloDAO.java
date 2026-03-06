package DAO;

import Modelo.Vuelo;
import Utilidades.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {

    public boolean insertar(Vuelo vuelo) {
        String sql = "INSERT INTO vuelos (cod_vuelo, fecha_salida, destino, procedencia) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, vuelo.getCod_vuelo());
            ps.setDate(2, new java.sql.Date(vuelo.getFecha_salida().getTime()));
            ps.setString(3, vuelo.getDestino());
            ps.setString(4, vuelo.getProcedencia());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.out.println("Error al insertar el vuelo: " + e.getMessage());
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public int borrar(String cod_vuelo) throws Exception {
        String sql = "DELETE FROM vuelos WHERE cod_vuelo = ?";
        int n = 0;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cod_vuelo);
            n = ps.executeUpdate();

            if (n != 1) {
                System.out.println("No se encontró ningún vuelo con el código proporcionado.");
            } else {
                System.out.println("Vuelo borrado correctamente en la base de datos.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el vuelo: " + e.getMessage());
            throw e;
        } finally {
            DBConnection.closeConnection();
        }
        return n;
    }

    public Vuelo buscarPorCodigo(String cod_vuelo) {
        String sql = "SELECT * FROM vuelos WHERE cod_vuelo = ?";
        Vuelo vueloEncontrado = null;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cod_vuelo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                vueloEncontrado = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el vuelo: " + e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
        return vueloEncontrado;
    }

    public Vuelo buscarPorDestino(String destino) {
        String sql = "SELECT * FROM vuelos WHERE destino = ?";
        Vuelo vueloEncontrado = null;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                vueloEncontrado = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el vuelo por destino: " + e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
        return vueloEncontrado;
    }

    public Vuelo buscarPorProcedencia(String procedencia) {
        String sql = "SELECT * FROM vuelos WHERE procedencia = ?";
        Vuelo vueloEncontrado = null;
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, procedencia);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                vueloEncontrado = new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
            }
        } catch (Exception e) {
            System.out.println("Error al buscar el vuelo por procedencia: " + e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
        return vueloEncontrado;
    }

    public ArrayList<Vuelo> listarPorFecha() {
        String sql = "SELECT * FROM vuelos ORDER BY fecha_salida ASC";
        ArrayList<Vuelo> vuelos = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                vuelos.add(new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error al listar los vuelos por fecha: " + e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
        return vuelos;
    }

    public boolean modificar(Vuelo vuelo) {
        String sql = "UPDATE vuelos SET fecha_salida = ?, destino = ?, procedencia = ? WHERE cod_vuelo = ?";
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1, new java.sql.Date(vuelo.getFecha_salida().getTime()));
            ps.setString(2, vuelo.getDestino());
            ps.setString(3, vuelo.getProcedencia());
            ps.setString(4, vuelo.getCod_vuelo());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;

        } catch (Exception e) {
            System.out.println("Error al modificar el vuelo: " + e.getMessage());
            return false;
        } finally {
            DBConnection.closeConnection();
        }
    }

    public List<Vuelo> listarTodos() {
        List<Vuelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM vuelos";

        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                lista.add(new Vuelo(
                        rs.getString("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                ));
            }
        } catch (Exception e) {
            System.out.println("Error al listar los vuelos: " + e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
        return lista;
    }

    public String obtenerUltimoCodigo() {
        String sql = "SELECT MAX(cod_vuelo) AS ultimo FROM vuelos WHERE cod_vuelo LIKE 'AEA1-%'";
        String ultimoCodigo = null;
        try {
            Connection conn = DBConnection.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                ultimoCodigo = rs.getString("ultimo");
            }
        } catch (Exception e) {
            System.out.println("Error al obtener el último código: " + e.getMessage());
        } finally {
            DBConnection.closeConnection();
        }
        return ultimoCodigo;
    }
}
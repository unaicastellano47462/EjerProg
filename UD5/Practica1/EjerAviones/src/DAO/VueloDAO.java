package DAO;


import Modelo.*;
import Utilidades.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VueloDAO {

    public void insertar(Vuelo vuelo){
        String sql = "INSERT INTO vuelos (fecha_salida, destino, procedencia) VALUES (?, ?, ?)";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1, (Date) vuelo.getFecha_salida());
            ps.setString(2, vuelo.getDestino());
            ps.setString(3, vuelo.getProcedencia());
            ps.executeUpdate();

            System.out.println("Registro insertado exitosamente");
            DBConnection.closeConnection();
        } catch (Exception e)
        {
            System.out.println("Error al insertar el vuelo: " + e.getMessage());
        }
    }

    public int borrar(int cod_vuelo) throws Exception {
        String sql = "DELETE FROM vuelos WHERE cod_vuelo = ?";

        int n=0;
        try {

            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, cod_vuelo);
            n = ps.executeUpdate();

            if (n != 1) {
                System.out.println("Error al borrar el vuelo");
                throw new Exception("No se encontró ningún vuelo con el código proporcionado.");
            }
            else
            {
                System.out.println("Vuelo borrado correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el vuelo: " + e.getMessage());
        }
        finally {
            DBConnection.closeConnection();
            return n;
        }
    }

    public Vuelo buscarPorCodigo(int cod_vuelo) {
        String sql = "SELECT * FROM vuelos WHERE cod_vuelo = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, cod_vuelo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Vuelo(
                        rs.getInt("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
            } DBConnection.closeConnection();
        } catch (Exception e)
        {
            System.out.println("Error al buscar el vuelo: " + e.getMessage());
        }
        return null;
    }

    public Vuelo buscarPorDestino(String destino) {
        String sql = "SELECT * FROM vuelos WHERE destino = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, destino);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Vuelo(
                        rs.getInt("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
            } DBConnection.closeConnection();
        } catch (Exception e)
        {
            System.out.println("Error al buscar el vuelo por destino: " + e.getMessage());
        }
        return null;
    }

    public Vuelo buscarPorProcedencia(String procedencia) {
        String sql = "SELECT * FROM vuelos WHERE procedencia = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, procedencia);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Vuelo(
                        rs.getInt("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                );
            } DBConnection.closeConnection();
        } catch (Exception e)
        {
            System.out.println("Error al buscar el vuelo por procedencia: " + e.getMessage());
        }
        return null;
    }

    public ArrayList<Vuelo> buscarPorFecha(Date fecha_salida) {
        String sql = "SELECT * FROM vuelos WHERE fecha_salida = ?";
        
        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1, fecha_salida);
            ResultSet rs = ps.executeQuery();

            ArrayList<Vuelo> vuelos = new ArrayList<>();

            while (rs.next()) {
                vuelos.add(new Vuelo(
                        rs.getInt("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                ));
            }
            DBConnection.closeConnection();
            return vuelos;
        }
        catch (Exception e)
        {
            System.out.println("Error al buscar el vuelo por fecha: " + e.getMessage());
        }
        return null;
    }

    public void modificar(Vuelo vuelo) {
        String sql = "UPDATE vuelos SET fecha_salida = ?, destino = ?, procedencia = ? WHERE cod_vuelo = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDate(1, (Date) vuelo.getFecha_salida());
            ps.setString(2, vuelo.getDestino());
            ps.setString(3, vuelo.getProcedencia());
            ps.setInt(4, vuelo.getCod_vuelo());
            ps.executeUpdate();

            System.out.println("Registro modificado exitosamente");
            DBConnection.closeConnection();

        } catch (Exception e)
        {
            System.out.println("Error al modificar el vuelo: " + e.getMessage());
        }
    }

    public List<Vuelo> listarTodos() {
        List<Vuelo> lista = new ArrayList<>();
        String sql = "SELECT * FROM vuelos";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Vuelo(
                        rs.getInt("cod_vuelo"),
                        rs.getDate("fecha_salida"),
                        rs.getString("destino"),
                        rs.getString("procedencia")
                ));
            }
            DBConnection.closeConnection();
        }
        catch (Exception e) {
            System.out.println("Error al listar los vuelos: " + e.getMessage());
        }
        return lista;
    }
}
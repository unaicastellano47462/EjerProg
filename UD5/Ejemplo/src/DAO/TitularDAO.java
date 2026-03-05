package DAO;

import Utilidades.DBConnection;
import Modelo.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TitularDAO {

    public void insertar(Titular titular) {
        String sql = "INSERT INTO titulares (dni, nombre) VALUES (?, ?)";

        try
        {
            Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, titular.getDni());
            ps.setString(2, titular.getNombre());
            ps.executeUpdate();

            /*
                Mensaje para nosotros. No para el usuario final.
                En un proyecto real, esto se manejaría con logs o se mostraría en la interfaz de usuario.
             */

            System.out.println(" (DAO)Titular insertado correctamente.");
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println(" (DAO)Error al insertar titular: " + e.getMessage());
        }
    }

    public int borrar(int id) throws Exception{
        String sql = "DELETE FROM titulares WHERE ID = ?";

        int n=0;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            n = ps.executeUpdate();

            if (n != 1) {
                System.out.println(" (DAO) Titular no borrado.");
                // Mensaje para el usuario
                throw new Exception(" No se encontró ningún titular con el ID proporcionado.");
            }
            else
            {
                    System.out.println(" (DAO) Titular borrado correctamente.");
            }

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al borrar titular: " + e.getMessage());
        }
        finally
        {
            DBConnection.closeConnection();
            return n;
        }
    }

    public Titular buscarPorId(int id) {
        String sql = "SELECT * FROM titulares WHERE id = ?";

        try {
            Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                );
            }
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al buscar titular: " + e.getMessage());
        }

        return null;
    }

    public Titular buscarPorDni(String dni) {
        String sql = "SELECT * FROM titulares WHERE dni = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                );
            }
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al buscar titular por dni: " + e.getMessage());
        }

        return null;
    }

    public ArrayList<Titular>  buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM titulares WHERE nombre = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();

            ArrayList<Titular> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                ));
            }

            DBConnection.closeConnection();
            return lista;

        }
        catch (Exception e)
        {
            System.out.println("(DAO) Error al buscar titulares por nombre: " + e.getMessage());
        }

        return null;
    }

    public void modificar(Titular titular)  {
        String sql = "UPDATE titulares SET nombre = ? WHERE id = ?";

        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, titular.getNombre());
            ps.setInt(2, titular.getId());
            int n = ps.executeUpdate();

            System.out.println(" (DAO) Titular modificado correctamente.");

            DBConnection.closeConnection();
        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al modificar titular: " + e.getMessage());
        }
    }

    public List<Titular> listarTodos() {
        List<Titular> lista = new ArrayList<>();
        String sql = "SELECT * FROM titulares";

        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new Titular(
                        rs.getInt("id"),
                        rs.getString("dni"),
                        rs.getString("nombre")
                ));
            }

            DBConnection.closeConnection();

        }
        catch (Exception e) {
            System.out.println(" (DAO) Error al listar titulares: " + e.getMessage());
        }

        return lista;
    }
}


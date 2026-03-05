package DAO;

import Utilidades.DBConnection;
import Modelo.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CuentasCorrienteDAO {

    public void insertar(CuentasCorriente cuenta) {
        // Cambiamos 'id' por 'iban' en la sentencia SQL
        String sql = "INSERT INTO cuentas_corrientes (iban, saldo) VALUES (?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            // Ahora el orden coincide: 1 es iban, 2 es saldo
            ps.setString(1, cuenta.getIban());
            ps.setDouble(2, cuenta.getSaldo());

            ps.executeUpdate();

            System.out.println(" (DAO) Cuenta corriente insertada correctamente en la BD.");

        } catch (SQLException e) {
            System.out.println(" (DAO) Error SQL al insertar: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" (DAO) Error general: " + e.getMessage());
        }
        // Nota: El uso de try-with-resources cierra la conexión automáticamente
    }

    public int borrar(int id) throws Exception {
       String sql = "DELETE FROM cuentas_corrientes WHERE ID = ?";

        int n=0;
        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            n = ps.executeUpdate();

            if (n != 1) {
                System.out.println(" (DAO) Cuenta corriente no borrada.");
                // Mensaje para el usuario
                throw new Exception(" No se encontró ninguna cuenta corriente con el ID proporcionado.");
            }
            else
            {
                    System.out.println(" (DAO) Cuenta corriente borrada correctamente.");
            }

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Problemas borrando la cuenta corriente: " + e.getMessage());
        }
        finally
        {
            DBConnection.closeConnection();
            return n;
        }
    }

    public CuentasCorriente buscarPorId(int id) {
        String sql = "SELECT * FROM cuentas_corrientes WHERE id = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new CuentasCorriente(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getDouble("saldo")
                );
            }
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al buscar cuenta corriente: " + e.getMessage());
        }

        return null;
    }

    public CuentasCorriente buscarPorIban(String iban) {
        String sql = "SELECT * FROM cuentas_corrientes WHERE iban = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, iban);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new CuentasCorriente(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getDouble("saldo")
                );
            }
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al buscar cuenta corriente: " + e.getMessage());
        }

        return null;
    }

    public List<CuentasCorriente> buscarPorSaldo(Double saldo) {
        String sql = "SELECT * FROM cuentas_corrientes WHERE saldo >= ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setDouble(1, saldo);
            ResultSet rs = ps.executeQuery();

            ArrayList<CuentasCorriente> lista = new ArrayList<>();

            while (rs.next()) {
                lista.add(new CuentasCorriente(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getDouble("saldo")
                ));
            }

            DBConnection.closeConnection();
            return lista;

        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al buscar cuentas corrientes por saldo: " + e.getMessage());
        }

        return null;
    }

    public void modificar(CuentasCorriente cuenta) {
        String sql = "UPDATE cuentas_corrientes SET iban = ? WHERE id = ?";

        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, cuenta.getIban());
            ps.setInt(2, cuenta.getId());
            int n = ps.executeUpdate();

            System.out.println(" (DAO) Cuenta corriente modificada correctamente.");

            DBConnection.closeConnection();
        }
        catch (Exception e)
        {
            System.out.println(" (DAO) Error al modificar cuenta corriente: " + e.getMessage());
        }
    }

    public List<CuentasCorriente> listarTodos() {
        List<CuentasCorriente> lista = new ArrayList<>();
        String sql = "SELECT * FROM cuentas_corrientes";

        try (Connection conn = DBConnection.getConnection();
             Statement ps = conn.createStatement();
             ResultSet rs = ps.executeQuery(sql)) {

            while (rs.next()) {
                lista.add(new CuentasCorriente(
                        rs.getInt("id"),
                        rs.getString("iban"),
                        rs.getDouble("saldo")
                ));
            }

            DBConnection.closeConnection();

        }
        catch (Exception e) {
            System.out.println(" (DAO) Error al listar cuentas corrientes: " + e.getMessage());
        }

        return lista;
    }
}

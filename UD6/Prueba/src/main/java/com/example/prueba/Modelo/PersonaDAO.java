package com.example.prueba.Modelo;

import com.example.prueba.Utilidades.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PersonaDAO {
    public void insertar(Persona p) {
        String sql = "INSERT INTO personas (nombre,apellidos,dni,telefono,fecha_nacimiento,edad) VALUES (?,?,?,?,?,?)";

        try
        {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, p.getNombre());
            ps.setString(2, p.getApellidos());
            ps.setString(3, p.getDni());
            ps.setString(4, p.getTelefono());
            ps.setDate(5, java.sql.Date.valueOf(p.getFechaNacimiento()));
            ps.setInt(6, p.getEdad());

            ps.executeUpdate();

            System.out.println("Titular insertado correctamente.");
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println("Error al insertar titular: " + e.getMessage());
        }
    }

    public void actualizar(Persona p) throws Exception{
        String sql = "UPDATE personas SET nombre = ?,apellidos=?,telefono=?,fecha_nacimiento=? ,edad=? WHERE dni = ?";

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, p.getNombre());
        ps.setString(2, p.getApellidos());
        ps.setString(6, p.getDni());
        ps.setString(3, p.getTelefono());
        ps.setDate(4, java.sql.Date.valueOf(p.getFechaNacimiento()));
        ps.setInt(5, p.getEdad());

        ps.executeUpdate();

        System.out.println("Persona actualizada correctamente.");
        DBConnection.closeConnection();

    }

    public Persona buscarPersona(String dni) {
        String sql = "SELECT * FROM personas WHERE dni = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, dni);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Persona(
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("dni"),
                        rs.getString("telefono"),
                        rs.getDate("fecha_nacimiento").toLocalDate(),
                        rs.getInt("edad")
                );
            }
            DBConnection.closeConnection();

        }
        catch (Exception e)
        {
            System.out.println("Error al buscar persona por dni: " + e.getMessage());
        }

        return null;
    }

    public void borrarPersona(Persona p) throws Exception
    {
        String sql = "DELETE FROM personas WHERE dni = ?";

        int n=0;

        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, p.getDni());
        n = ps.executeUpdate();

        if (n != 1)
        {
            System.out.println("Persona no borrada.");
            throw new Exception("No se puede borrar el persona");
        }
        else
        {
            System.out.println("Persona borrada.");
        }

        DBConnection.closeConnection();
    }
}


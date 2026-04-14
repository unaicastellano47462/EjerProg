package com.example.prueba.Controlador.modelos;

import com.example.prueba.Modelo.Persona;
import com.example.prueba.Modelo.PersonaDAO;

import java.time.LocalDate;

public class PersonaController {
    private static PersonaDAO personaDAO = new PersonaDAO();

    public static void insertarPersona(String nombre, String apellidos, String dni, String telefono, LocalDate fechaNacimiento, int edad) {
        Persona persona = new Persona(nombre, apellidos, dni, telefono, fechaNacimiento, edad);
        personaDAO.insertar(persona);
    }

    public static Persona borrarPersona(int id) {
        return null;
    }
}

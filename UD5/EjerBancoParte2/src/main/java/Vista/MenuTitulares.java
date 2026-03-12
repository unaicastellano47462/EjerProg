package Vista;

import Controladores.TitularController;
import Modelo.Titular;
import Utilidades.EntradaDatos;
import java.util.Scanner;

public class MenuTitulares {
    private Scanner sc;
    private TitularController titularController;

    public MenuTitulares() {
        sc = new Scanner(System.in);
        titularController = new TitularController();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE TITULARES ---");
            System.out.println("1. Crear titular");
            System.out.println("2. Modificar titular");
            System.out.println("3. Borrar titular");
            System.out.println("4. Listar todos los titulares");
            System.out.println("0. Volver");
            opcion = EntradaDatos.leerEntero(sc, "Opción: ");

            switch (opcion) {
                case 1 -> crearTitular();
                case 2 -> modificarTitular();
                case 3 -> borrarTitular();
                case 4 -> listarTitulares();
            }
        } while (opcion != 0);
    }

    private void crearTitular() {
        System.out.println("\n--- NUEVO TITULAR ---");
        String iban = EntradaDatos.leerTexto(sc, "IBAN: ", "^[A-Z0-9]{1,24}$");
        String dni = EntradaDatos.leerTexto(sc, "DNI: ", "^[0-9]{8}[A-Z]$");
        String nombre = EntradaDatos.leerTexto(sc, "Nombre: ", "^[A-Za-z ]+$");

        try {
            titularController.crearTitular(dni, nombre, iban);
            System.out.println("Titular creado con éxito.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void modificarTitular() {
        String dni = EntradaDatos.leerTexto(sc, "DNI del titular a modificar: ", "^[0-9]{8}[A-Z]$");
        Titular t = titularController.buscarPorDni(dni);
        if (t != null) {
            String nuevoNombre = EntradaDatos.leerTexto(sc, "Nuevo nombre: ", "^[A-Za-z ]+$");
            titularController.modificarTitular(t, nuevoNombre);
            System.out.println("Titular actualizado.");
        } else {
            System.out.println("No se encontró el titular.");
        }
    }

    private void borrarTitular() {
        String dni = EntradaDatos.leerTexto(sc, "DNI del titular a borrar: ", "^[0-9]{8}[A-Z]$");
        try {
            titularController.borrarTitular(dni);
            System.out.println("Titular borrado.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void listarTitulares() {
        System.out.println(titularController.listarTitulares());
    }
}
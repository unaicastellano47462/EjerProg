package Vista;

import Controller.TitularController;
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
            System.out.println("\n--- MENÚ TITULARES ---");
            System.out.println("1. Añadir nuevo titular");
            System.out.println("2. Listar todos los titulares");
            System.out.println("3. Buscar titular por DNI");
            System.out.println("4. Buscar titular por nombre");
            System.out.println("5. Modificar titular");
            System.out.println("6. Borrar titular");
            System.out.println("0. Volver al menú principal");

            opcion = EntradaDatos.leerEntero(sc, "Elige una opción: ");

            try {
                switch (opcion) {
                    case 1 -> crearTitular();
                    case 2 -> listarTitulares();
                    case 3 -> buscarPorDni();
                    case 4 -> buscarPorNombre();
                    case 5 -> modificarTitular();
                    case 6 -> borrarTitular();
                    case 0 -> System.out.println("Volviendo...");
                    default -> System.out.println("Opción incorrecta.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private void crearTitular() throws Exception {
        String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI: ", ".*");
        String nombre = EntradaDatos.leerTexto(sc, "Introduce el nombre: ", ".*");
        titularController.crearTitular(dni, nombre);
        System.out.println("Titular creado correctamente.");
    }

    private void listarTitulares() {
        System.out.println(titularController.listarTitulares().toString());
    }

    private void buscarPorDni() {
        String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI: ", ".*");
        Titular t = titularController.buscarPorDni(dni);
        if (t != null) {
            System.out.println(t.toString());
        } else {
            System.out.println("No se ha encontrado ningún titular con ese DNI.");
        }
    }

    private void buscarPorNombre() {
        String nombre = EntradaDatos.leerTexto(sc, "Introduce el nombre: ", ".*");
        System.out.println(titularController.buscarPorNombre(nombre).toString());
    }

    private void modificarTitular() {
        String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI del titular a modificar: ", ".*");
        Titular t = titularController.buscarPorDni(dni);
        if (t != null) {
            String nuevoNombre = EntradaDatos.leerTexto(sc, "Introduce el nuevo nombre: ", ".*");
            titularController.modificarTitular(t, nuevoNombre);
            System.out.println("Titular modificado correctamente.");
        } else {
            System.out.println("Titular no encontrado.");
        }
    }

    private void borrarTitular() throws Exception {
        String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI del titular a borrar: ", ".*");
        titularController.borrarTitular(dni);
        System.out.println("Titular borrado correctamente.");
    }
}
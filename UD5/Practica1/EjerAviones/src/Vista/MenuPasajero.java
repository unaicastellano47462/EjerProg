package Vista;

import Controlador.PasajeroController;
import Controlador.VueloController;
import Modelo.Pasajero;
import Modelo.Vuelo;
import Utilidades.EntradaDatos;

import java.util.List;
import java.util.Scanner;

public class MenuPasajero {

    private Scanner sc;
    private PasajeroController pasajeroController;
    private VueloController vueloController;
    public MenuPasajero() {
        sc = new Scanner(System.in);
        pasajeroController = new PasajeroController();
        vueloController = new VueloController();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n====== MENÚ PASAJEROS  ======");
            System.out.println("1. Añadir pasajero");
            System.out.println("2. Modificar pasajero");
            System.out.println("3. Borrar pasajero");
            System.out.println("4. Listar todos los pasajeros");
            System.out.println("5. Buscar por DNI");
            System.out.println("6. Listar pasajeros de un vuelo");
            System.out.println("7. Ver datos del vuelo de un pasajero");
            System.out.println("0. Volver");
            System.out.println("=============================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> crearPasajero();
                case 2 -> modificarPasajero();
                case 3 -> borrarPasajero();
                case 4 -> listarPasajeros();
                case 5 -> buscarPorDni();
                case 6 -> listarPorVuelo();
                case 7 -> verVueloDePasajero();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void crearPasajero() {
        System.out.println("\n--- AÑADIR PASAJERO ---");
        try {
            String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI: ", "^[A-Za-z0-9]+$");
            if (dni != null) {
                String nombre = EntradaDatos.leerTexto(sc, "Introduce el nombre: ", "^[a-zA-Z ]+$");
                if (nombre != null) {
                    String telefono = EntradaDatos.leerTexto(sc, "Introduce el teléfono (9 dígitos): ", "^[0-9]{9}$");
                    if (telefono != null) {
                        String cod_vuelo = EntradaDatos.leerTexto(sc, "Introduce el código de vuelo asignado (ej. AEA1-00001): ", "^[a-zA-Z0-9-]+$");
                        if (cod_vuelo != null) {
                            if (pasajeroController.crearPasajero(dni, nombre, telefono, cod_vuelo)) {
                                System.out.println("Pasajero añadido con éxito.");
                            } else {
                                System.out.println("No se pudo añadir. (Comprueba que el DNI no exista ya y que el vuelo exista).");
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error añadiendo el pasajero.");
        }
    }

    private void borrarPasajero() {
        System.out.println("\n--- BORRAR PASAJERO ---");
        try {
            String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI del pasajero a borrar: ", "^[A-Za-z0-9]+$");
            if (dni != null) {
                int resultado = pasajeroController.borrarPasajero(dni);
                if (resultado > 0) {
                    System.out.println("Pasajero borrado con éxito.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error borrando el pasajero.");
        }
    }

    private void buscarPorDni() {
        System.out.println("\n--- BUSCAR POR DNI ---");
        String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI a buscar: ", "^[A-Za-z0-9]+$");
        if (dni != null) {
            Pasajero pasajero = pasajeroController.buscarPorDni(dni);
            if (pasajero != null) {
                System.out.println(pasajero);
            } else {
                System.out.println("No se encontró pasajero con DNI: " + dni);
            }
        }
    }

    private void listarPorVuelo() {
        System.out.println("\n--- PASAJEROS POR VUELO ---");
        String cod_vuelo = EntradaDatos.leerTexto(sc, "Introduce el código del vuelo (ej. AEA1-00001): ", "^[a-zA-Z0-9-]+$");
        if (cod_vuelo != null) {
            List<Pasajero> pasajeros = pasajeroController.buscarPorVuelo(cod_vuelo);
            if (pasajeros == null || pasajeros.isEmpty()) {
                System.out.println("No hay pasajeros registrados en ese vuelo.");
            } else {
                for (Pasajero p : pasajeros) {
                    System.out.println(p);
                }
            }
        }
    }

    private void listarPasajeros() {
        System.out.println("\n--- LISTAR TODOS LOS PASAJEROS ---");
        List<Pasajero> pasajeros = pasajeroController.listarPasajeros();

        if (pasajeros == null || pasajeros.isEmpty()) {
            System.out.println("No hay pasajeros registrados.");
        } else {
            for (Pasajero p : pasajeros) {
                System.out.println(p);
            }
        }
    }

    private void modificarPasajero() {
        System.out.println("\n--- MODIFICAR PASAJERO ---");
        String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI del pasajero a modificar: ", "^[A-Za-z0-9]+$");
        if (dni != null) {
            Pasajero pasajero = pasajeroController.buscarPorDni(dni);
            if (pasajero != null) {
                System.out.println("Pasajero actual: " + pasajero);
                String nombre = EntradaDatos.leerTexto(sc, "Introduce el nuevo nombre: ", "^[a-zA-Z ]+$");
                if (nombre != null) {
                    String telefono = EntradaDatos.leerTexto(sc, "Introduce el nuevo teléfono: ", "^[0-9]{9}$");
                    if (telefono != null) {
                        String cod_vuelo = EntradaDatos.leerTexto(sc, "Introduce el nuevo código de vuelo (ej. AEA1-00001): ", "^[a-zA-Z0-9-]+$");
                        if (cod_vuelo != null) {
                            if (pasajeroController.modificarPasajero(pasajero, nombre, telefono, cod_vuelo)) {
                                System.out.println("Pasajero modificado con éxito.");
                            } else {
                                System.out.println("No se pudo modificar el pasajero.");
                            }
                        }
                    }
                }
            } else {
                System.out.println("No se encontró el pasajero con DNI: " + dni);
            }
        }
    }

    private void verVueloDePasajero() {
        System.out.println("\n--- VER VUELO DE UN PASAJERO ---");
        String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI del pasajero: ", "^[A-Za-z0-9]+$");
        if (dni != null) {
            Pasajero pasajero = pasajeroController.buscarPorDni(dni);
            if (pasajero != null) {
                System.out.println("\nPasajero encontrado: " + pasajero.getNombre() + " (DNI: " + pasajero.getDni() + ")");

                Vuelo vuelo = vueloController.buscarPorCodigo(pasajero.getCod_vuelo());
                if (vuelo != null) {
                    System.out.println("✈️ DATOS DE SU VUELO:");
                    System.out.println(vuelo);
                } else {
                    System.out.println("El vuelo asignado a este pasajero (" + pasajero.getCod_vuelo() + ") no existe o fue borrado.");
                }
            } else {
                System.out.println("No se encontró ningún pasajero con DNI: " + dni);
            }
        }
    }
}
package Vista;

import Controlador.VueloController;
import Modelo.*;
import Utilidades.EntradaDatos;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class MenuVuelo {

    private Scanner sc;
    private VueloController vueloController;

    public MenuVuelo() {
        sc = new Scanner(System.in);
        vueloController = new VueloController();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n====== MENÚ VUELO  ======");
            System.out.println("1. Crear vuelo");
            System.out.println("2. Modificar vuelo");
            System.out.println("3. Borrar vuelo");
            System.out.println("4. Listar vuelos");
            System.out.println("5. Buscar por código");
            System.out.println("6. Buscar por destino");
            System.out.println("7. Buscar por procedencia");
            System.out.println("8. Listar por fecha");
            System.out.println("0. Salir");
            System.out.println("========================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> crearVuelo();
                case 2 -> modificarVuelo();
                case 3 -> borrarVuelo();
                case 4 -> listarVuelos();
                case 5 -> buscarPorCodigo();
                case 6 -> buscarPorDestino();
                case 7 -> buscarPorProcedencia();
                case 8 -> listarPorFecha();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void crearVuelo() {
        System.out.println("\n--- CREAR VUELO ---");
        try {
            Date fecha_salida = EntradaDatos.leerFecha(sc, "Fecha de salida (YYYY-MM-DD): ");
            if (fecha_salida != null) {
                String destino = EntradaDatos.leerTexto(sc, "Introduce el destino: ", "^[a-zA-Z ]+$");
                if (destino != null) {
                    String procedencia = EntradaDatos.leerTexto(sc, "Introduce la procedencia: ", "^[a-zA-Z ]+$");
                    if (procedencia != null) {
                        String codigoGenerado = vueloController.crearVuelo(fecha_salida, destino, procedencia);
                        if (codigoGenerado != null) {
                            System.out.println("Vuelo creado con éxito. Código asignado automáticamente: " + codigoGenerado);
                        } else {
                            System.out.println("No se pudo crear el vuelo. Revisa los errores.");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error creando el vuelo.");
        }
    }

    private void borrarVuelo() {
        System.out.println("\n--- BORRAR VUELO ---");
        try {
            String cod_vuelo = EntradaDatos.leerTexto(sc, "Introduce el código del vuelo a borrar: ", "^[a-zA-Z0-9-]+$");
            if (cod_vuelo != null) {
                int resultado = vueloController.borrarVuelo(cod_vuelo);
                if (resultado > 0) {
                    System.out.println("Vuelo borrado con éxito.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error borrando el vuelo.");
        }
    }

    private Vuelo buscarPorCodigo() {
        System.out.println("\n--- BUSCAR VUELO POR CÓDIGO ---");
        String cod_vuelo = EntradaDatos.leerTexto(sc, "Introduce el código del vuelo a buscar (ej. AEA1-00001): ", "^[a-zA-Z0-9-]+$");

        if (cod_vuelo != null) {
            Vuelo vuelo = vueloController.buscarPorCodigo(cod_vuelo);
            if (vuelo != null) {
                System.out.println(vuelo);
            } else {
                System.out.println("No se encontró el vuelo con código: " + cod_vuelo);
            }
            return vuelo;
        }
        return null;
    }

    private Vuelo buscarPorDestino() {
        System.out.println("\n--- BUSCAR VUELO POR DESTINO ---");
        String destino = EntradaDatos.leerTexto(sc, "Introduce el destino a buscar: ", "^[a-zA-Z ]+$");
        if (destino != null) {
            Vuelo vuelo = vueloController.buscarPorDestino(destino);
            if (vuelo != null) {
                System.out.println(vuelo);
            } else {
                System.out.println("No se encontró ningún vuelo con destino: " + destino);
            }
            return vuelo;
        }
        return null;
    }

    private Vuelo buscarPorProcedencia() {
        System.out.println("\n--- BUSCAR VUELO POR PROCEDENCIA ---");
        String procedencia = EntradaDatos.leerTexto(sc, "Introduce la procedencia a buscar: ", "^[a-zA-Z ]+$");
        if (procedencia != null) {
            Vuelo vuelo = vueloController.buscarPorProcedencia(procedencia);
            if (vuelo != null) {
                System.out.println(vuelo);
            } else {
                System.out.println("No se encontró ningún vuelo con procedencia: " + procedencia);
            }
            return vuelo;
        }
        return null;
    }

    private void listarPorFecha() {
        System.out.println("\n--- LISTADO CRONOLÓGICO DE VUELOS ---");
        List<Vuelo> vuelos = vueloController.listarPorFecha();

        if (vuelos == null || vuelos.isEmpty()) {
            System.out.println("No hay vuelos registrados en el sistema.");
        } else {
            for (Vuelo v : vuelos) {
                System.out.println(v);
            }
        }
    }

    private void listarVuelos() {
        System.out.println("\n--- LISTAR TODOS LOS VUELOS ---");
        List<Vuelo> vuelos = vueloController.listarVuelos();

        if (vuelos == null || vuelos.isEmpty()) {
            System.out.println("No hay vuelos registrados.");
        } else {
            for (Vuelo v : vuelos) {
                System.out.println(v);
            }
        }
    }

    private void modificarVuelo() {
        System.out.println("\n--- MODIFICAR VUELO ---");
        String cod_vuelo = EntradaDatos.leerTexto(sc, "Introduce el código del vuelo a modificar: ", "^[a-zA-Z0-9-]+$");
        if (cod_vuelo != null) {
            Vuelo vuelo = vueloController.buscarPorCodigo(cod_vuelo);
            if (vuelo != null) {
                System.out.println("Vuelo actual: " + vuelo);
                Date fecha_salida = EntradaDatos.leerFecha(sc, "Introduce la nueva fecha de salida (YYYY-MM-DD): ");
                if (fecha_salida != null) {
                    String destino = EntradaDatos.leerTexto(sc, "Introduce el nuevo destino: ", "^[a-zA-Z ]+$");
                    if (destino != null) {
                        String procedencia = EntradaDatos.leerTexto(sc, "Introduce la nueva procedencia: ", "^[a-zA-Z ]+$");
                        if (procedencia != null) {
                            if (vueloController.modificarVuelo(vuelo, fecha_salida, destino, procedencia)) {
                                System.out.println("Vuelo modificado con éxito.");
                            } else {
                                System.out.println("No se pudo modificar el vuelo.");
                            }
                        }
                    }
                }
            } else {
                System.out.println("No se encontró el vuelo con código: " + cod_vuelo);
            }
        }
    }
}
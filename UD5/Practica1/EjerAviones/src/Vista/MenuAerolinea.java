package Vista;

import Controlador.*;
import Utilidades.EntradaDatos;

import java.util.Scanner;


public class MenuAerolinea {

    private Scanner sc;

    public MenuAerolinea() {
        sc = new Scanner(System.in);
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n====== MENÚ AEROLÍNEA  ======");
            System.out.println("1. Gestionar vuelos");
            System.out.println("2. Gestionar Pasajeros");
            System.out.println("0. Salir");
            System.out.println("========================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> {
                    MenuVuelo menuVuelo = new MenuVuelo();
                    menuVuelo.mostrarMenu();
                }
                case 2 -> {
                    MenuPasajero menuPasajero = new MenuPasajero();
                    menuPasajero.mostrarMenu();
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
}

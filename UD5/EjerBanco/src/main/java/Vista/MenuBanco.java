package Vista;

import Utilidades.EntradaDatos;

import java.util.Scanner;

public class MenuBanco {
    private Scanner sc;

    public MenuBanco() { sc = new Scanner(System.in); }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n====== MENÚ BANCO  ======");
            System.out.println("1. Gestionar titulares");
            System.out.println("2. Gestionar cuentas corrientes");
            System.out.println("0. Salir");
            System.out.println("========================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> {
                    MenuTitular menuTitular = new MenuTitular();
                    menuTitular.mostrarMenu();
                }
                case 2 -> {
                    MenuCuenta menuCuenta = new MenuCuenta();
                    menuCuenta.mostrarMenu();
                }
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }
}

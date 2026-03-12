package Vista;

import Utilidades.EntradaDatos;
import java.util.Scanner;

public class MenuBanco {
    private Scanner sc;
    private MenuCuentas menuCuentas;
    private MenuTitulares menuTitulares;

    public MenuBanco() {
        sc = new Scanner(System.in);
        menuCuentas = new MenuCuentas();
        menuTitulares = new MenuTitulares();
    }

    public void iniciar() {
        int opcion;
        do {
            System.out.println("\n********** SISTEMA BANCARIO **********");
            System.out.println("1. GESTIÓN DE CUENTAS");
            System.out.println("2. GESTIÓN DE TITULARES");
            System.out.println("0. SALIR");
            System.out.println("**************************************");

            opcion = EntradaDatos.leerEntero(sc, "Seleccione una sección: ");

            switch (opcion) {
                case 1 -> menuCuentas.mostrarMenu();
                case 2 -> menuTitulares.mostrarMenu();
                case 0 -> System.out.println("Cerrando aplicación...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }
}
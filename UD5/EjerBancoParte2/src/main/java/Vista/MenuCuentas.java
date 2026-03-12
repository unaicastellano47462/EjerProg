package Vista;

import Controladores.CuentaController;
import Utilidades.EntradaDatos;
import java.util.Scanner;

public class MenuCuentas {
    private Scanner sc;
    private CuentaController cuentaController;

    public MenuCuentas() {
        sc = new Scanner(System.in);
        cuentaController = new CuentaController();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- GESTIÓN DE CUENTAS ---");
            System.out.println("1. Crear cuenta");
            System.out.println("2. Listar cuentas");
            System.out.println("0. Volver");
            opcion = EntradaDatos.leerEntero(sc, "Opción: ");

            switch (opcion) {
                case 1 -> crearCuenta();
                case 2 -> System.out.println(cuentaController.listarCuentas());
            }
        } while (opcion != 0);
    }

    private void crearCuenta() {
        System.out.println("\n--- CREAR CUENTA ---");
        try {
            String iban = EntradaDatos.leerTexto(sc, "Introduce el IBAN (Ej: ES1111): ", "^ES[0-9]{4}$");

            if (iban != null) {
                double saldo = (double) EntradaDatos.leerEntero(sc, "Introduce el saldo inicial: ");
                cuentaController.crearCuenta(iban, saldo);
                System.out.println("Cuenta creada correctamente.");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
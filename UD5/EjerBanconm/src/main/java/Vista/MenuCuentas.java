package Vista;

import Controller.CuentaController;
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
            System.out.println("\n--- MENÚ CUENTAS ---");
            System.out.println("1. Añadir nueva cuenta");
            System.out.println("2. Listar todas las cuentas");
            System.out.println("3. Ver cuentas de un titular");
            System.out.println("4. Vincular titular a cuenta existente");
            System.out.println("0. Volver al menú principal");

            opcion = EntradaDatos.leerEntero(sc, "Elige una opción: ");

            try {
                switch (opcion) {
                    case 1 -> crearCuenta();
                    case 2 -> listarCuentas();
                    case 3 -> verCuentasTitular();
                    case 4 -> vincularTitular();
                    case 0 -> System.out.println("Volviendo...");
                    default -> System.out.println("Opción incorrecta.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 0);
    }

    private void crearCuenta() throws Exception {
        String iban = EntradaDatos.leerTexto(sc, "Introduce el IBAN: ", ".*");
        double saldo = EntradaDatos.leerEntero(sc, "Introduce el saldo inicial: ");
        cuentaController.crearCuenta(iban, saldo);
        System.out.println("Cuenta creada correctamente.");
    }

    private void listarCuentas() {
        System.out.println(cuentaController.listarCuentas().toString());
    }

    private void verCuentasTitular() {
        String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI del titular: ", ".*");
        System.out.println(cuentaController.listarCuentasDeUnTitular(dni).toString());
    }

    private void vincularTitular() throws Exception {
        String iban = EntradaDatos.leerTexto(sc, "Introduce el IBAN de la cuenta: ", ".*");
        String dni = EntradaDatos.leerTexto(sc, "Introduce el DNI del titular: ", ".*");
        cuentaController.vincularTitularACuenta(iban, dni);
        System.out.println("Titular vinculado correctamente a la cuenta.");
    }
}
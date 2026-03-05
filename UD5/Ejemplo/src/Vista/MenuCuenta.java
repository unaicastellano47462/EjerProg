package Vista;
import java.util.List;
import java.util.Scanner;
import Controladores.*;
import Modelo.CuentasCorriente;
import Utilidades.EntradaDatos;

public class MenuCuenta {

    private Scanner sc;

    private CuentasCorrienteController cuentasCorrienteController;

    public MenuCuenta()
    {
        // Objeto Scanner para leer la entrada del usuario
        sc = new Scanner(System.in);
        /*
        Creación del controlador para manejar la lógica de negocio
        relacionada con las cuentas corrientes.
         */
        cuentasCorrienteController = new CuentasCorrienteController();
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n====== MENÚ BANCO (CUENTAS CORRIENTES)  ======");
            System.out.println("1. Crear cuenta corriente");
            System.out.println("2. Modificar cuenta corriente");
            System.out.println("3. Borrar cuenta corriente");
            System.out.println("4. Listar cuentas corrientes");
            System.out.println("5. Listar cuentas corrientes por saldo");
            System.out.println("6. Buscar por ID");
            System.out.println("7. Buscar por IBAN");
            System.out.println("0. Salir");
            System.out.println("========================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> crearCuentaCorriente();
                case 2 -> modificarCuentaCorriente();
                case 3 -> borrarCuentaCorriente();
                case 4 -> listarCuentasCorrientes();
                case 5 -> listarPorSaldo();
                case 6 -> buscarPorId();
                case 7 -> buscarPorIban();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void crearCuentaCorriente() {
        System.out.println("\n--- CREAR CUENTA CORRIENTE ---");
        try
        {
            // Solicitar al usuario el IBAN y el saldo para crear una nueva cuenta corriente la expresion regular es para validar el formato del IBAN, que en este caso se espera que comience con "ES" seguido de 10 dígitos.
            String iban = EntradaDatos.leerTexto(sc, "Introduce el IBAN: ",  "^ES\\d{10}$");
            if (iban != null) {
                double saldo = EntradaDatos.leerEntero(sc, "Introduce el saldo: ");
                if (saldo != -1) {
                    // Llamar al controlador para crear la cuenta corriente con los datos proporcionados por el usuario.
                    cuentasCorrienteController.crearCuentaCorriente(iban, saldo);
                    // Mensaje para que el usuario sepa que se ha creado correctamente
                    System.out.println("Cuenta corriente creada correctamente.");
                }
            }
        }
        catch (Exception e)
        {
            System.out.println("Error creando la cuenta corriente: " + e.getMessage());
        }
    }

    private void borrarCuentaCorriente() {
        System.out.println("\n--- BORRAR CUENTA CORRIENTE ---");
        try {
            int id = EntradaDatos.leerEntero(sc, "Introduce el ID de la cuenta corriente a borrar: ");
            if (id != -1) {
                int n = cuentasCorrienteController.borrarCuentaCorriente(id);
                if (n == 1) {
                    System.out.println("Cuenta corriente borrada correctamente.");
                } else {
                    System.out.println("No se encontró ninguna cuenta corriente con el ID proporcionado.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error borrando la cuenta corriente: " + e.getMessage());
        }
    }

    private CuentasCorriente buscarPorIban () {
        System.out.println("\n--- BUSCAR CUENTA CORRIENTE POR IBAN ---");
        String iban = EntradaDatos.leerTexto(sc, "Introduce el IBAN a buscar: ", "^ES\\d{10}$");
        if (iban != null) {
            // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
            // Variable global?

            CuentasCorriente cuenta = cuentasCorrienteController.buscarPorIban(iban);
            if (cuenta != null) {
                System.out.println("Cuenta corriente encontrada: " + cuenta);
            } else {
                System.out.println("No se encontró ninguna cuenta corriente con el IBAN proporcionado.");
            }
            return cuenta;
        }
        return null;
    }

    private void listarPorSaldo() {
        System.out.println("\n--- LISTAR CUENTAS CORRIENTES POR SALDO ---");
        double saldo = EntradaDatos.leerEntero(sc, "Introduce el saldo mínimo: ");
        if (saldo != -1) {
           // Variable global?
            StringBuilder sb = cuentasCorrienteController.buscarPorSaldo(saldo);
            if (sb.isEmpty()) {
                System.out.println(sb.toString());
            } else {
                System.out.println("No se encontraron cuentas corrientes con el saldo mínimo proporcionado.");
            }
        }
    }

    private CuentasCorriente buscarPorId() {
        System.out.println("\n--- BUSCAR CUENTA CORRIENTE POR ID ---");
        int id = EntradaDatos.leerEntero(sc, "Introduce el ID a buscar: ");
        if (id != -1) {
            // Si es -1, ya hemos mostrado un mensaje de error en la función leerEntero, así que no hace falta mostrar otro aquí.
            // Variable global?

            CuentasCorriente cuenta = cuentasCorrienteController.buscarPorId(id);
            if (cuenta != null) {
                System.out.println("Cuenta corriente encontrada: " + cuenta);
            } else {
                System.out.println("No se encontró ninguna cuenta corriente con el ID proporcionado.");
            }
            return cuenta;
        }
        return null;
    }

    private void modificarCuentaCorriente() {
        System.out.println("\n--- MODIFICAR CUENTA CORRIENTE ---");
        CuentasCorriente cuenta = buscarPorIban();
        if (cuenta != null) {
            String nuevoIban = EntradaDatos.leerTexto(sc, "Introduce el nuevo IBAN: ", "^ES\\d{10}$");
            if (nuevoIban != null) {
                // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
                cuentasCorrienteController.modificarCuentaCorriente(cuenta, nuevoIban);
                System.out.println("Cuenta corriente modificada correctamente.");
            }
        }
    }

    private void listarCuentasCorrientes() {
        System.out.println("\n--- LISTADO DE CUENTAS CORRIENTES ---");
        List<CuentasCorriente> cuentas = cuentasCorrienteController.listarCuentasCorriente();

        if (cuentas.isEmpty()) {
            System.out.println("No hay cuentas corrientes registradas.");
        } else {
            for (CuentasCorriente c : cuentas) {
                System.out.println(c);
            }
        }

        //Mas puro
        System.out.println("--- LISTADO DE CUENTAS CORRIENTES (MÁS PURO) ---");
        StringBuilder sb = cuentasCorrienteController.listarCuentasCorriente2();
        System.out.println(sb);
    }
}

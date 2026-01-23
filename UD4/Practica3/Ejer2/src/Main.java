import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Cliente> clientes = new ArrayList<>();
    static List<Veterinario> veterinarios = new ArrayList<>();
    static List<Mascota> mascotas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("REGISTRO DE MASCOTAS, CLIENTES Y VETERINARIOS");
        registrarMascotas();
        registrarClientes();
        registrarVeterinarios();
        mostrarMenu();
    }

    static void registrarMascotas() {
        System.out.print("¿Cuántas mascotas desea registrar? ");
        int n = leerEntero();
        for (int i = 0; i < n; i++) {
            System.out.println("Mascota " + (i + 1));
            System.out.print("Tipo (Perro/Gato): ");
            String tipo = leerTextoNoVacio();
            System.out.print("Raza: ");
            String raza = leerTextoNoVacio();
            System.out.print("Nombre: ");
            String nombre = leerTextoNoVacio();
            LocalDate fecha = leerFecha("Fecha de nacimiento (AAAA-MM-DD): ");
            System.out.print("Sexo: ");
            String sexo = leerTextoNoVacio();
            System.out.print("Peso: ");
            double peso = leerDouble();
            System.out.print("Longitud: ");
            double longitud = leerDouble();
            System.out.print("Tipo de pelo: ");
            String pelo = leerTextoNoVacio();

            Mascota m;
            if (tipo.equalsIgnoreCase("Perro")) {
                m = new Perro(raza, nombre, fecha, sexo, peso, longitud, pelo, null, null);
            } else {
                m = new Gato(raza, nombre, fecha, sexo, peso, longitud, pelo, null, null);
            }
            mascotas.add(m);
        }
    }

    static void registrarClientes() {
        System.out.print("¿Cuántos clientes desea registrar? ");
        int n = leerEntero();
        for (int i = 0; i < n; i++) {
            System.out.println("Cliente " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = leerTextoNoVacio();
            System.out.print("Dirección: ");
            String direccion = leerTextoNoVacio();
            System.out.print("Teléfono: ");
            String telefono = leerTextoNoVacio();

            Cliente c = new Cliente(nombre, direccion, telefono, new ArrayList<>());
            clientes.add(c);

            System.out.println("¿Cuántas mascotas tiene este cliente?");
            int mCount = leerEntero();
            for (int j = 0; j < mCount; j++) {
                System.out.println("Seleccione una mascota por número para asignarla al cliente:");
                for (int k = 0; k < mascotas.size(); k++) {
                    Mascota tmp = mascotas.get(k);
                    String asignada = tmp.getDueño() == null ? "" : "(Ya asignada)";
                    System.out.println((k + 1) + ". " + tmp.getNombre() + " " + asignada);
                }
                int sel = leerEntero() - 1;
                Mascota m = mascotas.get(sel);
                if (m.getDueño() != null) {
                    System.out.println("Esta mascota ya tiene dueño. Seleccione otra.");
                    j--;
                    continue;
                }
                m.setDueño(c);
                c.agregarMascota(m);
            }
        }
    }

    static void registrarVeterinarios() {
        System.out.print("¿Cuántos veterinarios desea registrar? ");
        int n = leerEntero();
        for (int i = 0; i < n; i++) {
            System.out.println("Veterinario " + (i + 1));
            System.out.print("Nombre: ");
            String nombre = leerTextoNoVacio();
            System.out.print("Dirección: ");
            String direccion = leerTextoNoVacio();
            System.out.print("Teléfono: ");
            String telefono = leerTextoNoVacio();
            System.out.print("DNI: ");
            String dni = leerTextoNoVacio();
            System.out.print("Número de seguridad social: ");
            int nss = leerEntero();

            Veterinario v = new Veterinario(nombre, direccion, telefono, dni, nss, new ArrayList<>());
            veterinarios.add(v);

            System.out.println("¿Cuántas mascotas atenderá este veterinario?");
            int mCount = leerEntero();
            for (int j = 0; j < mCount; j++) {
                System.out.println("Seleccione una mascota por número:");
                for (int k = 0; k < mascotas.size(); k++) {
                    Mascota tmp = mascotas.get(k);
                    String asignada = tmp.getVeterinario() == null ? "" : "(Ya asignada)";
                    System.out.println((k + 1) + ". " + tmp.getNombre() + " " + asignada);
                }
                int sel = leerEntero() - 1;
                Mascota m = mascotas.get(sel);
                if (m.getVeterinario() != null) {
                    System.out.println("Esta mascota ya tiene veterinario. Seleccione otra.");
                    j--;
                    continue;
                }
                m.setVeterinario(v);
                v.getMascotas().add(m);  // CORRECCIÓN: agregamos directamente a la lista
            }
        }
    }

    static void mostrarMenu() {
        boolean salir = false;
        while (!salir) {
            System.out.println("MENÚ CLÍNICA VETERINARIA");
            System.out.println("1. Mostrar número de clientes por tipo de animal");
            System.out.println("2. Datos personales del cliente a partir del nombre de mascota");
            System.out.println("3. Datos del veterinario a partir de la mascota");
            System.out.println("4. Datos de las mascotas de un cliente");
            System.out.println("5. Datos de las mascotas de un veterinario");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = leerEntero();
            switch (opcion) {
                case 1 -> mostrarNumClientesPorTipo();
                case 2 -> mostrarClientePorMascota();
                case 3 -> mostrarVeterinarioPorMascota();
                case 4 -> mostrarMascotasDeCliente();
                case 5 -> mostrarMascotasDeVeterinario();
                case 6 -> salir = true;
                default -> System.out.println("Opción no válida.");
            }
        }
    }

    static int leerEntero() {
        while (true) {
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un número válido: ");
            }
        }
    }

    static double leerDouble() {
        while (true) {
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Ingrese un valor válido: ");
            }
        }
    }

    static String leerTextoNoVacio() {
        while (true) {
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) return input;
            System.out.print("No puede estar vacío. Ingrese nuevamente: ");
        }
    }

    static LocalDate leerFecha(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            try {
                return LocalDate.parse(sc.nextLine());
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido. Use AAAA-MM-DD");
            }
        }
    }

    static void mostrarNumClientesPorTipo() {
        System.out.print("Ingrese tipo de mascota (Perro/Gato): ");
        String tipo = sc.nextLine();
        int count = 0;
        for (Cliente c : clientes) {
            for (Mascota m : c.getMascotas()) {
                if ((tipo.equalsIgnoreCase("Perro") && m instanceof Perro) ||
                        (tipo.equalsIgnoreCase("Gato") && m instanceof Gato)) {
                    count++;
                    break;
                }
            }
        }
        System.out.println("Número de clientes con " + tipo + ": " + count);
    }

    static void mostrarClientePorMascota() {
        System.out.print("Ingrese nombre de la mascota: ");
        String nombre = sc.nextLine();
        for (Mascota m : mascotas) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                Cliente c = m.getDueño();
                System.out.println("Cliente: " + c.getNombre());
                System.out.println("Dirección: " + c.getDireccion());
                System.out.println("Teléfono: " + c.getTelefono());
                return;
            }
        }
        System.out.println("Mascota no encontrada.");
    }

    static void mostrarVeterinarioPorMascota() {
        System.out.print("Ingrese nombre de la mascota: ");
        String nombre = sc.nextLine();
        for (Mascota m : mascotas) {
            if (m.getNombre().equalsIgnoreCase(nombre)) {
                Veterinario v = m.getVeterinario();
                System.out.println("Veterinario: " + v.getNombre());
                System.out.println("Dirección: " + v.getDireccion());
                System.out.println("Teléfono: " + v.getTelefono());
                System.out.println("DNI: " + v.getDni());
                System.out.println("Nº Seguridad Social: " + v.getNumSeguridadSocial());
                return;
            }
        }
        System.out.println("Mascota no encontrada.");
    }

    static void mostrarMascotasDeCliente() {
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = sc.nextLine();
        for (Cliente c : clientes) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Mascotas de " + c.getNombre() + ":");
                for (Mascota m : c.getMascotas()) {
                    System.out.println("- " + m.getNombre() + " (" + m.getClass().getSimpleName() + ")");
                }
                return;
            }
        }
        System.out.println("Cliente no encontrado.");
    }

    static void mostrarMascotasDeVeterinario() {
        System.out.print("Ingrese nombre del veterinario: ");
        String nombre = sc.nextLine();
        for (Veterinario v : veterinarios) {
            if (v.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Mascotas atendidas por " + v.getNombre() + ":");
                for (Mascota m : mascotas) {
                    if (m.getVeterinario() == v) {
                        System.out.println("- " + m.getNombre() + " (" + m.getClass().getSimpleName() + ")");
                    }
                }
                return;
            }
        }
        System.out.println("Veterinario no encontrado.");
    }
}

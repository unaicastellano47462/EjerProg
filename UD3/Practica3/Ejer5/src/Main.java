import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Map<Month, Double> gastosPorMes = new HashMap<>();
    public static void main(String[] args) {
        iniciarRegistro();
        mostrarGastosOrdenados();
        sc.close();
    }

    public static void iniciarRegistro() {
        System.out.println("Registro de pagos con tarjeta:");
        while (true) {
            try {
                registrarPago();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage() + ". Intenta de nuevo.");
            }

            System.out.print("¿Quieres introducir otro pago? (s/n): ");
            String respuesta = sc.next();
            sc.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) break;
        }
    }

    public static void registrarPago() {
        int mes = leerMes();
        int dia = leerDia();
        double cantidad = leerCantidad();

        LocalDate fecha = LocalDate.of(2025, mes, dia);
        Month mesPago = fecha.getMonth();
        gastosPorMes.put(mesPago, gastosPorMes.getOrDefault(mesPago, 0.0) + cantidad);
    }

    public static int leerDia() {
        while (true) {
            try {
                System.out.print("Introduce el día (1-31): ");
                int dia = sc.nextInt();
                sc.nextLine();
                if (dia < 1 || dia > 31) throw new InputMismatchException();
                return dia;
            } catch (InputMismatchException e) {
                System.out.println("Día inválido. Intenta de nuevo.");
                sc.nextLine();
            }
        }
    }

    public static int leerMes() {
        while (true) {
            try {
                System.out.print("Introduce el mes (1-12): ");
                int mes = sc.nextInt();
                sc.nextLine();
                if (mes < 1 || mes > 12) throw new InputMismatchException();
                return mes;
            } catch (InputMismatchException e) {
                System.out.println("Mes inválido. Intenta de nuevo.");
                sc.nextLine();
            }
        }
    }

    public static double leerCantidad() {
        while (true) {
            try {
                System.out.print("Introduce la cantidad pagada: ");
                double cantidad = sc.nextDouble();
                sc.nextLine();
                if (cantidad < 0) throw new InputMismatchException();
                return cantidad;
            } catch (InputMismatchException e) {
                System.out.println("Cantidad inválida. Intenta de nuevo.");
                sc.nextLine();
            }
        }
    }

    public static void mostrarGastosOrdenados() {
        List<Map.Entry<Month, Double>> listaOrdenada = new ArrayList<>(gastosPorMes.entrySet());
        listaOrdenada.sort(Map.Entry.comparingByValue());
        System.out.println("\nTotal gastado por mes (ordenado de menor a mayor):");
        for (Map.Entry<Month, Double> entrada : listaOrdenada) {
            String nombreMes = entrada.getKey().getDisplayName(TextStyle.FULL, new Locale("es", "ES"));
            System.out.println(nombreMes + ": " + entrada.getValue() + " €");
        }
    }
}

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Queue<LocalDate> fechaCaducidad = new LinkedList<>();
    static Queue<String> nombreProducto = new LinkedList<>();

    public static void main(String[] args) {
        preguntarFecha();
        preguntarProductos();

        System.out.println("Fechas de caducidad en la cola:");
        for (LocalDate fecha : fechaCaducidad) {
            System.out.println(fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        }
    }

    public static void preguntarFecha() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            try {
                System.out.println("Ingrese la fecha de caducidad (dd/MM/yyyy): ");
                String fechaStr = sc.nextLine();

                LocalDate fecha = LocalDate.parse(fechaStr, formato);
                fechaCaducidad.add(fecha);

                if (!preguntarContinuar()) {
                    break;
                }

            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto.");
            }
        }
    }

    public static void preguntarProductos() {}

    public static boolean preguntarContinuar() {
        while (true) {
            System.out.println("¿Desea ingresar otra fecha? (si/no)");
            String respuesta = sc.nextLine().toLowerCase();

            if (respuesta.equalsIgnoreCase("si")) {
                return true;
            } else if (respuesta.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Eescribe 'si' o 'no'.");
            }
        }
    }
}

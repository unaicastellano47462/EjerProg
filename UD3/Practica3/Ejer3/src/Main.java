import javax.print.DocFlavor;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Stack<String> pila = new Stack<>();;
    public static void main(String[] args) {
        mostrarMenu();
    }

    public static void mostrarMenu(){
        String valido;
        do {
            try{
                System.out.print("Introduce una opcion: ");
                System.out.println("1) Añadir un libro a la pila");
                System.out.println("2) Consultar el libro en la parte superior: ");
                System.out.println("3) Introduce el nombre del libro: ");
                System.out.println("4) Retirar el libro en la parte superior: ");
                System.out.println("5) Mostrar todos los libros en la pila: ");
                System.out.println("6) Verificar si la pila esta vacia: ");
                System.out.println("7) Salir del programa ");
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        añadirLibro();
                        break;
                    case 2:
                        consultarLibroSup();
                        break;
                    case 3:
                        nombreLibro();
                        break;
                    case 4:
                        retirarLibroSup();
                        break;
                    case 5:
                        mostrarPila();
                        break;
                    case 6:
                        verificarPila();
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción no válida");
                }
                System.out.print("¿Desea realizar otra acción del menú? (si/no): ");
                valido = sc.nextLine().toLowerCase();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                valido = "si";
            }
        } while (valido.equalsIgnoreCase("si"));
    }

    public static void añadirLibro(){
        try {
            System.out.println("Introduce el nombre del libro: ");
            String nombre = sc.nextLine();

            pila.push(nombre);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
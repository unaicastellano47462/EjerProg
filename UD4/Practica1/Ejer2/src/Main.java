import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        class Alumno {
            int codigo;
            String nombre;
            String domicilio;
            int telefono;

            Alumno(int codigo, String nombre, String domicilio, int telefono) {
                this.codigo = codigo;
                this.nombre = nombre;
                this.domicilio = domicilio;
                this.telefono = telefono;
            }

            void mostrarDatos() {
                System.out.println("Código: " + codigo);
                System.out.println("Nombre: " + nombre);
                System.out.println("Domicilio: " + domicilio);
                System.out.println("Teléfono: " + telefono);
            }
        }

        Scanner sc = new Scanner(System.in);
        ArrayList<Alumno> agenda = new ArrayList<>();

        boolean añadirMas = true;
        while (añadirMas) {
            try {
                System.out.println("Añadir Alumno");

                System.out.print("Código: ");
                int codigo = sc.nextInt();
                sc.nextLine();

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Domicilio: ");
                String domicilio = sc.nextLine();

                System.out.print("Teléfono (solo números): ");
                int telefono = sc.nextInt();
                sc.nextLine();

                agenda.add(new Alumno(codigo, nombre, domicilio, telefono));
                System.out.println("Alumno agregado correctamente.");

                System.out.print("¿Quieres añadir otro alumno? (s/n): ");
                String resp = sc.nextLine();
                if (!resp.equalsIgnoreCase("s")) {
                    añadirMas = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido.");
                sc.nextLine();
            }
        }

        boolean buscarMas = true;
        while (buscarMas) {
            try {
                System.out.println("Buscar Alumno");
                System.out.print("Introduce el código del alumno a buscar: ");
                int codigoBuscar = sc.nextInt();
                sc.nextLine();

                boolean encontrado = false;
                for (Alumno a : agenda) {
                    if (a.codigo == codigoBuscar) {
                        System.out.println("Datos del alumno:");
                        a.mostrarDatos();
                        encontrado = true;
                        break;
                    }
                }

                if (!encontrado) {
                    System.out.println("Alumno no encontrado.");
                }

                System.out.print("¿Quieres buscar otro alumno? (s/n): ");
                String resp = sc.nextLine();
                if (!resp.equalsIgnoreCase("s")) {
                    buscarMas = false;
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debes ingresar un número válido.");
                sc.nextLine();
            }
        }

        System.out.println("Programa finalizado");
        sc.close();
    }
}

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        class Persona {
            String nombre;
            int dNacimiento;  //Dia nacimiento
            int mNacimiento; //Mes nacimiento
            int aNacimiento; //Año nacimiento
            String direccion;
            int codigoPostal;
            String ciudad;

            public Persona(String nombre, int dNacimiento, int mNacimiento, int aNacimiento, String direccion, int codigoPostal, String ciudad) {
                this.nombre = nombre;
                this.dNacimiento = dNacimiento;
                this.mNacimiento = mNacimiento;
                this.aNacimiento = aNacimiento;
                this.direccion = direccion;
                this.codigoPostal = codigoPostal;
                this.ciudad = ciudad;

                if (nombre == null || nombre.isBlank() ||
                        direccion == null || direccion.isBlank() ||
                        ciudad == null || ciudad.isBlank()) {
                    throw new IllegalArgumentException("Los campos de texto no pueden estar vacíos");
                }

                if (mNacimiento < 1 || mNacimiento > 12) {
                    throw new IllegalArgumentException("Mes incorrecto");
                }

                if (dNacimiento < 1 || dNacimiento > 31) {
                    throw new IllegalArgumentException("Día incorrecto");
                }

                if (aNacimiento > LocalDate.now().getYear()) {
                    throw new IllegalArgumentException("Año incorrecto");
                }

                this.nombre = nombre;
                this.dNacimiento = dNacimiento;
                this.mNacimiento = mNacimiento;
                this.aNacimiento = aNacimiento;
                this.direccion = direccion;
                this.codigoPostal = codigoPostal;
                this.ciudad = ciudad;
            }

            public int getEdad() {
                LocalDate fechaNacimiento = LocalDate.of(aNacimiento, mNacimiento, dNacimiento);
                return Period.between(fechaNacimiento, LocalDate.now()).getYears();
            }

            public String getNombre() {
                return nombre;
            }

            public String getCiudad() {
                return ciudad;
            }
        }
        ArrayList<Persona> personas = new ArrayList<>();
        String respuesta;

        do {
            try {
                System.out.println("Introducir nueva persona");

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();
                if (nombre.isBlank()) throw new IllegalArgumentException("El nombre no puede estar vacío");
                System.out.print("Día de nacimiento: ");
                int dia = sc.nextInt();
                if (dia < 1 || dia > 31) throw new IllegalArgumentException("Día incorrecto");

                System.out.print("Mes de nacimiento: ");
                int mes = sc.nextInt();
                if (mes < 1 || mes > 12) throw new IllegalArgumentException("Mes incorrecto");

                System.out.print("Año de nacimiento: ");
                int año = sc.nextInt();
                int añoActual = java.time.LocalDate.now().getYear();
                if (año > añoActual) throw new IllegalArgumentException("Año incorrecto");
                sc.nextLine();

                System.out.print("Dirección: ");
                String direccion = sc.nextLine();
                if (direccion.isBlank()) throw new IllegalArgumentException("La dirección no puede estar vacía");

                System.out.print("Código postal: ");
                int cp = sc.nextInt();
                sc.nextLine();

                System.out.print("Ciudad: ");
                String ciudad = sc.nextLine();
                if (ciudad.isBlank()) throw new IllegalArgumentException("La ciudad no puede estar vacía");

                personas.add(new Persona(nombre, dia, mes, año, direccion, cp, ciudad));

                System.out.print("¿Quieres introducir otra persona? (si/no): ");
                respuesta = sc.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Error: debes introducir un número válido.");
                sc.nextLine();
                respuesta = "si";
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                respuesta = "si";
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                respuesta = "si";
                sc.nextLine();
            }
        } while (respuesta.equalsIgnoreCase("si"));
            if (!personas.isEmpty()) {
                Persona mayor = personas.get(0);
                for (Persona p : personas) {
                    if (p.getEdad() > mayor.getEdad()) {
                        mayor = p;
                    }
                }
                System.out.println("Persona de mayor edad: " + mayor.getNombre());

                System.out.println("Personas que viven en Elche:");
                for (Persona p : personas) {
                    if (p.getCiudad().equalsIgnoreCase("Elche")) {
                        System.out.println(p.getNombre());
                    }
                }

                int mayoresEdad = 0;
                for (Persona p : personas) {
                    if (p.getEdad() >= 18) {
                        mayoresEdad++;
                    }
                }
                System.out.println("Número de personas mayores de edad: " + mayoresEdad);
            } else {
                System.out.println("No se introdujo ninguna persona.");
            }
    }
}
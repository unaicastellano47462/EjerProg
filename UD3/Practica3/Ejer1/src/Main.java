import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Set<String> porteros = new HashSet<String>();
    static Set<String> defensas = new HashSet<>();
    static Set<String> centrocampistas = new HashSet<>();
    static Set<String> delanteros = new HashSet<>();

    public static void main(String[] args) {
        agregarJugadoresIni();

        menu();
    }

    public static void agregarJugadoresIni(){
        String opcion;
        do {
            try {
                String nombre = leerNombreValido();
                String rol = leerRolValido();
                agregarJugador(nombre, rol);

                System.out.print("¿Desea agregar otro jugador? (si/no): ");
                opcion = sc.nextLine().toLowerCase();
            } catch (Exception e) {
                System.out.println("Error al ingresar el jugador: " + e.getMessage());
                sc.nextLine();
                opcion = "no";
            }
        } while (opcion.equals("si"));
    }

    public static void menu() {
        String valido;
        do {
            try {
                System.out.println("Menú de Jugadores");
                System.out.println("1. Añadir jugador");
                System.out.println("2. Eliminar jugador");
                System.out.println("3. Modificar jugador");
                System.out.println("4. Mostrar jugadores por rol");
                System.out.println("5. Salir");
                System.out.print("Elija una opción: ");
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        agregarJugadoresMenu();
                        break;
                    case 2:
                        eliminarJugadoresMenu();
                        break;
                    case 3:
                        modificarJugadoresMenu();
                        break;
                    case 4:
                        mostrarJugadores();
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        return;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }

                System.out.print("¿Desea realizar otra acción del menú? (si/no): ");
                valido = sc.nextLine().toLowerCase();

            } catch (InputMismatchException e) {
                System.out.println("Debe ingresar un número válido para el menú.");
                sc.nextLine();
                valido = "si";
            }

        } while (valido.equals("si"));
    }

    public static void agregarJugador(String nombre, String rol) {
        switch (rol) {
            case "portero":
                porteros.add(nombre);
                break;
            case "defensa":
                defensas.add(nombre);
                break;
            case "centrocampista":
                centrocampistas.add(nombre);
                break;
            case "delantero":
                delanteros.add(nombre);
                break;
            default:
                System.out.println("Rol no válido. Jugador no agregado.");
        }
    }

    public static void agregarJugadoresMenu(){
        String opcion;
        do {
            try {
                String nombre = leerNombreValido();
                String rol = leerRolValido();
                agregarJugador(nombre, rol);

                System.out.print("¿Desea agregar otro jugador? (si/no): ");
                opcion = sc.nextLine().toLowerCase();
            } catch (Exception e) {
                System.out.println("Error al agregar el jugador: " + e.getMessage());
                sc.nextLine();
                opcion = "no";
            }
        } while (opcion.equals("si"));
    }


    public static void eliminarJugadoresMenu(){
        String opcion;
        do {
            try {
                String nombre = leerNombreValido();

                if (porteros.remove(nombre) || defensas.remove(nombre) ||
                        centrocampistas.remove(nombre) || delanteros.remove(nombre)) {
                    System.out.println(nombre + " eliminado correctamente.");
                } else {
                    System.out.println("Jugador no encontrado.");
                }

                System.out.print("¿Desea eliminar otro jugador? (si/no): ");
                opcion = sc.nextLine().toLowerCase();
            } catch (Exception e) {
                System.out.println("Error al eliminar el jugador: " + e.getMessage());
                sc.nextLine();
                opcion = "no";
            }
        } while (opcion.equals("si"));
    }

    public static void modificarJugadoresMenu(){
        String opcion;
        do {
            try {
                System.out.print("Ingrese el nombre del jugador a modificar: ");
                String nombre = sc.nextLine();

                boolean encontrado = false;
                if (porteros.remove(nombre)) encontrado = true;
                else if (defensas.remove(nombre)) encontrado = true;
                else if (centrocampistas.remove(nombre)) encontrado = true;
                else if (delanteros.remove(nombre)) encontrado = true;

                if (encontrado) {
                    String nuevoNombre = leerNombreValido();
                    String nuevoRol = leerRolValido();
                    agregarJugador(nuevoNombre, nuevoRol);
                } else {
                    System.out.println("Jugador no encontrado.");
                }

                System.out.print("¿Desea modificar otro jugador? (si/no): ");
                opcion = sc.nextLine().toLowerCase();
            } catch (Exception e) {
                System.out.println("Error al modificar el jugador: " + e.getMessage());
                sc.nextLine();
                opcion = "no";
            }
        } while (opcion.equals("si"));
    }

    public static void mostrarJugadores() {
        System.out.println("Porteros: " + porteros);
        System.out.println("Defensas: " + defensas);
        System.out.println("Centrocampistas: " + centrocampistas);
        System.out.println("Delanteros: " + delanteros);
    }

    public static String leerNombreValido() {
        String nombre;
        while (true) {
            System.out.print("Ingrese el nombre del jugador: ");
            nombre = sc.nextLine();
            if (nombre.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                break;
            } else {
                System.out.println("Nombre inválido. Solo se permiten letras y espacios.");
            }
        }
        return nombre;
    }
    public static String leerRolValido() {
        String rol;
        while (true) {
            System.out.print("Ingrese el rol del jugador (portero, defensa, centrocampista, delantero): ");
            rol = sc.nextLine().toLowerCase();
            if (rol.equalsIgnoreCase("portero") || rol.equalsIgnoreCase("defensa") || rol.equalsIgnoreCase("centrocampista") || rol.equalsIgnoreCase("delantero")) {
                break;
            } else {
                System.out.println("Rol inválido. Solo se permiten: portero, defensa, centrocampista, delantero.");
            }
        }
        return rol;
    }
}

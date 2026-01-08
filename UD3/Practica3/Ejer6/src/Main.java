import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static String[] especies = {"perro", "gato", "conejo", "loro", "tortuga"};
    static ArrayList<String> animalesRescatados = new ArrayList<>();
    static HashMap<String, String> cuidadores = new HashMap<>();
    static Queue<String> colaAdopcion = new LinkedList<>();

    public static void main(String[] args) {
        mostarMenu();

    }

    public static void mostarMenu() {
        System.out.println("a) Ver especies aceptadas. \n" +
                "b) Agregar un nuevo animal al listado de rescatados. \n" +
                "c) Asignar un cuidador a un animal. \n" +
                "d) Pasar un animal a la cola de espera de adopcion. \n" +
                "e) Adoptar un animal. \n" +
                "f ) Lista todos los animales y sus cuidadores actuales. \n" +
                "g) Salir");
        System.out.println("Seleccione una opcion: ");

        try {
            String opcion = sc.nextLine().toLowerCase();

            switch (opcion) {
                case "a":
                    verEspeciesAceptadas();
                    break;
                case "b":
                    agregarAnimalRescatado();
                    break;
                case "c":
                    asignarCuidador();
                    break;
                case "d":
                    pasarAColaAdopcion();
                    break;
                case "e":
                  /*  adoptarAnimal();
                    break;
                case "f":
                    listarAnimalesYCuidadores();
                    break;*/
                case "g":
                    boolean salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: tipo de entrada inválido. Intenta de nuevo.");
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }

    public static void verEspeciesAceptadas() {
        System.out.println("Ver especies aceptadas.");
        for (String especie : especies) {
            System.out.println(especie);
        }

        continuar();
    }

    public static void agregarAnimalRescatado() {
        try {
            System.out.print("Nombre del animal: ");
            String nombre = sc.nextLine();

            System.out.print("Especie: ");
            String especie = sc.nextLine().toLowerCase();

            boolean valida = false;
            for (String e : especies) {
                if (e.equals(especie)) {
                    valida = true;
                    break;
                }
            }

            if (valida) {
                animalesRescatados.add(nombre + "-" + especie);
                System.out.println("Animal agregado correctamente.");
            } else {
                System.out.println("Especie no aceptada.");
            }
        } catch (Exception e) {
            System.out.println("Error al agregar animal.");
        }
        continuar();
    }

    public static void asignarCuidador() {
        try {
            System.out.print("Nombre del animal: ");
            String animal = sc.nextLine();

            System.out.print("Nombre del cuidador: ");
            String cuidador = sc.nextLine();

            cuidadores.put(animal, cuidador);
            System.out.println("Cuidador asignado.");
        } catch (Exception e) {
            System.out.println("Error al asignar cuidador.");
        }
        continuar();
    }

    public static void pasarAColaAdopcion() {
        try {
            System.out.print("Nombre del animal: ");
            String nombre = sc.nextLine();

            String encontrado = null;
            for (String animal : animalesRescatados) {
                if (animal.startsWith(nombre + "-")) {
                    encontrado = animal;
                    break;
                }
            }

            if (encontrado != null) {
                animalesRescatados.remove(encontrado);
                colaAdopcion.add(nombre);
                System.out.println("Animal enviado a adopcion");
            } else  {
                System.out.println("Especie no aceptada.");
            }
        } catch (Exception e) {
            System.out.println("Error al enviar animal.");
        }
        continuar();
    }


    public static void continuar() {
        System.out.println("Quieres continuar (Si/No)");
        String continuar = sc.nextLine();

        if (continuar.equalsIgnoreCase("Si")) {
            mostarMenu();
        } else  {
            System.exit(0);
        }
    }
}
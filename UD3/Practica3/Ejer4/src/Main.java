import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Map<String, String> contactos = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu();
    }
    
    private static int mostrarMenu() {
        System.out.println("MENÚ");
        System.out.println("1.- Añadir un nuevo número");
        System.out.println("2.- Borrar un número");
        System.out.println("3.- Buscar un número");
        System.out.println("4.- Borrar por nombre");
        System.out.println("5.- Buscar por nombre");
        System.out.println("6.- Salir");
        System.out.print("Elige una opción: ");

        int opcion = sc.nextInt();
        sc.nextLine();

        try {
            switch (opcion) {
                case 1:
                    anadirContacto();
                    break;
                case 2:
                    borrarNumero();
                    break;
                case 3:
                    buscarNumero();
                    break;
                case 4:
                    borrarNombre();
                    break;
                case 5:
                    buscarNombre();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Debes ingresar un número del 1 al 6.");
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }

        return opcion;
    }

    private static int anadirContacto() {
        String nombre;
        String numero;

        while (true) {
            System.out.print("Nombre: ");
            nombre = sc.nextLine();
            if (nombre.matches("[a-zA-Z. ]+")) {
                break;
            } else {
                System.out.println("Nombre inválido. Intenta de nuevo.");
            }
        }

        while (true) {
            System.out.print("Número: ");
            numero = sc.nextLine();
            if (numero.matches("[0-9]{9}")) {
                break;
            } else {
                System.out.println("Número inválido. Intenta de nuevo.");
            }
        }
        Map<Integer,String > linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(Integer.valueOf(numero), nombre);
        System.out.println("Contacto añadido correctamente.");

        if (quiereContinuar()) {
            return anadirContacto();
        } else {
            return mostrarMenu();
        }
    }

    private static int borrarNumero() {
        System.out.print("Número a borrar: ");
        String numero = sc.nextLine();
        String claveBorrar = null;
        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            if (entry.getValue().equals(numero)) {
                claveBorrar = entry.getKey();
                break;
            }
        }
        if (claveBorrar != null) {
            contactos.remove(claveBorrar);
            System.out.println("Contacto borrado  correctamente.");
        } else {
            System.out.println("Número no encontrado.");
        }
        if (quiereContinuar()) {
            return borrarNumero();
        } else {
            return mostrarMenu();
        }
    }

    private static int buscarNumero() {
        System.out.print("Escribe el numero que desea buscar: ");
        String numero = sc.nextLine();
        String claveBuscar = null;

        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            if (entry.getValue().equals(numero)) {
                claveBuscar = entry.getKey();
                break;
            }
        }

        if (claveBuscar != null) {
            System.out.println("Contacto encontrado:\n" +
                            "Nombre: " + claveBuscar + "\n" +
                            "Número: " + numero);
        } else {
            System.out.println("Contacto no encontrado.");
        }

        if (quiereContinuar()) {
            return buscarNumero();
        } else {
            return mostrarMenu();
        }
    }

    private static int borrarNombre() {
        System.out.print("Nombre a borrar: ");
        String nombre = sc.nextLine();
        String valorBorrar = null;
        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            if (entry.getValue().equals(nombre)) {
                valorBorrar = entry.getKey();
                break;
            }
        }
        if (valorBorrar != null) {
            contactos.remove(valorBorrar);
            System.out.println("Contacto borrado correctamente.");
        } else {
            System.out.println("Nombre no encontrado.");
        }
        if (quiereContinuar()) {
            return borrarNombre();
        } else {
            return mostrarMenu();
        }
    }

    private static int buscarNombre() {
        System.out.print("Escribe el nombre que desea buscar: ");
        String nombre = sc.nextLine();
        String claveBuscar = null;

        for (Map.Entry<String, String> entry : contactos.entrySet()) {
            if (entry.getValue().equals(nombre)) {
                claveBuscar = entry.getKey();
                break;
            }
        }

        if (claveBuscar != null) {
            System.out.println("Contacto encontrado:\n" +
                    "Nombre: " + nombre + "\n" +
                    "Número: " + claveBuscar);
        } else {
            System.out.println("Contacto no encontrado.");
        }

        if (quiereContinuar()) {
            return buscarNumero();
        } else {
            return mostrarMenu();
        }
    }

    private static boolean quiereContinuar() {
        System.out.print("¿Quieres continuar con esta acción? (sí/no): ");
        String respuesta = sc.nextLine().toLowerCase();
        return respuesta.equals("sí") || respuesta.equals("si");
    }
}
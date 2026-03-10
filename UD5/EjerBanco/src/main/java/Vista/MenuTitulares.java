package Vista;
import java.util.List;
import java.util.Scanner;
import Controladores.*;
import Modelo.Titular;
import Utilidades.EntradaDatos;

public class MenuTitulares {

    private Scanner sc;

    private TitularController titularController;

    public MenuTitulares()
    {
        // Objeto Scanner para leer la entrada del usuario
        sc = new Scanner(System.in);
            /*
            Creación del controlador para manejar la lógica de negocio
            relacionada con los titulares.
             */
        titularController = new TitularController();
    }

    public void mostrarMenu()
    {
        int opcion;
        do
        {
            System.out.println("\n====== MENÚ BANCO (TITULARES)  ======");
            System.out.println("1. Crear titular");
            System.out.println("2. Modificar titular");
            System.out.println("3. Borrar titular");
            System.out.println("4. Listar titulares");
            System.out.println("5. Listar titulares por nombre");
            System.out.println("6. Buscar por ID");
            System.out.println("7. Buscar por DNI");
            System.out.println("0. Salir");
            System.out.println("========================");

            opcion = EntradaDatos.leerEntero(sc, "Elige opción: ");

            switch (opcion) {
                case 1 -> crearTitular();
                case 2 -> modificarTitular();
                case 3 -> borrarTitular();
                case 4 -> listarTitulares();
                case 5 -> listarPorNombre();
                case 6 -> buscarPorId();
                case 7 -> buscarPorDni();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida.");
            }
        } while (opcion != 0);
    }

    private void crearTitular()
    {
        System.out.println("\n--- CREAR TITULAR ---");
        try
        {
            // Solicitar el dni y el nombre del titular al usuario
            String dni = EntradaDatos.leerTexto(sc, "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
            if (dni != null) {
                // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
                String nombre = EntradaDatos.leerTexto(sc, "Introduce nombre: ", "^[A-Za-z ]+$");
                if (nombre != null) {
                    // Llamar al controlador para crear el titular
                    titularController.crearTitular(dni, nombre);
                    // Mensaje para que el usuario sepa que se ha creado correctamente
                    System.out.println("Titular creado correctamente.");
                }
            }
        }
        catch (Exception e)
        {
            // Mensaje para el usuario para que sepa que ha habido un error al crear el titular
            System.out.println("Problemas creando el titular");
        }

    }

    private void borrarTitular() {
        System.out.println("\n--- BORRAR TITULAR ---");
        try
        {
            // id o dni? Se puede hacer de las dos formas.
            int id = EntradaDatos.leerEntero(sc, "Introduce id del titular a borrar: ");
            if (id != -1)
            {
                // Si es -1, ya hemos mostrado un mensaje de error en la función leerEntero, así que no hace falta mostrar otro aquí.
                // LLamar al controlador para borrar el titular por ID
                int n= titularController.borrarTitular(id);
                if (n==1)
                {
                    // Mensaje para que el usuario sepa que se ha borrado correctamente
                    System.out.println("Titular borrado correctamente.");
                }
                else {
                    // Mensaje para el usuario para que sepa que no se ha encontrado el titular con el ID proporcionado
                    System.out.println("No se encontró ningún titular con el ID proporcionado.");
                }

            }

        }
        catch (Exception e)
        {
            // Mensaje para el usuario para que sepa que ha habido un error al borrar el titular
            System.out.println("Problemas borrando el titular");
        }
    }

    private Titular buscarPorDni() {
        System.out.println("\n--- BUSCAR TITULAR POR DNI ---");
        String dni = EntradaDatos.leerTexto(sc, "Introduce DNI: ", "^[0-9]{8}[A-Za-z]$");
        if (dni != null) {
            // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
            // Variable global?
            Titular titular = titularController.buscarPorDni(dni);
            if (titular != null) {
                System.out.println("Titular encontrado: " + titular);
            } else {
                System.out.println("No se encontró ningún titular con el DNI proporcionado.");
            }
            return titular;
            // Encontrado o no, no tiene porque ser un error por lo que no pongo try
        }
        return null;
    }

    private void listarPorNombre() {
        System.out.println("\n--- BUSCAR TITULAR POR NOMBRE ---");
        String nombre = EntradaDatos.leerTexto(sc, "Introduce nombre: ", "^[A-Za-z ]+$");
        if (nombre != null) {
            // Variable global?
            StringBuilder sb= titularController.buscarPorNombre(nombre);
            if (!sb.isEmpty()) {
                System.out.println(sb.toString());
            } else {
                System.out.println("No se encontró ningún titular con el nombre proporcionado.");
            }
        }
    }

    private Titular buscarPorId() {
        System.out.println("\n--- BUSCAR TITULAR POR ID ---");
        int id = EntradaDatos.leerEntero(sc, "Introduce ID: ");
        if (id != -1) {
            // Si es -1, ya hemos mostrado un mensaje de error en la función leerEntero, así que no hace falta mostrar otro aquí.
            // Variable global?
            Titular titular = titularController.buscarPorId(id);
            if (titular != null) {
                System.out.println("Titular encontrado: " + titular);
            } else {
                System.out.println("No se encontró ningún titular con el ID proporcionado.");
            }
            return titular;
        }
        return null;
    }


    private void modificarTitular() {
        System.out.println("\n--- MODIFICAR TITULAR ---");
        Titular titular = buscarPorDni();
        if (titular != null) {
            String nuevoNombre = EntradaDatos.leerTexto(sc, "Introduce nuevo nombre: ", "^[A-Za-z ]+$");
            if (nuevoNombre != null) {
                // Si es null, ya hemos mostrado un mensaje de error en la función leerTexto, así que no hace falta mostrar otro aquí.
                titularController.modificarTitular(titular, nuevoNombre);
                System.out.println("Titular modificado correctamente.");
            }
        }
    }

    private void listarTitulares() {
        System.out.println("\n--- LISTADO DE TITULARES ---");
        List<Titular> titulares = titularController.listarTitulares();

        if (titulares.isEmpty())
        {
            System.out.println("No hay titulares registrados.");
        } else
        {
            for (Titular t : titulares) {
                System.out.println(t);
            }
        }

        // Más puro
        System.out.println("\n--- LISTADO DE TITULARES (FORMA PURA) ---");
        StringBuilder sb = titularController.listarTitulares2();
        System.out.println(sb);
    }

}


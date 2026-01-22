import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Libro> libros = new ArrayList<>();
    private static List<Alumno> alumnos = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Autor autor1 = new Autor("Autor 1", LocalDate.of(1975, 5, 10), "Pais 1");
        Autor autor2 = new Autor("Autor 2", LocalDate.of(1980, 8, 20), "Pais 2");

        libros.add(new Libro("Libro 1", "Editorial 1", 120, autor1));
        libros.add(new Libro("Libro 2", "Editorial 2", 200, autor2));
        libros.add(new Libro("Libro 3", "Editorial 3", 150, autor1));

        alumnos.add(new Alumno("Alumno 1", LocalDate.of(2000, 3, 15), "Pais 1", "DNI1", new ArrayList<>()));
        alumnos.add(new Alumno("Alumno 2", LocalDate.of(1999, 7, 22), "Pais 2", "DNI2", new ArrayList<>()));

        boolean salir = false;

        do {
            System.out.println("Menu Biblioteca ---");
            System.out.println("1. Alquilar libro");
            System.out.println("2. Devolver libro");
            System.out.println("3. Ver datos disponibles");
            System.out.println("4. Salir");

            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    alquilarLibro();
                    break;
                case 2:
                    devolverLibro();
                    break;
                case 3:
                    verDatos();
                    break;
                case 4:
                    salir = true;
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
            }

        } while (!salir);
    }

    private static void alquilarLibro() {
        System.out.println("Selecciona un alumno por número:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + ". " + alumnos.get(i).getNombre());
        }
        int idxAlumno = sc.nextInt();
        Alumno alumno = alumnos.get(idxAlumno);

        System.out.println("Selecciona un libro por número:");
        for (int i = 0; i < libros.size(); i++) {
            Libro l = libros.get(i);
            System.out.println(i + ". " + l.getTitulo() + " (Ejemplares: " + l.getNumEjemplares() + ")");
        }
        int idxLibro = sc.nextInt();
        Libro libro = libros.get(idxLibro);

        if (alumno.getLibros().size() >= 2) {
            System.out.println("El alumno ya tiene 2 libros alquilados.");
        } else if (alumno.alquilarLibro(libro)) {
            System.out.println("Libro alquilado correctamente.");
        } else {
            System.out.println("No hay ejemplares disponibles para alquilar.");
        }
    }

    private static void devolverLibro() {
        System.out.println("Selecciona un alumno por número:");
        for (int i = 0; i < alumnos.size(); i++) {
            System.out.println(i + ". " + alumnos.get(i).getNombre());
        }
        int idxAlumno = sc.nextInt();
        Alumno alumno = alumnos.get(idxAlumno);

        if (alumno.getLibros().isEmpty()) {
            System.out.println("El alumno no tiene libros para devolver.");
            return;
        }

        System.out.println("Selecciona un libro a devolver:");
        for (int i = 0; i < alumno.getLibros().size(); i++) {
            System.out.println(i + ". " + alumno.getLibros().get(i).getTitulo());
        }
        int idxLibro = sc.nextInt();
        Libro libro = alumno.getLibros().get(idxLibro);

        if (alumno.devolverLibro(libro)) {
            System.out.println("Libro devuelto correctamente.");
        } else {
            System.out.println("Error al devolver el libro.");
        }
    }

    private static void verDatos() {
        System.out.println("Libros disponibles");
        for (Libro l : libros) {
            System.out.println(l.getTitulo() + " Autor: " + l.getAutor().getNombre() +
                    " (Ejemplares: " + l.getNumEjemplares() + ")");
        }

        System.out.println("Alumnos y libros alquilados");
        for (Alumno a : alumnos) {
            System.out.print(a.getNombre() + " - Libros alquilados: ");
            if (a.getLibros().isEmpty()) {
                System.out.println("Ninguno");
            } else {
                for (Libro l : a.getLibros()) {
                    System.out.print(l.getTitulo() + " ");
                }
                System.out.println();
            }
        }
    }
}

import java.time.LocalDate;
import java.util.ArrayList;

public class Alumno extends Persona {

    private String dni;
    private ArrayList<Libro> librosAlquilados;

    public Alumno(String nombre, LocalDate fechaNac, String paisNac, String dni, ArrayList<Libro> libros) {
        super(nombre, fechaNac, paisNac);
        this.dni = dni;
        librosAlquilados = libros;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public ArrayList<Libro> getLibros() {
        return librosAlquilados;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.librosAlquilados = libros;
    }

    public boolean alquilarLibro(Libro libro) {
        if (libro.alquilar()) {
            librosAlquilados.add(libro);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(Libro libro) {
        if (librosAlquilados.contains(libro)) {
            libro.devolver();
            librosAlquilados.remove(libro);
            return true;
        }
        return false;
    }

    public static void mostrarDatos (){

    }
}

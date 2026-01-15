import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class Main {

    static class Estudio {
        String nombre;
        String ciudad;
        String direccion;
        String web;
        String fechaFundacion;
        String pais;
        List<String> telefonos;
        List<Pelicula> peliculas;

        Estudio(String nombre, String ciudad, String direccion,
                String web, String fechaFundacion, String pais) {
            this.nombre = nombre;
            this.ciudad = ciudad;
            this.direccion = direccion;
            this.web = web;
            this.fechaFundacion = fechaFundacion;
            this.pais = pais;
            this.telefonos = new ArrayList<>();
            this.peliculas = new ArrayList<>();
        }

        void agregarPelicula(Pelicula pelicula) {
            if (!peliculas.contains(pelicula)) {
                peliculas.add(pelicula);
                pelicula.agregarEstudio(this);
            }
        }
    }

    static class Pelicula {
        String titulo;
        int año;
        int duracion;
        String tipo;
        List<Estudio> estudios;

        Pelicula(String titulo, int año, int duracion, String tipo) {
            this.titulo = titulo;
            this.año = año;
            this.duracion = duracion;
            this.tipo = tipo;
            this.estudios = new ArrayList<>();
        }

        void agregarEstudio(Estudio estudio) {
            if (!estudios.contains(estudio)) {
                estudios.add(estudio);
                estudio.agregarPelicula(this);
            }
        }
    }

    public static void main(String[] args) {
        Estudio estudio1 = new Estudio("Warner Bros", "Los Ángeles",
                "Sunset Boulevard", "www.warnerbros.com",
                "1923", "EE.UU.");
        Estudio estudio2 = new Estudio("Universal Studios", "Hollywood",
                "Universal City", "www.universal.com",
                "1912", "EE.UU.");

        Pelicula pelicula1 = new Pelicula("Película A", 2020, 120, "Acción");
        Pelicula pelicula2 = new Pelicula("Película B", 2019, 150, "Drama");
        Pelicula pelicula3 = new Pelicula("Película C", 2021, 90, "Comedia");
        Pelicula pelicula4 = new Pelicula("Pelicula D", 1998, 155, "Aventura");

        pelicula1.agregarEstudio(estudio1);
        pelicula2.agregarEstudio(estudio1);
        pelicula2.agregarEstudio(estudio2);
        pelicula3.agregarEstudio(estudio2);
        pelicula4.agregarEstudio(estudio2);

        List<Pelicula> peliculas = List.of(pelicula1, pelicula2, pelicula3);
        List<Estudio> estudios = List.of(estudio1, estudio2);

        Estudio estudioMasProductivo = Collections.max(estudios, Comparator.comparingInt(e -> e.peliculas.size()));
        System.out.println();
        System.out.println("Estudio que más películas ha producido:");
        System.out.println(estudioMasProductivo.nombre);
    }
}

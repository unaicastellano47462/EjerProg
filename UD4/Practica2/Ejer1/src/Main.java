import java.util.ArrayList;
import java.util.List;

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
    }

    static class Pelicula {
        String titulo;
        int anio;
        int duracion;
        String tipo;
        List<Estudio> estudios;

        Pelicula(String titulo, int anio, int duracion, String tipo) {
            this.titulo = titulo;
            this.anio = anio;
            this.duracion = duracion;
            this.tipo = tipo;
            this.estudios = new ArrayList<>();
        }
    }

    public static void main(String[] args) {

        Estudio estudio1 = new Estudio(
                "Warner Bros", "Los Ángeles",
                "Sunset Boulevard", "www.warnerbros.com",
                "1923", "EE.UU.");

        Estudio estudio2 = new Estudio(
                "Universal Studios", "Hollywood",
                "Universal City", "www.universal.com",
                "1912", "EE.UU.");

        Pelicula pelicula1 = new Pelicula("Película A", 2020, 120, "Acción");
        Pelicula pelicula2 = new Pelicula("Película B", 2019, 150, "Drama");
        Pelicula pelicula3 = new Pelicula("Película C", 2021, 90, "Comedia");

        pelicula1.estudios.add(estudio1);
        estudio1.peliculas.add(pelicula1);

        pelicula2.estudios.add(estudio1);
        pelicula2.estudios.add(estudio2);
        estudio1.peliculas.add(pelicula2);
        estudio2.peliculas.add(pelicula2);

        pelicula3.estudios.add(estudio2);
        estudio2.peliculas.add(pelicula3);

        List<Pelicula> peliculas = new ArrayList<>();
        peliculas.add(pelicula1);
        peliculas.add(pelicula2);
        peliculas.add(pelicula3);

        List<Estudio> estudios = new ArrayList<>();
        estudios.add(estudio1);
        estudios.add(estudio2);

        Pelicula peliculaMasLarga = peliculas.get(0);
        for (Pelicula p : peliculas) {
            if (p.duracion > peliculaMasLarga.duracion) {
                peliculaMasLarga = p;
            }
        }

        System.out.println("Película más larga: " + peliculaMasLarga.titulo);
        System.out.println("Estudios que la produjeron:");
        for (Estudio e : peliculaMasLarga.estudios) {
            System.out.println("- " + e.nombre);
        }

        Estudio estudioMasProductivo = estudios.get(0);
        for (Estudio e : estudios) {
            if (e.peliculas.size() > estudioMasProductivo.peliculas.size()) {
                estudioMasProductivo = e;
            }
        }

        System.out.println();
        System.out.println("Estudio que más películas ha producido:");
        System.out.println(estudioMasProductivo.nombre);
    }
}

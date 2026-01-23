import java.time.LocalDate;

public class Perro extends Mascota {
    public Perro(String raza, String nombre, LocalDate fechaNac, String sexo, double peso, double longitud, String tipoPelo, Cliente dueño, Veterinario veterinario) {
        super(raza, nombre, fechaNac, sexo, peso, longitud, tipoPelo, dueño, veterinario);
    }
}


import java.time.LocalDate;

public class Gato extends Mascota{
    public Gato(String raza, String nombre, LocalDate fechaNac, String sexo, double peso, double longitud, String tipoPelo, Cliente dueño, Veterinario veterinario) {
        super(raza, nombre, fechaNac, sexo, peso, longitud, tipoPelo, dueño, veterinario);
    }
}

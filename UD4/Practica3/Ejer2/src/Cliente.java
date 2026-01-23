import java.util.List;

public class Cliente extends Persona {
    private List<Mascota> mascotas;

    public Cliente(String nombre, String direccion, String telefono, List<Mascota> mascotas) {
        super(nombre, direccion, telefono);
        this.mascotas = mascotas;
    }

    public List<Mascota> getMascotas() { return mascotas; }

    public void agregarMascota(Mascota m) {
        mascotas.add(m);
    }
}

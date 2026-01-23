import java.util.List;

public class Veterinario extends Persona {
    private String dni;
    private int numSeguridadSocial;
    private List<Mascota> mascotas;

    public Veterinario(String nombre, String direccion, String telefono, String dni, int numSeguridadSocial, List<Mascota> mascotas) {
        super(nombre, direccion, telefono);
        this.dni = dni;
        this.numSeguridadSocial = numSeguridadSocial;
        this.mascotas = mascotas;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    public int getNumSeguridadSocial() {
        return numSeguridadSocial;
    }

    public void setNumSeguridadSocial(int numSeguridadSocial) {
        this.numSeguridadSocial = numSeguridadSocial;
    }
}

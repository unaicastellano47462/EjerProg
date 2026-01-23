import java.time.LocalDate;

public class Mascota {
    private String raza;
    private String nombre;
    private LocalDate fechaNac;
    private String sexo;
    private double peso;
    private double longitud;
    private String tipoPelo;
    private Cliente dueño;
    private Veterinario veterinario;

    public Mascota(String raza, String nombre, LocalDate fechaNac, String sexo, double peso, double longitud, String tipoPelo, Cliente dueño, Veterinario veterinario) {
        this.raza = raza;
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.sexo = sexo;
        this.peso = peso;
        this.longitud = longitud;
        this.tipoPelo = tipoPelo;
        this.dueño = dueño;
        this.veterinario = veterinario;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public String getTipoPelo() {
        return tipoPelo;
    }

    public void setTipoPelo(String tipoPelo) {
        this.tipoPelo = tipoPelo;
    }

    public Cliente getDueño() {
        return dueño;
    }

    public void setDueño(Cliente dueño) {
        this.dueño = dueño;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }
}

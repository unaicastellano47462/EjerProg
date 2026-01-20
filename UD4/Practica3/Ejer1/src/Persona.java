import java.time.LocalDate;

public class Persona {
    private String nombre;
    private LocalDate fechaNac;
    private String paisNac;

    public Persona(String nombre, LocalDate fechaNac, String paisNac) {
        this.nombre = nombre;
        this.fechaNac = fechaNac;
        this.paisNac = paisNac;
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

    public String getPaisNac() {
        return paisNac;
    }

    public void setPaisNac(String paisNac) {
        this.paisNac = paisNac;
    }
}

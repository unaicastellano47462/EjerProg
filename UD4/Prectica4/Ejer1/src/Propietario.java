import java.util.List;

public class Propietario {
    private String nombre;
    private List<Coche> coches;

    public Propietario(String nombre, List<Coche> coches) {
        this.nombre = nombre;
        this.coches = coches;
    }

    public String getNombre() { return nombre; }
    public List<Coche> getCoches() { return coches; }
}
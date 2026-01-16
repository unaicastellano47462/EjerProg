import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String nombre;
    private List<Empleado> empleados;
    private List<Cliente> clientes;

    public Empresa(String nombre) {
        this.nombre = nombre;
        empleados = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado e) {
        empleados.add(e);
    }

    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    public Directivo directivoConMasSubordinados() {
        Directivo max = null;
        int mayor = -1;

        for (Empleado e : empleados) {
            if (e instanceof Directivo) {
                Directivo d = (Directivo) e;
                if (d.getNumeroSubordinados() > mayor) {
                    mayor = d.getNumeroSubordinados();
                    max = d;
                }
            }
        }
        return max;
    }
}

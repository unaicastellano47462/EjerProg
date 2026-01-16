import java.util.ArrayList;
import java.util.List;

public class Empleado extends Persona {

    protected int sueldoBruto;
    protected List<Empleado> subordinados;

    public Empleado(String nombre, int edad, int sueldoBruto) {
        super(nombre, edad);
        this.sueldoBruto = sueldoBruto;
        this.subordinados = new ArrayList<>();
    }

    public void agregarSubordinado(Empleado e) {
        this.subordinados.add(e);
    }

    public int calcularSalario() {
        return sueldoBruto;
    }

    public int getNumeroSubordinados() {
        return subordinados.size();
    }

    @Override
    public String toString() {
        return "Empleado " +
                "sueldoBruto: " + sueldoBruto +
                ", subordinados: " + subordinados;
    }
}

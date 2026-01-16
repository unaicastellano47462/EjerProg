public class Directivo extends Empleado {
    private String categoria;

    public Directivo(String nombre, int edad, int sueldoBruto, String categoria) {
        super(nombre, edad, sueldoBruto);
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Directivo " +
                "categoria: '" + categoria;
    }
}


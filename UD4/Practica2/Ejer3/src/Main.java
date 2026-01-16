public class Main {
    public static void main(String[] args) {

        Empresa empresa = new Empresa("TechSoft");

        Directivo d1 = new Directivo("Unai", 45, 41000, "Alta");
        Directivo d2 = new Directivo("Aritz", 50, 20000, "Media");

        Empleado e1 = new Empleado("Urtzi", 30, 120);
        Empleado e2 = new Empleado("Josu", 28, 500);
        Empleado e3 = new Empleado("Ibai", 35, 510);

        d1.agregarSubordinado(e1);
        d1.agregarSubordinado(e2);
        d2.agregarSubordinado(e3);

        empresa.agregarEmpleado(d1);
        empresa.agregarEmpleado(d2);
        empresa.agregarEmpleado(e1);
        empresa.agregarEmpleado(e2);
        empresa.agregarEmpleado(e3);

        Directivo resultado = empresa.directivoConMasSubordinados();
        System.out.println("Directivo con más subordinados: " + resultado.getNombre());
    }
}

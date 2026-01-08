public class Circunferencia extends Figura {

    public Circunferencia(double radio) {
        super(radio);
    }

    public double calcularCircunferencia() {
        return 2 * PI * radio;
    }

    public double calcularArea() {
        return PI * radio * radio;
    }
}


public class Esfera extends Figura {

    public Esfera(double radio) {
        super(radio);
    }

    public double calcularVolumen() {
        return (4 * PI * radio * radio * radio) / 3;
    }
}

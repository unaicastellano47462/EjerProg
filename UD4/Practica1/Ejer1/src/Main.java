import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el radio: ");
        double radio = sc.nextDouble();

        Circunferencia circulo = new Circunferencia(radio);
        Esfera esfera = new Esfera(radio);

        System.out.println("Longitud de la circunferencia: " + circulo.calcularCircunferencia());
        System.out.println("Área del círculo: " + circulo.calcularArea());
        System.out.println("Volumen de la esfera: " + esfera.calcularVolumen());
    }
}

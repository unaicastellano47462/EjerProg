
public class Coche {
    private String matricula;
    private String marca;
    private int ano;
    private double precio;

    public Coche(String matricula, String marca, int ano, double precio) {
        this.matricula = matricula;
        this.marca = marca;
        this.ano = ano;
        this.precio = precio;
    }

    public String getMatricula() { return matricula; }
    public String getMarca() { return marca; }
    public int getAno() { return ano; }
    public double getPrecio() { return precio; }
}
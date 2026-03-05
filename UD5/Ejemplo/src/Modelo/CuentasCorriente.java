package Modelo;

public class CuentasCorriente {
    //Añadir id integer, iban varchar(24), saldo double

    private int id;
    private String iban;
    private double saldo;

    public CuentasCorriente() {
    }

    public CuentasCorriente(int id, String iban, double saldo) {
        this.id = id;
        this.iban = iban;
        this.saldo = saldo;
    }

    public CuentasCorriente(String iban, double saldo) {
        this.iban = iban;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentasCorriente{" +
                "id=" + id +
                ", iban='" + iban + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}

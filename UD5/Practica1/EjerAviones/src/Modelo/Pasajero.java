package Modelo;

public class Pasajero {
    private String DNI;
    private String nombre;
    private int telefono;
    private String cod_vuelo;

    public Pasajero() {
    }

    public Pasajero(String DNI, String nombre, int telefono, String cod_vuelo) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cod_vuelo = cod_vuelo;
    }

    public Pasajero(String nombre, int telefono, String cod_vuelo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.cod_vuelo = cod_vuelo;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCod_vuelo() {
        return cod_vuelo;
    }

    public void setCod_vuelo(String cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "DNI='" + DNI + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", cod_vuelo='" + cod_vuelo + '\'' +
                '}';
    }
}

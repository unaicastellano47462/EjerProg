package Modelo;

public class Pasajero {
    private String dni;
    private String nombre;
    private String telefono;
    private String cod_vuelo;

    public Pasajero(String dni, String nombre, String telefono, String cod_vuelo) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.cod_vuelo = cod_vuelo;
    }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCod_vuelo() { return cod_vuelo; }
    public void setCod_vuelo(String cod_vuelo) { this.cod_vuelo = cod_vuelo; }

    @Override
    public String toString() {
        return "Pasajero{" +
                "DNI='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", vuelo='" + cod_vuelo + '\'' +
                '}';
    }
}
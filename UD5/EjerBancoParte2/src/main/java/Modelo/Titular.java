package Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "titulares")
public class Titular {
    @Id
    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "iban", nullable = false)
    private Cuenta iban;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Cuenta getIban() {
        return iban;
    }

    public void setIban(Cuenta iban) {
        this.iban = iban;
    }

    public Titular() {
    }

    public Titular(String nombre, Cuenta iban) {
        this.nombre = nombre;
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Titular{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", iban=" + iban +
                '}';
    }
}
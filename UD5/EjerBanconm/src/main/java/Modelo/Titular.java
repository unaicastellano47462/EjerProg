package Modelo;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "titulares")
public class Titular {
    @Id
    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @ManyToMany(mappedBy = "titulares", fetch = FetchType.LAZY)
    private Set<Cuenta> cuentas = new LinkedHashSet<>();

    public Titular() {}

    public Titular(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Set<Cuenta> getCuentas() { return cuentas; }
    public void setCuentas(Set<Cuenta> cuentas) { this.cuentas = cuentas; }

    @Override
    public String toString() {
        return "Titular{dni='" + dni + "', nombre='" + nombre + "'}";
    }
}
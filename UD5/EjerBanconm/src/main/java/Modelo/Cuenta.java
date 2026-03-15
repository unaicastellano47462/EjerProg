package Modelo;

import jakarta.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "cuentas")
public class Cuenta {
    @Id
    @Column(name = "iban", nullable = false, length = 24)
    private String iban;

    @Column(name = "saldo", nullable = false)
    private Double saldo;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "cuentas_titulares",
            joinColumns = @JoinColumn(name = "iban"),
            inverseJoinColumns = @JoinColumn(name = "dni"))
    private Set<Titular> titulares = new LinkedHashSet<>();

    public Cuenta() {}

    public Cuenta(Double saldo) {
        this.saldo = saldo;
    }

    public String getIban() { return iban; }
    public void setIban(String iban) { this.iban = iban; }
    public Double getSaldo() { return saldo; }
    public void setSaldo(Double saldo) { this.saldo = saldo; }
    public Set<Titular> getTitulares() { return titulares; }
    public void setTitulares(Set<Titular> titulares) { this.titulares = titulares; }

    @Override
    public String toString() {
        return "Cuenta{iban='" + iban + "', saldo=" + saldo + '}';
    }
}
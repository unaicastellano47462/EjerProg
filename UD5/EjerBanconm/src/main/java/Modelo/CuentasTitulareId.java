package Modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import org.hibernate.Hibernate;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CuentasTitulareId implements Serializable {
    private static final long serialVersionUID =-4165202341651596556L;

    @Column(name = "dni", nullable = false, length = 50)
    private String dni;

    @Column(name = "iban", nullable = false, length = 50)
    private String iban;

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CuentasTitulareId entity = (CuentasTitulareId) o;
        return Objects.equals(this.iban, entity.iban) &&
                Objects.equals(this.dni, entity.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, dni);
    }

}
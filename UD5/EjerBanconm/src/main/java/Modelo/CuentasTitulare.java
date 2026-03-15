package Modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "cuentas_titulares")
public class CuentasTitulare {
    @EmbeddedId
    private CuentasTitulareId id;

    @MapsId("dni")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dni", nullable = false)
    private Titular dni;

    @MapsId("iban")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iban", nullable = false)
    private Cuenta iban;

    public CuentasTitulareId getId() {
        return id;
    }

    public void setId(CuentasTitulareId id) {
        this.id = id;
    }

    public Titular getDni() {
        return dni;
    }

    public void setDni(Titular dni) {
        this.dni = dni;
    }

    public Cuenta getIban() {
        return iban;
    }

    public void setIban(Cuenta iban) {
        this.iban = iban;
    }

}
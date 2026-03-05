package Modelo;

public class CuentaTitular {
    private int idCuenta;
    private int idTitular;

    public CuentaTitular(int idCuenta, int idTitular) {
        this.idCuenta = idCuenta;
        this.idTitular = idTitular;
    }

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public int getIdTitular() {
        return idTitular;
    }

    public void setIdTitular(int idTitular) {
        this.idTitular = idTitular;
    }
}

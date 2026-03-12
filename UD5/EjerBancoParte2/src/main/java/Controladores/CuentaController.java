package Controladores;

import DAO.CuentaDAO;
import Modelo.Cuenta;

import java.util.List;

public class CuentaController {

    private CuentaDAO cuentaDAO;

    public CuentaController() {
        cuentaDAO = new CuentaDAO();
    }

    public void crearCuenta(String iban, Double saldoInicial) throws Exception {
        if (cuentaDAO.buscarPorIban(iban) != null) {
            throw new Exception("El IBAN ya existe.");
        }

        Cuenta nuevaCuenta = new Cuenta(saldoInicial);
        nuevaCuenta.setIban(iban);
        cuentaDAO.insertar(nuevaCuenta);
    }

    public StringBuilder listarCuentas() {
        List<Cuenta> lista = cuentaDAO.listarTodas();
        StringBuilder sb = new StringBuilder();
        for (Cuenta c : lista) {
            sb.append(c.toString()).append("\n");
        }
        return sb;
    }
}
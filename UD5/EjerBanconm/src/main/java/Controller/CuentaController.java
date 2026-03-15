package Controller;

import DAO.CuentaDAO;
import DAO.TitularCuentaDAO;
import Modelo.Cuenta;
import java.util.List;

public class CuentaController {
    private CuentaDAO cuentaDAO;
    private TitularCuentaDAO titularCuentaDAO;

    public CuentaController() {
        cuentaDAO = new CuentaDAO();
        titularCuentaDAO = new TitularCuentaDAO();
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

    public StringBuilder listarCuentasDeUnTitular(String dni) {
        List<Cuenta> lista = cuentaDAO.buscarCuentasPorDniTitular(dni);
        StringBuilder sb = new StringBuilder();

        if (lista.isEmpty()) {
            sb.append("No se encontraron cuentas para el DNI: ").append(dni).append("\n");
        } else {
            for (Cuenta c : lista) {
                sb.append(c.toString()).append("\n");
            }
        }
        return sb;
    }

    public void vincularTitularACuenta(String iban, String dni) throws Exception {
        titularCuentaDAO.asociarTitularACuenta(iban, dni);
    }
}
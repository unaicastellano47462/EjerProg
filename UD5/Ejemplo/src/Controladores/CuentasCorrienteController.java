package Controladores;

import Modelo.*;
import DAO.*;

import java.util.List;

public class CuentasCorrienteController {

    private CuentasCorrienteDAO cuentasCorrienteDAO;

    public CuentasCorrienteController() { cuentasCorrienteDAO = new CuentasCorrienteDAO();}

    public void crearCuentaCorriente(String iban, double saldo) {
        CuentasCorriente cuenta = new CuentasCorriente(iban, saldo);
        cuentasCorrienteDAO.insertar(cuenta);
    }

    public int borrarCuentaCorriente(int id) throws Exception {
        // Implementar método para borrar cuenta corriente por ID
        return cuentasCorrienteDAO.borrar(id);
    }

    public void modificarCuentaCorriente(CuentasCorriente cuenta, String nuevoIban) {
        // Implementar método para modificar cuenta corriente por ID
        cuenta.setIban(nuevoIban);
        cuentasCorrienteDAO.modificar(cuenta);
    }

    public CuentasCorriente buscarPorIban(String iban) {
        return cuentasCorrienteDAO.buscarPorIban(iban);
    }

    public List<CuentasCorriente> listarCuentasCorriente() {
        return cuentasCorrienteDAO.listarTodos();
    }

    public StringBuilder listarCuentasCorriente2() {
        // Más puro
        List<CuentasCorriente> lista = cuentasCorrienteDAO.listarTodos();
        StringBuilder sb = new StringBuilder();
        for (CuentasCorriente c : lista) {
            sb.append(c.toString()).append("\n");
        }
        return sb;
    }

    public StringBuilder buscarPorSaldo(double saldo) {
        // Más puro
        List<CuentasCorriente> lista = cuentasCorrienteDAO.buscarPorSaldo(saldo);
        StringBuilder sb = new StringBuilder();
        for (CuentasCorriente c : lista) {
            sb.append(c.toString()).append("\n");
        }
        return sb;
    }

    public CuentasCorriente buscarPorId(int id) {
        return cuentasCorrienteDAO.buscarPorId(id);
        // return cuentasCorrienteDAO.buscarPorId(id).toString();
    }
}

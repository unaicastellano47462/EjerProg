package Controladores;

import DAO.CuentaDAO;
import DAO.TitularDAO;
import Modelo.Cuenta;
import Modelo.Titular;
import java.util.List;

public class TitularController {

    private TitularDAO titularDAO;
    private CuentaDAO cuentaDAO;

    public TitularController() {
        titularDAO = new TitularDAO();
        cuentaDAO = new CuentaDAO();
    }

    public void crearTitular(String dni, String nombre, String ibanStr) throws Exception {
        Cuenta cuenta = cuentaDAO.buscarPorIban(ibanStr);

        if (cuenta == null) {
            cuenta = new Cuenta(0.0);
            cuenta.setIban(ibanStr);
        }

        Titular titular = new Titular(nombre, cuenta);
        titular.setDni(dni);

        titularDAO.insertar(titular);
    }

    public Titular buscarPorDni(String dni) {
        return titularDAO.buscarPorDni(dni);
    }

    public void modificarTitular(Titular titular, String nuevoNombre) {
        titular.setNombre(nuevoNombre);
        titularDAO.modificar(titular);
    }

    public void borrarTitular(String dni) throws Exception {
        titularDAO.borrar(dni);
    }

    public StringBuilder listarTitulares() {
        List<Titular> lista = titularDAO.listarTodos();
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append("DNI: ").append(t.getDni())
                    .append(" | Nombre: ").append(t.getNombre())
                    .append(" | IBAN: ").append(t.getIban().getIban())
                    .append(" | Saldo: ").append(t.getIban().getSaldo()).append("€\n");
        }
        return sb;
    }

    public StringBuilder buscarPorNombre(String nombre) {
        List<Titular> lista = titularDAO.buscarPorNombre(nombre);
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append("DNI: ").append(t.getDni())
                    .append(" | Nombre: ").append(t.getNombre())
                    .append("\n");
        }
        return sb;
    }
}
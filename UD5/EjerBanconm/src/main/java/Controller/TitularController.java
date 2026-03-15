package Controller;

import DAO.TitularDAO;
import Modelo.Titular;
import java.util.List;

public class TitularController {
    private TitularDAO titularDAO;

    public TitularController() {
        titularDAO = new TitularDAO();
    }

    public void crearTitular(String dni, String nombre) throws Exception {
        if(titularDAO.buscarPorDni(dni) != null) {
            throw new Exception("El DNI ya existe.");
        }
        Titular titular = new Titular(dni, nombre);
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
                    .append(" | Nombre: ").append(t.getNombre()).append("\n");
        }
        return sb;
    }

    public StringBuilder buscarPorNombre(String nombre) {
        List<Titular> lista = titularDAO.buscarPorNombre(nombre);
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append("DNI: ").append(t.getDni())
                    .append(" | Nombre: ").append(t.getNombre()).append("\n");
        }
        return sb;
    }
}
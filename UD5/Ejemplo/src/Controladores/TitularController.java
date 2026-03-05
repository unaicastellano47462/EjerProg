package Controladores;

import Modelo.*;
import DAO.*;

import java.util.List;

public class TitularController {

    private TitularDAO titularDAO;

    public TitularController() {
        titularDAO = new TitularDAO();
    }

    public void crearTitular(String dni, String nombre) {
        Titular titular = new Titular(dni, nombre);
        titularDAO.insertar(titular);
    }

    public int borrarTitular(int id) throws Exception{
        // Implementar método para borrar titular por ID
        return titularDAO.borrar(id);
    }

    public void modificarTitular(Titular titular, String nuevoNombre) {
        // Implementar método para modificar titular por ID
        titular.setNombre(nuevoNombre);
        titularDAO.modificar(titular);
    }

    public Titular buscarPorDni(String dni) {
        return titularDAO.buscarPorDni(dni);
    }

    public List<Titular> listarTitulares() {

        return titularDAO.listarTodos();
    }

    public StringBuilder listarTitulares2()
    {
        // Más puro
        List<Titular> lista = titularDAO.listarTodos();
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }

    public StringBuilder buscarPorNombre(String nombre)
    {
        // Más puro
        List<Titular> lista = titularDAO.buscarPorNombre(nombre);
        StringBuilder sb = new StringBuilder();
        for (Titular t : lista) {
            sb.append(t.toString()).append("\n");
        }
        return sb;
    }

    public Titular buscarPorId(int id) {

        return titularDAO.buscarPorId(id);
        // return titularDAO.buscarPorId(id).toString();
    }
}


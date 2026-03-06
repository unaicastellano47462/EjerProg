package Controlador;

import DAO.PasajeroDAO;
import Modelo.Pasajero;

import java.util.List;

public class PasajeroController {

    private PasajeroDAO pasajeroDAO;

    public PasajeroController() {
        pasajeroDAO = new PasajeroDAO();
    }

    public boolean crearPasajero(String dni, String nombre, String telefono, String cod_vuelo) {
        Pasajero pasajero = new Pasajero(dni, nombre, telefono, cod_vuelo);
        return pasajeroDAO.insertar(pasajero);
    }

    public int borrarPasajero(String dni) throws Exception {
        return pasajeroDAO.borrar(dni);
    }

    public boolean modificarPasajero(Pasajero pasajero, String nuevoNombre, String nuevoTelefono, String nuevoVuelo) {
        pasajero.setNombre(nuevoNombre);
        pasajero.setTelefono(nuevoTelefono);
        pasajero.setCod_vuelo(nuevoVuelo);
        return pasajeroDAO.modificar(pasajero);
    }

    public Pasajero buscarPorDni(String dni) {
        return pasajeroDAO.buscarPorDni(dni);
    }

    public List<Pasajero> buscarPorVuelo(String cod_vuelo) {
        return pasajeroDAO.buscarPorVuelo(cod_vuelo);
    }

    public List<Pasajero> listarPasajeros() {
        return pasajeroDAO.listarTodos();
    }
}
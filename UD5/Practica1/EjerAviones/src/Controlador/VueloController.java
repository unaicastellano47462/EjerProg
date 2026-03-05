package Controlador;

import DAO.*;
import Modelo.Vuelo;

import java.util.Date;
import java.util.List;

public class VueloController {

    private VueloDAO vueloDAO;

    public VueloController() { vueloDAO = new VueloDAO(); }

    public void crearVuelo(Date fecha_salida, String destino, String procedencia) {
        Vuelo vuelo = new Vuelo(fecha_salida, destino, procedencia);
        vueloDAO.insertar(vuelo);
    }

    public int borrarVuelo(int cod_vuelo) throws Exception {
        // Implementar método para borrar vuelo por código
        return vueloDAO.borrar(cod_vuelo);
    }

    public void modificarVuelo(Vuelo vuelo, Date nuevaFecha, String nuevoDestino, String nuevaProcedencia) {
        // Implementar método para modificar vuelo por código
        vuelo.setFecha_salida(nuevaFecha);
        vuelo.setDestino(nuevoDestino);
        vuelo.setProcedencia(nuevaProcedencia);
        vueloDAO.modificar(vuelo);
    }
    public Vuelo buscarPorCodigo(int cod_vuelo) {
        return vueloDAO.buscarPorCodigo(cod_vuelo);
    }

    public Vuelo buscarPorDestino(String destino) {
        return vueloDAO.buscarPorDestino(destino);
    }

    public Vuelo buscarPorProcedencia(String procedencia) {
        return vueloDAO.buscarPorProcedencia(procedencia);
    }

    public StringBuilder buscarPorFecha(Date fecha_salida) {
        List<Vuelo> vuelos = vueloDAO.buscarPorFecha((java.sql.Date) fecha_salida);
        StringBuilder sb = new StringBuilder();
        for (Vuelo v : vuelos) {
            sb.append(v.toString()).append("\n");
        }
        return sb;
    }

    public List<Vuelo> listarVuelos() {
        return vueloDAO.listarTodos();
    }
}

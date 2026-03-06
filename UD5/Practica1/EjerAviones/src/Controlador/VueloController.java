package Controlador;

import DAO.VueloDAO;
import Modelo.Vuelo;

import java.util.Date;
import java.util.List;

public class VueloController {

    private VueloDAO vueloDAO;

    public VueloController() { vueloDAO = new VueloDAO(); }

    private String generarNuevoCodigo() {
        String ultimoCodigo = vueloDAO.obtenerUltimoCodigo();

        if (ultimoCodigo == null || ultimoCodigo.isEmpty()) {
            return "AEA1-00001";
        } else {
            try {
                String[] partes = ultimoCodigo.split("-");
                int numero = Integer.parseInt(partes[1]);
                numero++;
                return String.format("AEA1-%05d", numero);
            } catch (Exception e) {
                return "AEA1-00001";
            }
        }
    }

    public String crearVuelo(Date fecha_salida, String destino, String procedencia) {
        String nuevoCodigo = generarNuevoCodigo();
        Vuelo vuelo = new Vuelo(nuevoCodigo, fecha_salida, destino, procedencia);

        if (vueloDAO.insertar(vuelo)) {
            return nuevoCodigo;
        }
        return null;
    }

    public int borrarVuelo(String cod_vuelo) throws Exception {
        return vueloDAO.borrar(cod_vuelo);
    }

    public boolean modificarVuelo(Vuelo vuelo, Date nuevaFecha, String nuevoDestino, String nuevaProcedencia) {
        vuelo.setFecha_salida(nuevaFecha);
        vuelo.setDestino(nuevoDestino);
        vuelo.setProcedencia(nuevaProcedencia);
        return vueloDAO.modificar(vuelo);
    }

    public Vuelo buscarPorCodigo(String cod_vuelo) {
        return vueloDAO.buscarPorCodigo(cod_vuelo);
    }

    public Vuelo buscarPorDestino(String destino) {
        return vueloDAO.buscarPorDestino(destino);
    }

    public Vuelo buscarPorProcedencia(String procedencia) {
        return vueloDAO.buscarPorProcedencia(procedencia);
    }

    public List<Vuelo> listarPorFecha() {
        return vueloDAO.listarPorFecha();
    }

    public List<Vuelo> listarVuelos() {
        return vueloDAO.listarTodos();
    }
}
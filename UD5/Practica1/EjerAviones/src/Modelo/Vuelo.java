package Modelo;

import java.util.Date;

public class Vuelo {
    private int cod_vuelo;
    private Date fecha_salida;
    private String destino;
    private String procedencia;

    public Vuelo() {
    }

    public Vuelo(int cod_vuelo, Date fecha_salida, String destino, String procedencia) {
        this.cod_vuelo = cod_vuelo;
        this.fecha_salida = fecha_salida;
        this.destino = destino;
        this.procedencia = procedencia;
    }

    public Vuelo(Date fecha_salida, String destino, String procedencia) {
        this.fecha_salida = fecha_salida;
        this.destino = destino;
        this.procedencia = procedencia;
    }

    public int getCod_vuelo() {
        return cod_vuelo;
    }

    public void setCod_vuelo(int cod_vuelo) {
        this.cod_vuelo = cod_vuelo;
    }

    public Date getFecha_salida() {
        return fecha_salida;
    }

    public void setFecha_salida(Date fecha_salida) {
        this.fecha_salida = fecha_salida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getProcedencia() {
        return procedencia;
    }

    public void setProcedencia(String procedencia) {
        this.procedencia = procedencia;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "cod_vuelo=" + cod_vuelo +
                ", fecha_salida=" + fecha_salida +
                ", destino='" + destino + '\'' +
                ", procedencia='" + procedencia + '\'' +
                '}';
    }
}

package mundo;

import java.util.LinkedList;
import java.util.Date;

public class Vuelo {
    private String codigoVuelo;
    private String salida;
    private String llegada;
    private Date fecha;
    private LinkedList<Asiento> asientos;

    public Vuelo(String codigoVuelo, String salida, String llegada, Date fecha, int cantidadAsientos) {
        this.codigoVuelo = codigoVuelo;
        this.salida = salida;
        this.llegada = llegada;
        this.fecha = fecha;
        this.asientos = new LinkedList<>();
        for (int i = 1; i <= cantidadAsientos; i++) {
            asientos.add(new Asiento(i));
        }
    }

    // Getters y Setters
    public String getCodigoVuelo() { return codigoVuelo; }
    public String getSalida() { return salida; }
    public String getLlegada() { return llegada; }
    public Date getFecha() { return fecha; }
    public LinkedList<Asiento> getAsientos() { return asientos; }

    public void setCodigoVuelo(String codigoVuelo) { this.codigoVuelo = codigoVuelo; }
    public void setSalida(String salida) { this.salida = salida; }
    public void setLlegada(String llegada) { this.llegada = llegada; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
}

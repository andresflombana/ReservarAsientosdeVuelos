package mundo;

import java.util.ArrayList;
import java.util.Date;

public class AdministradorVuelos {
    private ArrayList<Vuelo> vuelos;

    public AdministradorVuelos() {
        vuelos = new ArrayList<>();
    }

    public void agregarVuelo(Vuelo vuelo) {
        vuelos.add(vuelo);
    }

    public ArrayList<Vuelo> obtenerVuelos() {
        return vuelos;
    }

    public Vuelo obtenerVuelo(String codigoVuelo) {
        for (Vuelo vuelo : vuelos) {
            if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                return vuelo;
            }
        }
        return null;
    }

    public void eliminarVuelo(String codigoVuelo) {
        vuelos.removeIf(vuelo -> vuelo.getCodigoVuelo().equals(codigoVuelo));
    }

    public void actualizarVuelo(String codigoVuelo, String nuevoCodigoVuelo, String salida, String llegada, Date fecha, int nuevaCantidadAsientos) {
        Vuelo vuelo = obtenerVuelo(codigoVuelo);
        if (vuelo != null) {
            vuelo.setCodigoVuelo(nuevoCodigoVuelo);
            vuelo.setSalida(salida);
            vuelo.setLlegada(llegada);
            vuelo.setFecha(fecha);
        }
    }
}

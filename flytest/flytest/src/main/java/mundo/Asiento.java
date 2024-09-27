package mundo;

public class Asiento {
    private int numero;
    private boolean reservado;
    private String nombrePasajero;

    public Asiento(int numero) {
        this.numero = numero;
        this.reservado = false;
        this.nombrePasajero = "";
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    // Getters y Setters
    public int getNumero() { return numero; }
    public boolean isReservado() { return reservado; }
    public String getNombrePasajero() { return nombrePasajero; }

    public void reservar(String nombrePasajero) {
        this.reservado = true;
        this.nombrePasajero = nombrePasajero;
    }

    public void liberar() {
        this.reservado = false;
        this.nombrePasajero = "";
    }
}

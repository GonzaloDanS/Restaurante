package entidades;

public class Mesa {

    private int idMesa;
    private int numero;
    private boolean estadoMesa;
    private boolean libre;
    private int capacidad;

    public Mesa(int idMesa, int numero, boolean estadoMesa, boolean libre, int capacidad) {
        this.idMesa = idMesa;
        this.numero = numero;
        this.estadoMesa = estadoMesa;
        this.libre = libre;
        this.capacidad = capacidad;
    }

    public Mesa() {

    }

    public Mesa(int numero, boolean estadoMesa, boolean libre, int capacidad) {
        this.numero = numero;
        this.estadoMesa = estadoMesa;
        this.libre = libre;
        this.capacidad = capacidad;
    }

    public boolean isLibre() {
        return libre;
    }

    public void setLibre(boolean libre) {
        this.libre = libre;
    }

    
    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstadoMesa() {
        return estadoMesa;
    }

    public void setEstadoMesa(boolean estadoMesa) {
        this.estadoMesa = estadoMesa;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "idMesa = " + idMesa + " - numero = " + numero + " - estadoMesa = " + estadoMesa + " - libre = "+ libre +" - capacidad = " + capacidad;
    }

}

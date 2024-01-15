package entidades;

import java.time.LocalDateTime;

public class Pedido {
    
    private int idPedido;
    private int idMesa;
    private int idMesero;
    private LocalDateTime fechaHora;
    private double importe;
    private boolean cobrada;
    
    public Pedido(){};
    
    public Pedido(int idPedido, int idMesa, int nombreMesero, LocalDateTime fechaHora, double importe, boolean cobrada) {
        this.idPedido = idPedido;
        this.idMesa = idMesa;
        this.idMesero = nombreMesero;
        this.fechaHora = fechaHora;
        this.importe = importe;
        this.cobrada = cobrada;
    }

    public Pedido(int idMesa, int nombreMesero, LocalDateTime fechaHora, double importe, boolean cobrada) {
        this.idMesa = idMesa;
        this.idMesero = nombreMesero;
        this.fechaHora = fechaHora;
        this.importe = importe;
        this.cobrada = cobrada;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public int getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(int idMesa) {
        this.idMesa = idMesa;
    }

    public int getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(int idMesero) {
        this.idMesero = idMesero;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean isCobrada() {
        return cobrada;
    }

    public void setCobrada(boolean cobrada) {
        this.cobrada = cobrada;
    }

    @Override
    public String toString() {
        return " " + "ID Pedido: " + idPedido + "||ID Mesa: " + idMesa + "||Nombre del Mesero: " + idMesero + "||Fecha & Hora: " + fechaHora + "||Importe: " + importe + "||Cobrada: " + cobrada + "\n"+' ';
    }
    
        
}

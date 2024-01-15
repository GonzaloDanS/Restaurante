package entidades;

public class Producto {
    private int idProd;
    private String nom;
    private double precio;
    private int stock;
    private boolean estado;

    public Producto() {
    }

    public Producto(String nom, double precio, int stock, boolean estado) {
        this.nom = nom;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public Producto(int idProd, String nom, double precio, int stock, boolean estado) {
        this.idProd = idProd;
        this.nom = nom;
        this.precio = precio;
        this.stock = stock;
        this.estado = estado;
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nom;
    }
    
    
}

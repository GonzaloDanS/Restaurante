package entidades;

public class Factura {
    public String nom;
    public int cant;
    public double precio;

    public Factura() {
    }
    
    

    public Factura(String nom, int cant, double precio) {
        this.nom = nom;
        this.cant = cant;
        this.precio = precio;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return nom + " - " + cant + " - " + precio ;
    }
    
    
}

package restaurante;
import entidades.*;
import accesoADatos.*;

public class Restaurante {

    public static void main(String[] args) {
        LogIn login = new LogIn();
        System.out.println(login.acceso("10101010", "restaurantegpfm"));
    }
    
}

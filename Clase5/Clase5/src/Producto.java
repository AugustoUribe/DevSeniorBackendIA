

public class Producto {
    //Atributos 
    String nombre;
    double precio;

    //Cosntructor Vacio
    Producto() {
        this.nombre = "Sin nombre";
        this.precio = 0.0;
    }

    //Cosntructor con Parámetros
    Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    void mostrar() {
        System.out.println(nombre + " -> $" + precio);
    }
}


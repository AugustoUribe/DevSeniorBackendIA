public class ProductoApp {
    public static void main(String[] args) {
        Producto vacio = new Producto();
        vacio.mostrar();

        Producto cafe = new Producto("Cafe", 12000.0);
        cafe.mostrar();
    }
}
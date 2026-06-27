public class Pedido {
    public static double calcularPropina(double subtotal, double porcentaje) {
        return subtotal * porcentaje;
    }

    public static double calcularTotal(double subtotal, double porcentaje){
        double propina=calcularPropina(80000, 0.10);
        return subtotal+propina;
    }
}

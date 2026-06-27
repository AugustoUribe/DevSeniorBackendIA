public class Metodos {

    public static double calcularPropina(double subtotal, double porcentaje) {
        return subtotal * porcentaje;
    }

    public static double calcularTotal(double subtotal, double porcentaje){
        double propina=calcularPropina(80000, 0.10);
        return subtotal+propina;
    }
    public static void main(String[] args) throws Exception {
        double propina=calcularPropina(80000, 0.10);
        double total=calcularTotal(80000, 0.10);
        System.out.println("Propina: " + propina);
        System.out.println("El total es: "+total);


    }
}

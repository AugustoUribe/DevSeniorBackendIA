public class Metodos {

    public static double calcularPropina(double subtotal, double porcentaje) {
        return subtotal * porcentaje;
    }
    
    public static void main(String[] args) {
        double propina = calcularPropina(80000, 0.10);
        System.out.println("Propina: " + propina);



    }
}

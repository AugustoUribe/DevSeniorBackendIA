public class Ciclos {
    public static void main(String[] args) {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Plato #" + i + " impreso en el recibo");
        } 

        int mesasPorLimpiar = 3;
        while (mesasPorLimpiar > 0) {
            System.out.println("Faltan " + mesasPorLimpiar + " mesas");
            mesasPorLimpiar--;
        }
        System.out.println("Todo limpio!");


    }
}

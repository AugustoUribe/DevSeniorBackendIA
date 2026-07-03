import java.util.Scanner;

public class Menu {

    public static void mostrar() {
        System.out.println();
        System.out.println("=== GESTOR DE RESERVAS ===");
        System.out.println("1. Agendar una Reserva");
        System.out.println("2. Listar todas las Reservas");
        System.out.println("3. Cancelar una Reserva");
        System.out.println("4. Ver reporte del dia");
        System.out.println("5. Salir");
    }

    public static int leerOpcion(Scanner sc) {
        return Validador.leerEntero(sc, "Elige una opcion: ");
    }
}
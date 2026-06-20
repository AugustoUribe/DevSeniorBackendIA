import java.util.Scanner;

public class Opciones {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int opcion=0;
        while (opcion!=4){
        System.out.println("--------- MENU DE OPCIONES ---------");
        System.out.println("1. Nuevo pedido");
        System.out.println("2. Aplicar Descuento");
        System.out.println("3. Cerrar Caja");
        System.out.println("4. Salir");

        System.out.println("Elija la opcion: ");
        opcion=leer.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("Nuevo pedido");
                break;
            case 2:
                System.out.println("Aplicar descuento");
                break;
            case 3:
                System.out.println("Cerrar caja");
                break;
            case 4:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opcion invalida"); 
            
        }
        }
    }
}

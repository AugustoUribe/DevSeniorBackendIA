import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
        Operaciones operaciones = new Operaciones();
        boolean continuar = true;
 
        System.out.println("Bienvenida Marta. Sistema de reservas iniciado.");
 
        while (continuar) {
            Menu.mostrarMenu();
            int opcion = Menu.leerOpcion(sc);
 
            switch (opcion) {
                case 1:
                    agendar(sc, operaciones);
                    break;
                case 2:
                    operaciones.listarReservas();
                    break;
                case 3:
                    cancelar(sc, operaciones);
                    break;
                case 4:
                    operaciones.mostrarReporte();
                    break;
                case 5:
                    continuar = false;
                    System.out.println("Cerrando el sistema. ¡Hasta pronto Marta!");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        sc.close();
    }
 
    /**
     * Orquesta el flujo de agendamiento: pide datos, valida cupo y hora,
     * y le informa al usuario si la reserva quedó registrada.
     */
    private static void agendar(Scanner sc, Operaciones operaciones) {
        if (!operaciones.hayCupoDisponible()) {
            System.out.println("La agenda del día está llena (máximo " + Operaciones.CAPACIDAD_MAXIMA + " citas).");
            return;
        }
 
        String nombre = Menu.leerNombreCliente(sc);
        int hora = Menu.leerHora(sc);
 
        if (operaciones.horaOcupada(hora)) {
            System.out.println("Esa hora ya está ocupada. Elige otra.");
            return;
        }
 
        int servicio = Menu.leerServicio(sc);
        boolean exito = operaciones.agendarReserva(nombre, hora, servicio);
 
        if (exito) {
            System.out.println("Reserva agendada con éxito.");
        } else {
            System.out.println("No se pudo agendar la reserva. Verifica los datos.");
        }
    }
 
    /**
     * Orquesta el flujo de cancelación: muestra las reservas, pide el número
     * y reporta el resultado.
     */
    private static void cancelar(Scanner sc, Operaciones operaciones) {
        operaciones.listarReservas();
        int numero = Menu.leerNumeroCancelacion(sc);
        boolean exito = operaciones.cancelarReserva(numero);
 
        if (exito) {
            System.out.println("Reserva cancelada con éxito.");
        } else {
            System.out.println("No se encontró una reserva activa con ese número.");
        }
    }
}

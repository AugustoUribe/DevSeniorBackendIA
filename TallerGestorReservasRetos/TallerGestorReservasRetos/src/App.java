import java.util.Scanner;

/**
 * App.java
 * Responsabilidad: el arranque del programa.
 * Contiene el main, el Scanner compartido y el ciclo principal del menú.
 */
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
                    buscarCliente(sc, operaciones);
                    break;
                case 6:
                    editar(sc, operaciones);
                    break;
                case 7:
                    operaciones.mostrarHorasDisponibles();
                    break;
                case 8:
                    operaciones.mostrarServicioMasPedido();
                    break;
                case 9:
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

    /**
     * RETO 1: Pide un nombre y muestra todas las citas de ese cliente.
     */
    private static void buscarCliente(Scanner sc, Operaciones operaciones) {
        String nombre = Menu.leerNombreBusqueda(sc);
        operaciones.buscarPorCliente(nombre);
    }

    /**
     * RETO 2: Orquesta la edición de la hora de una reserva existente.
     */
    private static void editar(Scanner sc, Operaciones operaciones) {
        operaciones.listarReservas();
        int numero = Menu.leerNumeroEdicion(sc);
        int nuevaHora = Menu.leerNuevaHora(sc);

        boolean exito = operaciones.editarHora(numero, nuevaHora);
        if (exito) {
            System.out.println("Reserva actualizada con éxito.");
        } else {
            System.out.println("No se pudo editar. Verifica el número de reserva y que la nueva hora esté libre.");
        }
    }
}
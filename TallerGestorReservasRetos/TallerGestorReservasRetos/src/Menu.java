import java.util.Scanner;

/**
 * Menu.java
 * Responsabilidad: todo lo que el usuario ve y escribe.
 * Imprime opciones y lee datos, apoyándose en Validador para
 * pedir de nuevo cuando el dato no es correcto.
 */
public class Menu {

    public static void mostrarMenu() {
        System.out.println("\n===== MARTA PELUQUERÍA =====");
        System.out.println("1. Agendar reserva");
        System.out.println("2. Listar reservas del día");
        System.out.println("3. Cancelar reserva");
        System.out.println("4. Ver reporte del día");
        System.out.println("5. Buscar por cliente");
        System.out.println("6. Editar una reserva");
        System.out.println("7. Ver horas disponibles");
        System.out.println("8. Servicio más pedido");
        System.out.println("9. Salir");
        System.out.print("Elige una opción: ");
    }

    /**
     * Lee la opción del menú, asegurándose de que sea un número.
     */
    public static int leerOpcion(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        int opcion = sc.nextInt();
        sc.nextLine(); // limpia el salto de línea pendiente
        return opcion;
    }

    /**
     * Pide el nombre del cliente hasta que no esté vacío.
     */
    public static String leerNombreCliente(Scanner sc) {
        String nombre;
        do {
            System.out.print("Nombre del cliente: ");
            nombre = sc.nextLine();
            if (Validador.textoVacio(nombre)) {
                System.out.println("El nombre no puede estar vacío. Intenta de nuevo.");
            }
        } while (Validador.textoVacio(nombre));
        return nombre;
    }

    /**
     * Pide la hora hasta que sea un número entre 8 y 17.
     */
    public static int leerHora(Scanner sc) {
        int hora;
        do {
            System.out.print("Hora de la cita (8 a 17) - Elija horas en punto (ejemplo 9): ");
            while (!sc.hasNextInt()) {
                System.out.print("Ingresa un número válido: ");
                sc.next();
            }
            hora = sc.nextInt();
            sc.nextLine();
            if (!Validador.horaValida(hora)) {
                System.out.println("La hora debe estar entre " + Operaciones.HORA_INICIO
                        + " y " + Operaciones.HORA_FIN + ".");
            }
        } while (!Validador.horaValida(hora));
        return hora;
    }

    /**
     * Muestra el catálogo de servicios y pide una opción válida (1, 2 o 3).
     */
    public static int leerServicio(Scanner sc) {
        int servicio;
        do {
            System.out.println("Servicios disponibles:");
            System.out.println("1. Corte de Cabello\t - $25000");
            System.out.println("2. Tinte\t\t - $60000");
            System.out.println("3. Manicure\t\t - $30000");
            System.out.print("Elige el servicio: ");
            while (!sc.hasNextInt()) {
                System.out.print("Ingresa un número válido: ");
                sc.next();
            }
            servicio = sc.nextInt();
            sc.nextLine();
            if (!Validador.servicioValido(servicio)) {
                System.out.println("Servicio inválido. Debe ser 1, 2 o 3.");
            }
        } while (!Validador.servicioValido(servicio));
        return servicio;
    }

    /**
     * Pide el número de la reserva que se desea cancelar.
     */
    public static int leerNumeroCancelacion(Scanner sc) {
        System.out.print("Número de reserva a cancelar: ");
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    /**
     * RETO 1: Pide el nombre del cliente a buscar. No puede estar vacío.
     */
    public static String leerNombreBusqueda(Scanner sc) {
        String nombre;
        do {
            System.out.print("Nombre del cliente a buscar: ");
            nombre = sc.nextLine();
            if (Validador.textoVacio(nombre)) {
                System.out.println("El nombre no puede estar vacío. Intenta de nuevo.");
            }
        } while (Validador.textoVacio(nombre));
        return nombre;
    }

    /**
     * RETO 2: Pide el número de la reserva que se desea editar.
     */
    public static int leerNumeroEdicion(Scanner sc) {
        System.out.print("Número de la reserva a editar: ");
        while (!sc.hasNextInt()) {
            System.out.print("Ingresa un número válido: ");
            sc.next();
        }
        int numero = sc.nextInt();
        sc.nextLine();
        return numero;
    }

    /**
     * RETO 2: Pide la nueva hora para la reserva que se está editando.
     * Reutiliza la misma validación de rango que leerHora (8 a 17).
     */
    public static int leerNuevaHora(Scanner sc) {
        int hora;
        do {
            System.out.print("Nueva hora para la cita (8 a 17): ");
            while (!sc.hasNextInt()) {
                System.out.print("Ingresa un número válido: ");
                sc.next();
            }
            hora = sc.nextInt();
            sc.nextLine();
            if (!Validador.horaValida(hora)) {
                System.out.println("La hora debe estar entre " + Operaciones.HORA_INICIO
                        + " y " + Operaciones.HORA_FIN + ".");
            }
        } while (!Validador.horaValida(hora));
        return hora;
    }
}

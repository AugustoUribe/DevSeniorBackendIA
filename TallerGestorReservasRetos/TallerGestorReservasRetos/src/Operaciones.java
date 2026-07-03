/**
 * Operaciones.java
 * Responsabilidad: el "cerebro" del sistema.
 * Guarda y transforma las reservas usando arreglos estáticos paralelos:
 * la posición (índice) es el hilo que conecta cliente, hora y servicio.
 *
 * clientes[0] -> "Laura"
 * horas[0]    -> 10
 * servicios[0]-> 1 (Corte)
 * activas[0]  -> true/false (si la reserva sigue vigente)
 */

public class Operaciones {

    // ===== CONSTANTES DEL NEGOCIO =====
    public static final int CAPACIDAD_MAXIMA = 10; // cupo máximo de reservas por día
    public static final int HORA_INICIO = 8;        // primera hora agendable
    public static final int HORA_FIN = 17;           // última hora agendable

    // ===== ARREGLOS PARALELOS (tamaño fijo) =====
    private String[] clientes;
    private int[] horas;
    private int[] servicios; // guarda el código: 1, 2 o 3
    private boolean[] activas; // false = cancelada
    private int totalReservas; // cuántas posiciones de los arreglos están en uso

    // Catálogo de servicios (índice 0 = servicio 1, índice 1 = servicio 2, etc.)
    private String[] nombresServicios = {"Corte de Cabello", "Tinte", "Manicure"};
    private int[] preciosServicios = {25000, 60000, 30000};

    public Operaciones() {
        clientes = new String[CAPACIDAD_MAXIMA];
        horas = new int[CAPACIDAD_MAXIMA];
        servicios = new int[CAPACIDAD_MAXIMA];
        activas = new boolean[CAPACIDAD_MAXIMA];
        totalReservas = 0;
    }

    /**
     * Indica si aún hay espacio en la agenda del día.
     */
    public boolean hayCupoDisponible() {
        return totalReservas < CAPACIDAD_MAXIMA;
    }

    /**
     * Recorre las reservas activas y verifica si una hora ya está tomada.
     */
    public boolean horaOcupada(int hora) {
        for (int i = 0; i < totalReservas; i++) {
            if (activas[i] && horas[i] == hora) {
                return true;
            }
        }
        return false;
    }

    /**
     * Igual que horaOcupada, pero ignora una posición específica.
     * Se usa al editar: la reserva no debe "chocar consigo misma".
     */
    public boolean horaOcupadaExcluyendo(int hora, int indiceExcluir) {
        for (int i = 0; i < totalReservas; i++) {
            if (i != indiceExcluir && activas[i] && horas[i] == hora) {
                return true;
            }
        }
        return false;
    }

    /**
     * Intenta agendar una reserva nueva.
     * Devuelve true si se agendó, false si algo no cumplió las reglas.
     */
    public boolean agendarReserva(String cliente, int hora, int servicio) {
        if (!hayCupoDisponible()) return false;
        if (Validador.textoVacio(cliente)) return false;
        if (!Validador.horaValida(hora)) return false;
        if (!Validador.servicioValido(servicio)) return false;
        if (horaOcupada(hora)) return false;

        clientes[totalReservas] = cliente;
        horas[totalReservas] = hora;
        servicios[totalReservas] = servicio;
        activas[totalReservas] = true;
        totalReservas++;
        return true;
    }

    /**
     * Imprime en consola todas las reservas activas del día.
     */
    public void listarReservas() {
        boolean hayReservas = false;
        System.out.println("\n=== RESERVAS DEL DÍA ===");
        for (int i = 0; i < totalReservas; i++) {
            if (activas[i]) {
                hayReservas = true;
                int indiceServicio = servicios[i] - 1;
                System.out.println("N° " + (i + 1)
                        + " | Cliente: " + clientes[i]
                        + " | Hora: " + horas[i] + ":00"
                        + " | Servicio: " + nombresServicios[indiceServicio]
                        + " | Precio: $" + preciosServicios[indiceServicio]);
            }
        }
        if (!hayReservas) {
            System.out.println("No hay reservas registradas.");
        }
    }

    /**
     * Cancela una reserva a partir de su número visible en el listado (1, 2, 3...).
     * Devuelve true si se pudo cancelar, false si el número no existe o ya estaba cancelada.
     */
    public boolean cancelarReserva(int numero) {
        int indice = numero - 1;
        if (indice < 0 || indice >= totalReservas) return false;
        if (!activas[indice]) return false;

        activas[indice] = false;
        return true;
    }

    /**
     * Cuenta cuántas citas siguen activas (no canceladas).
     */
    public int contarCitasActivas() {
        int contador = 0;
        for (int i = 0; i < totalReservas; i++) {
            if (activas[i]) contador++;
        }
        return contador;
    }

    /**
     * Suma el dinero facturado por las citas activas del día.
     */
    public int calcularFacturacion() {
        int total = 0;
        for (int i = 0; i < totalReservas; i++) {
            if (activas[i]) {
                total += preciosServicios[servicios[i] - 1];
            }
        }
        return total;
    }

    /**
     * Imprime el reporte del día: total de citas y total facturado.
     */
    public void mostrarReporte() {
        System.out.println("\n=== REPORTE DEL DÍA ===");
        System.out.println("Total de citas: " + contarCitasActivas());
        System.out.println("Total facturado: $" + calcularFacturacion());
    }

    /**
     * RETO 1: Busca y muestra todas las citas activas de un cliente por nombre.
     * La comparación ignora mayúsculas/minúsculas.
     */
    public void buscarPorCliente(String nombre) {
        boolean encontrado = false;
        System.out.println("\n=== CITAS DE: " + nombre + " ===");
        for (int i = 0; i < totalReservas; i++) {
            if (activas[i] && clientes[i].equalsIgnoreCase(nombre)) {
                encontrado = true;
                int indiceServicio = servicios[i] - 1;
                System.out.println("N° " + (i + 1)
                        + " | Hora: " + horas[i] + ":00"
                        + " | Servicio: " + nombresServicios[indiceServicio]
                        + " | Precio: $" + preciosServicios[indiceServicio]);
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron citas para ese cliente.");
        }
    }

    /**
     * RETO 2: Cambia la hora de una reserva existente.
     * Devuelve true si el cambio fue válido y se aplicó, false en caso contrario.
     */
    public boolean editarHora(int numero, int nuevaHora) {
        int indice = numero - 1;
        if (indice < 0 || indice >= totalReservas) return false;
        if (!activas[indice]) return false;
        if (!Validador.horaValida(nuevaHora)) return false;
        if (horaOcupadaExcluyendo(nuevaHora, indice)) return false;

        horas[indice] = nuevaHora;
        return true;
    }

    /**
     * RETO 3: Imprime todas las horas del día (8 a 17) que siguen libres.
     */
    public void mostrarHorasDisponibles() {
        System.out.println("\n=== HORAS DISPONIBLES ===");
        boolean hayDisponibles = false;
        for (int hora = HORA_INICIO; hora <= HORA_FIN; hora++) {
            if (!horaOcupada(hora)) {
                hayDisponibles = true;
                System.out.println(hora + ":00");
            }
        }
        if (!hayDisponibles) {
            System.out.println("No quedan horas disponibles hoy.");
        }
    }

    /**
     * RETO 4: Recorre las reservas activas y determina qué servicio
     * se pidió más veces, usando un arreglo contador de tamaño 3
     * (índice 0 = Corte, índice 1 = Tinte, índice 2 = Peinado).
     */
    public void mostrarServicioMasPedido() {
        int[] contador = new int[3];
        for (int i = 0; i < totalReservas; i++) {
            if (activas[i]) {
                contador[servicios[i] - 1]++;
            }
        }

        boolean hayReservas = false;
        int indiceMax = 0;
        for (int i = 0; i < contador.length; i++) {
            if (contador[i] > 0) hayReservas = true;
            if (contador[i] > contador[indiceMax]) {
                indiceMax = i;
            }
        }

        System.out.println("\n=== SERVICIO MÁS PEDIDO ===");
        if (!hayReservas) {
            System.out.println("Aún no hay reservas registradas.");
            return;
        }
        System.out.println(nombresServicios[indiceMax] + " (" + contador[indiceMax] + " veces)");
    }
}

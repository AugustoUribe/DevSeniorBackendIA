public class Operaciones {
       // ===== CONSTANTES DEL NEGOCIO =====
    public static final int CAPACIDAD_MAXIMA = 10; // cupo máximo de reservas por día
    public static final int HORA_INICIO = 8;        // primera hora agendable
    public static final int HORA_FIN = 17;           // última hora agendable
 
    // ===== ARREGLOS A UTILIZAR (tamaño fijo) =====
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
     * Agendar una reserva nueva.
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

}

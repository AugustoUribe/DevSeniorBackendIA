/**
 * Validador.java
 * Responsabilidad: el "portero" del sistema.
 * Solo responde sí/no sobre si un dato es válido. Nunca guarda datos.
 */
public class Validador {

    /**
     * Valida que la hora esté dentro del horario de atención (8 a 17 en punto).
     * Se agenda en horas en punto: 8, 9, 10 ... 17 (la última cita empieza a las 17:00).
     */
    public static boolean horaValida(int hora) {
        return hora >= Operaciones.HORA_INICIO && hora <= Operaciones.HORA_FIN;
    }

    /**
     * Valida que un texto no esté vacío ni sea solo espacios.
     */
    public static boolean textoVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    /**
     * Valida que el servicio elegido sea 1 (Corte), 2 (Tinte) o 3 (Peinado).
     */
    public static boolean servicioValido(int servicio) {
        return servicio == 1 || servicio == 2 || servicio == 3;
    }
}

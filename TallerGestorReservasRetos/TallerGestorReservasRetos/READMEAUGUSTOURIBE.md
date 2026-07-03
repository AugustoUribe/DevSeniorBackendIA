# Marta Peluquería — Sistema de Reservas (CLI)

Aplicación de consola en Java para gestionar las reservas de citas: agendar, listar, cancelar, editar, buscar por cliente, ver horas disponibles y el reporte del día.

## Requisitos

- JDK 8 o superior instalado ([verificar con `java -version`](https://www.oracle.com/java/technologies/downloads/))

## Clonar y ejecutar

```bash
git clone https://github.com/AugustoUribe/DevSeniorBackendIA.git
cd DevSeniorBackendIA/TallerGestorReservasRetos/TallerGestorReservasRetos/src
javac *.java
java App
```

Esto compila todas las clases y arranca el menú interactivo en la terminal.

## Estructura del proyecto

| Archivo            | Responsabilidad                                             |
|---------------------|--------------------------------------------------------------|
| `App.java`          | Arranque del programa, `main`, ciclo del menú                |
| `Menu.java`         | Muestra opciones y lee/valida lo que escribe el usuario      |
| `Validador.java`    | Reglas de validación (hora, texto vacío, servicio)            |
| `Operaciones.java`  | Lógica de negocio: arreglos paralelos, agendar, cancelar, etc.|

## Notas

- Horario de atención: 8:00 a 17:00 (horas en punto).
- Cupo máximo por día: 10 reservas (constante `CAPACIDAD_MAXIMA` en `Operaciones.java`).
- Servicios disponibles: 1) Corte, 2) Tinte, 3) Peinado.

 * Operaciones.java
 * Responsabilidad: el "cerebro" del sistema.
 * Guarda y transforma las reservas usando arreglos estáticos paralelos:
 * la posición (índice) es el hilo que conecta cliente, hora y servicio.
 *
 * clientes[0] -> "Laura"
 * horas[0]    -> 10
 * servicios[0]-> 1 (Corte)
 * activas[0]  -> true/false (si la reserva sigue vigente)



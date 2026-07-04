public class Libro {
    String titulo;
    String autor;
    int paginas;

    String descripcion() {
        return titulo + " de " + autor + " (" + paginas + " paginas)";
    }
}


public class LibroMain {
    public static void main(String[] args) {
        Libro libro = new Libro();
        libro.titulo = "Clean Code";
        libro.autor = "Robert Martin";
        libro.paginas = 464;
        System.out.println(libro.descripcion());
    }
}

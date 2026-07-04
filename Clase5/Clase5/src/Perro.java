public class Perro {
    // ! Atributos -> Características de la clase
    String nombre;
    String raza;

    void Perro(){
        this.nombre="";
        this.raza="";
    }

    // ! Métodos -> lo que puede hacer
    void ladrar(){
        System.out.println(nombre+" dice: Guau");
    }

}

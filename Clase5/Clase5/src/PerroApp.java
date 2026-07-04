public class PerroApp {
    public static void main(String[] args)  {
        Perro miPerro=new Perro();
        miPerro.nombre="Firulais";
        miPerro.raza="Labrador";

        miPerro.ladrar();

        Perro otroPerro= new Perro();
        otroPerro.nombre="Rocky";
        otroPerro.raza="Pastor Aleman";
        otroPerro.ladrar();
        
    }

}

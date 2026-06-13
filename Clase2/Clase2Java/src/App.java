public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String nombre="Augusto Uribe";
        int edad=47;
        final double IVA=16; //Constantes declarar con Mayusculas
        final int DIAS_SEMANA=7; //Constantes declarar con mayusculas buenas practicas
        System.out.println(nombre+" tiene "+edad+" años");
        
        //Operadores matematicos

        int a=10;
        int b=5;
        int suma=a+b;
        System.out.println("La suma entre "+a+" y "+b+" es: "+suma);

        int resta=a-b;
        System.out.println("La resta entre "+a+" y "+b+" es: "+resta);

        int mult=a*b;
        System.out.println("La multiplicación entre "+a+" y "+b+" es: "+mult);

        int division=a/b;
        System.out.println("La division entre "+a+" y "+b+" es: "+division);

        int residuo=a%b;
        System.out.println("El residuo entre "+a+" y "+b+" es: "+residuo);



    }
}

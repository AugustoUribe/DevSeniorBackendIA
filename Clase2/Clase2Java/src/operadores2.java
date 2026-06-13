public class operadores2 {
    public static void main(String[] args) throws Exception {
    int entero=5;
    int entero2=5;
    double decimal=entero; //Cambio implicito del tipo de una variable

    System.out.println("El valor entero: "+entero);
    System.out.println("El valor decimal: "+decimal);
    
    System.out.println("Concatenación: "+entero+entero2); // Concatenar como cadena de caracteres
    System.out.println("LA suma es: "+(entero+entero2)); //Operar con el parentesis
    }

}

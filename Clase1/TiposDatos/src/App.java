import java.util.Scanner;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        //Declarar variables 
        int edad;
        double salario;
        float promedio;
        char sexo;
        boolean estado;
        String nombres;

/* 
        //Entrada de Datos por consola
        Scanner read = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        nombres=read.next();
        System.out.print("Ingrese edad: ");
        edad=read.nextInt();
        System.out.println("Ingrese el salario: ");
        salario=read.nextDouble();
        System.out.println("Ingrese el sexo: ");
        sexo=read.next().charAt(0); //Captura solo la primera posicion de lo que escribe el usuario 
        System.out.println("Ingrese el estado del estudiante: ");
        estado=read.nextBoolean();



        //Procesamiento de datos

        //Salida de datos por consola
        System.out.println("EL nombre del estudiante es: "+nombres);
        System.out.println("La edad del estudiante es:  "+edad);

*/
        //Entrada de datos por ventana Emergente
        
        nombres=JOptionPane.showInputDialog("Ingrese el nombre: ");
        edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
        salario=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario"));
        sexo=JOptionPane.showInputDialog("Ingrese el sexo: ").charAt(0);

        //Salida de datos por ventana emergente:

        JOptionPane.showMessageDialog(null, "Nombre:"+nombres);
        JOptionPane.showMessageDialog(null, "Edad:"+edad);
        
        // varios en uno solo:
        JOptionPane.showMessageDialog(null, "Nombre:"+nombres+"\nEdad;"+edad);
        
        
        




    }
}

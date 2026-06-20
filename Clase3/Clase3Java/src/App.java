import java.util.Scanner;
import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leer=new Scanner(System.in);
        int edad;
        double salario;
        float promedio;
        char sexo;
        boolean estado;
        String nombres;
        int personas;

      /*   
        System.out.print("Cantidad de personas en la mesa: ");
        personas=leer.nextInt();
        //cuando primero se pregunta por numeros y luego String, sale error por lo que hay que 
        //poner un sc.nextLine() porque los numeros consumen una linea y no deja escribir los 
        //String por eso es importante dar un el nextLine solito para que permita
        leer.nextLine();
        System.out.print("Nombre: ");
        nombres=leer.nextLine();
        
        System.out.println("Mesa de: "+nombres+", "+personas+" personas.");
      */

       
/* 
        double subtotal = 120000;
        boolean tieneCupon = true;
        boolean aplicaDescuento = subtotal > 100000 && tieneCupon;
        System.out.println("Aplica descuento? " + aplicaDescuento);
*/

//CONVERSION DE TIPOS IMPLICITO Y NO IMPLICITO
/* 
        int unidades=5;
        double comoDecimal = unidades;
        System.out.println("Conversión implícita: "+comoDecimal);

        double precio = 2000.75;
        int precioRecortado = (int) precio;
        System.out.println("Casting - no implicito : "+precioRecortado);
*/
  /*       int edad;
        double salario;
        float promedio;
        char sexo;
        boolean estado;
        String nombres;

        nombres=JOptionPane.showInputDialog("Ingrese el nombre: ");
        edad=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad:"));
        salario=Double.parseDouble(JOptionPane.showInputDialog("Ingrese el salario"));
        sexo=JOptionPane.showInputDialog("Ingrese el sexo: ").charAt(0);

        //Salida de datos por ventana emergente:

        JOptionPane.showMessageDialog(null, "Nombre:"+nombres);
        JOptionPane.showMessageDialog(null, "Edad:"+edad);
        
        // varios en uno solo:
        JOptionPane.showMessageDialog(null, "Nombre:"+nombres+"\nEdad;"+edad);
  */
 
             
        
    }
}

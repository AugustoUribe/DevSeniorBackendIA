import java.util.Scanner;
import javax.swing.JOptionPane;

public class RepasoClase{
    public static void main(String[] args) throws Exception {
        //Declarar variables 
        int edad;
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
        
        
    }    
}


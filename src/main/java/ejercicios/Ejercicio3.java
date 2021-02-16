package ejercicios;

import java.util.Scanner;

/**
 * 6.3. A partir de la clase CuentaCorriente que te proporcionará el profesor,
 * crea un programa en el que se creen una cuenta corriente (siempre se crean
 * con saldo inicial cero) y mediante un menú le permita al usuario hacer
 * operaciones como ingresar, retirar y consultar saldo en la cuenta. 
 * El único atributo público de la cuenta es el IBAN (String de 24 dígitos/letras).
 */
import recursos.CuentaCorriente;

public class Ejercicio3 {
    static CuentaCorriente cuenta;
    static Scanner teclado;

    static void menu (){
        teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        do {
           opcion=pintarMenu ();
           switch (opcion) {
               case 1: System.out.println("\tElegiste opción 1"); break;
               case 2: System.out.println("\tElegiste opción 2"); break;
               case 3: System.out.println("\tElegiste opción 3"); break;   
               case 4: System.out.println("\tElegiste opción 4"); break;    
               case 0: salir=true; break;    
               default: System.out.println("Opción incorrecta");
            }
        } while (!salir);
    }
    
    private static int pintarMenu (){
        System.out.println("\n\n\n");  
        System.out.println("Elija una opción:");  
        System.out.println("1 Opción 1");  
        System.out.println("2 Opción 2");  
        System.out.println("3 Opción 3");  
        System.out.println("4 Opción 4");  
        System.out.println("0 Salir del programa");  
        try {                  //si introduce un valor no entero haría return 999
          return Integer.parseInt (teclado.nextLine());
        } catch (Exception e ) {return 999;}
     }

     public static void main(String[] args) {
         menu();
     }
}

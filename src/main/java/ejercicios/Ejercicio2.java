package ejercicios;

import java.util.Scanner;
import recursos.MovilPrepago;

/**
 * 6.2. A partir de la clase MovilPrepago del ejercicio anterior, crea un
 * programa en el que el usuario dé de alta un teléfono con unas características
 * determinadas y luego le permita mediante un menú hacer operaciones como
 * consultar saldo, recarga, hacer llamada, navegar. Se proporciona un modelo
 * (modeloMenu) a modo de esqueleto, con el menú y las funciones necesarias, en
 * las que solo tienes rellenar los huecos.
 */

public class Ejercicio2 {
    static Scanner teclado;
    static MovilPrepago telefono;
    static int importe = 0;

    static MovilPrepago crearTelefono(long numero) {
        return new MovilPrepago(numero, (float) 0.02, (float) 0.02, (float) 0.30, (float) 0);
    }

    static float consultarSaldo(MovilPrepago telefono) {
        return telefono.consultarSaldo();
    }

    static void recargaSaldo(MovilPrepago telefono, int importe) {
        telefono.recargar(importe);
    }

    static void menu() {
        teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        do {
            opcion = pintarMenu();
            switch (opcion) {
                case 1:
                    System.out.println("\tVas a dar de alta un teléfono");
                    System.out.print("Introduce un número de teléfono:");
                    int numero = Integer.parseInt(teclado.nextLine());
                    telefono = crearTelefono((long) numero);
                    break;
                case 2:
                    System.out.println("Tu saldo es de: " + consultarSaldo(telefono));
                    break;
                case 3:
                    System.out.println("\tVa a realizar una recarga de saldo.");
                    System.out.print("\tIntroduzca el importe de la recarga: ");
                    importe = Integer.parseInt(teclado.nextLine());
                    recargaSaldo(telefono, importe);
                    System.out.println("\tTu nuevo saldo es de: " + consultarSaldo(telefono));
                    break;
                case 4:
                    boolean colgar = false;
                    String sino = "";
                    System.out.println("\tEstas haciendo una llamada, tu saldo se agota!!");
                    while (consultarSaldo(telefono) > 0 && !colgar) {
                        telefono.efectuarLlamada(60);
                        try {
                            Thread.sleep(1000);
                        } catch (Exception e) {
                            System.out.println("");
                        }
                        System.out.println("Desea colgar? S/N");
                        sino = teclado.nextLine();
                        if(sino.equalsIgnoreCase("S"))
                            colgar = true;
                    }
                    break;
                case 5:
                    
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (!salir);
    }

    private static int pintarMenu() {
        System.out.printf("%n%n");
        System.out.println("Elija una opción:");
        System.out.println("1 Alta de un telefono");
        System.out.println("2 Consultar saldo");
        System.out.println("3 Recargar saldo");
        System.out.println("4 Hacer una llamada");
        System.out.println("0 Salir del programa");
        try { // si introduce un valor no entero haría return 999
            return Integer.parseInt(teclado.nextLine());
        } catch (Exception e) {
            return 999;
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello World!");
        menu();
        teclado.close();
    }
}

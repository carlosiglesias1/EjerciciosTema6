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
        // Para non meterse en líos, os costes van a ir preestablecidos
        // Só se operará sobre un teléfono en cada execución, dado que non hai unha
        // estructura que garde os distintos telefonos
        // Co cal ao dar de alta un novo telefono, o seguinte quedaría colgado
        return new MovilPrepago(numero, (float) 0.02, (float) 0.50, (float) 0.20, (float) 0);
    }

    static float consultarSaldo(MovilPrepago telefono) {
        return telefono.consultarSaldo();
    }

    static void recargaSaldo(MovilPrepago telefono, int importe) {
        telefono.recargar(importe);
    }

    static void llamadoDeEmergrensia() {
        boolean colgar = false;
        String sino = "";
        while (consultarSaldo(telefono) > 0 && !colgar) {
            telefono.efectuarLlamada(60);
            try {
                // Conversación interesante
                System.out.println("\tBlablabla");
                Thread.sleep(300);
                System.out.println("\t¿Blablablabla?");
                Thread.sleep(200);
                System.out.println("\tBlablabla");
                Thread.sleep(300);
            } catch (Exception e) {
                System.out.println("No hay buena covertura");
            }
            System.out.println("\tDesea colgar? S/N");
            sino = teclado.nextLine();
            if (sino.equalsIgnoreCase("S") || sino.equalsIgnoreCase("Si"))
                colgar = true;
        }
    }

    static void navegando() {
        System.out.println("\tPuedes hacer otras cosas, pero gastarás tu saldo a razón de 1 mb por interacción");
        System.out.println("\tPara dejar de navegar, pulsa 'Salir' en el menú");
        int opcion;
        boolean salir = false;
        do {
            opcion = pintarMenu();
            if (opcion == 0)
                salir = true;
            menu(opcion);
            telefono.navegar(1);
        } while (!salir && consultarSaldo(telefono) > 0);
        System.out.println("\tHas dejado de navegar");
    }

    static void menu(int opcionMenu) {
        int opcion = opcionMenu;
        switch (opcion) {
            case 1:
                if (telefono==null){
                    System.out.println("\tVas a dar de alta un teléfono");
                    System.out.print("\tIntroduce un número de teléfono:");
                    int numero = Integer.parseInt(teclado.nextLine());
                    telefono = crearTelefono((long) numero);
                }
                else
                    System.out.println("Ya has creado un teléfono");
                break;
            case 2:
                System.out.println("\tTu saldo es de: " + consultarSaldo(telefono));
                break;
            case 3:
                System.out.println("\tVa a realizar una recarga de saldo.");
                System.out.print("\tIntroduzca el importe de la recarga: ");
                importe = Integer.parseInt(teclado.nextLine());
                recargaSaldo(telefono, importe);
                System.out.println("\tTu nuevo saldo es de: " + consultarSaldo(telefono));
                break;
            case 4:
                System.out.println("\tEstas haciendo una llamada, tu saldo se agota!!");
                llamadoDeEmergrensia();
                break;
            case 5:
                System.out.println("\tEstas navegando por internet");
                navegando();
                break;
            case 0:
                break;
            default:
                System.out.println("\nOpción incorrecta");
        }
    }

    private static int ejecutarMenu() {
        teclado = new Scanner(System.in);
        int opcion;
        boolean salir = false;
        do {
            opcion = pintarMenu();
            if (opcion == 0)
                salir = true;
            menu(opcion);
        } while (!salir);
        return 1;
    }

    private static int pintarMenu() {
        System.out.printf("%n%n");
        System.out.println("Elija una opción:");
        System.out.println("1 Alta de un telefono");
        System.out.println("2 Consultar saldo");
        System.out.println("3 Recargar saldo");
        System.out.println("4 Hacer una llamada");
        System.out.println("5 Navegar por internet");
        System.out.println("0 Salir del programa");
        try {
            // si introduce un valor no entero haría return 999
            return Integer.parseInt(teclado.nextLine());
        } catch (Exception e) {
            return 999;
        }
    }

    public static void main(String[] args) {
        ejecutarMenu();
        teclado.close();
    }
}

package ejercicios;

import java.util.Scanner;
import recursos.CuentaCorriente;

/**
 * 6.4. Haz un programa como el anterior, pero creando dos cuentas en vez de
 * una. Habrá una opción de menú nueva que será “Cambiar cuenta activa” para
 * pasar de una cuenta a otra. Tendremos una variable de tipo CuentaCorriente
 * que le puedes llamar cuentaActiva que unas veces apuntará a una cuenta y
 * otras veces a la otra Recuerda que las variables de tipo Objeto, a diferencia
 * de los tipos primitivos, son apuntadores a los objetos, si tenemos los
 * objetos ‘cuenta1’ y ‘cuenta2’ creados con su constructor, podemos hacer luego
 * una tercera variable ‘cuentaActiva’ sin constructor y hacer
 * ‘cuentaActiva=cuenta1’ o bien ‘cuentaActiva=cuenta2’ cuando nos interese.
 */

public class Ejercicio4 {
    static CuentaCorriente[] cuenta = new CuentaCorriente[3];
    static CuentaCorriente cuentaActiva;
    static Scanner teclado;

    static void setCuentaActiva() {
        int posicion;
        System.out.println("¿Que cuenta quieres activar?");
        posicion = Integer.parseInt(teclado.nextLine());
        if (posicion > 3)
            cuentaActiva = null;
        else
            cuentaActiva = cuenta[posicion];
    }

    static void altaCuenta() {
        float[] comisiones = Ejercicio3.selectComision();
        System.out.println("\tIntroduce un número de cuenta: ");
        cuentaActiva = new CuentaCorriente(teclado.nextLine());
        CuentaCorriente.setComision(comisiones[0], comisiones[1]);
        System.out.println(
                "\tHas dado de alta una cuenta con una comision minima de " + CuentaCorriente.getMinimoCosmision());
    }

    static void cambiarCuenta () {
        int posicion = 3;
        System.out.println("Selecciona la posicion de la cuenta a la que quieres cambiar");
        while (posicion > 3 || cuenta[posicion] == null){
            posicion = Integer.parseInt(teclado.nextLine());
        }
        cuentaActiva = cuenta [posicion];
    }

    static void menu() {
        teclado = new Scanner(System.in);
        boolean salir = false;
        int opcion;
        do {
            opcion = pintarMenu();
            switch (opcion) {
                case 1:
                    System.out.println("\tDar cuenta de alta");
                    if (cuenta[2] != null) {
                        System.out.println("No puedes introducir más cuentas");
                    } else {
                        int contador = 0;
                        while (cuenta[contador] != null)
                            contador++;
                        altaCuenta();
                        cuenta[contador] = cuentaActiva;
                    }
                    break;
                case 2:
                    System.out.println("\tIngresar");
                    Ejercicio3.cuenta = cuentaActiva;
                    Ejercicio3.ingreso();
                    break;
                case 3:
                    System.out.println("\tTu saldo actual es de " + cuentaActiva.getSaldo());
                    break;
                case 4:
                    System.out.println("\tElegiste opción 4");
                    Ejercicio3.cuenta = cuentaActiva;
                    Ejercicio3.retirada();
                    break;
                case 5:
                    System.out.println("\tCambiar de cuenta");
                    setCuentaActiva();
                    break;
                case 0:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        } while (!salir);
    }

    private static int pintarMenu() {
        System.out.println("\n");
        System.out.println("Elija una opción:");
        System.out.println("1 Alta de cuenta");
        System.out.println("2 Ingresar");
        System.out.println("3 Consultar saldo");
        System.out.println("4 Retirar");
        System.out.println("5 Cambiar de cuenta");
        System.out.println("0 Salir del programa");
        try { // si introduce un valor no entero haría return 999
            return Integer.parseInt(teclado.nextLine());
        } catch (Exception e) {
            return 999;
        }
    }

    public static void main(String[] args) {
        menu();
    }
}

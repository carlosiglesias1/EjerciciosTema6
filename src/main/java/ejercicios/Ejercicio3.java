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

    static String selectBanco() {
        String banco = "";
        System.out.println("\tSelecciona un banco donde darse de alta");
        System.out.println("\t\t ABANCA: Comision 4.5%\n\t\t\tComision mínima 15€");
        System.out.println("\t\t Santander: Comision 4.32%\n\t\t\t Mínimo 20€");
        System.out.println("\t\t BBVA: Comision 4.55%\n\t\t\t Mínimo 8.75€");
        banco = teclado.nextLine();
        return banco;
    }

    static float[] selectComision() {
        // bancoComision [0] = pc -> bancoComision [1] = mc
        float[] bancoComision = { 0f, 0f };
        String banco = selectBanco();
        if (banco.equalsIgnoreCase("ABANCA")) {
            bancoComision[0] = 0.045f;
            bancoComision[1] = 15f;
        } else if (banco.equalsIgnoreCase("Santander")) {
            bancoComision[0] = 0.0432f;
            bancoComision[1] = 20f;
        } else if (banco.equalsIgnoreCase("BBVA")) {
            bancoComision[0] = 0.455f;
            bancoComision[1] = 8.75f;
        }
        return bancoComision;
    }

    static void altaCuenta() {
        // poñeremos que ao dar de alta unha conta, haberá que seleccionar o banco no
        // que se da de alta, cada banco terá un porcetajeComision e un minimoComision
        // característicos
        if (cuenta != null) {
            System.out.println("\tYa has dado de alta una cuenta");
            return;
        }
        float[] comisiones = selectComision();
        System.out.println("\tIntroduce un número de cuenta: ");
        cuenta = new CuentaCorriente(teclado.nextLine());
        CuentaCorriente.setComision(comisiones[0], comisiones[1]);
        System.out.println("\tHas dado de alta una cuenta con una comision minima de " + CuentaCorriente.getMinimoCosmision());
    }

    static void ingreso (){
        float cantidad;
        System.out.println("\tIntroduzca la cantidad");
        cantidad = Float.parseFloat(teclado.nextLine());
        cuenta.ingresar(cantidad);
        System.out.println("\tEl nuevo saldo de tu cuenta es "+cuenta.getSaldo());
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
                    altaCuenta();
                    break;
                case 2:
                    System.out.println("\tIngresar");
                    ingreso();
                    break;
                case 3:
                    System.out.println("\tElegiste opción 3");
                    break;
                case 4:
                    System.out.println("\tElegiste opción 4");
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
        System.out.println("1 Opción 1");
        System.out.println("2 Opción 2");
        System.out.println("3 Opción 3");
        System.out.println("4 Opción 4");
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

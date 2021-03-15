package ejercicios;

/**
 * 6.13. Realiza un juego de la ruleta rusa para dos jugadores. La pistola tiene
 * 6 huecos en la recámara pero solo una bala. Al empezar la partida se genera
 * una posición al azar de la recámara para la bala de forma que puede salir en
 * el primer disparo, en el segundo, etc. hasta el sexto. Los jugadores irán
 * disparando sucesivamente hasta que uno de los dos se muera. Crea una clase
 * Pistola con los atributos y métodos que la definen.
 * 
 */

import recursos.Pistola;

public class Ejercicio13 {
    public static void main(String[] args) {
        Pistola ruleta = new Pistola();
        boolean fin = false;
        ruleta.recargar();

        do{
            System.out.println("Es el turno del jugador 1");
            if(ruleta.disparar()){
                System.out.println("¡¡¡¡BANG!!!");
                break;
            }
            System.out.println("Es el turno del jugador 2");
            if(ruleta.disparar()){
                System.out.println("¡¡¡¡BANG!!!");
                fin = true;
            }
        }while (!fin);
    }
}

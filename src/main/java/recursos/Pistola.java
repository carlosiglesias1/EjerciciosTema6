package recursos;

/**
 * 6.13. Realiza un juego de la ruleta rusa para dos jugadores. La pistola tiene
 * 6 huecos en la recámara pero solo una bala. Al empezar la partida se genera
 * una posición al azar de la recámara para la bala de forma que puede salir en
 * el primer disparo, en el segundo, etc. hasta el sexto. Los jugadores irán
 * disparando sucesivamente hasta que uno de los dos se muera. Crea una clase
 * Pistola con los atributos y métodos que la definen.
 * 
 */

import java.util.Random;

public class Pistola {
    private int[] cargador = { 0, 0, 0, 0, 0, 0 };
    static Random posicion = new Random();

    public Pistola () {
        //Empty constructor
    }

    static int girar() {
        return posicion.nextInt(6);
    }

    public void recargar() {
        this.cargador[girar()] = 1;
    }

    public boolean disparar() {
        if (this.cargador[girar()] == 0)
            return false;
        else
            return true;
    }
}

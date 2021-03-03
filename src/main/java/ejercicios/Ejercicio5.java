package ejercicios;

import recursos.Ahorcado;
/**
 * A partir de la clase Ahorcado que te proporcionará el profesor, crea un
 * programa que permita al usuario jugar al ahorcado. Desconocemos los atributos
 * de la clase Ahorcado ya que son privados, pero sus métodos públicos son:
 * Constructor(String txtAdivinar, String txtPista). Crea el juego con la frase
 * a adivinar y con un texto de pista para el jugador. 
 * - Constructor(String txtAdivinar). Crea el juego con la frase a adivinar, sin pistas. 
 * - boolean probarLetra (char x). Comprueba si la letra pasada como parámetro está en la
 * frase a adivinar, en caso afirmativo, devuelve true¸ sino false. 
 * - boolean adivinada(). Devuelve true si se ha adivinado la frase, false en caso
 * contrario. 
 * - boolean perdio(). Devuelve true si se ha llegado al número
 * máximo de intentos sin adivinar la frase, false en caso contrario. 
 * - char leerLetra (). Pide al usuario por consola una letra y devuelve dicha letra.
 * - void pintar (). Dibuja un “tablero” en la consola, con el estado del juego.
 */

public class Ejercicio5 {
    public static void main(String[] args) {
        Ahorcado juego = new Ahorcado("Caraculo", "Es alguien muy feo");
        while (!juego.adivinada() && !juego.perdio()){
            System.out.println("Introduce una letra para adivinar la palabra");
            juego.probarLetra(juego.leerLetra());
            juego.pintar();
        }
        if (juego.adivinada())
            System.out.println("Has ganado");
        else
            System.out.println("Has perdido");
        
    }
}

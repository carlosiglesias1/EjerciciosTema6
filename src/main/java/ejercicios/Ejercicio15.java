package ejercicios;

import java.util.Scanner;

import recursos.examen.Examen;

/**
 * 6.15. Un profesor ha desarrollado un examen tipo test de 20 preguntas y cada
 * una de ellas tiene cuatro opciones: a), b), c) ó d), siendo solo una de ellas
 * la correcta. Cada pregunta correcta suma 0.5 puntos y cada una incorrecta
 * resta 0.2 puntos, no pudiendo llevar un alumno ninguna nota inferior a cero.
 * Desarrolla una clase llamada Examen que almacene las respuestas correctas de
 * las 20 preguntas. La clase debe disponer de algún mecanismo mediante el que
 * se le pase las respuestas de un alumno para las 20 preguntas (a,b,c,d o bien
 * z, siendo respuesta en blanco) y nos informe de la puntos en el examen. Hacer
 * un programa que permita primero informar de las respuestas correctas a un
 * examen y después introducir las respuestas de los alumnos, mostrándonos la
 * nota obtenida por los mismos.
 */

public class Ejercicio15 {
    public static void main(String[] args) {
        Examen examen = new Examen();
        char[] respuestas = new char[examen.getNumeroPreguntas()];
        Scanner teclado = new Scanner(System.in);
        //fingimos ser el profesor para ver las respuestas
        for (int i = 0; i < respuestas.length; i++) {
            System.out.print(" " + examen.getRespuestaCrrecta(i));
        }
        System.out.println();
        for (int i = 0; i < respuestas.length; i++) {
            System.out.print("La respuesta a la pregunta "+ (i+1) + " es: ");
            respuestas[i] = teclado.nextLine().charAt(0);
        }
        System.out.printf("Has sacado %.2f %n", examen.corregirExamen(respuestas));

        teclado.close();
    }
}

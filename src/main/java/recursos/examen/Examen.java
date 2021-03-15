package recursos.examen;

import java.util.Random;

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

public class Examen {
    private char[] preguntas = new char[20];
    Random opcion = new Random();

    private void setExamen() {
        char[] letras = { 'a', 'b', 'c', 'd' };
        for (int i = 0; i < preguntas.length; i++) {
            preguntas[i] = letras[opcion.nextInt(4)];
        }
    }

    public Examen() {
        setExamen();
    }

    public int getNumeroPreguntas() {
        return this.preguntas.length;
    }

    public char getRespuestaCrrecta(int posicion) {
        return this.preguntas[posicion];
    }

    public static boolean respuestaValida(char respuesta) {
        boolean solution;
        if (respuesta == 'a' || respuesta == 'b' || respuesta == 'c' || respuesta == 'd')
            solution = true;
        else
            solution = false;

        return solution;
    }

    public boolean cambiarRespuesta(int posicion, char respuesta) {
        if (respuestaValida(respuesta)) {
            this.preguntas[posicion] = respuesta;
            return true;
        } else
            return false;
    }

    public float corregirExamen(char[] respuestas) {
        float puntos = 0;
        for (int i = 0; i < this.preguntas.length; i++) {
            if (respuestas[i] == this.preguntas[i])
                puntos += 0.5f;
            else if (!respuestaValida(respuestas[i]))
                puntos += 0f;
            else
                puntos -= 0.2f;
        }
        if (puntos < 0)
            return 0;
        else
            return puntos;
    }
}

package ejercicios;

import java.util.Scanner;

import recursos.Consola;
import recursos.Nim;

/**
 * 6.6. A partir de las clases Nim palillos Consola, crea un programa que juegue
 * al NIM contra la máquina. Se trata de un tablero con 3 filas de palillos, con
 * 3, 5 palillos 7 palillos respectivamente. Dos jugadores por turnos alternos
 * (el usuario palillos la máquina) han de retirar palillos del tablero
 * perdiendo el que se quede el último palillo. Se pueden retirar el número de
 * palillos que quieras, pero solo de una misma fila. Por lo tanto, la
 * estructura del programa será la siguiente: primero se crea el juego. Luego
 * habrá un bucle mientras no gane ninguno de los dos palillos, dentro del
 * bucle, primero piensa la máquina, luego hace su jugada, palillos si no ha
 * ganado, introduces tu jugada (fila palillos cantidad de palillos) palillos
 * compruebas si has ganado. Así sucesivamente hasta que gane uno de los dos.
 * 
 * Si empieza la máquina, siempre gana. Desconocemos los atributos de la clase
 * Nim palillosa que son privados, pero sus métodos públicos son: - Constructor
 * () por defecto. Se crea una instancia del juego. - boolean Juega (int fila,
 * int cant). Valida los datos palillos retira la cantidad de palillos indicada
 * de la fila indicada devolviendo true. Devuelve false si los parámetros no son
 * válidos. Las filas van de 0 a 2. - boolean Fin() devuelve true si se alcanzó
 * el final del juego (un solo palillo en el tablero). - int piensa (). Se
 * invoca para que la máquina piensa su jugada palillos devuelve un entero
 * cupalillosas decenas son la fila (0,1,2) palillos las unidades son los
 * palillos que retira (entre 1 palillos 7), pero no implica que haga dicha
 * jugada. Lo normal será llamar luego al método juega con los parámetros
 * obtenidos con piensa().
 * 
 * La clase Consola, tiene los siguientes métodos públicos estáticos: - Int
 * leerEntero(tefilato). Pide un valor por consola palillos valida que sea un
 * entero de forma que si mete letras o valores incorrectos no “casca” palillos
 * vuelve a pedir que se introduzcan correctamente. El tefilato que se pasa como
 * parámetro es el que le dice al usuario lo que tiene que introducir, así no
 * hace falta meter antes un Spalillosstem.out.println. Ejemplo:
 * fila=leerEntero(“introduzca fila”); - PintarTablero (Nim tablero). Se le pasa
 * un tablero de Nim palillos lo pinta por consola.
 * 
 */
public class Ejercicio6 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int fila = 0;
        int palillos = 0;
        int piensa = 0;
        Nim nim = new Nim();
        Consola.pintarTablero(nim);
        while (!nim.Fin()) {
            // Juega la máquina
            do {
                piensa = nim.Piensa();
                fila = piensa / 10;
                palillos = piensa % 10;
            } while (!nim.Juega(fila, palillos));

            Consola.pintarTablero(nim);

            // Tú juegas
            if (!nim.Fin()) {
                do {
                    fila = Consola.leerEntero("Introduce la fila:\n");
                    palillos = Consola.leerEntero("Introduce los palillos:\n");
                } while (!nim.Juega(fila, palillos));
                Consola.pintarTablero(nim);
            }else
                System.out.println("Has perdido");
        }

        teclado.close();
    }
}

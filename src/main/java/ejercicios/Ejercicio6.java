package ejercicios;

/**
 * 6.6. A partir de las clases Nim y Consola, crea un programa que juegue al NIM
 * contra la máquina. Se trata de un tablero con 3 filas de palillos, con 3, 5 y
 * 7 palillos respectivamente. Dos jugadores por turnos alternos (el usuario y
 * la máquina) han de retirar palillos del tablero perdiendo el que se quede el
 * último palillo. Se pueden retirar el número de palillos que quieras, pero
 * solo de una misma fila. Por lo tanto, la estructura del programa será la
 * siguiente: primero se crea el juego. Luego habrá un bucle mientras no gane
 * ninguno de los dos y, dentro del bucle, primero piensa la máquina, luego hace
 * su jugada, y si no ha ganado, introduces tu jugada (fila y cantidad de
 * palillos) y compruebas si has ganado. Así sucesivamente hasta que gane uno de
 * los dos.
 * 
 * Si empieza la máquina, siempre gana. Desconocemos los atributos de la clase
 * Nim ya que son privados, pero sus métodos públicos son: 
 * - Constructor () por defecto. Se crea una instancia del juego. - boolean Juega (int fila, int cant). Valida los datos y retira la cantidad de palillos indicada de la fila
 * indicada devolviendo true. Devuelve false si los parámetros no son válidos.
 * Las filas van de 0 a 2. 
 * - boolean Fin() devuelve true si se alcanzó el final
 * del juego (un solo palillo en el tablero). 
 * - int piensa (). Se invoca para
 * que la máquina piensa su jugada y devuelve un entero cuyas decenas son la
 * fila (0,1,2) y las unidades son los palillos que retira (entre 1 y 7), pero
 * no implica que haga dicha jugada. Lo normal será llamar luego al método juega
 * con los parámetros obtenidos con piensa(). La clase Consola, tiene los
 * siguientes métodos públicos estáticos: - Int leerEntero(texto). Pide un valor
 * por consola y valida que sea un entero de forma que si mete letras o valores
 * incorrectos no “casca” y vuelve a pedir que se introduzcan correctamente. El
 * texto que se pasa como parámetro es el que le dice al usuario lo que tiene
 * que introducir, así no hace falta meter antes un System.out.println. Ejemplo:
 * x=leerEntero(“introduzca fila”); - PintarTablero (Nim tablero). Se le pasa un
 * tablero de Nim y lo pinta por consola.
 * 
 */
public class Ejercicio6 {

}

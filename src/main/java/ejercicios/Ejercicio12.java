package ejercicios;

import java.time.LocalDate;
import java.util.Scanner;

import recursos.Alumno;

/**
 * 6.12. Diseña una clase llamada Alumno para gestionar los alumnos de una
 * escuela. Contiene los atributos: nombre completo, DNI, fecha de nacimiento y
 * nombre de la escuela (común para todos los alumnos). Además del constructor,
 * los métodos set y get para cada atributo, tendrá los siguientes métodos:
 * -Método que nos dice si es mayor de edad o no. - Método al que se le pase
 * como parámetro otro alumno y nos devuelva true si el alumno pasado es menor
 * que él mismo. False en caso contrario. - Método al que se le pase como
 * parámetro otro alumno y nos devuelva true si el alumno pasado es exactamente
 * igual en todos los campos (un duplicado). False en caso contrario. Realiza a
 * continuación un programa sencillo que use la clase definida.
 */

public class Ejercicio12 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Alumno chico;
        System.out.println("Introduce los datos del alumno ('Nombre','Dni', 'aaaa-mm-dd', 'Colegio')");
        chico = new Alumno(teclado.nextLine(), teclado.nextLine(), LocalDate.parse(teclado.nextLine()), teclado.nextLine());
        if(chico.esMayorEdad())
            System.out.println("El chaval tiene más de dieciocho años");
        else
            System.out.println("El chaval es menor de edad");
        teclado.close();
    }
}

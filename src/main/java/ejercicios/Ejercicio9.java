package ejercicios;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;

/**6.9. Ejercicios de fechas. Usando las clases de Java para el manejo de fechas, realiza
programas con la siguiente funcionalidad:
a) Introducir tu fecha de nacimiento y muestre cuantos días han pasado hasta ahora
mismo.
b) Introducir una fecha y un número de días y calcule la fecha que se obtiene al
incrementar dichos días a la fecha.
c) Introducir dos horas de reloj y nos dé la diferencia entre ambas en segundos.
d) ¿Cuántos años bisiestos ha habido desde el año 1 dC?
e) Introducir una fecha y mostrar el día de la semana que le corresponde.
f) Introducir un tipo de producto (1- perecedero, 2-electrónica, 3-ropa) y la fecha de
compra, y que informe si se puede devolver a día de hoy o no (los plazos de
devolución, son respectivamente 5 horas, 6 meses, 15 días)
g) Introducir un año y decir cuántos domingos tiene.
h) Indica el día de la semana (en texto, en gallego) del 31 de diciembre de los últimos 5
años. */



public class Ejercicio9 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int dias = 0;
        System.out.println("Apartado a)");
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.now();
        LocalDate birthDate = LocalDate.of(2000, 2, 9);
        dias += date.getDayOfYear()-birthDate.getDayOfYear();
        dias += (date.getYear()-birthDate.getYear())*365;
        System.out.println("Desde "+birthDate.format(df)+" han pasado "+dias+" días");

        System.out.println("Apartado b)");


    }
}

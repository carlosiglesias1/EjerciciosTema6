package ejercicios;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalTime;
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
    static Scanner teclado = new Scanner(System.in);
    static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static void promptFecha (){
        System.out.println("Escribe una fecha aaaa-mm-dd");
    }
    
    static void promptHora (){
        System.out.println("Escribe una hora hh:mm:ss");
    }
    
    static void solucionA (){
        int dias = 0;
        LocalDate date = LocalDate.now();
        promptFecha();
        LocalDate birthDate = LocalDate.parse(teclado.nextLine());
        dias += date.getDayOfYear()-birthDate.getDayOfYear();
        dias += (date.getYear()-birthDate.getYear())*365;
        System.out.println("Desde "+birthDate.format(df)+" han pasado "+dias+" días");
    }

    static void solucionB (){
        promptFecha();
        LocalDate date = LocalDate.parse(teclado.nextLine());
        System.out.println("Introduce los días");
        int dias = Integer.parseInt(teclado.nextLine());
        System.out.println("La fecha "+ date.format(df) +" más "+ dias +" días da como resultado "+date.plusDays(dias).format(df));

    }
    static LocalTime horaMayor (LocalTime time, LocalTime time2){
        if (time.getHour()>time2.getHour() || time.getHour()==time2.getHour() && time.getMinute() > time2.getMinute() || time.getMinute() == time2.getMinute() && time.getSecond()>time2.getSecond())
            return time;
        else
            return time2;
    }
    static void solucionC () {
        int segundos = 0;
        promptHora();
        LocalTime time = LocalTime.parse(teclado.nextLine());
        promptHora();
        LocalTime time2 = LocalTime.parse(teclado.nextLine());
        if(horaMayor(time, time2)==time){
            segundos += (time.getHour()-time2.getHour())*3600;
            segundos += (time.getMinute()-time2.getMinute())*60;
            segundos += (time.getSecond()-time2.getSecond());
        }else{
            segundos += (time2.getHour()-time.getHour())*3600;
            segundos += (time2.getMinute()-time.getMinute())*60;
            segundos += (time2.getSecond()-time.getSecond());
        }
        System.out.println(segundos);
    }

    void solucionD () {
        
    }

    public static void main(String[] args) {
        System.out.println("\nApartado a)");
        //solucionA();

        System.out.println("\nApartado b)");
        //solucionB();

        System.out.println("\nApartado c)");
        solucionC();
        teclado.close();
    }
}

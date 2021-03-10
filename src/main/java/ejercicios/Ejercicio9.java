package ejercicios;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalTime;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 6.9. Ejercicios de fechas. Usando las clases de Java para el manejo de
 * fechas, realiza programas con la siguiente funcionalidad: a) Introducir tu
 * fecha de nacimiento y muestre cuantos días han pasado hasta ahora mismo. b)
 * Introducir una fecha y un número de días y calcule la fecha que se obtiene al
 * incrementar dichos días a la fecha. c) Introducir dos horas de reloj y nos dé
 * la diferencia entre ambas en segundos. d) ¿Cuántos años bisiestos ha habido
 * desde el ano 1 dC? e) Introducir una fecha y mostrar el día de la semana que
 * le corresponde. f) Introducir un tipo de producto (1- perecedero,
 * 2-electrónica, 3-ropa) y la fecha de compra, y que informe si se puede
 * devolver a día de hoy o no (los plazos de devolución, son respectivamente 5
 * horas, 6 meses, 15 días) g) Introducir un ano y decir cuántos domingos tiene.
 * h) Indica el día de la semana (en texto, en gallego) del 31 de diciembre de
 * los últimos 5 años.
 */

public class Ejercicio9 {
    static Scanner teclado = new Scanner(System.in);
    static DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    static void promptFecha() {
        System.out.println("Escribe una fecha aaaa-mm-dd");
    }

    static void promptHora() {
        System.out.println("Escribe una hora hh:mm:ss");
    }

    static void solucionA() {
        int dias = 0;
        LocalDate date = LocalDate.now();
        promptFecha();
        LocalDate birthDate = LocalDate.parse(teclado.nextLine());
        dias += date.getDayOfYear() - birthDate.getDayOfYear();
        dias += (date.getYear() - birthDate.getYear()) * 365;
        System.out.println("Desde " + birthDate.format(df) + " han pasado " + dias + " días");
    }

    static void solucionB() {
        promptFecha();
        LocalDate date = LocalDate.parse(teclado.nextLine());
        System.out.println("Introduce los días");
        int dias = Integer.parseInt(teclado.nextLine());
        System.out.println("La fecha " + date.format(df) + " más " + dias + " días da como resultado "
                + date.plusDays(dias).format(df));

    }

    static LocalTime horaMayor(LocalTime time, LocalTime time2) {
        if (time.getHour() > time2.getHour()
                || time.getHour() == time2.getHour() && time.getMinute() > time2.getMinute()
                || time.getMinute() == time2.getMinute() && time.getSecond() > time2.getSecond())
            return time;
        else
            return time2;
    }

    static void solucionC() {
        int segundos = 0;
        promptHora();
        LocalTime time = LocalTime.parse(teclado.nextLine());
        promptHora();
        LocalTime time2 = LocalTime.parse(teclado.nextLine());
        if (horaMayor(time, time2) == time) {
            segundos += (time.getHour() - time2.getHour()) * 3600;
            segundos += (time.getMinute() - time2.getMinute()) * 60;
            segundos += (time.getSecond() - time2.getSecond());
        } else {
            segundos += (time2.getHour() - time.getHour()) * 3600;
            segundos += (time2.getMinute() - time.getMinute()) * 60;
            segundos += (time2.getSecond() - time.getSecond());
        }
        System.out.println(segundos);
    }

<<<<<<< HEAD
    static void solucionD () {
        int contador = 0;
        for (int i = 1; i < LocalDate.now().getYear(); i++) {
            if(i % 4 == 0)
                contador++;
        }
        System.out.println("Han pasado " + contador +" años bisiestos." );
    }

    static void solucionE (){
        String dias [] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        promptFecha();
        LocalDate fecha = LocalDate.parse(teclado.nextLine());
        System.out.println("Estamos a " + dias[fecha.getDayOfWeek().getValue()-1]);
=======
    static void solucionD() {
        int contador = 0;
        for (int i = 0; i < LocalDate.now().getYear(); i++) {
            if (i % 4 == 0)
                contador++;
        }
        System.out.println("Han pasado " + contador + " años bisiestos");
    }

    static void solucionE() {
        String[] semana = { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo" };
        promptFecha();
        LocalDate fecha = LocalDate.parse(teclado.nextLine());
        System.out.println("Hoy es " + semana[fecha.getDayOfWeek().getValue()]);
    }

    static String[] getDataF() {
        String[] tipo = { "Perecedero", "Electrónica", "Ropa" };
        int tipoProducto = 3;
        String fechayHora = "";
        LocalDate fechaCompra = null;
        LocalTime horaCompra = null;
        String[] dataF = new String[3];

        System.out.println("Introduce un tipo de producto");
        System.out.println("1: " + tipo[0]);
        System.out.println("2: " + tipo[1]);
        System.out.println("3: " + tipo[2]);
        tipoProducto = (Integer.parseInt(teclado.nextLine())) - 1;
        System.out.println("Introduce una fecha y hora de compra en formato aaaa-mm-dd//hh:mm:ss");
        fechayHora = teclado.nextLine();
        while (fechaCompra == null && horaCompra == null) {
            try {
                fechaCompra = LocalDate.parse(fechayHora.substring(0, 10));
                horaCompra = LocalTime.parse(fechayHora.substring(12));
            } catch (Exception e) {
                System.err.println("Has introducido mal los datos");
            }
        }
        dataF[0] = Integer.toString(tipoProducto);
        dataF[1] = fechayHora.substring(0, 10);
        dataF[2] = fechayHora.substring(12);
        return dataF;
    }

    static void solucionF(String[] datos) {
        final String NADANDENADA = "No puedes devolverlo";
        LocalDate fechaCompra = LocalDate.parse(datos[1]);
        LocalTime horaCompra = LocalTime.parse(datos[2]);
        switch (Integer.parseInt(datos[0])) {
        case 0:
            if (fechaCompra == LocalDate.now() && horaCompra.getSecond() - LocalTime.now().getSecond() <= 5 * 3600)
                System.out.println("Pudes devolverlo");
            else
                System.out.println(NADANDENADA);
            break;
        case 1:
            if (fechaCompra.getYear() == LocalDate.now().getYear()
                    && fechaCompra.getMonthValue() - LocalDate.now().getMonthValue() < 6)
                System.out.println("Puedes devolverlo");
            else
                System.out.println(NADANDENADA);
            break;
        case 2:
            if (LocalDate.now().getDayOfYear() - fechaCompra.getDayOfYear() <= 15)
                System.out.println("Puedes devolverlo");
            else
                System.out.println(NADANDENADA);
            break;
        default:
            System.out.println("Talojo");
        }
        System.out.println(fechaCompra + " " + horaCompra);
    }

    static void solucionG() {
        final String inicioFecha = "-01-01";
        int cuentaDomingos = 0;
        int ano = 0;
        LocalDate fecha;
        System.out.println("Introduce un año");
        ano = Integer.parseInt(teclado.nextLine());
        switch (Integer.toString(ano).length()) {
        case 1:
            fecha = LocalDate.parse("000" + ano + inicioFecha);
            break;
        case 2:
            fecha = LocalDate.parse("00" + ano + inicioFecha);
            break;
        case 3:
            fecha = LocalDate.parse("0" + ano + inicioFecha);
            break;
        case 4:
            fecha = LocalDate.parse(ano + inicioFecha);
            break;
        default:
            System.out.println("Parámetros mal introducidos, se usará la fecha actual");
            fecha = LocalDate.now();
            break;
        }
        while (fecha.getDayOfWeek() != DayOfWeek.SUNDAY)
            fecha = fecha.plusDays(1);
        if (fecha.getYear() % 4 == 0) {
            while (fecha.getDayOfYear() < 366) {
                if (fecha.getDayOfWeek() == DayOfWeek.SUNDAY)
                    cuentaDomingos++;
                fecha = fecha.plusDays(1);
            }
        } else {
            while (fecha.getDayOfYear() < 365) {
                if (fecha.getDayOfWeek() == DayOfWeek.SUNDAY)
                    cuentaDomingos++;
                fecha = fecha.plusDays(1);
            }
        }
        System.out.println("En este año hubo " + cuentaDomingos + " domingos");
    }

    static void solucionH() {
        LocalDate fecha = LocalDate.parse("2021-12-31");
        for (int i = 0; i < 5; i++) {
            fecha = fecha.minusYears(1);
            System.out.println(fecha.getDayOfWeek());
        }
>>>>>>> 886c064295144d7c78197f4cccb6c3d172c5b800
    }

    public static void main(String[] args) {
        System.out.println("\nApartado a)");
        solucionA();

        System.out.println("\nApartado b)");
        solucionB();

        System.out.println("\nApartado c)");
<<<<<<< HEAD
        //solucionC();
=======
        solucionC();
>>>>>>> 886c064295144d7c78197f4cccb6c3d172c5b800

        System.out.println("\nApartado d)");
        solucionD();

        System.out.println("\nApartado e)");
        solucionE();

        System.out.println("\nApartado f)");
<<<<<<< HEAD
=======
        solucionF(getDataF());

        System.out.println("\nApartado g)");
        solucionG();

        System.out.println("\nApartado h)");
        solucionH();
>>>>>>> 886c064295144d7c78197f4cccb6c3d172c5b800

        teclado.close();
    }
}

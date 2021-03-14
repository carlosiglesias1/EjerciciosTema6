package ejercicios;

import java.time.LocalDate;

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

public class Alumno {
    private String nombre;
    private String dni;
    private LocalDate fechaNacimiento;
    private String nombreEscuela;

    public Alumno(String name, String id, LocalDate date, String escuela) {
        this.nombre = name;
        this.dni = id;
        this.fechaNacimiento = date;
        this.nombreEscuela = escuela;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getDNI() {
        return this.dni;
    }

    public String getfechaNacimiento() {
        return this.fechaNacimiento.toString();
    }

    public String getSchool() {
        return this.nombreEscuela;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    static boolean isLetter(char letter) {
        try {
            Integer.parseInt(String.valueOf(letter));
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    static int countLetters(String dni) {
        int counter = 0;
        for (int i = 0; i < dni.length(); i++) {
            if (isLetter(dni.charAt(i)))
                counter++;
        }
        return counter;
    }

    public boolean setDNI(String dni) {
        if (dni.length() > 9 || countLetters(dni) > 1)
            return false;
        else {
            this.dni = dni;
            return true;
        }
    }

    public void setfechaNacimiento(LocalDate birth) {
        this.fechaNacimiento = birth;
    }

    public void setSchool(String school) {
        this.nombreEscuela = school;
    }

    public boolean esMayorEdad() {
        LocalDate now = LocalDate.now();
        if (now.getDayOfYear() - this.fechaNacimiento.getYear() > 18
                || now.getYear() - this.fechaNacimiento.getYear() == 18
                        && now.getMonth().getValue() > this.fechaNacimiento.getMonth().getValue()
                || now.getMonth().getValue() == this.fechaNacimiento.getMonth().getValue()
                        && now.getDayOfMonth() > this.fechaNacimiento.getDayOfMonth())
            return true;
        else
            return false;
    }

    public boolean esMayor(LocalDate birthDate) {
        if (birthDate.getDayOfYear() < this.fechaNacimiento.getYear()
                || birthDate.getYear() == this.fechaNacimiento.getYear()
                        && birthDate.getMonth().getValue() < this.fechaNacimiento.getMonth().getValue()
                || birthDate.getMonth().getValue() == this.fechaNacimiento.getMonth().getValue()
                        && birthDate.getDayOfMonth() < this.fechaNacimiento.getDayOfMonth())
            return true;
        else
            return false;
    }

    public boolean estaCopiado (Alumno chaval){
        if(this.nombre.equals(chaval.nombre) && this.dni.equals(chaval.dni) && this.fechaNacimiento == chaval.fechaNacimiento && this.nombreEscuela.equals(chaval.nombreEscuela))
            return true;
        else
            return false;
    }
}

package ejercicios;

import java.util.Scanner;

import recursos.Circulo;

/**
 * 6.7. Implementar una clase llamada Circulo, que tiene solo la propiedad radio
 * y los métodos setRadio, getRadio, calcularCircunferencia, calcularSuperficie,
 * calcularDiametro además de un constructor. Crea un programa que use esta
 * clase creando un par de círculos y usando los métodos creados. ¿El atributo
 * radio puede ser privado?
 */

public class Ejercicio7 {
    public static void main(String[] args) {
        Circulo circulo;
        Scanner teclado = new Scanner(System.in);

        System.out.println("Introduce un radio para crear la circunferencia");
        circulo = new Circulo(teclado.nextInt());
        System.out.println("La longitud de la circunferencia es "+circulo.calcularCircunferencia());
        System.out.println("El área del círculo es "+ circulo.cularSuperficie());
        System.out.println("El diámetro del círculo es "+circulo.calcularDiametro());
        System.out.println("El radio de tu círculo es de " + circulo.getRadio());
        System.out.println("Ahora vamos a cambiar el radio: ");
        System.out.print("\t Introduce otro radio:");
        circulo.setRadio(teclado.nextInt());
        System.out.println("La longitud de la nueva circunferencia es "+circulo.calcularCircunferencia());
        System.out.println("El área del nuevo círculo es "+ circulo.cularSuperficie());
        System.out.println("El diámetro del nuevo círculo es "+circulo.calcularDiametro());
        System.out.println("El radio de tu círculo es de " + circulo.getRadio());
        teclado.close();

    }
}

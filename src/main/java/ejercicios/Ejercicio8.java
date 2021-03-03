package ejercicios;

import java.util.Scanner;

import recursos.EjemplarLibro;

/**6.8. Implementar una clase llamada EjemplarLibro que se va a usar en una biblioteca y
que tiene los siguientes atributos:
- Título de libro (se le pone en el momento del alta)
- Fecha de adquisición (es la fecha del sistema en el momento del alta)
- Número de ejemplar: 1, 2, 3, etc. (de un mismo libro, la biblioteca tiene varios ejemplares)
- Prestado (sí /no). Inicialmente no está prestado.
Además, tiene los siguientes métodos:
- Constructor 1: cuando es el primer ejemplar de un determinado título, se le pasa como
parámetro solo el título del libro. El resto de datos los puede calcular él.
- Constructor 2: se le pasa como parámetro un libro y copia todos sus atributos salvo el
número de ejemplar que será 1 más el del libro pasado.
- Prestar (): si no está prestado lo marca como prestado y devuelve true¸ si está prestado no
hace nada y devuelve false.
- Devolver (): si está prestado lo marca como no prestado y devuelve true¸ si no está
prestado no hace nada y devuelve false.
- toString (): Genera un String con el nombre, la fecha entre paréntesis y el número de
ejemplar entre corchetes. Este método se usará para sacar por pantalla de forma cómoda los
datos de un libro.
Haz un main() que cree 4 libros (probando ambos constructores), que realice algún
préstamo y devolución, y finalmente muestre los libros -con toString()-. 
*/

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        EjemplarLibro [] libro = new  EjemplarLibro [2];
        
        System.out.println("Introduce el título de un libro");
        libro [0] = new EjemplarLibro(teclado.nextLine());
        System.out.println("Se ha dado de alta " + libro[0].toString());

        System.out.println("\nAhora daremos de alta otro ejemplar del libro anterior");
        libro [1] = new EjemplarLibro(libro[0]);
        System.out.println("Hemos dado de alta "+libro[1].toString());

        System.out.println("\nAhora prestaremos un libro");
        if(libro[0].prestar())
            System.out.println("\tAla, ya hemos prestado " + libro[0].toString());
        else
            System.out.println("\tVaya, algo ha fallado, debe de estar leyendolo alguien");
        
        System.out.println("\nAhora no podemos prestar más ese libro, pero podemos prestar el otro ejemplar");
        System.out.println("Anda! Han venido a devolver el libro " + libro[0].toString());
        if(libro[0].devolver())
            System.out.println("\tHurra! Lo hemos recuperado");
        else
            System.out.println("\tVaya, algo ha fallado, debe de estar leyendolo alguien");
        teclado.close();
    }
}

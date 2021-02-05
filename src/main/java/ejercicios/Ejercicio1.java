package ejercicios;

/**A partir de la clase MovilPrepago que te proporcionará el profesor, haz un programa
en el que se cree un teléfono con unas características determinadas y luego ejecute una
serie de actividades como recargar 10 euros, llamar 30 seguntos, navegar 10MB, etc.
Viendo cómo se va modificando el saldo. 
*/
import recursos.MovilPrepago;

public class Ejercicio1 {

    private static final String SALDO_ACTUAL = "Saldo actual: ";

    public static void main(String[] args) {
        MovilPrepago telefono = new MovilPrepago(627195654, 1.05f, 0.30f, 5.00f, 10.00f);
        System.out.println("\nRecargas 10€\n");
        telefono.recargar(10);
        System.out.println(SALDO_ACTUAL + telefono.consultarSaldo());
        System.out.println("\nVas a hacer una llamada de 4 minutos\n");
        telefono.efectuarLlamada(240);
        System.out.println("\nVas a navegar 10 megas\n");
        System.out.println(SALDO_ACTUAL + telefono.consultarSaldo());
        for (int i = 1; i < 10; i++) {
            if (telefono.consultarSaldo() > 0) {
                telefono.navegar(i);
                System.out.println(SALDO_ACTUAL + telefono.consultarSaldo());
            }
        }
    }
}

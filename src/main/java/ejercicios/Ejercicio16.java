package ejercicios;

import recursos.juegogato.*;

public class Ejercicio16 {
    public static void main(String[] args) {
        TableroGatoRaton tablero = new TableroGatoRaton();
        Gato gato = new Gato(tablero.getLongitudTablero());
        Raton raton = new Raton(tablero.getLongitudTablero());

        tablero.setGato(gato.getPosicion());
        tablero.setRaton(raton.getPosicion()[0], raton.getPosicion()[1]);
        tablero.pintarTablero();
        System.out.println();

        while(gato.getPosicion() != raton.getPosicion()){
            tablero.registrarMovimientoRaton(raton);
            tablero.setRaton(raton.getPosicion()[0], raton.getPosicion()[1]);
            tablero.pintarTablero();
            System.out.println();
            tablero.registrarMovimientoGato(gato, raton);
            tablero.setGato(gato.getPosicion());
            tablero.pintarTablero();
            System.out.println();
        }
    }
}

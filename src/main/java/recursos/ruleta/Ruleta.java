package recursos.ruleta;

import java.util.Random;

/**
 * 6.14. Diseña una clase llamada Ruleta y un programa que la use, con la
 * siguiente funcionalidad. - El jugador puede apostar lo que quiera a par o a
 * impar . - En cada juego obtiene un número al azar entre 0 y 36 - Si sale 0
 * pierde tanto par como impar, y en caso contrario si el jugador acierta (par o
 * impar) gana tanto como lo apostado. Define los métodos necesarios para que
 * los usuarios puedan apostar a par o impar. Hacer un programa en el que un
 * jugador lleve 10.000 euros y juegue 10.000 veces 1 euro cada vez siempre
 * apostando a par ¿Con cuánto dinero acaba? El resultado final puede ir entre 0
 * y 20.000 euros. Ejecútalo varias veces.
 */

public class Ruleta {
    private int numeroGanador;
    static Random posicion = new Random();
    
    public Ruleta () {
        //new ruleta
    }

    public void setRuleta (){
        this.numeroGanador = posicion.nextInt(37);
    }

    public int getNumeroGanador(){
        return numeroGanador;
    }

}

package ejercicios;

import recursos.ruleta.*;

public class Ejercicio14 {
    public static void main(String[] args) {
        final int MAX = 20000;
        final int MIN = 0;
        int count = 0;
        Jugador player = new Jugador(10000);
        for (int i = 0; i < 10000; i++) {
            player.apostarPar(1);
            if(player.jugar())
                System.out.println("Has ganado");
            if(player.getDinero()<MIN || player.getDinero() > MAX)
                break;
            count++;
        }
        System.out.println(player.getDinero()+ " en "+count+" intentos");
    }
}


//Pierde todas las veces que juega a la ruleta
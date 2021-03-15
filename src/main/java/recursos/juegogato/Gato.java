package recursos.juegogato;

import java.util.Random;

public class Gato {
    private int [] posicion = new int [2];

    public Gato (int x, int y){
        this.posicion[0] = x;
        this.posicion[1] = y;
    }

    public void mover (Raton raton){
        if(Math.abs(raton.getPosicion()[0]-this.posicion[0])>Math.abs(raton.getPosicion()[1]-this.posicion[1])){
            this.posicion[1]++;
        }
        else
            this.posicion[0]++;
    }
}

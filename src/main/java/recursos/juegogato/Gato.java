package recursos.juegogato;

import java.util.Random;

public class Gato {
    private int [] posicion = new int [2];
    private Random numRandom = new Random();

    public Gato (int indice){
        this.posicion[0] = numRandom.nextInt(indice);
        this.posicion[1] = numRandom.nextInt(indice);
    }

    public int [] getPosicion (){
        return posicion;
    }

    public void mover (Raton raton){
        if(Math.abs(raton.getPosicion()[0]-this.posicion[0])>Math.abs(raton.getPosicion()[1]-this.posicion[1])){
            if(raton.getPosicion()[1]-this.posicion[1]>0)
                this.posicion[1]++;
            else
                this.posicion[1]--;
        }
        else{
            if(raton.getPosicion()[0]-this.posicion[0]>0)
                this.posicion[0]++;
            else
                this.posicion[0]--;
        }
    }
}

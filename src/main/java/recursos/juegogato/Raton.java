package recursos.juegogato;

import java.util.Random;

public class Raton {
    private int[] posicion = new int[2];
    static Random direccion = new Random();

    public Raton(int x, int y) {
        posicion[0] = x;
        posicion[1] = y;
    }

    public Raton (){
        //para que el gato sepa donde esta
        posicion[0] = this.posicion[0];
        posicion[1] =this.posicion[1];
    }

    protected int[] getPosicion() {
        return this.posicion;
    }

    public void mover (){
        int eje = direccion.nextInt(4);
        switch (eje){
            case 0:
                this.posicion[0] += 2;
                break;
            case 1:
                this.posicion[0] -=2;
                break;
            case 2:
                this.posicion[1] +=2;
                break;
            case 3:
                this.posicion[1] -=2;
                break;
            default:System.out.println("Got to think about it");
                break;

        }
    }
}

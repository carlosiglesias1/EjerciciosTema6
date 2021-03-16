package recursos.juegogato;

import java.util.Random;

public class Raton {
    private int[] posicion = new int[2];
    static Random direccion = new Random();

    public Raton (int indice){
        posicion[0] = direccion.nextInt(indice);
        posicion[1] = direccion.nextInt(indice);
    }

    public int[] getPosicion() {
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

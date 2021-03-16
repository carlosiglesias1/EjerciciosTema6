package recursos.juegogato;

import java.util.Random;

public class Gato {
    private int[] posicion = new int[2];
    private Random numRandom = new Random();

    public Gato(int indice) {
        this.posicion[0] = numRandom.nextInt(indice);
        this.posicion[1] = numRandom.nextInt(indice);
    }

    public int[] getPosicion() {
        return posicion;
    }

    private void acercarseEjeX(Raton raton) {
        int distanciaEjeX = raton.getPosicion()[0] - this.posicion[0];
        int distanciaEjeY = raton.getPosicion()[1] - this.posicion[1];
        if (distanciaEjeX > 0)
            this.posicion[0]++;
        else if (distanciaEjeX == 0) {
            if (distanciaEjeY > 0)
                this.posicion[1]++;
            else
                this.posicion[1]--;
        } else
            this.posicion[0]--;
    }

    private void acercarseEjeY(Raton raton) {
        int distanciaEjeX = raton.getPosicion()[0] - this.posicion[0];
        int distanciaEjeY = raton.getPosicion()[1] - this.posicion[1];
        if (distanciaEjeY > 0)
            this.posicion[1]++;
        else if (distanciaEjeY == 0) {
            if (distanciaEjeX > 0)
                this.posicion[0]++;
            else
                this.posicion[0]--;
        } else
            this.posicion[1]--;
    }

    public void mover(Raton raton) {
        int distanciaEjeX = raton.getPosicion()[0] - this.posicion[0];
        int distanciaEjeY = raton.getPosicion()[1] - this.posicion[1];
        if (Math.abs(distanciaEjeX) > Math.abs(distanciaEjeY)) {
            acercarseEjeY(raton);
        } else {
            acercarseEjeX(raton);
        }
    }
}

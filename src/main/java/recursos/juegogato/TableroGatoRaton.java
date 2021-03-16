package recursos.juegogato;

import java.util.Random;

public class TableroGatoRaton {
    private char [] [] tablero = new char [20] [20];
    Random numero = new Random();

    public int getLongitudTablero (){
        return tablero.length;
    }

    public void setGato (int [] posicion){
        tablero [posicion[0]][posicion[1]] = 'G';
    }

    public void setRaton (int x, int y){
        tablero [x][y] = 'R';
    }

    public TableroGatoRaton () {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                tablero[i][j] = '*';
            }
        }
    }

    private boolean posicionValida (int [] posicion){
        if(posicion[0]<tablero.length && posicion[1]<tablero.length && posicion[0] >= 0 && posicion[1] >= 0)
            return true;
        else
            return false;
    }

    public void registrarMovimientoGato (Gato gato, Raton raton){
        tablero[gato.getPosicion()[0]][gato.getPosicion()[1]] = '*';
        do{
            gato.mover(raton);
        }while(!posicionValida(gato.getPosicion()));
    }

    public void registrarMovimientoRaton (Raton raton){
        tablero[raton.getPosicion()[0]][raton.getPosicion()[1]] = '*';
        do{
            raton.mover();
        }while(!posicionValida(raton.getPosicion())|| tablero[raton.getPosicion()[0]][raton.getPosicion()[1]]=='G');
    }

    public void pintarTablero () {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero.length; j++) {
                System.out.print(tablero[j][i]);
            }
            System.out.println();
        }
    }
}

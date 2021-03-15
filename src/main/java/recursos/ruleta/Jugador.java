package recursos.ruleta;

public class Jugador extends Ruleta {
    private int dinero;
    protected int [] apuestasEnNumeros = new int [37];
    
    public Jugador (int fondos){
        super();
        this.dinero = fondos;
    }

    public int getDinero (){
        return dinero;
    }

    public void apostarNumero (int numeroApostado, int cantidad) {
        apuestasEnNumeros[numeroApostado] = cantidad;
    }

    public void apostarPar (int cantidad){
        dinero -= cantidad;
        for (int i = 2; i < apuestasEnNumeros.length; i++) {
            if(i%2 == 0){
                apuestasEnNumeros[i] = cantidad;
            }
        }
    }

    public void apostarImpar (int cantidad){
        dinero -= cantidad;
        for (int i = 0; i < apuestasEnNumeros.length; i++) {
            if(i%2 != 0){
                apuestasEnNumeros[i] = cantidad;
            }
        }
    }

    public boolean jugar (){
        super.setRuleta(); 
        if(apuestasEnNumeros[super.getNumeroGanador()]==0)
            return false;
        else{
            this.dinero += apuestasEnNumeros[super.getNumeroGanador()]*2;
            return true;
        }
    }
}

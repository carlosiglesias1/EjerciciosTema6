package recursos.ruleta;

public class PruebaBeneficios {
    public static void main(String[] args) {
        Jugador player1 = new Jugador(10000);
        final int MIN = 0;
        int count = 0;
        while(player1.getDinero()<10010 && player1.getDinero()>MIN){
            player1.apostarPar(1);
            player1.jugar();
            System.out.println(player1.getDinero());
            count++;
        }
        System.out.println(player1.getDinero()+ " en "+count+" intentos");
    }
}

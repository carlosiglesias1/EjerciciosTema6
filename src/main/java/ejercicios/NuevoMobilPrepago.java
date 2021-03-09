package ejercicios;

import java.util.Random;

/**
 * 6.10. Desarrolla la clase MovilPrepago que te proporcionó el profesor para
 * ejercicios anteriores y compárala con la proporcionada.
 */

public class NuevoMobilPrepago {
    private String numeroMovil;
    private final float costeEstablecLlamada;
    private final float costeMinutoLlamada;
    private final float costeConsumoMB;
    private float saldo;

    static String generatePhoneNumber() {
        Random generator = new Random();

        String strippedNum;
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;

        num1 = generator.nextInt(600) + 100;
        num2 = generator.nextInt(641) + 100;
        num3 = generator.nextInt(8999) + 1000; 

        strippedNum = Integer.toOctalString(num1);
        return strippedNum + num2 + num3;
    }

    public NuevoMobilPrepago(float cell, float cml, float ccmb) {
        numeroMovil = generatePhoneNumber();
        costeEstablecLlamada = cell;
        costeMinutoLlamada = cml;
        costeConsumoMB = ccmb;
        saldo = 0.0f;
    }

    public String getNumber() {
        return numeroMovil;
    }

    public boolean recarga(int importe) {
        if (importe % 5 == 0)
            return false;
        else {
            saldo += importe;
            return true;
        }
    }

    public void llamar(int segundos) {
        saldo -= Math.round(costeEstablecLlamada + costeMinutoLlamada / 60 * segundos * 100f) / 100f;
        if (saldo < 0)
            saldo = 0;
    }

    public void navegar(int mb) {
        saldo -= Math.round(costeConsumoMB * mb * 100f) / 100f;
        if (saldo < 0)
            saldo = 0;
    }

    public float consultarSaldo() {
        return saldo;
    }
}

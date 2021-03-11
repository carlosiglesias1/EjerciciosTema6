package ejercicios;

import java.util.ArrayList;

/**
 * 6.11. Desarrolla la clase CuentaCorriente que te proporcionó el profesor para
 * ejercicios anteriores y compárala con la proporcionada.
 */

public class NuevaCuentaCorriente {
    private String IBAN;
    private float saldo;
    private int contadorIngresos;
    private static ArrayList <String []> movimientos = new ArrayList <String []>();
    private static float porcentajeComision;
    private static float minimoComision;

    static String calcularIBAN(String codigoPais, String entidad, String oficina, String dc, String numeroCuenta) {
        return entidad + oficina + dc + numeroCuenta + codigoPais + "00";
    }

    public NuevaCuentaCorriente(String codigoPais, String entidad, String oficina, String DigitoControl,
            String numeroCuenta) {
        IBAN = calcularIBAN(codigoPais, entidad, oficina, DigitoControl, numeroCuenta);
        saldo = 0.0f;
        contadorIngresos = 0;
    }

    public static float getPorcentajeComision() {
        return porcentajeComision;
    }

    public static float getMinimoCosmision() {
        return minimoComision;
    }

    public float getSaldo() {
        return saldo;
    }

    static void registrarMovimiento (int tipo, float importe){
        movimientos.add(new String[]{Integer.toString(tipo),Float.toString(importe)});
    }

    static void imprimirMovimientos (){
        String [] tipo = {"Ingreso", "Retirada"};
        for (int i = 0; i < movimientos.size(); i++) {
            if(movimientos.get(i)[0].equals("0"))
                System.out.println(tipo[0]);
            else
                System.out.println();
            System.out.println("\t"+movimientos.get(i)[1]+"\n");
        }
    }

    public void ingresar(float importe) {
        float bonus = 0;
        if (++contadorIngresos == 3) {
            contadorIngresos = 0;
            bonus = 0.7f;
        }
        saldo += importe + bonus;
        registrarMovimiento(0, importe);
    }

    public boolean retirar(float importe) {
        float comision;
        if (porcentajeComision * importe < minimoComision)
            comision = minimoComision;
        else
            comision = porcentajeComision * importe;
        if (importe + comision <= saldo) {
            saldo -= importe + comision; // resta (importe+comision)
            contadorIngresos = 0;
            registrarMovimiento(1, importe);
            return true;
        } else
            return false;
    }
}

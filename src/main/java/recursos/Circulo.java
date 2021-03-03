package recursos;

/**
 * 6.7. Implementar una clase llamada Circulo, que tiene solo la propiedad radio
 * y los métodos setRadio, getRadio, calcularCircunferencia, calcularSuperficie,
 * calcularDiametro además de un constructor. Crea un programa que use esta
 * clase creando un par de círculos y usando los métodos creados. ¿El atributo
 * radio puede ser privado?
 */

public class Circulo {
    private int radio;
    
    public Circulo (int radius){
        this.radio = radius;
    }

    public void setRadio (int radius) {
        this.radio = radius;
    }

    public int getRadio () {
        return this.radio;
    }

    public float calcularCircunferencia (){
        float longitud = 0;
        longitud = 3.14159f * 2 * radio;
        return longitud;
    }

    public float cularSuperficie () {
        float superficie = 0;
        superficie = 3.14159f * (radio * radio);
        return superficie; 
    }

    public int calcularDiametro () {
        return this.radio * 2;
    }
}

package br.com.consulta.soap;

public class SimpleDoubleZeroTest {

    public static void main(String[] args) {

        double doubleValue1 = 0.00000000;
        double doubleValue2 = 0.0001;
        double doubleValue3 = 0.0;

        if (Math.abs(doubleValue2) >= 2 * Double.MIN_VALUE) {
            System.out.println("valor != ZERO " + Math.abs(doubleValue2));
        } else {
            System.out.println("valor = ZERO " + Math.abs(doubleValue2));
        }

    }

}

package br.com.consulta.soap;

public class TesteDoubleCompare {

    public static void main(String[] args) {
        var um = 15.0;
        var dois = 15.1;

        if(Double.compare(um, dois) == 0) {
            System.out.println("iguais  " + Double.compare(um, dois));
        } else {
            System.out.println("diferente  " + Double.compare(um, dois));
        }
    }

}

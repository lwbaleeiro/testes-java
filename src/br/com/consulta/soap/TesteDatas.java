package br.com.consulta.soap;

import java.time.LocalDate;

public class TesteDatas {

    public static void main(String[] args) {

        LocalDate dateAntiga = LocalDate.parse("2015-07-30");

        int quantidadeAnos = LocalDate.now().compareTo(dateAntiga) + 1;

        for (var incrementer = 1; incrementer <= quantidadeAnos; incrementer++) {

            LocalDate dataFinal = dateAntiga.plusYears(incrementer);
            LocalDate dataInicial = dataFinal.minusYears(1);

            if (dataInicial.getYear() == LocalDate.now().getYear()) {
                dataFinal = LocalDate.now();
                System.out.println("passou aqui");
            }

            System.out.println( incrementer + " primeira data " + dataInicial + " segunda data " + dataFinal);
        }

//        LocalDate dataInicial = null;
//        LocalDate dataFinal = null;
//
//        var beginDate = java.sql.Date.valueOf(LocalDate.now());
//        var endDate = java.sql.Date.valueOf(LocalDate.now());
//
//        beginDate = java.sql.Date.valueOf(dataInicial.toString());
//        endDate = java.sql.Date.valueOf(dataFinal.toString());
//
//        System.out.println("begin date " +  beginDate);
//        System.out.println("endDate date " +  endDate);
    }
}

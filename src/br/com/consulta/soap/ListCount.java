package br.com.consulta.soap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListCount {

    public static void main(String[] args) {


        List<EvolucaoPatrimonial> evolucaoPatrimonialList = new ArrayList<>();

        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 28), "120.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 28), "120.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 24), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 24), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 24), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 24), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 25), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 25), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 25), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 25), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 26), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 26), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 26), "100.00"));
        evolucaoPatrimonialList.add(new EvolucaoPatrimonial(LocalDate.of(2021, 12, 26), "100.00"));

        Map<String, Long> quantidadeCertificadosPorData =
                evolucaoPatrimonialList.stream().collect(Collectors.groupingBy(e -> e.acumulado, Collectors.counting()));

        var quantidadeCertificados = "120.00";

        for (String acumulado : quantidadeCertificadosPorData.keySet()) {
//            if (quantidadeCertificadosPorData.get(acumulado) == quantidadeCertificados) {
//                evolucaoPatrimonialList.removeIf(evolucaoPatrimonial -> evolucaoPatrimonial.acumulado.equals(quantidadeCertificados));
//            }
        }

 //      evolucaoPatrimonialList.removeIf(evolucaoPatrimonial -> evolucaoPatrimonial.date == finalDataASerRemovida);

//        var collect = evolucaoPatrimonialList
//                .stream()
//                .filter(e -> e.date != finalDataASerRemovida)
//                .collect(Collectors.toList());


        System.out.println(evolucaoPatrimonialList);
    }

    private static class EvolucaoPatrimonial {
        private LocalDate date;
        private String acumulado;

        public EvolucaoPatrimonial(LocalDate date, String acumulado) {
            this.date = date;
            this.acumulado = acumulado;
        }

        @Override
        public String toString() {
            return "EvolucaoPatrimonial{" +
                    "date=" + date +
                    ", acumulado=" + acumulado +
                    '}';
        }
    }

}

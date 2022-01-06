package br.com.consulta.soap;

public class SplitAppRendaFixa {

    public static void main(String[] args) {
//        var objeto = "{\n" +
//                "  \"fundos\": {\n" +
//                "    \"29.722.458/0001-36\": {\n" +
//                "      \"rentabilidade\": {\n" +
//                "        \"mes_anterior\": \"-4.57\",\n" +
//                "        \"mes_corrente\": \"2.46\",\n" +
//                "        \"ano_corrente\": \"-0.71\",\n" +
//                "        \"tres_meses\": \"-8.79\",\n" +
//                "        \"seis_meses\": \"-8.00\",\n" +
//                "        \"doze_meses\": \"6.15\",\n" +
//                "        \"vinte_quatro_meses\": \"N/A\",\n" +
//                "        \"trinta_seis_meses\": \"N/A\",\n" +
//                "        \"total\": \"N/A\"\n" +
//                "      },\n" +
//                "      \"volatilidade\": {\n" +
//                "        \"mes_corrente\": \"15.31\",\n" +
//                "        \"ano_corrente\": \"14.34\",\n" +
//                "        \"tres_meses\": \"14.64\",\n" +
//                "        \"seis_meses\": \"12.61\",\n" +
//                "        \"doze_meses\": \"13.93\",\n" +
//                "        \"vinte_quatro_meses\": \"24.86\",\n" +
//                "        \"trinta_seis_meses\": \"21.57\",\n" +
//                "        \"total\": \"21.40\"\n" +
//                "      },\n" +
//                "      \"pl_12_meses\": 317019518.46,\n" +
//                "      \"dt_cota\": \"2021-11-12T00:00:00\",\n" +
//                "      \"dt_abertura_fundo\": \"2018-05-02T00:00:00\",\n" +
//                "      \"cnpj_fundo\": \"29.722.458/0001-36\",\n" +
//                "      \"taxa_administracao\": 1.5,\n" +
//                "      \"benchmark\": \"DI de um dia\",\n" +
//                "      \"classe\": \"Multimercado\"\n" +
//                "    }\n" +
//                "  }\n" +
//                "}";

        var objeto = "{\n" +
                "\t\"fundos\": {\n" +
                "\t\t\"35.363.972/0001-25\": {\n" +
                "\t\t\t\"rentabilidade\": {\n" +
                "\t\t\t\t\"mes_anterior\": \"-2.45\",\n" +
                "\t\t\t\t\"mes_corrente\": \"1.64\",\n" +
                "\t\t\t\t\"ano_corrente\": \"-13.37\",\n" +
                "\t\t\t\t\"tres_meses\": \"-14.77\",\n" +
                "\t\t\t\t\"seis_meses\": \"-16.57\",\n" +
                "\t\t\t\t\"doze_meses\": \"-10.61\",\n" +
                "\t\t\t\t\"vinte_quatro_meses\": \"N/A\",\n" +
                "\t\t\t\t\"trinta_seis_meses\": \"N/A\",\n" +
                "\t\t\t\t\"total\": \"N/A\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"volatilidade\": {\n" +
                "\t\t\t\t\"mes_corrente\": \"16.32\",\n" +
                "\t\t\t\t\"ano_corrente\": \"15.30\",\n" +
                "\t\t\t\t\"tres_meses\": \"19.34\",\n" +
                "\t\t\t\t\"seis_meses\": \"16.45\",\n" +
                "\t\t\t\t\"doze_meses\": \"15.15\",\n" +
                "\t\t\t\t\"vinte_quatro_meses\": \"N/A\",\n" +
                "\t\t\t\t\"trinta_seis_meses\": \"27.58\",\n" +
                "\t\t\t\t\"total\": \"27.58\"\n" +
                "\t\t\t},\n" +
                "\t\t\t\"pl_12_meses\": 209082388.8,\n" +
                "\t\t\t\"dt_cota\": \"2021-12-23T00:00:00\",\n" +
                "\t\t\t\"dt_abertura_fundo\": \"2020-02-05T00:00:00\",\n" +
                "\t\t\t\"cnpj_fundo\": \"35.363.972/0001-25\",\n" +
                "\t\t\t\"taxa_administracao\": \"\",\n" +
                "\t\t\t\"benchmark\": \"OUTROS\",\n" +
                "\t\t\t\"classe\": \"Multimercado\"\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        String[] textoSeparadoDataCota = getTextoSeparado(objeto, ",", 6);

        for (String campo : textoSeparadoDataCota) {
            String campoValor = campo.replace("\"", "").trim();
            if (!campoValor.equals("vinte_quatro_meses")) {
                var mesCorrente = parseDoubleOrNull(campoValor);
                System.out.println(mesCorrente);
            }
        }

    }

    private static Double parseDoubleOrNull(String value) {
        try {
            return Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0D;
        }
    }

    private static String[] getTextoSeparado(String texto, String separador, int position) {
        String[] splitString = texto.split(separador);
        String base64EncodedBody = splitString[position];
        return base64EncodedBody.split(":");
    }

}

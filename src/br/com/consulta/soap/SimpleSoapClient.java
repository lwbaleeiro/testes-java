package br.com.consulta.soap;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleSoapClient {

    public static void main(String args[]) throws IOException {

        String address="Hyderabad";

        /* place your xml request from soap ui below with necessary changes in parameters*/

        String xml="<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:ws=\"http://www.YourUrlAsPerWsdl.com/\">\r\n" +
                "   <soapenv:Header/>\r\n" +
                "   <soapenv:Body>\r\n" +
                "      <ws:callRest>\r\n" +
                "         <name>"+"Hello"+"</name>\r\n" +
                "         <address>"+address+"</address>\r\n" +
                "      </ws:callRest>\r\n" +
                "   </soapenv:Body>\r\n" +
                "</soapenv:Envelope>";

        String xmlRequest = "<soapenv:Envelope\n" +
                "\txmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\"\n" +
                "\txmlns:cad=\"http://cadastro.ejb.enterprise.cadastros.servicos.sicredi.com.br/\">\n" +
                "\t<soapenv:Header/>\n" +
                "\t<soapenv:Body>\n" +
                "\t\t<cad:buscarGerenteConta>\n" +
                "\t\t\t<inBuscarGerenteConta>\n" +
                "\t\t\t\t<codAgencia>0101</codAgencia>\n" +
                "\t\t\t\t<codUA>12</codUA>\n" +
                "\t\t\t\t<numConta>839714</numConta>\n" +
                "\t\t\t</inBuscarGerenteConta>\n" +
                "\t\t</cad:buscarGerenteConta>\n" +
                "\t</soapenv:Body>\n" +
                "</soapenv:Envelope>";

        String responseF=callSoapService(xmlRequest);
        System.out.println(responseF);
    }


    static String callSoapService(String soapRequest) {
        try {
            String url = "http://ws-cadastro.hom.sicredi.net:80/InformacoesCadastraisService/InformacoesCadastraisService"; // replace your URL here
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // change these values as per soapui request on top left of request, click on RAW, you will find all the headers
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(soapRequest);
            wr.flush();
            wr.close();
            String responseStatus = con.getResponseMessage();
            System.out.println(responseStatus);
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // You can play with response which is available as string now:
            String finalvalue = response.toString();
            System.out.println("Object: " +  response);

            // or you can parse/substring the required tag from response as below based your response code
            //finalvalue = finalvalue.substring(finalvalue.indexOf("<response>") + 10, finalvalue.indexOf("</response>"));

            return finalvalue;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}


package br.com.projetotca.Pagamento;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DadosDoCartao {
    private String nomeTitular;
    private String numeroCartao;
    private String codigoSeguranca;
    private String dataValidade;
    private Scanner input = new Scanner(System.in);

    public void perguntarDados() {
            System.out.println("Nome do titular: ");
            nomeTitular = input.nextLine();

            System.out.println("Número do cartão: ");
            numeroCartao = input.nextLine();
            while (numeroCartao.length() != 16) {
                System.out.println("O número do cartão deve conter 16 dígitos.\n");
                System.out.println("Número do cartão: ");
                numeroCartao = input.nextLine();
            }
            System.out.println("Código de segurança: ");
            codigoSeguranca = input.nextLine();
            while (codigoSeguranca.length() != 3) {
                System.out.println("O código de segurança deve conter 3 dígitos.\n");
                System.out.println("Código de segurança: ");
                codigoSeguranca = input.nextLine();
            }
            System.out.println("Data de validade (MM/yy): ");
            dataValidade = input.nextLine();
            while (!validarFormatoData(dataValidade)) {
                System.out.println("A data de validade deve estar no formato MM/yy.\n");
                System.out.println("Data de validade (MM/yy): ");
                dataValidade = input.nextLine();
               break; }
            }

    private boolean validarFormatoData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return data.matches("\\d{2}/\\d{2}");
        }
    }
}


//*****************************************************************************************************
//
//            if (numeroCartao.length() != 16) {
//                System.out.println("Número do cartão inválido. O número do cartão deve conter 16 dígitos.");
//            }
//            if (codigoSeguranca.length() != 3) {
//                System.out.println("Código de segurança inválido. O código de segurança deve conter 3 dígitos.");
//            }
//            if (!validarFormatoData(dataValidade)) {
//                System.out.println("Formato de data inválido. A data de validade deve estar no formato MM/yy.");
//            }
//*****************************************************************************************************
//        System.out.println("Número do cartão: ");
//        String numeroCartao = input.nextLine();
//        System.out.println("Nome do titular: ");
//        String nomeTitular = input.nextLine();
//        System.out.println("Data de validade: ");
//        String dataValidade = input.nextLine();
//        System.out.println("cvv: ");
//        String codigoSeguranca = input.nextLine();
//
//        return false;
//********************************************************************************************************//
//public class DadosDoCartao {
//    private Scanner input = new Scanner(System.in);
//
//    boolean perguntarDados() {
//        System.out.println("Nome do titular: ");
//        String nomeTitular = input.nextLine();
//        String numeroCartao;
//        String codigoSeguranca;
//        String dataValidade;
//
//        do {
//            System.out.println("Número do cartão: ");
//            numeroCartao = input.nextLine();
//            System.out.println("Código de segurança: ");
//            codigoSeguranca = input.nextLine();
//            System.out.println("Data de validade (MM/yy): ");
//            dataValidade = input.nextLine();
//
//            if (numeroCartao.length() != 16) {
//                System.out.println("Número do cartão inválido. O número do cartão deve conter 16 dígitos.");
//            }
//            if (codigoSeguranca.length() != 3) {
//                System.out.println("Código de segurança inválido. O código de segurança deve conter 3 dígitos.");
//            }
//            if (!validarFormatoData(dataValidade)) {
//                System.out.println("Formato de data inválido. A data de validade deve estar no formato MM/yy.");
//            }
//        } while (numeroCartao.length() != 16 || codigoSeguranca.length() != 3 || !validarFormatoData(dataValidade));
//
//        return true;
//    }
//
//    private boolean validarFormatoData(String data) {
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
//        sdf.setLenient(false); // Impede a conversão de datas inválidas
//        try {
//            Date date = sdf.parse(data);
//            return true;
//        } catch (ParseException e) {
//            return false;
//        }
//    }
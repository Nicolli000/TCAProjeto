package br.com.projetotca.PagamentoService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static br.com.projetotca.Service.CarrinhoDeCompras.recibo;

public class DadosCartao {
    private String nomeTitular;
    private String numeroCartao;
    private String codigoSeguranca;
    private String dataValidade;
    private Scanner input = new Scanner(System.in);
    public void perguntarDados() {
        System.out.println("Nome do titular: ");
             nomeTitular = input.nextLine();
        while (!nomeTitular.matches("[a-zA-Z\\s]+")) {
            // (\\s): Representa um espaço em branco.
            System.out.println("Nome inválido. Deve conter nome e sobrenome.");
            System.out.println("Nome do titular: ");
                  nomeTitular = input.nextLine();
            }
            System.out.println("Número do cartão: ");
            numeroCartao = input.nextLine();
            while(numeroCartao.length() != 16) {
                System.out.println("Número do cartão inválido. O número do cartão deve conter 16 dígitos.");
                System.out.println("Número do cartão: ");
                numeroCartao = input.nextLine();
            }
            System.out.println("Código de segurança: ");
                 codigoSeguranca = input.nextLine();
            while (codigoSeguranca.length() != 3) {
            System.out.println("Código de segurança inválido. O código de segurança deve conter 3 dígitos.");
            System.out.println("Código de segurança: ");
                codigoSeguranca = input.nextLine();
            }
            System.out.println("Data de validade (MM/yy): ");
                dataValidade = input.nextLine();
            while (!validarFormatoData(dataValidade)) {
            System.out.println("Formato de data inválido. A data de validade deve estar no formato MM/yy.");
            System.out.println("Data de validade (MM/yy): ");
                dataValidade = input.nextLine();
                break;
            }
            recibo();
    }
    private boolean validarFormatoData(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
        sdf.setLenient(false); // Impede a conversão de datas inválidas
        try {
            Date date = sdf.parse(data);
            return true;
        } catch (ParseException e) {
            return data.matches("\\d{2}/\\d{2}");
        }
    }
}

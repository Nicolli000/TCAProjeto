package br.com.projetotca.Pagamento;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class FormaDePagamento {
    private static double valorPago;
    static final Scanner input = new Scanner(System.in);
    private static double valorTotal;  //valor final

    public FormaDePagamento(double valorTotal) {
        FormaDePagamento.valorTotal = valorTotal;
        List<String> produtos = new ArrayList<>();
    }

    private static void pagarComCartao(double valorTotal) {
        DadosDoCartao dadosCartao = new DadosDoCartao();
        dadosCartao.perguntarDados();
        double saldoConta = 1000.0; // Saldo inicial
        if (valorTotal <= saldoConta) {
            saldoConta -= valorTotal; // Deduz o valor do saldo
            System.out.println("Pagamento de R$" + valorTotal + " realizado com sucesso.");
            System.out.println("Saldo restante: R$" + saldoConta);
        } else {

            System.out.println("Saldo insuficiente. Tente novamente.");
        }
    }

        public static void pagarCredito () {
            DadosDoCartao dadosDoCartao = new DadosDoCartao();
            dadosDoCartao.perguntarDados();
            pagarComCartao(valorTotal);

        }
        public static void pagarDebito () {
            DadosDoCartao dadosCartao = new DadosDoCartao();
            dadosCartao.perguntarDados();
           pagarComCartao(valorTotal);
        }
        public static void pagarPix () {
            DadosDoCartao dadosCartao = new DadosDoCartao();
            Random random = new Random();
            boolean pagamentoAprovado = random.nextDouble() < 0.9;
            if (pagamentoAprovado) {
                System.out.println("Pagamento em pix de: R$" + valorTotal + " realizado com sucesso.");
                System.out.println("Obrigado pela preferência!");
            } else {
                System.out.println("Pagamento via Pix de não realizado.");
            }
        }
    }


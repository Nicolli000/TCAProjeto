package br.com.projetotca.PagamentoService;

import java.util.InputMismatchException;
import java.util.Scanner;

import static br.com.projetotca.PrincipalCliente.exibirMenuCliente;
import static br.com.projetotca.Service.CarrinhoDeCompras.recibo;


public class IniciarPagamento {
    private static Scanner input = new Scanner(System.in);
    private static double valorTotal;  //valor final


    public static void exibirFormaPagamento() {
        System.out.println("""
                ╭────────────────────**Formas*de*Pagamento**─────────────────────╮
                │   1 - Crédito                                                  │
                │   2 - Débito                                                   │
                │   3 - Pix                                                      │
                │   4 - Voltar ao Menu Principal                                 │
                ╰─────────────────────────────****───────────────────────────────╯
                """);
        int opcao = input.nextInt();

        while (opcao != 5) {
            switch (opcao) {
                case 1:
                   pagarCredito(valorTotal);
                    break;
                case 2:
                    pagarDebito(valorTotal);
                    break;
                case 3:
                    pagarPix(valorTotal); // Adicionei valorTotal como parâmetro, se necessário
                    break;
                case 4:
                    exibirMenuCliente();
                    break;
                default:
                    System.out.println("Opção não encontrada.");
                    break;
            }
        }
    }

    private static void pagarComCartao(double valorTotal) {
        try {
            DadosCartao dadosCartao = new DadosCartao();
            dadosCartao.perguntarDados();

            double valorPago = input.nextDouble();
            if (valorPago >= valorTotal) {
                System.out.println("Pagamento de R$" + valorTotal + " realizado com sucesso.");
            } else {
                System.out.println("Saldo insuficiente. Tente novamente.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Valor inválido. Por favor, insira um valor numérico.");
            pagarComCartao(valorTotal); // Tente novamente
        }
    }

    public static void pagarCredito(double valorTotal) {
        DadosCartao dadosDoCartao = new DadosCartao();
        dadosDoCartao.perguntarDados();
        pagarComCartao(valorTotal);
        recibo();
    }

    public static void pagarDebito(double valorTotal) {
        DadosCartao dadosCartao = new DadosCartao();
        dadosCartao.perguntarDados();
        pagarComCartao(valorTotal);
        recibo();
    }

    public static void pagarPix(double valorTotal) {
            System.out.println("Pagamento em pix realizado com sucesso.");
        recibo();
        }
    }
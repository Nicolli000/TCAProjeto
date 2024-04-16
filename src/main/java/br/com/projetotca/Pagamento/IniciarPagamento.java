package br.com.projetotca.Pagamento;

import br.com.projetotca.CarrinhoDeCompras;
import br.com.projetotca.DadosProduto.Produto;

import java.util.*;

import static br.com.projetotca.CarrinhoDeCompras.exibirMenu;
import static br.com.projetotca.Pagamento.FormaDePagamento.*;

public class IniciarPagamento {
    CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
;    private Produto produto = new Produto();
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, String> carrinho;
    private double valorTotal;  //valor final
    FormaDePagamento formaDePagamento = new FormaDePagamento(valorTotal);
    public static void main(String[] args) { //VOID -> VAZIO
      //  public void escolhaPagamento()
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        var opcao  = exibirFormaPagamento();
        while (opcao != 6) {
            switch (opcao) {
                case 1:
                    pagarCredito();
                    break;
                case 2:
                    pagarDebito();
                    break;
                case 3:
                    pagarPix();
                case 4:
                    exibirMenu();
                default:
                    System.out.println("Opção não encontrada.");
                    break;
            }
        }
    }
    public static int exibirFormaPagamento() {
        System.out.println("""
                ==============Formas de pagamento===============
                --   1 - Crédito                              --
                --   2 - Débito                               --
                --   3 - Pix                                  --
                --   4 - Voltar ao menu principal.            --
                ---------------------***------------------------
                """);
        return Integer.parseInt(input.nextLine());
    }
}


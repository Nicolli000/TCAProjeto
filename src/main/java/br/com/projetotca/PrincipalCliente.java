package br.com.projetotca;


import br.com.projetotca.Model.Produto;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static br.com.projetotca.Service.CarrinhoDeCompras.*;

public class PrincipalCliente {

    static Scanner input = new Scanner(System.in);
    private static Map<Produto, Integer> carrinho;
    
    public static void main(String[] args) {
        carrinho = new HashMap<>();
        var opcao = exibirMenuCliente();

        while (opcao != 6) {
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    loginCliente();
                    break;
                case 3:
                    listarProdutos();
                    break;
                case 4:
                    iniciarCompra();
                    break;
                case 5:
                    System.out.println("Obrigado pela preferência!");
                    System.exit(0);
                default:
                    System.out.println("Opção não encontrada.");
                    break;
            }
            opcao = exibirMenuCliente();
        }
    }

    public static int exibirMenuCliente() {
            System.out.println(
            "╔════════════════════════════════════════════════════╗\n" +
            "║                  HortiFruti-Skillo                 ║\n" +
            "║                                                    ║\n" +
            "║ *** Seja Bem-Vindo! Selecione a opção desejada *** ║\n" +
            "║                                                    ║\n" +
            "║  1 - Cadastrar-se                                  ║\n" +
            "║  2 - Login                                         ║\n" +
            "║  3 - Lista de Produtos                             ║\n" +
            "║  4 - Realizar compra                               ║\n" +
            "║  5 - Sair.                                         ║\n" +
            "║                                                    ║\n" +
            "╚════════════════════════════════════════════════════╝\n");
        return input.nextInt();
    }
}
package br.com.projeto.tca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarrinhoDeComprass {
    private static Scanner teclado = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho; //Para adicionar ao carrinho

    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        exibirMenu();

    }
    int opcao = exibirMenu();
    private static int exibirMenu() {
        System.out.println("""
                *---------------HortFruti Skillo----------------*
                ***Seja Bem-Vindo! Selecione a opção desejada:***
                --   1 - Cadastrar-se                         -- 
                --   2 - Realizar compra                      -- 
                --   3 - Lista de Compra                      --
                --   4 - Sair.                                -- 
                ------------------------------------------------
                """);
        var opcao = exibirMenu();
//        while (opcao != 8) {
//            try {
//                switch (opcao) {
//                    case 1:
//
//                }
//            }
//        }
    }
}
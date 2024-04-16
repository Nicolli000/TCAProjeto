package br.com.projetotca;


import br.com.projetotca.DadosProduto.Produto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static br.com.projetotca.CarrinhoDeCompras.*;

public class Principal {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, Integer> carrinho; //Para adicionar ao carrinho
    
    public static void main(String[] args) {
        produtos = new ArrayList<>();
        carrinho = new HashMap<>();
        var opcao = exibirMenu();                                          //int opcao = input.nextInt();

        while (opcao != 6) {
           // opcao = exibirMenu();
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
        }
    }

    public static int exibirMenu() {
        System.out.println("""
                *---------------HortFruti Skillo----------------*
                ***Seja Bem-Vindo! Selecione a opção desejada:***
                --   1 - Cadastrar-se                         --
                --   2 - Login                                --
                --   3 - Lista de Produtos                    --
                --   4 - Realizar compra                      --
                --   5 - Sair.                                --
                ------------------------------------------------
                """);
        return input.nextInt();
    }
//    public static void cadastrarCliente() {
//
//        System.out.println("Nome seu nome  :  ");
//        String nome = input.next();
//
//        System.out.println("Insira seu CPF: ");
//        double cpf = input.nextDouble();
//
//        System.out.println("Usuario " + nome + "cadastrado com sucesso!");
//    }
//
//    private static void loginCliente() {
//        System.out.println("Nome do usuario:  ");
//        String nome = input.next();
//
//        System.out.println("Insira seu CPF: ");
//        double cpf = input.nextDouble();
//
//        System.out.println("Usuario " + nome + "iniciado com sucesso!");
//    }
//
//    private static void listarProdutos() {
//        if (produtos.size() > 0) { //se ela lista contém algum produto
//            System.out.println("Lista de produtos:\n");   //entao mostrar  lista
//            for (Produto p : produtos) {
//                System.out.println(p);
//            }
//        } else {
//            System.out.println("Nenhum produto encontrado.");
//        }
//    }
//
//
//    private static void inserirCompraNoBanco(Produto produto, double quiloTotal) {
//        String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
//        String usuario = "root";
//        String senha = "12234";
//
//        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
//            String sql = "INSERT INTO compras (nome_produto, quantidade) VALUES (?, ?)";
//            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
//            preparedStatement.setString(1, produto.getNomeProduto());
//            preparedStatement.setDouble(2, quiloTotal);
//            int linhasAfetadas = preparedStatement.executeUpdate();
//            if (linhasAfetadas > 0) {
//                System.out.println("Compra registrada no banco de dados com sucesso!");
//            } else {
//                System.out.println("Falha ao registrar a compra no banco de dados.");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    private static void iniciarCompra() {
//
//        for (Produto p : produtos) {
//            System.out.println("*---------------Produtos disponíveis---------------*\n" + p + "\n");
//        }
//        System.out.println("Digite o nome do produto que deseja comprar: ");
//        String nomeProduto = input.next();
//
//        System.out.println("Digite quantos kg do produto " + nomeProduto + "você deseja comprar: ");
//        Double quilo  = input.nextDouble();
//
//        Produto produtoSelecionado = null;
//        for (Produto p : produtos) {
//            if (p.getNomeProduto().equalsIgnoreCase(nomeProduto)) {
//                produtoSelecionado = p;
//                break;
//            }
//        }
////        if (produtoSelecionado != null) {
////            carrinho.put(produtoSelecionado,  );    //Put -> Ele é usado para adicionar um par chave-valor ao mapa.
////            System.out.println("Produto adicionado ao carrinho com sucesso!");
////            inserirCompraNoBanco(produtoSelecionado, quiloTotal);
////        } else {
////            System.out.println("Produto não encontrado.");
////        }
//    }
}





















//
//  try {
//Connection conexao = DriverManager.getConnection( idProduto, );
//String sql = "INSERT INTO produtos (id, nome, peso) VALUES (?, ?, ?)";
//PreparedStatement stmt = conexao.prepareStatement(sql);
//                stmt.setString(1, nomeProduto);
// Defina o preço e a descrição do produto conforme necessário
//                stmt.setDouble(2, precoDoProduto);
//                stmt.setString(3, descricaoDoProduto);
//int linhasAfetadas = stmt.executeUpdate();
//                if (linhasAfetadas > 0) {
//        System.out.println("Produto adicionado ao carrinho com sucesso!");
//                } else {
//                        System.out.println("Falha ao adicionar o produto ao carrinho.");
//                }
//                        } catch (
//SQLException e) {
//        e.printStackTrace();
//            }
//
//

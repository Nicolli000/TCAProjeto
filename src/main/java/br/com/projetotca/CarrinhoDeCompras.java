package br.com.projetotca;

import br.com.projetotca.BancoDeDados.ClienteDAO;
import br.com.projetotca.Cliente.ContaCliente;
import br.com.projetotca.DadosProduto.Produto;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import static br.com.projetotca.BancoDeDados.ProdutoDAO.listagem;
import static br.com.projetotca.Pagamento.IniciarPagamento.exibirFormaPagamento;

public class CarrinhoDeCompras {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Produto> produtos;
    private static Map<Produto, String> carrinho; //é um mapa onde as chaves são objetos do tipo Produto e os valores associados a essas chaves são String (String).
    private static ClienteDAO contaService = new ClienteDAO();

    public static void cadastrarCliente() {

        System.out.println("Digite seu nome: ");
           String nome = input.nextLine();
        System.out.println("Insira seu CPF: ");
            String cpf = input.nextLine();
        System.out.println("Insira seu e-mail: ");
            String email = input.nextLine();
        System.out.println("Insira sua senha: ");
            String senha = input.nextLine();
        System.out.println("Insira seu endereço: ");
             String endereco = input.nextLine();
        ContaCliente dadosDaConta = new ContaCliente(cpf, nome, email, endereco, senha);
        contaService.salvarConta(dadosDaConta);
        System.out.println("Usuário " + nome + " cadastrado com sucesso!");
        exibirMenu();
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
        return Integer.parseInt(input.nextLine());
    }

    static void loginCliente() {
        System.out.println("Nome do usuario:  ");
            String nome = input.nextLine();
        System.out.println("Insira sua senha: ");
            String senha = input.nextLine();
        System.out.println("Usuario " + nome + "iniciado com sucesso!");
        ContaCliente dadosDaConta = new ContaCliente(nome, senha);
        contaService.verificarConta(dadosDaConta);
    }

    static void listarProdutos() {
        System.out.println("---------------------Produtos disponíveis---------------------\n");   // então mostrar lista
        listagem().forEach(System.out::println);
    }

    static void iniciarCompra() {
        produtos = new ArrayList<>();
        boolean isPresent = false;  //declara uma variável booleana chamada isPresent e a inicializa com o valor false.
        double totalCompra = 0.0; // Variável para armazenar o total da compra
            System.out.println("---------------------Produtos disponíveis---------------------\n");
               listagem().forEach(System.out::println);
            System.out.println("\n");

        System.out.println("--------------Iniciando sua compra---------------\n");
        System.out.println("Digite o nome do produto que deseja comprar: ");
        String nomeProduto = input.nextLine();

        System.out.println("Digite a quantidade desejada: ");
        int quantidade = Integer.parseInt(input.nextLine());

        for (Produto p : produtos) {
            if (p.getNomeProduto().equals(nomeProduto)) {
                double totalProduto = p.getPrecoPorUnidade() * quantidade; // Calcula o total do produto
                totalCompra += totalProduto; // Adiciona ao total da compra
                if (carrinho.containsKey(p)) {//containsKey -> método serve para verificar se um determinado mapa contém uma chave específica.
                    quantidade += Integer.parseInt(carrinho.get(p));
                }
                carrinho.put(p, String.valueOf(quantidade));
                System.out.println(p.getNomeProduto() + " adicionado ao carrinho.");
                isPresent = true;
                break;
            }
        }
        if (!isPresent) {
            System.out.println("Produto não encontrado.");
        }
        System.out.println("Deseja adicionar outro produto ao carrinho?\n");
        System.out.println("Digite 1 para sim, ou 0 para finalizar a compra.\n");
        int opcao = Integer.parseInt(input.nextLine());
        if (opcao == 1) {
            iniciarCompra();
        } else {
       if (opcao == 0){
           System.out.println("Total da compra: R$" + totalCompra);
           exibirFormaPagamento();
       }
   }
}
    private static void finalizarCompra() {
        // Lógica para finalizar a compra
    }

}


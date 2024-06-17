package br.com.projetotca.Service;

import br.com.projetotca.Model.Cliente;
import br.com.projetotca.Model.Produto;
import br.com.projetotca.PagamentoService.IniciarPagamento;
import br.com.projetotca.Repository.ClienteDAO;
import br.com.projetotca.Repository.ProdutoDAO;

import java.util.*;

import static br.com.projetotca.PagamentoService.IniciarPagamento.exibirFormaPagamento;
import static br.com.projetotca.PrincipalCliente.exibirMenuCliente;
import static br.com.projetotca.Repository.ProdutoDAO.listagem;

public class CarrinhoDeCompras {
    IniciarPagamento iniciarOagamento= new IniciarPagamento();
    static HashMap<String, Integer> carrinhoDeCompras = new HashMap<>();
    Produto produto = new Produto();
    static Cliente dadosDaConta = new Cliente();
    private static Scanner input = new Scanner(System.in);
    //  public static Map<Produto, String> carrinho; //é um mapa onde as chaves são objetos do tipo Produto e os valores associados a essas chaves são String (String).
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
        Cliente dadosDaConta = new Cliente(cpf, nome, email, endereco, senha);
        contaService.salvarConta(dadosDaConta);
        System.out.println("Usuário " + nome + " cadastrado com sucesso!");
        exibirMenuCliente();
    }

    public static void loginCliente() {
        System.out.println("Nome do usuario:  ");
        String nome = input.nextLine();
        System.out.println("Insira sua senha: ");
        String senha = input.nextLine();
        // Criar uma instância de ContaCliente com os dados fornecidos pelo usuário
        Cliente dadosDaConta = new Cliente(nome, senha);
        // Verificar a conta usando os dados fornecidos pelo usuário
        contaService.verificarConta(dadosDaConta);
        exibirMenuCliente();
    }

    public static void listarProdutos() {
        System.out.println("════════════════════════Produtos disponíveis════════════════════════\n");   // então mostrar lista
        listagem().forEach(System.out::println);
        System.out.println("════════════════════════════════════════════════════════════════════\n");
    }

    public static void iniciarCompra() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        Produto produto = new Produto();
        double totalCompra = 0.0;
        Scanner input = new Scanner(System.in);
        System.out.println("═════════════════════════════════════════════════════════════════════════════════════\n");
        System.out.println("════════════════════════════════Produtos disponíveis════════════════════════════════\n");
        List<Produto> produtosDisponiveis = listagem(); // Obter lista de produtos disponíveis
        produtosDisponiveis.forEach(System.out::println);
        System.out.println("═════════════════════════════════════════════════════════════════════════════════════\n");
        System.out.println("════════════════════════════════Iniciando sua compra════════════════════════════════\n");
        int opcao = 0;
        do {
            System.out.println("Digite o nome do produto que deseja comprar: ");
            String nomeProduto = input.nextLine();
            System.out.println("Digite a quantidade desejada: ");
            int quantidade = input.nextInt();
            input.nextLine(); // Consumir a quebra de linha pendente

            produto = produtoDAO.verificarProduto(nomeProduto, quantidade);
            if (produto != null) {
                double precoTotalProduto = produto.getPrecoPorUnidade() * quantidade;
                totalCompra += precoTotalProduto;
                double totalCompraFormatado = Math.round(totalCompra * 100.0) / 100.0;
                carrinhoDeCompras.put( produto.getNomeProduto(), quantidade);
                System.out.println("Produto " + nomeProduto + " adicionado ao carrinho. Total: R$" + totalCompraFormatado);
                System.out.println("═════════════════════════════════════════════════════════════════════════════════════\n");

            } else {
                System.out.println("Produto não encontrado. Tente novamente");
            }
            System.out.println("Deseja adicionar outro produto ao carrinho?\nDigite 1 para sim, ou 0 para finalizar a compra.\n");
            opcao = input.nextInt();
            input.nextLine(); // Consumir a quebra de linha pendente
        } while (opcao != 0);

        for (Map.Entry<String, Integer> entry : carrinhoDeCompras.entrySet()) {
            String nomeProduto = entry.getKey();
            Integer quantidade = entry.getValue();
            System.out.println("Produto: " + nomeProduto + ", Quantidade: " + quantidade);
        }
        double totalCompraFormatado = Math.round(totalCompra * 100.0) / 100.0;
        System.out.println("Preço total: R$" + totalCompraFormatado);
        System.out.println("═════════════════════════════════════════════════════════════════════════════════════\n");
        exibirFormaPagamento();
        System.out.println("Compra finalizada com sucesso!");
        input.close(); // Fechar o Scanner
    }

    public static void recibo (){
        System.out.println("═════════════════════RECIBO═════════════════════");
        //ID DO RECIBO//
        int idNota = (int) (Math.random() * 20);
        System.out.println("ID: "+ idNota);
        //LISTA DE PRODUTOS//
        for (Map.Entry<String, Integer> entry : carrinhoDeCompras.entrySet()) {
            String nomeProduto = entry.getKey();
            Integer quantidade = entry.getValue();
            System.out.println("PRODUTO: " + nomeProduto + ", QUANTIDADE: " + quantidade);
        }//DATA DA COMPRA//
        Date dataDaCompra = new Date();
        System.out.println("DATA DA COMPRA: " + dataDaCompra);
        System.out.println();
        System.out.println("══════════════════════════════════════════════════");
        System.exit(0);
    }
}
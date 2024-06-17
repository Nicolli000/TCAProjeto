package br.com.projetotca;

import br.com.projetotca.Model.Produto;
import br.com.projetotca.Repository.FuncionarioDAO;
import br.com.projetotca.Repository.ProdutoDAO;
import br.com.projetotca.Service.FuncionarioService;

import java.util.Scanner;

import static br.com.projetotca.Service.CarrinhoDeCompras.listarProdutos;

public class PrincipalFuncionario {
    private static FuncionarioDAO funcionarioDAO; // Instância do FuncionarioDAO

    static Produto produto = new Produto();
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws Exception {
        FuncionarioService funcionarioService = new FuncionarioService();
        var opcao = exibirMenuFuncionario();                                          //int opcao = input.nextInt();

        while (opcao != 7) {
            opcao = exibirMenuFuncionario();
            switch (opcao) {
                case 1:
                    funcionarioService.loginFuncionario();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    funcionarioService.adicionarProduto();
                    break;
                case 4:
                    funcionarioService.apagarProduto();
                    break;
                case 5:
                    opEditarProduto();
                      break;
                case 6:
                    System.out.println("Volte sempre que precisar!");
                    System.exit(0);
                default:
                    System.out.println("Opção não encontrada.");
                    break;
            }
            opcao = exibirMenuFuncionario();
        }
    }
    public static void opEditarProduto() {
        FuncionarioService funcionarioService = new FuncionarioService();
        ProdutoDAO produtoDAO = new ProdutoDAO();
        var opcao = opcaoEditarProduto();                                          //int opcao = input.nextInt();
        while (opcao != 5) {
        // opcao = exibirMenu();
        switch (opcao) {
            case 1:
                funcionarioService.editarProduto(funcionarioService, produtoDAO, "nome");
                break;
            case 2:
                funcionarioService.editarProduto(funcionarioService, produtoDAO, "preco");
                break;
            case 3:
                funcionarioService.editarProduto(funcionarioService, produtoDAO, "gramas");
                break;
            case 4:
                System.out.println("Volte sempre!");
                System.exit(0);
            default:
                System.out.println("Opção não encontrada.");
                break;
        }
        opcao = opcaoEditarProduto();
    }
}
    public static int exibirMenuFuncionario() {
            System.out.println("""
            ╔══════════════════════════════════════════════╗
            ║              HortiFruti-SKILLO               ║
            ║                (FUNCIONÁRIO)                 ║
            ├──────────────────────────────────────────────┤
            ║  **** Bem-Vindo! Selecione uma opção: ****   ║
            ║                                              ║
            ║   1 - Login                                  ║
            ║   2 - Lista de Produtos                      ║
            ║   3 - Adicionar Produto                      ║
            ║   4 - Deletar produto                        ║
            ║   5 - Editar Produto                         ║
            ║   6 - Sair                                   ║
            ╚══════════════════════════════════════════════╝
            """);
        return input.nextInt();
    }
    public static int opcaoEditarProduto() {
        System.out.println("""
               ╔═══════════════════════════════╗
               ║     * HortiFruti-SKILLO *     ║
               ║         (FUNCIONÁRIO)         ║
               ╟───────────────────────────────╢
               ║    DIGITE A OPÇÃO DESEJADA:   ║
               ║ 1 - Alterar nome do produto.  ║
               ║ 2 - Alterar preço do produto. ║
               ║ 3 - Alterar kg do produto.    ║
               ╚═══════════════════════════════╝
               """);

        return input.nextInt();
    }
}

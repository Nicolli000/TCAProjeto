package br.com.projetotca.Service;

import br.com.projetotca.Model.Funcionario;
import br.com.projetotca.Model.Produto;
import br.com.projetotca.Repository.FuncionarioDAO;
import br.com.projetotca.Repository.ProdutoDAO;

import java.util.Scanner;

import static br.com.projetotca.PrincipalFuncionario.exibirMenuFuncionario;
import static br.com.projetotca.Repository.FuncionarioDAO.addProduto;
public class FuncionarioService {
    Produto produto = new Produto();
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    public static Scanner input = new Scanner(System.in);

    public void adicionarProduto() {
        System.out.println("Digite o id para o produto:");
        String id = input.nextLine();
        System.out.println("Digite o nome do produto: ");
        String nomeProduto = input.nextLine();
        System.out.println("Digite o preço do produto: ");
        Double precoPorUnidade = input.nextDouble();
        System.out.println("Digite o kg do produto: ");
        Double gramas = input.nextDouble();
        addProduto(id, nomeProduto, precoPorUnidade, gramas);
        System.out.println("Produto " + nomeProduto + " adicionado com sucesso!");
        exibirMenuFuncionario();
    }

    public void editarProduto(FuncionarioService funcionarioService, ProdutoDAO produtoDAO, String tipo) {
        try {
            System.out.println("Digite o ID do produto:");
            String id = input.nextLine();
            Produto produto = produtoDAO.verificarProdutoPorID(id);
            if (produto != null) {
                if ("nome".equals(tipo)) {
                    System.out.println("Digite o novo nome do produto:");
                    String novoNome = input.nextLine();
                    produto.setNomeProduto(novoNome); // Atualização do nome do produto
                } else if ("preco".equals(tipo)) {
                    System.out.println("Digite o novo preço do produto:");
                    Double novoPreco = Double.parseDouble(input.nextLine());
                    produto.setPrecoPorUnidade(novoPreco); 
                    System.out.println("Digite o novo peso do produto:");
                    Double novoPeso = Double.parseDouble(input.nextLine());
                    produto.setGramas(novoPeso);
                }
                produtoDAO.atualizarProduto(produto);
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Produto não encontrado.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Por favor, digite um valor numérico válido.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao atualizar o produto: " + e.getMessage());
        }
        exibirMenuFuncionario();
    }

    public void apagarProduto() throws Exception {
        System.out.println("Digite o ID do produto que deseja excluir:");
        int id = input.nextInt();

        Produto produto = new Produto();
        produto.setId(id);

        funcionarioDAO.deletarProduto(produto);
        exibirMenuFuncionario();
    }

    public void loginFuncionario() {
        System.out.println("Digite seu nome:  ");
        String nome = input.nextLine();
        System.out.println("Digite a senha: ");
        Double senha = input.nextDouble();
        Funcionario funcionario = new Funcionario(nome, senha);
        funcionarioDAO.verificarFuncionario(funcionario);
        exibirMenuFuncionario();
    }
}
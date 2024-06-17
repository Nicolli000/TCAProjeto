package br.com.projetotca.Repository;

import br.com.projetotca.Model.Funcionario;
import br.com.projetotca.Model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static br.com.projetotca.PrincipalCliente.exibirMenuCliente;
import static br.com.projetotca.PrincipalFuncionario.exibirMenuFuncionario;

public class FuncionarioDAO {
    public static void addProduto(String id, String nomeProduto, Double precoPorUnidade, double gramas) {
        String sql = "INSERT INTO tbproduto (id, nome_produto, preco_unidade, gramas) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, Integer.parseInt(id));
            pstm.setString(2, nomeProduto);
            pstm.setDouble(3, precoPorUnidade);
            pstm.setDouble(4, gramas);
            // pstm.setDate(4,new Date(produto.getDataDeEmissao().getTime()));
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } //f
    public void deletarProduto(Produto produto) throws Exception {
        String sql = "DELETE FROM tbproduto WHERE id = ?";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, produto.getId());

            int linhaExcluida = pstm.executeUpdate(); // Executando a atualização

            if (linhaExcluida > 0) {
                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("ID incorreto ou produto não existe. Tente novamente.");
            }

            exibirMenuCliente(); // Exibindo o menu após a operação
        } catch (SQLException e) {
            System.err.println("Erro ao apagar o produto: " + e.getMessage());
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void verificarFuncionario(Funcionario funcionario) {
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "SELECT * FROM Funcionarios WHERE nome = ? AND senha = ?"; //esta consulta selecionará todas as linhas da tabela tbcliente onde o campo nome é igual ao valor fornecido e o campo senha é igual ao valor fornecido.
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, funcionario.getNome());
            pstm.setDouble(2,funcionario.getSenha());
            try(ResultSet rs = pstm.executeQuery()){
                if (rs.next()){
                    System.out.println("Usuário logado com sucesso!");
                    exibirMenuFuncionario();
                } else {
                    System.out.println("Nome ou senha incorretos. Tente novamente");
                    exibirMenuFuncionario();
                }
            }
            pstm.execute();
            pstm.close();
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package br.com.projetotca.Repository;

import br.com.projetotca.Model.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection conn;
    public static List<Produto> listagem() {
        List<Produto> produtos = new ArrayList<>();

        Connection conn;   //Garante que Connection, PreparedStatement e ResultSet são fechados automaticamente ao final do bloco, mesmo em caso de exceção.
        PreparedStatement pstm = null; //
        ResultSet rs = null;//
        String sql = "select * from tbproduto ";
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNomeProduto(rs.getString("nome_produto"));
                produto.setPrecoPorUnidade(rs.getDouble("preco_unidade"));
                produto.setGramas(rs.getInt("gramas"));
                produtos.add(produto); // Adiciona o produto à lista
            }
            rs.close();
            pstm.close();
            conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }
    public void saveProduto(Produto produto) throws Exception {

        String sql = "INSERT INTO tbproduto ( id, nome_produto, preco_unidade, gramas) " +
                "VALUES (?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, produto.getId());
            pstm.setString(2, produto.getNomeProduto());
            pstm.setDouble(3, produto.getPrecoPorUnidade());
            pstm.setDouble(4, produto.getGramas());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
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
    } //f
    public Produto verificarProduto(String nomeProduto, int quantidade) {
        Produto produtoEncontrado = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null; //É usado para armazenar o resultado da consulta SQL.
        String sql = "SELECT * FROM tbproduto WHERE nome_produto = ?";
        try {
            conn = ConnectionFactory.createConnectionToMySQL(); //Cria uma conexão com o banco de dados MySQL
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nomeProduto);

            rs = pstm.executeQuery();
            if (rs.next()) { //Verifica se a consulta retornou algum resultado.
                produtoEncontrado = new Produto();
                produtoEncontrado.setNomeProduto(rs.getString("nome_produto"));
                produtoEncontrado.setPrecoPorUnidade(rs.getDouble("preco_unidade"));
                produtoEncontrado.setGramas(rs.getDouble("gramas"));
                // Defina outros atributos do produto, se necessário
            } else {
                System.out.println("Produto não encontrado. Tente novamente");
                // Retorna null se o produto não for encontrado
                return null;
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao verificar o produto: " + e.getMessage(), e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return produtoEncontrado;
    }

    public Produto verificarProdutoPorID(String id) {
        Produto produtoEncontrado = null;
        Connection conn = null;
        PreparedStatement pstm = null;
        String sql = "SELECT * FROM tbproduto WHERE id = ?";
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, id);

            try (ResultSet rs = pstm.executeQuery()) {
                if (rs.next()) {
                    produtoEncontrado = new Produto();
                    produtoEncontrado.setId(rs.getInt("id"));
                    produtoEncontrado.setNomeProduto(rs.getString("nome_produto"));
                    produtoEncontrado.setPrecoPorUnidade(rs.getDouble("preco_unidade"));
                    produtoEncontrado.setGramas(rs.getDouble("gramas"));
                    System.out.println("Produto encontrado.");
                } else {
                    System.out.println("Produto não encontrado. Tente novamente");
                    return null;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstm != null) pstm.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return produtoEncontrado;
    }

    public void atualizarProduto(Produto produto) {
        // Query SQL para atualizar o produto com base no ID
        String sql = "UPDATE tbproduto SET nome_produto = ?, preco_unidade = ?, gramas = ? WHERE id = ?";
        try (Connection conn = ConnectionFactory.createConnectionToMySQL();
             PreparedStatement pstm = conn.prepareStatement(sql)) {
            // Define os parâmetros da query com os novos valores do produto
            pstm.setString(1, produto.getNomeProduto());
            pstm.setDouble(2, produto.getPrecoPorUnidade());
            pstm.setDouble(3, produto.getGramas());
            pstm.setInt(4, produto.getId());
            // Executa a query para atualizar o produto
            int linhasAfetadas = pstm.executeUpdate();
            // Verifica se o produto foi atualizado com sucesso
            if (linhasAfetadas > 0) {
                System.out.println("Produto atualizado com sucesso!");
            } else {
                System.out.println("Falha ao atualizar o produto. Produto não encontrado ou nenhum dado alterado.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao atualizar o produto: " + e.getMessage());
        }
    }
}

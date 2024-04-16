package br.com.projetotca.BancoDeDados;

import br.com.projetotca.Cliente.ContaCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO {

    public void salvarConta(ContaCliente dadosDaConta){

        Connection conn= null;
        PreparedStatement pstm = null;

        String sql = "INSERT INTO tbcliente (cpf, nome, email, senha, endereco) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, dadosDaConta.getCpf());
            pstm.setString(2, dadosDaConta.getNome());
            pstm.setString(3, dadosDaConta.getEmail());
            pstm.setString(4, dadosDaConta.getSenha());
            pstm.setString(5, dadosDaConta.getEndereco());
                pstm.execute();
                pstm.close();
                conn.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void verificarConta(ContaCliente dadosDaConta) {
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        ContaCliente dadosCliente = null;

        String sql = "SELECT * FROM tbcliente WHERE nome = ? AND senha = ?"; //esta consulta selecionará todas as linhas da tabela tbcliente onde o campo nome é igual ao valor fornecido e o campo senha é igual ao valor fornecido.

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, dadosDaConta.getNome()); // Define o valor do parâmetro na consulta preparada
            pstm.setString(2,dadosDaConta.getSenha());
            rs = pstm.executeQuery(); // Executa a consulta

//            if (rs.next()) {
//                // Se houver resultados, cria uma instância de ContaCliente e popula com os dados do ResultSet
//                dadosCliente.setNome(rs.getString("nome"));
//                dadosCliente.setSenha(rs.getString("senha"));}
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Lidar com exceções de fechamento de conexão, se necessário
                e.printStackTrace();
            }
        }
    }
}


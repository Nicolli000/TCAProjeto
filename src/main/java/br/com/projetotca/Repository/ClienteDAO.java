package br.com.projetotca.Repository;
import br.com.projetotca.Model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static br.com.projetotca.PrincipalCliente.exibirMenuCliente;

public class ClienteDAO {  //DAO -> Objeto de acesso a Dados
    public void salvarConta(Cliente dadosDaConta){

        Connection conn= null; //representa uma conexão com o banco de dados.
        PreparedStatement pstm = null; // representa uma declaração SQL preparada, que permite definir parâmetros de forma dinâmica

        String sql = "INSERT INTO tbcliente (cpf, nome, email, senha, endereco) VALUES (?, ?, ?, ?, ?)";

        try {
            conn = ConnectionFactory.createConnectionToMySQL(); //cria e retorna uma conexão com o banco de dados MySQL.
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
    public void verificarConta(Cliente dadosDaConta) {
        Connection conn = null;
        PreparedStatement pstm = null;
               String sql = "SELECT * FROM tbcliente WHERE nome = ? AND senha = ?"; //esta consulta selecionará todas as linhas da tabela tbcliente onde o campo nome é igual ao valor fornecido e o campo senha é igual ao valor fornecido.
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, dadosDaConta.getNome());
            pstm.setString(2,dadosDaConta.getSenha());
            try(ResultSet rs = pstm.executeQuery()){
               if (rs.next()){
                   System.out.println("Usuário logado com sucesso!");
                   exibirMenuCliente();
               } else {
                   System.out.println("Nome ou senha incorretos. Tente novamente");
                   exibirMenuCliente();
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


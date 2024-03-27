package br.com.projetotca.BancoDeDados;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

   public class ConnectionFactory {
      public static void main(String[] args) {
         // Informações de conexão com o banco de dados
         String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
         String usuario = "root";
         String senha = "12234";

         // Objeto de conexão
         Connection conexao = null;

         try {
            conexao = DriverManager.getConnection(url, usuario, senha);

         } catch (SQLException e) {
            // Lidar com exceções de SQL
            e.printStackTrace();
         } finally {
            // Fechar a conexão com o banco de dados
            if (conexao != null) {
               try {
                  conexao.close();
               } catch (SQLException e) {
                  // Lidar com exceções ao fechar a conexão
                  e.printStackTrace();
               }
            }
         }
      }
   }

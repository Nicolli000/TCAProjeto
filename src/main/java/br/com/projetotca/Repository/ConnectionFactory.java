package br.com.projetotca.Repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
      private static final String USERNAME = "root";
      private static final String PASSWORD = "10447171";
      private static final String DATABASE_URL ="jdbc:mysql://localhost:3306/horti_fruti";
      
   public static Connection createConnectionToMySQL() throws Exception {
	   
         Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
         return conn;
      }
      public static void main(String[] args) {
         String url = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
         String usuario = "root";
         String senha = "12234";
      Connection conexao = null;
         try {// exceção
            conexao = DriverManager.getConnection(url, usuario, senha); 
         } catch (SQLException e) { 
            e.printStackTrace();
         } finally { // Código que será sempre executado, independente de uma exceção ter sido lançada ou não
            // Fechar a conexão com o banco de dados
            if (conexao != null) {
               try {
                  conexao.close();
               } catch (SQLException e) {
               //mostrar erros
                  e.printStackTrace();
               }
            }
         }
      }
   }

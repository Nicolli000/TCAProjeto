package br.com.projetotca.Repository;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
      private static final String USERNAME = "root";
      private static final String PASSWORD = "10447171";
      private static final String DATABASE_URL ="jdbc:mysql://localhost:3306/horti_fruti";
      /*
       * Conexão com o banco de dados
       */

   public static Connection createConnectionToMySQL() throws Exception {
         //Faz com que a chave seja carregada pela jvm
         // Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
         return conn;
      }

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

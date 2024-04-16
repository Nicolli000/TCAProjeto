package br.com.projetotca.BancoDeDados;

import br.com.projetotca.DadosProduto.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection conn;

    public static List<Produto> listagem(){
        List<Produto>produtos = new ArrayList<>();
        Connection conn;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        String sql = "select * from tbproduto ";
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = conn.prepareStatement(sql);
            rs = pstm.executeQuery();

            while (rs.next()) {
                Produto produto = new Produto(); {
                    produto.setId(rs.getString(1));
                    produto.setNomeProduto(rs.getString(2));
                    produto.setPrecoPorUnidade((int) rs.getDouble(3));

                    produtos.add(produto);
                }
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
        String sql = "INSERT INTO tbproduto ( id, nome_produto, preco_unidade) " +
                "VALUES (?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1,produto.getNomeProduto());
            pstm.setString(2, produto.getId());
            pstm.setDouble(3, produto.getPrecoPorUnidade());
            // pstm.setDate(4,new Date(produto.getDataDeEmissao().getTime()));
            pstm.execute();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (pstm!= null){
                    pstm.close();
                }
                if (conn!= null){
                    conn.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

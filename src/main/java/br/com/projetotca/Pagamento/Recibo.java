package br.com.projetotca.Pagamento;

import java.sql.Date;

public class Recibo {
private Date dataCompra;
private Double precoTotal;
private String idRecibo;
private String TotalProdutos;
    public Recibo(Date dataCompra,Double precoTotal,String idRecibo, String TotalProdutos) {
        this.dataCompra = dataCompra;
        this.precoTotal = precoTotal;
        this.idRecibo = idRecibo;
        this.TotalProdutos = TotalProdutos;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public String getIdRecibo() {
        return idRecibo;
    }

    public String getTotalProdutos() {
        return TotalProdutos;
    }

}

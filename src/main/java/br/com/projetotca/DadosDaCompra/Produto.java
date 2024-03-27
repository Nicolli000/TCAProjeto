package br.com.projetotca.DadosDaCompra;

public class Produto {
    private int idProduto;
    private String nomeProduto;
    private Double peso;
    private int formaDePagamento;
    private int DataDeEmissao;
    private String listaDeProduto;

    public int getIdProduto() {
        return idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public Double getPeso() {
        return peso;
    }

    public int getFormaDePagamento() {
        return formaDePagamento;
    }

    public int getDataDeEmissao() {
        return DataDeEmissao;
    }

    public String getListaDeProduto() {
        return listaDeProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public void setFormaDePagamento(int formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    public void setDataDeEmissao(int dataDeEmissao) {
        DataDeEmissao = dataDeEmissao;
    }

    public void setListaDeProduto(String listaDeProduto) {
        this.listaDeProduto = listaDeProduto;
    }
}








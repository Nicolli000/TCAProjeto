package br.com.projetotca.DadosProduto;

public class Produto {
    private String id;
    private String nomeProduto;
    private double precoPorUnidade;
    public Produto(String nomeProduto, double precoPorUnidade, String id) {
        this.nomeProduto = nomeProduto;
        this.precoPorUnidade = precoPorUnidade;
        this.id = id;
    }

    public Produto() {

    }

    public String getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPrecoPorUnidade() {
        return precoPorUnidade;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setPrecoPorUnidade(int precoPorUnidade) {
        this.precoPorUnidade = precoPorUnidade;
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id + '\'' +
                ", Produto:" + nomeProduto + '\'' +
                ", Preço: " + precoPorUnidade +
                '}';

}}

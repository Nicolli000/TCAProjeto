package br.com.projetotca.Model;

public class Produto {
    private int id;
    private String nomeProduto;
    private double precoPorUnidade;
    private double gramas;

    public Produto(int id, String nomeProduto, double precoPorUnidade, double gramas) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoPorUnidade = precoPorUnidade;
        this.gramas = gramas;
    }

    public Produto() {
    }

    public int getId() {
        return id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPrecoPorUnidade() {
        return precoPorUnidade;
    }

    public double getGramas() {
        return gramas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public void setPrecoPorUnidade(double precoPorUnidade) {
        this.precoPorUnidade = precoPorUnidade;
    }

    public void setGramas(double gramas) {
        this.gramas = gramas;
    }

    @Override
    public String toString() {
        return "id:" + id +
                " - Produto: " + nomeProduto +
                " - Preço: R$" + precoPorUnidade +
                " - Gramas:" + gramas;
    }
}

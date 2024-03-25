package br.com.projeto.tca;

public class Produto {
    private int idProduto;
    private String nome;
    private Double preco;
    private Double peso;

    public Produto( String nome, Double preco, Double peso) { //construtor:
      this.nome = nome;
        this.preco = preco;
        this.peso = peso;

    }

    public int getIdProduto() {
        return idProduto;
    }

    public String getNome() {
        return nome;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPeso() {
        return peso;
    }
    public String toString(){
        return "Id do Produto: " + this.getIdProduto()+
                "\nProduto: " + this.getNome() +
                "\nPeso: " + this.getPeso() +
                "\nPreco: " + this.getPreco();

    }
}

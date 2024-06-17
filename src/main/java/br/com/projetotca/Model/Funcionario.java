package br.com.projetotca.Model;

public class Funcionario {
    int idFuncionario;
    String nome;
    Double senha;

    public Funcionario(String nome, Double senha) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.senha = senha;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getSenha() {
        return senha;
    }

    public void setSenha(Double senha) {
        this.senha = senha;
    }

//    public Funcionario(int idFuncionario, String nome, int senha) {
//        this.idFuncionario = idFuncionario;
//        this.nome = nome;
//        this.senha = senha;
//    }

    @Override
    public String toString() {
        return "Funcionário{" +
                "id:" + idFuncionario +
                ", nome:'" + nome + '\'' +
                ", senha:" + senha +
                '}';
    }
}

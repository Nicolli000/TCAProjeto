package br.com.projetotca.Cliente;

import java.util.Objects;

public class ContaCliente {
        private String nome;
        private String cpf;
        private String email;
        private String endereco;
        private String senha;

    public ContaCliente(String cpf, String nome, String email, String endereco, String senha) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.senha = senha;
    }

    public ContaCliente(String nome, String senha) {
        //this.nome = nome;

    }

    public String getEndereco() {
        return endereco;
        }
        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public String getEmail() {
            return email;
        }

    public String getSenha() {
        return senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "ContaCliente{" +
                "nome:'" + nome + '\'' +
                ", cpf:'" + cpf + '\'' +
                ", email:'" + email + '\'' +
                ", endereco:'" + endereco + '\'' +
                ", senha:'" + senha + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContaCliente contaCliente = (ContaCliente) o;
        return cpf.equals(contaCliente.cpf);
        //Isso é uma medida de segurança para garantir que o objeto o seja do mesmo tipo antes de prosseguir com a comparação.
    }
    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}

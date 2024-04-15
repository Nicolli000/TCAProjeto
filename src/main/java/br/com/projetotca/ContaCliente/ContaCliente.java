package br.com.projetotca.ContaCliente;

import java.util.Objects;

// adicionar um comentário de teste para o git
public class ContaCliente {
        private String nome;
        private Integer cpf;

//       public ContaCliente(DadosCadastroCliente dados){
//           this.nome = dados.nome();
//           this.cpf = dados.cpf();
//       }

    @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
        ContaCliente cliente = (ContaCliente) o;
            return cpf.equals(cliente.cpf);
        }

        @Override
        public int hashCode() {
            return Objects.hash(cpf);
        }

        @Override
        public String toString() {
            return "{" +
                    "nome='" + nome + '\'' +
                    ", cpf='" + cpf + '\'' +
                    '}';
        }

        public String getNome() {
            return nome;
        }

        public Integer getCpf() {
            return cpf;
        }

    }



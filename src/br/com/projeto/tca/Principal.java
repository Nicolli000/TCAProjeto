
import br.com.projeto.tca.Balanca;


public class Principal {
    public static void main(String[] args) {

        Balanca balancaHortifruti = new Balanca();

        // balancaHortifruti.addTabela();
        //balancaHortifruti.addTabela(3, 6.45, "Abacate");
        System.out.println(balancaHortifruti.tabela);

//        var opcao = exibirMenu();
//        while (opcao != 8) {
//            try {
//                switch (opcao) {
//                    case 1:
//                        cadastrar();
//                        break;
//                    case 2:
//                        abrirConta();
//                        break;
//                    case 3:
//                        encerrarConta();
//                        break;
//                    case 4:
//                        consultarSaldo();
//                        break;
//                    case 5:
//                        realizarSaque();
//                        break;
//                    case 6:
//                        realizarDeposito();
//                        break;
//                    case 7:
//                        realizarTransferencia();
//                        break;
//                }
//            } catch (RegraDeNegocioException e) {
//                System.out.println("Erro: " +e.getMessage());
//                System.out.println("Pressione qualquer tecla e de ENTER para voltar ao menu");
//                teclado.next();
//            }
//            opcao = exibirMenu();
//        }


    }
}

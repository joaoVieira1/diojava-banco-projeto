import Contas.Conta;
import Contas.ContaCorrente;
import Contas.ContaPoupanca;
import Modelos.Banco;
import Modelos.Cliente;

public class Main {

    public static void main(String[] args) {
        Banco itau = new Banco("Itau");

        Cliente joao = new Cliente("João Pedro", 19, "+55(16)99215-5796", "39.466.388-3", "479.919.358-92");
        Cliente sarah = new Cliente("Sarah Giraldi", 20, "+55(16)12345-1234", "12.345.678-9", "100.200.300-10");

        Conta contaJoaoC = new ContaCorrente(joao, "Itau", 12466, 2021);
        Conta contaJoaoP = new ContaPoupanca(joao, "Itau", 15623, 2024);
        Conta contaSarahC = new ContaCorrente(sarah, "Itau", 24584, 2009);

        itau.addConta(contaJoaoC);
        itau.addConta(contaJoaoP);
        itau.addConta(contaSarahC);

        contaSarahC.depositar(1000.00);
        contaJoaoC.depositar(3500.00);
        contaJoaoC.transferir(500, contaJoaoP);

        contaJoaoC.imprimirExtrato();
        contaJoaoP.imprimirExtrato();

        itau.mostrarContas();
    }

}
package Contas;

import Modelos.Cliente;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(Cliente cliente, String agencia, int numero, int anoCriacao) {
        super(cliente, agencia, numero, anoCriacao);
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("EXTRATO CONTA POUPANÇA \n" + super.toString() + "\n");
    }

    @Override
    public int compareTo(Conta c) {
        return Integer.compare(this.getAnoCriacao(), c.getAnoCriacao());
    }

}

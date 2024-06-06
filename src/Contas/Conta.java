package Contas;

import Erros.DepositoInvalido;
import Erros.SaldoInvalido;
import Erros.SaqueInvalido;
import Interface.InterfaceConta;
import Modelos.Cliente;

public abstract class Conta implements InterfaceConta, Comparable<Conta> {
    private Cliente cliente;
    private double saldo;
    private int numero;
    private String agencia;
    private int anoCriacao;

    public Conta(Cliente cliente, String agencia, int numero, int anoCriacao){
        setAgencia(agencia);
        setCliente(cliente);
        setSaldo(0);
        setNumero(numero);
        setAnoCriacao(anoCriacao);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if(saldo < 0){
            throw new SaldoInvalido();
        }

        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public int getAnoCriacao() {
        return anoCriacao;
    }

    public void setAnoCriacao(int anoCriacao) {
        this.anoCriacao = anoCriacao;
    }

    @Override
    public void depositar(double valor) {
        if(valor < 0){
            throw new DepositoInvalido();
        }

        setSaldo(getSaldo() + valor);
    }

    @Override
    public void sacar(double valor) {
        if(valor > getSaldo()){
            throw new SaldoInvalido();
        }

        setSaldo(getSaldo() - valor);
    }

    @Override
    public void transferir(double valor, InterfaceConta contaDestinataria) {
        if(valor > getSaldo()){
            throw new SaqueInvalido();
        }

        this.sacar(valor);
        contaDestinataria.depositar(valor);
    }

    @Override
    public String toString(){
        return "DADOS DA CONTA\n" +
                "Cliente: " + getCliente() + "\n" +
                "Saldo: " + getSaldo() + "\n" +
                "Agência: " + getAgencia() + "\n" +
                "Numero: " + getNumero() + "\n" +
                "Ano de criação da conta: " + getAnoCriacao() + "\n";
    }


}

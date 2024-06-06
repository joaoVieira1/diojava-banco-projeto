package Modelos;

import Contas.Conta;
import Erros.AgenciaInvalida;

import java.util.LinkedList;
import java.util.List;

public class Banco {
    private String nome;
    private List<Conta> contas;

    public Banco(String nome){
        contas = new LinkedList<>();
        setNome(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void mostrarContas(){
        System.out.println("====== BANCO DE CONTAS ======");
        contas.stream().sorted().forEach(s -> System.out.println(s + "\n"));
    }

    public void addConta(Conta conta){
        if(!conta.getAgencia().equals(this.getNome())){
            throw new AgenciaInvalida();
        }

        contas.add(conta);
    }

}

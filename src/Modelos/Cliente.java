package Modelos;

import Erros.CPFInvalido;
import Erros.IdadeInsuficiente;
import Erros.RGInvalido;
import Erros.TelefoneInvalido;

public class Cliente {
    private String nome;
    private int idade;
    private String telefone;
    private String RG;
    private String CPF;

    public Cliente(String nome, int idade, String telefone, String RG, String CPF) {
        setNome(nome);
        setIdade(idade);
        setTelefone(telefone);
        setRG(RG);
        setCPF(CPF);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if(idade < 18){
            System.out.println("Apenas maiores de 18 anos podem criar contas bancárias");
            throw new IdadeInsuficiente();
        }

        this.idade = idade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        if(!telefone.matches("\\+\\d{1,3}\\(\\d{2}\\)\\d{4,5}-\\d{4}")){
            throw new TelefoneInvalido();
        }

        this.telefone = telefone;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        if(!RG.matches("\\d{2}.\\d{3}.\\d{3}-\\d{1}")){
            throw new RGInvalido();
        }

        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        if(!CPF.matches("\\d{3}.\\d{3}.\\d{3}-\\d{2}")){
            throw new CPFInvalido();
        }

        this.CPF = CPF;
    }

    @Override
    public String toString(){
        return "DADOS DO CLIENTE\n" +
                "Nome: " + getNome() + "\n" +
                "Idade: " + getIdade() + "\n" +
                "Telefone: " + getTelefone() + "\n" +
                "RG: " + getRG() + "\n" +
                "CPF: " + getCPF() + "\n";
    }

}

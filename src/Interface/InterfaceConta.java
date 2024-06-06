package Interface;

public interface InterfaceConta {

    public void depositar(double valor);
    public void sacar(double valor);
    public void transferir(double valor, InterfaceConta contaDestinataria);
    public void imprimirExtrato();

}

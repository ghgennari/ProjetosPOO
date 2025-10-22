/**
 *
 * @author Gustavo
 */
public class ContaCorrente {
    private int numero;
    private double saldo;
    
    public ContaCorrente(int conta,double valor){
        numero = conta;
        saldo = valor;
    }
    
    public int getNumero(){
        return(numero);
    }
    
    public double getSaldo(){
        return(saldo);
    }
    
    public void sacar(double saque){
        saldo = saldo - saque;
    }
    
    public void depositar(double deposito){
        saldo = saldo + deposito;
    }
}

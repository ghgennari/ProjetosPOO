package fatec.poo.model;

/**
 *
 * @author Gustavo
 */
public abstract class Pessoa {
    private String nome;
    private int anoInscricao;
    private double totalCompras;
    
    public Pessoa(String n, int anoInsc){
        nome = n;
        anoInscricao = anoInsc;
    }
    
    public abstract double calcBonus(int b);
    
    public void addCompras(double valor){
        totalCompras = totalCompras + valor;
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getAnoInscricao(){
        return anoInscricao;
    }
    
    public double getTotalCompras(){
        return totalCompras;
    }
}

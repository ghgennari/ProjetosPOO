package fatec.poo.model;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */

public abstract class Pessoa {
    private String nome;
    private int anoInscricao;
    private double totalCompras;
    private ArrayList<PedidoCompra> pedidos;
    
    public Pessoa(String n, int anoInsc){
        nome = n;
        anoInscricao = anoInsc;
        pedidos = new ArrayList<PedidoCompra>();
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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setAnoInscricao(int anoInscricao) {
        this.anoInscricao = anoInscricao;
    }
    
    public void addPedido(PedidoCompra p){
        pedidos.add(p);
        p.setPessoa(this);
        
    }

    public ArrayList<PedidoCompra> getPedidos() {
        return pedidos;
    }
    
}

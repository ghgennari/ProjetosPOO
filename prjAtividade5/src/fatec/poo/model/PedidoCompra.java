package fatec.poo.model;

/**
 *
 * @author Gustavo
 */
public class PedidoCompra {
    private int numero;
    private String dataPedido;
    private double valor;

    public PedidoCompra(int numero) {
        this.numero = numero;
    }

    public String getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(String dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
    
}

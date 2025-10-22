package fatec.poo.model;

/**
 *
 * @author Gustavo
 */
public class Palestra {
    private String data;
    private String tema;
    private double valor;
    private Participante participantes[];
    private Palestrante palestrante;
    private int numFunc;

    public Palestra(String tema, double valor) {
        this.tema = tema;
        this.valor = valor;
        participantes = new Participante[5];
    }

    public void setData(String data) {
        this.data = data;
    }
    
    public String getData() {
        return data;
    }

    public String getTema() {
        return tema;
    }

    public double getValor() {
        return valor;
    }
    
    public double calcTotalFaturado(){
        double valorTotal = 0;
        for(int i = 0; i<numFunc ; i++){
            double valorPago = valor;
            switch (participantes[i].getTipo()) {
                case 'E':
                    valorPago = valorPago - valor * 0.15;
                    break;
                case 'I':
                    valorPago = valorPago - valor * 0.20;
                    break;
                case 'C':
                    valorPago = valor;
            }
        valorTotal = valorTotal + valorPago;
    }
        return valorTotal;
}
    
    public void addParticipante(Participante p){
        participantes[numFunc] = p;
        numFunc ++;
    }

    public Palestrante getPalestrante() {
        return palestrante;
    }

    public void setPalestrante(Palestrante palestrante) {
        this.palestrante = palestrante;
    }
    
    
    
}

package fatec.poo.model;

/**
 *
 * @author Gustavo
 */
public class PessoaJuridica extends Pessoa {
    private String cgc;
    private double taxaIncentivo;
    
    public PessoaJuridica(String c, String n, int anoInsc){
        super(n,anoInsc);
        cgc = c;
    }
    
    public double calcBonus(int anoAtual){
        return (taxaIncentivo/100*getTotalCompras()) * (anoAtual - getAnoInscricao());
    }
    
    public void setTaxaIncentivo(double taxaInc){
        taxaIncentivo = taxaInc;
    }
    
    public String getCgc(){
        return cgc;
    }
    
    public double getTaxaIncentivo(){
        return taxaIncentivo;
    }
    
}

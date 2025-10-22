
package fatec.poo.model;

/**
 *
 * @author Gustavo
 */
public class Palestrante extends Pessoa {
    private String empresa;
    private double taxaCobranca;
    private Palestra palestras[];
    private int numFunc;

    public Palestrante(String cpf, String nome, String empresa) {
        super(cpf, nome);
        this.empresa = empresa;
        palestras = new Palestra[3];
    }

    public String getEmpresa() {
        return empresa;
    }

    public double getTaxaCobranca() {
        return taxaCobranca;
    }

    public void setTaxaCobranca(double taxaCobranca) {
        this.taxaCobranca = taxaCobranca;
    }
    
    public double calcTotalReceberPalestras(){
        double total = 0;
        for(int i = 0; i < numFunc ; i++){
            total = total + palestras[i].calcTotalFaturado();
        }
        total =total+ total * (taxaCobranca/100);
        return total;
    }
    
    public void addPalestra(Palestra p){
        palestras[numFunc] = p;
        numFunc ++;
    }
    
}

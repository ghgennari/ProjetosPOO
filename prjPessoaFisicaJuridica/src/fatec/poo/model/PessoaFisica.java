package fatec.poo.model;

/**
 *
 * @author Gustavo
 */
public class PessoaFisica extends Pessoa {
    private String cpf;
    private double base;
    
    public PessoaFisica(String c, String n, int anoInsc){
        super(n, anoInsc);
        cpf = c;
    }
    
    public double calcBonus(int anoAtual){
        if(getTotalCompras()>12000){
            return (anoAtual - getAnoInscricao())*base;
        }else{
            return 0;
        }
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public void setBase(double b){
        base = b;
    }
    
    public double getBase(){
        return base;
    }
    
}

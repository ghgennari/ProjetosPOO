package fatec.poo.model;

/**
 * @author Gustavo
 */
public class Cliente extends Pessoa{
    private String cpf;
    private double peso;
    private double altura;

    public Cliente(String c, String n, String tel){
        super(n, tel);
        cpf = c;
    }
    
    public void setPeso(double p){
        peso = p;
    }
    
    public void setAltura(double a){
        altura = a;
    }
    
    public String getCpf(){
        return cpf;
    }
    
    public double getPeso(){
        return peso;
    }
    
    public double getAltura(){
        return altura;
    }
    
    public double calcIMC(){
        return peso / Math.pow(altura,2); // Pode ser um metodo estatico, onde não ha a necessidade de instancia um objeto
    }
}

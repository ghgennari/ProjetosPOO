package fatec.poo.model;

/*
 * @author Gustavo
 */
public class Pessoa {
    private String nome;
    private String telefone;
    
    public Pessoa(String n,String tel){
        telefone = tel;
        nome = n;
    }
    
    public String getNome(){
        return nome;
    }
    
    public String getTelefone(){
        return telefone;
    }
}

/**
 *
 * @author ghgen
 */
import fatec.poo.model.Cliente;
import fatec.poo.model.Instrutor;
public class Aplic {
    public static void main(String[] args) {
        Cliente objCli = new Cliente("479.178.978-42","Gustavo","15981599953");
        Instrutor objInst = new Instrutor(1010,"Henrique Garcia","15997305722");
        
        //Cliente
        objCli.setAltura(1.69);
        objCli.setPeso(85);
        System.out.println("Cliente: "+objCli.getCpf());
        System.out.println("Nome: "+objCli.getNome());
        System.out.println("Telefone: "+objCli.getTelefone());
        System.out.println("Peso: "+objCli.getPeso()+"kg");
        System.out.println("Altura: "+objCli.getAltura()+"m");
        System.out.println("IMC: "+objCli.calcIMC());
        
        System.out.println("\n");
        
        //Instrutor
        objInst.setAreaAtuacao("Low Code");
        System.out.println("Instrutor: "+objInst.getIdentificacao());
        System.out.println("Nome: "+objInst.getNome());
        System.out.println("Telefone: "+objInst.getTelefone());
        System.out.println("Area de Atuacao: "+objInst.getAreaAtuacao());
        
    }
    
}

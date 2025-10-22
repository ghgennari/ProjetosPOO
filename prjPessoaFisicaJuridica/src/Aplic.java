
import fatec.poo.model.PessoaFisica;
import fatec.poo.model.PessoaJuridica;
import java.text.DecimalFormat;

/**
 *
 * @author Gustavo
 */
public class Aplic {
    public static void main(String[] args) {
        // TODO code application logic here
        DecimalFormat df = new DecimalFormat("#,##0.00");
        PessoaFisica objPf = new PessoaFisica("321.654.987.00","Rodrigo Maganhoto",2020);
        PessoaJuridica objPj = new PessoaJuridica("46.634.044/0001-74","Sorocity", 1654);
        
        objPf.addCompras(200);
        objPf.addCompras(15000);
        objPf.setBase(45);
        
        objPj.addCompras(5000);
        objPj.addCompras(10000);
        objPj.setTaxaIncentivo(5);
        
        System.out.println("Ano Atual: " + 2025);
        System.out.println("\nPessoa Fisica");
        System.out.println("Data de Inscrição:  " + objPf.getAnoInscricao());
        System.out.println("CPF:                "+objPf.getCpf());
        System.out.println("Nome:               " + objPf.getNome());       
        System.out.println("Base:               " + objPf.getBase());
        System.out.println("Total Compras:      " + df.format(objPf.getTotalCompras()));
        System.out.println("Bonus:              " + df.format(objPf.calcBonus(2024)));
        
        System.out.println("\n\nPessoa Jurídica");
        System.out.println("Data de Inscrição:  " + objPj.getAnoInscricao());
        System.out.println("CGC:                " + objPj.getCgc());
        System.out.println("Nome:               " + objPj.getNome());        
        System.out.println("Taxa Incentivo:     " + objPj.getTaxaIncentivo() + "%");
        System.out.println("Total Compras:      " + df.format(objPj.getTotalCompras()));
        System.out.println("Bonus:              " + df.format(objPj.calcBonus(2024)));
    }
}


import fatec.poo.model.Palestra;
import fatec.poo.model.Palestrante;
import fatec.poo.model.Participante;
import java.text.DecimalFormat;

/**
 *
 * @author Gustavo
 */
public class Aplic {
    public static void main(String[] args) {
        // TODO code application logic here
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        Palestrante palestrante = new Palestrante("444.555.6661-77","José Antonio Silva","Hiper Palestras"); //Criação do palestrante
        
        Participante part1 = new Participante("123.456.789-10","Carlos RIbeiro",'C'); // Criação dos participantes
        Participante part2 = new Participante("476.098.192-12","Renata Cardoso",'E');
        Participante part3 = new Participante("110.566.797-00","Edmundo Antunes",'I');
        Participante part4 = new Participante("245.786.555-99","Joao Silva",'I');
        Participante part5 = new Participante("354.876.999-11","Renato Alcantara",'C');
        
        Palestra palestra1 = new Palestra("Marketing digital", 200.00); // Criação das palestras
        Palestra palestra2 = new Palestra("Afiliados",400.00);
        
        palestrante.addPalestra(palestra2); //Adicionando o palestrante as palestras
        palestrante.addPalestra(palestra1);
        
        palestrante.setTaxaCobranca(10); //Taxa do palestrante em porcentagem
        palestra1.setData("10/10/2025"); //Data palestra 1
        palestra1.setPalestrante(palestrante); //Palestrante palestra 1
        palestra2.setData("11/10/2025");//Data palaestra 2
        palestra2.setPalestrante(palestrante); //Palestrante palestra 2
        
        //Participantes da palestra 1
        palestra1.addParticipante(part1);
        palestra1.addParticipante(part3);
        palestra1.addParticipante(part5);
        
        //Participantes da palestra 2
        palestra2.addParticipante(part2);
        palestra2.addParticipante(part4);
        
        System.out.println("CPF palestrante: "+palestrante.getCpf());
        System.out.println("Nome: "+palestrante.getNome());
        System.out.println("Taxa de Cobrança: "+df.format(palestrante.getTaxaCobranca())+"%");
        System.out.println("Valor total a receber pelas palestras: "+df.format(palestrante.calcTotalReceberPalestras()));
        
    }
    
}

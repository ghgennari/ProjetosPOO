
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
        
        Palestrante objPalestrante = new Palestrante("444.555.6661-77","José Antonio Silva","Hiper Palestras"); //Criação do palestrante
        
        Participante objPart1 = new Participante("123.456.789-10","Carlos RIbeiro",'E'); // Criação dos participantes
        Participante objPart2 = new Participante("476.098.192-12","Renata Cardoso",'C');
        Participante objPart3 = new Participante("110.566.797-00","Edmundo Antunes",'C');
        Participante objPart4 = new Participante("245.786.555-99","Joao Silva",'I');
        Participante objPart5 = new Participante("354.876.999-11","Renato Alcantara",'I');
        
        Palestra objPalestra1 = new Palestra("Marketing digital", 1000.00); // Criação das palestras
        Palestra objPalestra2 = new Palestra("Afiliados",2000.00);
        
        objPalestrante.addPalestra(objPalestra2); //Adicionando o palestrante as palestras
        objPalestrante.addPalestra(objPalestra1);
        
        objPalestrante.setTaxaCobranca(60); //Taxa do palestrante em porcentagem
        objPalestra1.setData("10/10/2025"); //Data palestra 1
        objPalestra1.setPalestrante(objPalestrante); //Palestrante palestra 1
        objPalestra2.setData("11/10/2025");//Data palaestra 2
        objPalestra2.setPalestrante(objPalestrante); //Palestrante palestra 2
        
        //Participantes da palestra 1
        objPalestra1.addParticipante(objPart1);
        objPalestra1.addParticipante(objPart3);
        objPalestra1.addParticipante(objPart5);
        
        //Participantes da palestra 2
        objPalestra2.addParticipante(objPart2);
        objPalestra2.addParticipante(objPart4);
        
        System.out.println("CPF palestrante: "+objPalestrante.getCpf());
        System.out.println("Nome: "+objPalestrante.getNome());
        System.out.println("Taxa de Cobrança: "+df.format(objPalestrante.getTaxaCobranca())+"%");
        System.out.println("Valor total a receber pelas palestras: "+df.format(objPalestrante.calcTotalReceberPalestras()));
        
    }
    
}

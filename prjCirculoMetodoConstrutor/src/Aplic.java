
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Aplic {
    public static void main(String[] args) {
       double medRaio;
       int opcao;
       String unidade;
       
       Scanner entrada = new Scanner(System.in);
       System.out.print("Digite a unidade de medida: ");
       unidade = entrada.next();
       System.out.print("Digite o raio do circulo: ");
       medRaio = entrada.nextDouble();
       
       Circulo objCir = new Circulo(unidade);
       objCir.setRaio(medRaio);
       
       do{
           System.out.println("1 - Consultar medida da area");
           System.out.println("2 - COnsultar medida do perimetro");
           System.out.println("3 - Consultar medida do diametro");
           System.out.println("4 - Encerrar");
           System.out.println("Digite a opcao:");
           opcao = entrada.nextInt();
           
           System.out.println("Medida do raio: " + objCir.getRaio()+" "+objCir.getUnidadeMedida());
           if(opcao == 1){
               System.out.println("\n\nMedida da Area: " + objCir.calcArea() + " " + objCir.getUnidadeMedida() + "²");
           }else{
               if(opcao == 2){
                   System.out.println("\n\nMedida do perimetro: " + objCir.calcPerimetro()+ " " + objCir.getUnidadeMedida());
               }else{
                   if(opcao == 3){
                       System.out.println("\n\nMedida do diametro: " + objCir.calcDiametro()+ " " + objCir.getUnidadeMedida());
                   }
               }
           }
       }while (opcao<4);
       
       System.out.println("Sistem encerrado!");
    }
    
}

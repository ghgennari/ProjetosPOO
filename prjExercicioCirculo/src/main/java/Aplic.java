
import java.util.Scanner;

/**
 *
 * @author Gustavo
 */
public class Aplic {
    public static void main(String[] args) {
       double medRaio;
       int opcao;
       
       Scanner entrada = new Scanner(System.in);
       System.out.print("Digite o raio do circulo: ");
       medRaio = entrada.nextDouble();
       
       Circulo objCir = new Circulo();
       objCir.setRaio(medRaio);
       
       do{
           System.out.println("1 - Consultar medida da area");
           System.out.println("2 - COnsultar medida do perimetro");
           System.out.println("3 - Consultar medida do diametro");
           System.out.println("4 - Encerrar");
           System.out.println("Digite a opcao:");
           opcao = entrada.nextInt();
           
           if(opcao == 1){
               System.out.println("\n\nMedida da Area: " + objCir.calcArea());
           }else{
               if(opcao == 2){
                   System.out.println("\n\nMedida do perimetro: " + objCir.calcPerimetro());
               }else{
                   if(opcao == 3){
                       System.out.println("\n\nMedida do diametro: " + objCir.calcDiametro());
                   }
               }
           }
           
       }while (opcao<4);
       
       System.out.println("Sistem encerrado!");
    }
    
}

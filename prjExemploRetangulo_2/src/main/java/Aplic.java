import java.util.Scanner;
/**
 *
 * @author Gustavo
 */
public class Aplic {
    public static void main(String[] args) {
        double medAlt, medBase;
        int opcao;
        Retangulo objRet;
        Scanner entrada;
        
        //Instanciação de um objeto da classe Scanner
        entrada = new Scanner(System.in);
        System.out.print("Digite a medida da altura do retangulo: ");
        medAlt = entrada.nextDouble(); //scanf("%lf",&medAlt)
        
        System.out.print("Digite a medida da base do retangulo: ");
        medBase = entrada.nextDouble();//scanf("%lf",&medBase)
        
        //Instanciação de um objeto da classe Retangulo
        objRet = new Retangulo();
        objRet.setAltura(medAlt);
        objRet.setBase(medBase);
        
        do{
           System.out.println("1 - Consultar medida da area");
           System.out.println("2 - Consultar medida do perimetro");
           System.out.println("3 - Consultar medida da diagonal");
           System.out.println("4 - Encerrar");
           System.out.print("\n\t\tDigite a opcao: ");
           opcao = entrada.nextInt(); //scanf("%d",&opcao);
           
           if(opcao == 1){
               System.out.println("\n\nMedida da area: " + objRet.calcArea());
           }
           else 
               if(opcao == 2){
                    System.out.println("\n\nMedida do perimetro: " + objRet.calcPerimetro());
                }
                else 
                   if(opcao == 3){
                        System.out.println("\n\nMedida da diagonal: " + objRet.calcDiagonal());
                    }
           
        }while(opcao < 4);
        
        System.out.print("Sistema encerrado.");
    }
    
}

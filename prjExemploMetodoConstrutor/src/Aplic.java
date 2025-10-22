import java.util.Scanner;

/**
 *
 * @author Dimas
 */
public class Aplic {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        double medAlt, medBase;
        int opcao;
        String unidade; 
        
        System.out.print("Digite a unidade de medida: ");
        unidade = entrada.next();
        
        //criação do ponteiro,
        //instanciação(alocação) de um objeto da classe Retangulo
        //e chamada do método construtor       
        Retangulo objRet = new Retangulo(unidade);
        
        
	System.out.print("Digite a medida da altura do retângulo: ");
        medAlt = entrada.nextDouble();      
        System.out.print("Digite a medida da base do retângulo: ");
        medBase = entrada.nextDouble();   
		
	//Passagem de mensagens
        objRet.setAltura(medAlt);
        objRet.setBase(medBase);
        
        do{
            System.out.println("\n\n1 - Consultar medida da área");
            System.out.println("2 - Consultar medida do perímetro");
            System.out.println("3 - Consultar medida da diagonal");
            System.out.println("4 - Encerrar");
            System.out.print("\n\t\tDigite a opção: ");
            opcao = entrada.nextInt(); //scanf("%d", &opcao);
            
            System.out.println("\n\nMedida da altura do retângulo: " + objRet.getAltura() + " " + objRet.getUnidadeMedida() );
            System.out.println("Medida da base do retângulo: " + objRet.getBase()+ " " + objRet.getUnidadeMedida());
            if (opcao == 1){
                System.out.println("Medida da área: " + objRet.calcArea()+ " " + objRet.getUnidadeMedida()+ "²");
            }else
               if (opcao == 2){
                   System.out.println("Medida do perímetro: " + objRet.calcPerimetro()+ " " + objRet.getUnidadeMedida());       
               }else
                  if (opcao == 3){
                      System.out.println("Medida da diagonal: " + objRet.calcDiagonal()+ " " + objRet.getUnidadeMedida());
                  } 
        }while(opcao < 4);        
    }        
}

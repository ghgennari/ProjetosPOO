/**
 *
 * @author Gustavo
 */
import java.util.Scanner;
public class Aplic {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int conta,opcao;
        double saldo;
        
        System.out.print("Digite a conta: ");
        conta = entrada.nextInt();
        System.out.print("Digite o saldo: ");
        saldo = entrada.nextDouble();
        
        ContaCorrente objConta = new ContaCorrente(conta,saldo);
        
        
        do{
            System.out.println("\n\n1-Depositar");
            System.out.println("2-Sacar");
            System.out.println("3-Consultar saldo");
            System.out.println("4-Sair");
            System.out.print("Digite a opcao desejada: ");
            opcao = entrada.nextInt();
            
            System.out.println("\nNumero da conta: " + objConta.getNumero());
            if(opcao==1){
                System.out.println("Digite o valor a depositar: ");
                double deposito = entrada.nextDouble();
                objConta.depositar(deposito);
                System.out.println("Saldo atual em conta: "+objConta.getSaldo());
            }else{
                if(opcao==2){
                    System.out.println("Digite o valor a sacar: ");
                    double sacar = entrada.nextDouble();
                    if(sacar <= objConta.getSaldo()){
                        objConta.sacar(sacar);
                        System.out.println("Saldo atual em conta: " + objConta.getSaldo());
                    }else{
                        System.out.println("Saldo Insuficiente");
                    }
                }else{
                    if(opcao == 3){
                        System.out.println("Saldo atual: " + objConta.getSaldo());
                    }
                }
            }
            
        }while(opcao<4);
    }
}

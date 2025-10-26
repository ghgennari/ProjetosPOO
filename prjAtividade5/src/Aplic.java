
import java.text.DecimalFormat;
import java.util.Scanner;
import fatec.poo.model.PessoaFisica;
import fatec.poo.model.PessoaJuridica;
import fatec.poo.model.PedidoCompra;
import fatec.poo.model.Pessoa;

/**
 *
 * @author Gustavo
 */
public class Aplic {
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("#,##0.00");
        
        //Entrada de dados PESSOA FISICA
        String nomePF, CPF;
        int anoPF;
        System.out.println("\t\t---CADASTRO DA PESSOA FISICA---");
        System.out.println("Digite o nome da pessoa fisica: ");
        nomePF = entrada.nextLine();
        System.out.println("Digite o CPF: ");
        CPF = entrada.nextLine();
        System.out.println("Ano de inscrição: ");
        anoPF = entrada.nextInt();
        System.out.println("Base de Bonus R$: ");
        PessoaFisica objPF = new PessoaFisica(CPF, nomePF, anoPF); //Instanciando objeto PF após entrada dos valores
        objPF.setBase(entrada.nextDouble());
        
        
        //Entrada de dados PESSOA JURIDICA
        entrada.nextLine();
        String nomePJ, CGC;
        int anoPJ;
        System.out.println("\t\t---CADASTRO DA PESSOA JURIDICA---");
        System.out.println("Digite o nome da pessoa juridica: ");
        nomePJ = entrada.nextLine();
        System.out.println("Digite o CGC: ");
        CGC = entrada.nextLine();
        System.out.println("Ano de inscrição: ");
        anoPJ = entrada.nextInt();
        System.out.println("Digite a taxa de incentivo (%): ");
        PessoaJuridica objPJ = new PessoaJuridica(CGC, nomePJ, anoPJ);//Instanciando objeto PJ após entrada dos valores
        objPJ.setTaxaIncentivo(entrada.nextDouble());
        
        //Entrada de PEDIDOS COMPRA
        PedidoCompra cadPedidos[] = new PedidoCompra[10];
        int qtdPedPF = 0, qtdPedPJ = 0;
        double valor = 0;
        
        for (int i = 0;i<10;i++){
            System.out.println("\nQuantidade de pedidos: "+(i+1));
            System.out.println("Número do pedido: ");
            int p = entrada.nextInt();
            entrada.nextLine();
            
            PedidoCompra pedido = new PedidoCompra(p);
            
            System.out.println("Data do Pedido: ");
            pedido.setDataPedido(entrada.nextLine());
            
            System.out.println("Valor do pedido R$: ");
            valor = entrada.nextDouble();
            pedido.setValor(valor);
            
            System.out.println("Pedido de Pessoa Fisica ou Pessoa Juridica?"
                    + "\n1-Pessoa Fisica\n2-Pessoa Juridica");
            int escolha = entrada.nextInt();
            
            switch(escolha){
                case 1:
                    objPF.addPedido(pedido);
                    objPF.addCompras(valor);
                    qtdPedPF++;
                    break;
                case 2:
                    objPJ.addPedido(pedido);
                    objPJ.addCompras(valor);
                    qtdPedPJ++;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
            
            cadPedidos[i] = pedido;
            
            System.out.println("\nDeseja fazer outro pedido:"
                    + "\n1-SIM\n2-NÃO");
            int opcao = entrada.nextInt();
            if(opcao == 2){
                break;
            }
        }
        System.out.println("\t\t---PESSOA FISICA---");
        System.out.println("Nome: " + objPF.getNome());
        System.out.println("CPF: " + objPF.getCpf());
        System.out.println("Pedidos: " + qtdPedPF);
        System.out.println("Total das Compras: R$"+df.format(objPF.getTotalCompras()));
        System.out.println("Bonus: R$"+df.format(objPF.calcBonus(2025)));
        
        System.out.println("\t\t---PESSOA JURIDICA---");
        System.out.println("Nome: "+objPJ.getNome());
        System.out.println("CGC: "+objPJ.getCgc());
        System.out.println("Pedidos: "+ qtdPedPJ);
        System.out.println("Total Compras: R$"+df.format(objPJ.getTotalCompras()));
        System.out.println("Bonus: R$"+df.format(objPJ.calcBonus(2025)));
    }
}
    

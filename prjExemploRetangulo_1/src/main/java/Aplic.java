/**
 *
 * @author Gustavo
 */
public class Aplic {

    public static void main(String[] args) {
        Retangulo objRet; //Definição do ponteiro
        
        //Instanciação(alocação) de um objeto da classe Retangulo
        objRet = new Retangulo();
        
        //Implementando o caso de uso Montar Figura Geometrica Retangulo
        objRet.setAltura(5.0); //Passando mensagem para o objeto
        objRet.setBase(8.0);
        
        System.out.println("Medida da altura: " + objRet.getAltura());
        System.out.println("Medida da base: " + objRet.getBase());
        
        //Implementando o caso de uso Consultar Area Figura Geometrica Retangulo
        System.out.println("Medida da Area: " + objRet.calcArea());
        
        //Implementando o caso de uso Consultar Perimetro Figura Geometrica Retangulo
        System.out.println("Medida do Perimetro: " + objRet.calcPerimetro());
        
        //Implementando o caso de uso Consultar Diagonal Figura Geometrica Retangulo
        System.out.println("Medida da diagonal: " + objRet.calcDiagonal());
    }
    
}

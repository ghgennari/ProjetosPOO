
/**
 *
 * @author Gustavo
 */
public class Retangulo {
    private double altura;
    private double base;
    
    //Tem como parametro de entrada a medida da altura
    public void setAltura(double a){
        altura = a;
    }
    
    //Retorna o conteudo do atributo altura
    public double getAltura(){
        return(altura);
    }
    
    //Tem como parametro de entrada a medida da base
    public void setBase(double b){
        base = b;
    }
    
    //Retorna o conteudo do atributo base
    public double getBase(){
        return(base);
    }
    
    public double calcArea(){
        return(altura * base);
    }
    
    public double calcPerimetro(){
        return(2 * (altura + base));
    }
    
    public double calcDiagonal(){
        return(Math.sqrt(Math.pow(altura,2)+Math.pow(base,2)));
    }
}

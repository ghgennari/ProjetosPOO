/**
 *
 * @author Gustavo
 */
public class Circulo {
    private double raio;
    
    public void setRaio(double r){
        raio = r;
    }
    
    public double getRaio(){
        return(raio);
    }
    
    public double calcArea(){
        return(raio * 3.1416);
    }
    
    public double calcPerimetro(){
        return(2*3.1416*raio);
    }
    
    public double calcDiametro(){
        return(2*raio);
    }
    
}

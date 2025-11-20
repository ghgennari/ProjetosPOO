
package fatec.poo.model;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Paciente extends Pessoa {
    private LocalDate dataNascimento;
    private double altura;
    private double peso;
    private ArrayList<Consulta> consultas;

    public Paciente(String cpf, String nome, LocalDate dataNascimento) {
        super(cpf, nome);
        this.dataNascimento = dataNascimento;
        consultas = new ArrayList<Consulta>();
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public double getPeso() {
        return peso;
    }
    
    public void addConsulta(Consulta c){
        consultas.add(c);
    }
    
    public double calcIMC(){
        return peso/ Math.pow(altura, 2);
    }
    
    public int calcIdade(LocalDate dataAtual){
        return Period.between(getDataNascimento(), dataAtual).getYears();
    }
    
}

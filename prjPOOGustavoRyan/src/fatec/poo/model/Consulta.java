
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Gustavo
 */
public class Consulta {
    private int codigo;
    private String data;
    private double valor;
    private Medico medico;
//    private Paciente paciente;
    private ArrayList<Medicacao> medicacoes;
    private ArrayList<Exame> exames;
    private Exame exame;

    public Consulta(int codigo, String data) {
        this.codigo = codigo;
        this.data = data;
        exames = new ArrayList<Exame>();
        medicacoes = new ArrayList<Medicacao>();
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

//    public void setPaciente(Paciente paciente) {
//        this.paciente = paciente;
//    }
    
    public void addExames(Exame ex){
        exames.add(ex);
        ex.setConsulta(this);
    }
    
    public void addMedicacao(Medicacao med){
        medicacoes.add(med);
//        med.setConsulta(this);
    }
    
    public double calcValorTotalPagar(){
        double totalExames = 0;
        for(int i=0;i<exames.size();i++){
            totalExames += exames.get(i).getValor();
        }
        return valor + totalExames;
    }
    
}

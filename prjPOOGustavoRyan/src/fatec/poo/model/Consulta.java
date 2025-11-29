
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
    private ArrayList<Medicacao> medicacoes;
    private ArrayList<Exame> exames;

    public Consulta(int codigo, String data) {
        this.codigo = codigo;
        this.data = data;
        exames = new ArrayList<>();
        medicacoes = new ArrayList<>();
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(String data) {
        this.data = data;
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
    
    public void addExames(Exame ex){
        exames.add(ex);
        ex.setConsulta(this);
    }
    
    public void addMedicacao(Medicacao med){
        medicacoes.add(med);
    }
    
    public double calcValorTotalPagar(){
        double totalExames = 0;
        for(int i=0;i<exames.size();i++){
            totalExames += exames.get(i).getValor();
        }
        return valor + totalExames;
    }

    public Medico getMedico() {
        return medico;
    }

}

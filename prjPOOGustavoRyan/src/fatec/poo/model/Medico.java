
package fatec.poo.model;

import java.util.ArrayList;

/**
 *
 * @author Gstavo
 */
public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private ArrayList<Consulta> consultas;

    public Medico(String cpf, String nome, String crm, String especialidade) {
        super(cpf, nome);
        this.crm = crm;
        this.especialidade = especialidade;
        consultas = new ArrayList<>();
    }

    public String getCrm() {
        return crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }
    
    public void addConsultas(Consulta c){
        consultas.add(c);
        c.setMedico(this);
    }
    
}

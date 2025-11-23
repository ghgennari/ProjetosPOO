
package fatec.poo.control;

import fatec.poo.model.Medico;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class DaoMedico {
    private Connection conn;
    
    public DaoMedico(Connection conn){
        this.conn = conn;
    }
    
    public void inserir(Medico medico){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbMedico(CPF, Nome, Endereco, Telefone, CRM, Especialidade) VALUES (?,?,?,?,?,?)");
            ps.setString(1, medico.getCpf());
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getEndereco());
            ps.setString(4, medico.getTelefone());
            ps.setString(5, medico.getCrm());
            ps.setString(6, medico.getEspecialidade());
            
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Medico medico){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbMedico SET Nome=?,CRM=?,Especilidade=?,Endereco=?,Telefone=? WHERE CPF=?");
            
            ps.setString(1, medico.getCpf());
            ps.setString(2, medico.getNome());
            ps.setString(3, medico.getEndereco());
            ps.setString(4, medico.getTelefone());
            ps.setString(5, medico.getCrm());
            ps.setString(6, medico.getEspecialidade());
            
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void excluir(Medico medico){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbMedico WHERE CPF=?");
            ps.setString(1, medico.getCpf());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Medico consultar (String cpf){
        Medico m = null;
        
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * FROM tbMedico WHERE CPF=?");
            ps.setString(1,cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                m = new Medico (cpf, rs.getString("Nome"),rs.getString("CRM"),rs.getString("Especialidade"));
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return (m);
    }
}

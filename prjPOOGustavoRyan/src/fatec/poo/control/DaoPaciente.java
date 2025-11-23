
package fatec.poo.control;

import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 *
 * @author Gustavo
 */
public class DaoPaciente {
    private Connection conn;

    public DaoPaciente(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Paciente paciente){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbPaciente(CPF, Nome, Endereco, Telefone, DataNascimento,Altura,Peso) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1,paciente.getCpf());
            ps.setString(2,paciente.getNome());
            ps.setString(3,paciente.getEndereco());
            ps.setString(4,paciente.getTelefone());
            ps.setString(5,paciente.getDataNascimento());
            ps.setDouble(6,paciente.getAltura());
            ps.setDouble(7,paciente.getPeso());
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Paciente paciente){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbPaciente SET Nome=?, Endereco=?, Telefone=?, DataNascimento=?,Altura=?,Peso=? WHERE CPF=?");
            ps.setString(1,paciente.getCpf());
            ps.setString(2,paciente.getNome());
            ps.setString(3,paciente.getEndereco());
            ps.setString(4,paciente.getTelefone());
            ps.setString(5,paciente.getDataNascimento());
            ps.setDouble(6,paciente.getAltura());
            ps.setDouble(7,paciente.getPeso());
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Paciente consultar(String cpf){
        Paciente p = null;
        PreparedStatement ps = null;
        
        try{
            ps = conn.prepareStatement("SELECT * FROM tbPaciente WHERE CPF=?");
            ps.setString(1, cpf);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()){
                LocalDate dt = LocalDate.parse(rs.getString("DataNascimento"));
                p = new Paciente(rs.getString("CPF"),rs.getString("Nome"),dt);
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return p;
    }
    
    public void excluir(Paciente paciente){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbPaciente WHERE CPF = ?");
            ps.setString(1,paciente.getCpf());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
}

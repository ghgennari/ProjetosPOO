
package fatec.poo.control;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medico;
import fatec.poo.model.Paciente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Gustavo
 */
public class DaoConsulta {
    private Connection conn;

    public DaoConsulta(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Consulta consulta, Paciente paciente){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbConsulta(codigo,data,valor,cpfMedico,cpfPaciente) VALUES (?,?,?,?,?)");
            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getData());
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, consulta.getMedico().getCpf());
            ps.setString(5,paciente.getCpf());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Consulta consulta){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbConsulta SET data=?,valor=? WHERE codigo=?");
            ps.setString(1,consulta.getData());
            ps.setDouble(2, consulta.getValor());
            ps.setInt(3, consulta.getCodigo());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Consulta consultar(int codigo){
        Consulta c = null;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT * FROM tbConsulta WHERE codigo = ?");
            ps.setInt(1,codigo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                c = new Consulta(rs.getInt("codigo"),rs.getString("data"));
                c.setValor(rs.getDouble("valor"));
                Medico m = new DaoMedico(conn).consultar(rs.getString("cpfMedico"));
                m.addConsultas(c);
                Paciente p = new DaoPaciente(conn).consultar(rs.getString("cpfPaciente"));
                p.addConsulta(c);
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return c;
    }
    
    public void excluir(Consulta consulta){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbConsulta WHERE codigo = ?");
            ps.setInt(1,consulta.getCodigo());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Paciente consultaPaciente(int codigo){
        Paciente p = null;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("SELECT cpfPaciente FROM tbConsulta WHERE Codigo = ?");
            ps.setInt(1, codigo);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                String cpf = rs.getString("cpfPaciente");
                DaoPaciente dao = new DaoPaciente(conn);
                p = dao.consultar(cpf);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return p;
    }
}

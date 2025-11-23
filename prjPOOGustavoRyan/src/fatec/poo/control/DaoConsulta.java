
package fatec.poo.control;

import fatec.poo.model.Consulta;
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
    
    public void inserir(Consulta consulta){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbConsulta(Codigo,Data,Valor,CPFMedico,CPFPaciente) VALUES (?,?,?,?,?)");
            ps.setInt(1, consulta.getCodigo());
            ps.setString(2, consulta.getData());
            ps.setDouble(3, consulta.getValor());
            ps.setString(4, consulta.getMedico().getCpf());
            ps.setString(5,consulta.getPaciente().getCpf());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Consulta consulta){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbConsulta SET Data=?,Valor=? WHERE Codigo=?");
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
            ps = conn.prepareStatement("SELECT * FROM tbConsulta WHERE Codigo = ?");
            ps.setInt(1,codigo);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                c = new Consulta(rs.getInt("Codigo"),rs.getString("Data"));
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return c;
    }
    
    public void excluir(Consulta consulta){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbConsulta WHERE Codigo = ?");
            ps.setInt(1,consulta.getCodigo());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
}

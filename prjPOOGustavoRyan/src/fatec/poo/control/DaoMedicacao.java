
package fatec.poo.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fatec.poo.model.Consulta;
import fatec.poo.model.Medicacao;

/**
 *
 * @author Gustavo
 */
public class DaoMedicacao {
    private Connection conn;

    public DaoMedicacao(Connection conn){
        this.conn = conn;
    }

    public void inserir(Medicacao medicacao, Consulta consulta){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbMedicacao(nome,dosagem,qtdeDias,codConsulta) VALUES (?,?,?,?)");
            ps.setString(1, medicacao.getNome());
            ps.setString(2, medicacao.getDosagem());
            ps.setInt(3, medicacao.getQtdeDias());
            ps.setInt(4, consulta.getCodigo()); //Medicicao nao aponta pra consulta na modelagem

            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }

    public void alterar(Medicacao medicacao){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbMedicacao SET dosagem = ?,qtdeDias = ? WHERE nome = ?");
            ps.setString(1, medicacao.getDosagem());
            ps.setInt(2, medicacao.getQtdeDias());
            ps.setString(3, medicacao.getNome());

            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }

    public Medicacao consultar(String nome){
        Medicacao m = null;

        PreparedStatement ps = null;

        try{
            ps = conn.prepareStatement("SELECT * FROM tbMedicacao WHERE nome=?");
            ps.setString(1, nome);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                m = new Medicacao(rs.getString("nome"));
                m.setDosagem(rs.getString("dosagem"));
                m.setQtdeDias(rs.getInt("qtdeDias"));
                Consulta c = new DaoConsulta(conn).consultar(rs.getInt("codConsulta"));
                c.addMedicacao(m);
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return m;
    }

    public void excluir(Medicacao medicacao){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbMedicacao WHERE nome=?");
            ps.setString(1, medicacao.getNome());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Consulta buscarConsulta(String nome){
        Consulta c = null;
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("SELECT codConsulta FROM tbMedicacao WHERE nome = ?");
            ps.setString(1, nome);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                int cod = rs.getInt("codConsulta");
                DaoConsulta dao = new DaoConsulta(conn);
                c = dao.consultar(cod);
            }
            }catch(SQLException ex){
                System.out.println(ex.toString());
            }
        return c;
    }    
}

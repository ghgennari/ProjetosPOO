
package fatec.poo.control;

import fatec.poo.model.Consulta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import fatec.poo.model.Exame;

/**
 *
 * @author Gustavo
 */
public class DaoExame {
    private Connection conn;

    public DaoExame(Connection conn) {
        this.conn = conn;
    }
    
    public void inserir(Exame exame){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("INSERT INTO tbExame(codigo, descricao, data, horario, valor, codConsulta) VALUES (?,?,?,?,?,?)");

            ps.setInt(1, exame.getCodigo());
            ps.setString(2, exame.getDescricao());
            ps.setString(3, exame.getData());
            ps.setString(4, exame.getHorario());
            ps.setDouble(5, exame.getValor());
            ps.setInt(6, exame.getConsulta().getCodigo()); //Exame nao aponta pra consulta na modelagem

            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }

    public void alterar(Exame exame){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbExame SET descricao=?, data=?, horario=?, valor=? WHERE codigo = ?");
            ps.setString(1, exame.getDescricao());
            ps.setString(2, exame.getData());
            ps.setString(3, exame.getHorario());
            ps.setDouble(4, exame.getValor());
            ps.setInt(5,exame.getCodigo());

            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }

    public Exame consultar(int codigo){
        Exame e = null;
        PreparedStatement ps = null;

        try{
            ps=conn.prepareStatement("SELECT * FROM tbExame WHERE codigo = ?");
            ps.setInt(1,codigo);

            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                e = new Exame(rs.getInt("codigo"),rs.getString("descricao"));
                e.setData(rs.getString("data"));
                e.setHorario(rs.getString("horario"));
                e.setValor(rs.getDouble("valor"));
                Consulta c = new DaoConsulta(conn).consultar(Integer.parseInt(rs.getString("codConsulta")));
                e.setConsulta(c);
            }
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
        return e;
    }

    public void excluir(Exame exame){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbExame WHERE codigo=?");
            ps.setInt(1,exame.getCodigo());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }


}

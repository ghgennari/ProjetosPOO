
package fatec.poo.control;

import fatec.poo.model.Paciente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

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
            ps = conn.prepareStatement("INSERT INTO tbPaciente(cpf, nome, endereco, telefone, dataNascimento,altura,peso) VALUES (?,?,?,?,?,?,?)");
            ps.setString(1,paciente.getCpf());
            ps.setString(2,paciente.getNome());
            ps.setString(3,paciente.getEndereco());
            ps.setString(4,paciente.getTelefone());
            ps.setString(5,paciente.getDataNascimento());
            ps.setDouble(6,paciente.getAltura());
            ps.setDouble(7,paciente.getPeso());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public void alterar(Paciente paciente){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("UPDATE tbPaciente SET nome=?, "
                    + "endereco=?, telefone=?, "
                    + "dataNascimento=?,altura=?,peso=? WHERE cpf=?");
            ps.setString(1,paciente.getNome());
            ps.setString(2,paciente.getEndereco());
            ps.setString(3,paciente.getTelefone());
            ps.setString(4,paciente.getDataNascimento());
            ps.setDouble(5,paciente.getAltura());
            ps.setDouble(6,paciente.getPeso());
            ps.setString(7,paciente.getCpf());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
    
    public Paciente consultar(String cpf){
    Paciente p = null;
    PreparedStatement ps = null;

    try{
        ps = conn.prepareStatement("SELECT * FROM tbPaciente WHERE cpf=?");
        ps.setString(1, cpf);

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String data = rs.getString("dataNascimento");
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy");
            LocalDate dt = LocalDate.parse(data, fmt);

            p = new Paciente(rs.getString("cpf"), rs.getString("nome"), dt);

            p.setEndereco(rs.getString("endereco"));
            p.setTelefone(rs.getString("telefone"));
            p.setAltura(rs.getDouble("altura"));
            p.setPeso(rs.getDouble("peso"));
        }
    }catch(SQLException ex){
        System.out.println(ex.toString());
    }
    return p;
}

    
    public void excluir(Paciente paciente){
        PreparedStatement ps = null;
        try{
            ps = conn.prepareStatement("DELETE FROM tbPaciente WHERE cpf = ?");
            ps.setString(1,paciente.getCpf());
            ps.execute();
        }catch(SQLException ex){
            System.out.println(ex.toString());
        }
    }
}

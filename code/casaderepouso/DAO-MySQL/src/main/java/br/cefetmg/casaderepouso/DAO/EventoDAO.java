
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.dto.Evento;
import br.cefetmg.casaderepouso.idao.IEventoDAO;
import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author rigor
 */
public class EventoDAO implements IEventoDAO {
     @Override
    public void inserir(Evento event) throws SQLException, ClassNotFoundException{
        try{
            
            Connection con = DAO.conectar();
            String sql = "INSERT INTO evento (id, nome, rg, descricao, lugar, dia, horario, telefone, email) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
             
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, event.getId());
            pstmt.setString(2, event.getNome());
            pstmt.setString(3, event.getRg());
            pstmt.setString(4, event.getDescricao());
            pstmt.setString(5, event.getLocal());
            
            pstmt.setString(6, event.getData());
            
            pstmt.setString(7, event.getHorario());
            pstmt.setString(8, event.getFone());
            pstmt.setString(9, event.getEmail());

            pstmt.executeUpdate();
            pstmt.close();
            con.close();
      
        }
        catch(SQLException e){
            System.out.println(e);
            throw new SQLException(e.getMessage(), e);       
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
            throw new ClassNotFoundException(e.getMessage(), e);       
        }
    }


    @Override
    public boolean deletar(Evento event) throws SQLException, ClassNotFoundException {
         return true;
    }

    @Override
    public ArrayList<Evento> listarTodos()throws SQLException, ClassNotFoundException{
       String sql = "SELECT * FROM evento ORDER BY nome";
        try {
            
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Evento> listAll = new ArrayList<Evento>();
            while (rs.next()) {

                String id = rs.getString(1);
                String nome = rs.getString(2);
                String rg = rs.getString(3);
                String desc = rs.getString(4);

               
                String lugar = rs.getString(5);


                String dia = rs.getString(6);
                String hora = rs.getString(7);
                String fone = rs.getString(8);
                String email = rs.getString(9);

                Evento event = new Evento(nome, rg, desc, lugar,
                     dia,  hora, fone, email, id);

                listAll.add(event);
            }
            rs.close();
            pst.close();
            con.close();
            return listAll;

        } 
        catch(SQLException e){
            throw new SQLException(e.getMessage(), e);       
        }
        catch(ClassNotFoundException e){
            throw new ClassNotFoundException(e.getMessage(), e);       
        }
}


    @Override
    public Evento pesquisar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

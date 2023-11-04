
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
        
    }


    @Override
    public boolean deletar(Evento event) throws SQLException, ClassNotFoundException {
         return true;
    }

    @Override
    public ArrayList<Evento> listarTodos()throws SQLException, ClassNotFoundException{
       //Colocando um return aleatório para tirar o warning
       ArrayList<Evento> list = null;
       return list;
}


    @Override
    public Evento pesquisar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

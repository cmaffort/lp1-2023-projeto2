package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Visitante;
import br.cefetmg.casaderepouso.idao.IVisitanteDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */

public class VisitanteDAO implements IVisitanteDAO{

    public boolean cadastrar(Visitante visitante) {
        String sqlVisitante = "INSERT INTO visitantes(nome, rg, telefone, vinculo_com_morador,data_e_hora_de_visita, morador) VALUES(?,?,?,?,?,?)";
        System.out.println("Chegou no Conector, sla o nome disso");

        try {   
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdlardeidosos", "root", "admin");
                PreparedStatement pstm = con.prepareStatement(sqlVisitante);
                
                //Transforma os ? nas variaveis
                pstm.setString(1, visitante.getNome());
                pstm.setString(2, visitante.getRg());
                pstm.setString(3, visitante.getTelefone());
                pstm.setString(4, visitante.getVinculo());
                pstm.setString(5,  visitante.getDataVisita());
                pstm.setString(6, visitante.getMorador());
                
                //Executar
                pstm.executeUpdate();
                //encerrar conexao
                con.close();
            

        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VisitanteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public List<Visitante> listarTodos() {
        String query = "SELECT * FROM visitantes";
        List<Visitante> visitanteList = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdlardeidosos", "root", "admin");
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet resultset = preparedStatement.executeQuery();
            while(resultset.next()){
                Visitante visitante = new Visitante(resultset.getString("nome"),resultset.getString("rg"),resultset.getString("telefone"),resultset.getString("vinculo_com_morador"),resultset.getString("morador"),resultset.getString("data_e_hora_de_visita"));
                visitanteList.add(visitante);
            }
            connection.close();
            
    }catch (ClassNotFoundException ex) {
            System.out.println(ex);
    } catch (SQLException ex) {
        System.out.println(ex);
    }
        return visitanteList;
    }

    }
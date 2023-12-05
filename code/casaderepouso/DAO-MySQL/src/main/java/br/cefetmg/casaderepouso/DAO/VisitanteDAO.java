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
        String sqlVisitante = "INSERT INTO visitantes(nome, rg, telefone, vinculo_com_morador,data_visita, morador, hora_visita) VALUES(?,?,?,?,?,?,?)";
        //System.out.println("Chegou no Conector");

        try {   
                Connection con = DAO.conectar();
                PreparedStatement pstm = con.prepareStatement(sqlVisitante);
                
                //Transforma os ? nas variaveis
                pstm.setString(1, visitante.getNome());
                pstm.setString(2, visitante.getRg());
                pstm.setString(3, visitante.getTelefone());
                pstm.setString(4, visitante.getVinculo());
                pstm.setString(5,  visitante.getDataVisita());
                pstm.setString(6, visitante.getMorador());
                pstm.setString(7,visitante.getHoraVisita());
                
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

            Connection connection = DAO.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String nome = rs.getString(2);
                String rg = rs.getString(3);
                String telefone = rs.getString(4);
                String vinculo = rs.getString(5);
                String dataVisita = rs.getString(8);
                String morador = rs.getString(6);
                String horaVisita = rs.getString(7);
                
                Visitante visitante = new Visitante(nome, rg, telefone, morador, vinculo, dataVisita, horaVisita);
                
                visitanteList.add(visitante);

            }
            connection.close();
            rs.close();
            
    }catch (ClassNotFoundException ex) {
            System.out.println(ex);
    } catch (SQLException ex) {
        System.out.println(ex);
    }
        return visitanteList;
    }

    }
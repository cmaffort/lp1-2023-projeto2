package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Visitante;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */

public class VisitanteDAO{

    public static Boolean cadastrar(Visitante visitante) {
        String sqlVisitante = "INSERT INTO visitante(nome, rg, telefone, vinculo_com_morador,data_e_hora_de_visita, morador) VALUES(?,?,?,?,?,?)";
        System.out.println("Chegou no Conector, sla o nome disso      ");

        try {                
                Connection con = DAO.conectar();
                PreparedStatement pstm = con.prepareStatement(sqlVisitante);
                
                //Transforma os ? nas variaveis
                pstm.setString(1, visitante.getNome());
                pstm.setString(2, visitante.getRg());
                pstm.setString(3, visitante.getTelefone());
                pstm.setString(4, visitante.getVinculo());
                pstm.setDate(5, (java.sql.Date) visitante.getDataVisita());
                pstm.setString(7, visitante.getMorador());
                
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
    
    public ArrayList<Visitante> listarTodos()throws SQLException, ClassNotFoundException{

	String sql = "SELECT * FROM morador ORDER BY nome";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Visitante> listAll = null;
            while (rs.next()) {

                String nome = rs.getString(1);
                String rg = rs.getString(2);
                String telefone = rs.getString(3);
                String vinculo_com_morador= rs.getString(4);
                Date data_e_hora_de_visita = rs.getDate(5);
                String morador = rs.getString(6);
                Visitante visi = null;                

                listAll.add(visi);
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

    }
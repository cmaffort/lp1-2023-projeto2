/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Consulta;
import br.cefetmg.casaderepouso.idao.IConsultaDAO;
import java.sql.Connection;
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
 * @author jujua
 */
public class ConsultaDAO implements IConsultaDAO{

    public ConsultaDAO() {
    }

    @Override
    public boolean cadastrar(Consulta consulta) {
               String sqlConsulta = "INSERT INTO consulta(data, hora, profissional_de_saude, especializacao, tipo) VALUES(?,?,?,?,?)";
        System.out.println("Chegou no Conector");

        try {   

                Connection con = DAO.conectar();
          
                PreparedStatement pstm = con.prepareStatement(sqlConsulta);
                
                //Transforma os ? nas variaveis
                pstm.setString(1, consulta.getData());
                pstm.setString(2, consulta.getHora());
                pstm.setString(3, consulta.getProfissional());
                pstm.setString(4, consulta.getEspecializacao());
                pstm.setString(5,  consulta.getTipo());
                
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
    public List<Consulta> listarTodos() {
         String query = "SELECT * FROM consulta";
        List<Consulta> consultaList = new ArrayList<>();
        try {
            
            Connection connection = DAO.conectar();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String data = rs.getString(1);
                String hora = rs.getString(2);
                String profissional = rs.getString(3);
                String especializacao = rs.getString(4);
                String tipo = rs.getString(5);

                
                Consulta consulta = new Consulta(data, hora, profissional, especializacao, tipo);
                
                consultaList.add(consulta);

            }
            connection.close();
            rs.close();
            
    }catch (ClassNotFoundException ex) {
            System.out.println(ex);
    } catch (SQLException ex) {
        System.out.println(ex);
    }
        return consultaList;
    }

    }

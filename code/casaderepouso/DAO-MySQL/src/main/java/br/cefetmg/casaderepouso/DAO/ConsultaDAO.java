/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.dto.Consulta;
import br.cefetmg.casaderepouso.idao.IConsultaDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdlardeidosos", "root", "admin");
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
}

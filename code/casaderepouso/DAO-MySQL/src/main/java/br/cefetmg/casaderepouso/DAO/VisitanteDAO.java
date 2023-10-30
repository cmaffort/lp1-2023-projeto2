/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.dto.Visitante;
import java.sql.SQLException;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.DAO.connection.DAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.time.LocalTime;


/**
 *
 * @author Aluno
 */


public class VisitanteDAO {
    
    public boolean atualizar(Visitante visitante) throws ClassNotFoundException, SQLException{
        return false;
    }

    public boolean deletar(Visitante visitante) {
        return false;
    }

    public boolean inserir(Visitante visitante) {

        String sql = "INSERT INTO visitante(nome, valor, tarja, validade, morador, dose, data, hora) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, visitante.getNome());
            pstm.setString(2, visitante.getRg());
            pstm.setString(3, visitante.getTelefone());
            pstm.setString(4, visitante.getMorador());
            pstm.setString(5, visitante.getVinculo());
            pstm.setDate(7, (Date) visitante.getDataVisita());
            pstm.setString(8, visitante.getHoraVisita());
            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fecha conexão
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }

                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    
    public ArrayList<Visitante> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public Visitante pesquisar(String nome) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
        public Visitante pesquisar(String nome, String cpf) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

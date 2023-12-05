/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

/**
 *
 * @author Aluno
 */

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Refeicao;
import br.cefetmg.casaderepouso.idao.IRefeicaoDAO;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;  
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class RefeicaoDAO implements IRefeicaoDAO {
    @Override
    public boolean deletar(Refeicao ref) throws SQLException, ClassNotFoundException {
         try {
            Connection con = DAO.conectar();

            String sql = "DELETE FROM refeicao WHERE cpf = ? AND hora = ? AND cardapio = ? AND tipo = ? AND dia = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, ref.getCpfMorador());
            pstmt.setString(2, ref.getHora());
            pstmt.setString(3, ref.getCardapio());
            pstmt.setString(4, ref.getTipo());
            pstmt.setString(5, ref.getDia());
            pstmt.executeUpdate();

            pstmt.close();
            con.close();
            return true;
        } 
         catch(SQLException e){
            throw new SQLException(e.getMessage(), e);       
        }
        catch(ClassNotFoundException e){
            throw new ClassNotFoundException(e.getMessage(), e);       
        }
    } 
    
    @Override
    public boolean inserir(Refeicao refeicao){
        String sql = "INSERT INTO refeicao (cpf, hora, cardapio, tipo, dia) VALUES(?, ?, ?, ?, ?)";
        try{
            Connection con = DAO.conectar();
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, refeicao.getCpfMorador());
            pstmt.setString(5, refeicao.getDia());
            pstmt.setString(2, refeicao.getHora());
            pstmt.setString(4, refeicao.getTipo());
            pstmt.setString(3, refeicao.getCardapio());
            pstmt.executeUpdate();
            con.close();
      
        }catch (SQLException e) {
            System.out.println(e);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MoradorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
  
    @Override
    public ArrayList<Refeicao> listarTodos()throws SQLException, ClassNotFoundException{

	String sql = "SELECT * FROM refeicao ORDER BY cpf";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Refeicao> listAll = new ArrayList<>();
            while (rs.next()) {

                String cpf  = rs.getString(1);
                String dia = rs.getString(5);
                String hora = rs.getString(2);
                String tipo = rs.getString(4);
                String cardapio = rs.getString(3);

                Refeicao ref = new Refeicao(cpf,hora,cardapio,tipo,dia);    

                listAll.add(ref);
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
    public ArrayList<Refeicao> pesquisar(String cpf) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM refeicao ORDER BY cpf";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Refeicao> listAll = new ArrayList<>();
            while (rs.next()) {
                if(rs.getString(1).equals(cpf)){
                    String cpfN = rs.getString(1);
                    String hora = rs.getString(2);
                    String cardapio = rs.getString(3);
                    String tipo = rs.getString(4);
                    String dia = rs.getString(5);

                    Refeicao ref = new Refeicao(cpfN,hora,cardapio,tipo,dia);
                    listAll.add(ref);
                }
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

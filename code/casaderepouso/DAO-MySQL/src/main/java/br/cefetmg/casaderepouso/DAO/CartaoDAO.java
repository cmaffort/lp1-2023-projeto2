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
import br.cefetmg.casaderepouso.dto.Cartao;
import br.cefetmg.casaderepouso.idao.ICartaoDAO;
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


public class CartaoDAO implements ICartaoDAO {
    @Override
    public boolean deletar(Cartao cartao) throws SQLException, ClassNotFoundException {
         try {
            Connection con = DAO.conectar();

            String sql = "DELETE FROM cartao_credito WHERE cpf = ? AND numero_cartao = ? AND nome_cartao = ? AND validade = ? AND cardtype = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cartao.getCpf());
            pstmt.setString(2, cartao.getNumero());
            pstmt.setString(3, cartao.getNome());
            pstmt.setString(4, cartao.getValidade());
            pstmt.setString(5, cartao.getCardtype());
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
    public boolean inserir(Cartao cartao){
        String sql = "INSERT INTO cartao_credito (cpf, numero_cartao,nome_cartao,validade, cardtype) VALUES(?, ?, ?, ?, ?)";
        try{
            Connection con = DAO.conectar();
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, cartao.getCpf());
            pstmt.setString(2, cartao.getNumero());
            pstmt.setString(3, cartao.getNome());
            pstmt.setString(4, cartao.getValidade());
            pstmt.setString(5, cartao.getCardtype());
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
    public ArrayList<Cartao> listarTodos()throws SQLException, ClassNotFoundException{

	String sql = "SELECT * FROM cartao_credito ORDER BY cpf";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Cartao> listAll = new ArrayList<>();
            while (rs.next()) {

                String cpf  = rs.getString(1);
                String numero = rs.getString(2);
                String nome = rs.getString(3);
                String validade = rs.getString(4);
                String cardtype = rs.getString(5);

                Cartao car = new Cartao(cpf,numero,nome,validade, cardtype);    

                listAll.add(car);
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

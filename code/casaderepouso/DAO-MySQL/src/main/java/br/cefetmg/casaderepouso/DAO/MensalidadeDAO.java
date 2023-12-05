/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Mensalidade;
import br.cefetmg.casaderepouso.idao.IMensalidadeDAO;
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


public class MensalidadeDAO implements IMensalidadeDAO {

    @Override
    public boolean atualizar(Mensalidade mensalidade) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE mensalidade SET cpfResponsavel = ?, inicio = ?, fim = ? WHERE cpfMorador = ?";
        try {
            
            Connection con = DAO.conectar(); 
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(4, mensalidade.getCpfMorador());
            pstmt.setString(1, mensalidade.getCpfResponsavel());
            pstmt.setString(2, mensalidade.getInicio());
            pstmt.setString(3, mensalidade.getFim());
            pstmt.executeUpdate();
            con.close();
            
        } catch(SQLException e){
            throw new SQLException(e.getMessage(), e);       
        }
        catch(ClassNotFoundException e){
            throw new ClassNotFoundException(e.getMessage(), e);       
        }
        return true;
    }
    
    @Override
    public boolean deletar(Mensalidade mor) throws SQLException, ClassNotFoundException {
         try {
            Connection con = DAO.conectar();

            String sql = "DELETE FROM mensalidade WHERE cpfMorador = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mor.getCpfMorador());
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
    public boolean inserir(Mensalidade mensalidade){
        String sql = "INSERT INTO mensalidade (cpfMorador,cpfResponsavel,Inicio,Fim) VALUES(?, ?, ?, ?)";
        try{

            Connection con = DAO.conectar();
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mensalidade.getCpfMorador());
            pstmt.setString(2, mensalidade.getCpfResponsavel());
            pstmt.setString(3, mensalidade.getInicio());
            pstmt.setString(4, mensalidade.getFim());
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
    public ArrayList<Mensalidade> listarTodos()throws SQLException, ClassNotFoundException{

	String sql = "SELECT * FROM mensalidade ORDER BY cpfMorador";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Mensalidade> listAll = new ArrayList<>();
            while (rs.next()) {

                String cpfMorador = rs.getString(1);
                String cpfResponsavel = rs.getString(2);
                String inicio = rs.getString(3);
                String fim = rs.getString(4);
                
                Mensalidade mor = new Mensalidade(cpfMorador,cpfResponsavel,inicio,fim);

                listAll.add(mor);
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
    public Mensalidade pesquisar(String cpf) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM mensalidade ORDER BY cpfMorador";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            Mensalidade pesquisado = null;
            while (rs.next()) {
                if(rs.getString(1).equals(cpf)){
                    String cpfMorador = rs.getString(1);
                    String cpfResponsavel = rs.getString(2);
                    String inicio = rs.getString(3);
                    String fim = rs.getString(4);
                    
                    pesquisado = new Mensalidade(cpfMorador,cpfResponsavel,inicio,fim);
                    rs.close();
                    pst.close();
                    con.close();
                    return pesquisado;
                }
       }
            rs.close();
            pst.close();
            con.close();
            return null;
        } 
        catch(SQLException e){
            throw new SQLException(e.getMessage(), e);       
        }
        catch(ClassNotFoundException e){
            throw new ClassNotFoundException(e.getMessage(), e);       
        }
    }
    
}

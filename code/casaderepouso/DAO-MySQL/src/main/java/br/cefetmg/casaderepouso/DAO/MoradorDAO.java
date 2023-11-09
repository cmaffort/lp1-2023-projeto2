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
import br.cefetmg.casaderepouso.dto.Morador;
import br.cefetmg.casaderepouso.idao.IMoradorDAO;
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


public class MoradorDAO implements IMoradorDAO {

    @Override
    public boolean atualizar(Morador morador) throws ClassNotFoundException, SQLException {
        String sql = "UPDATE morador SET nome = ?,datanascimento = ?, planomedico = ?, responsavel = ?, nome_mae = ?, endereco = ?, condicoes = ?, estado = ? WHERE cpf = ?";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdlardeidosos", "root", "admin");
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, morador.getNome());
            pstmt.setString(9, morador.getCpf());
            pstmt.setString(2, morador.getDataNasc());
            pstmt.setString(3, morador.getPlanoMedico());
            pstmt.setString(4, "teste");
            pstmt.setString(5, morador.getNomeMae());
            pstmt.setString(6, morador.getEndereco());
            pstmt.setString(7, morador.getCondicaoEspecial());
            pstmt.setString(8, morador.getEstado());
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
    public boolean deletar(Morador mor) throws SQLException, ClassNotFoundException {
         try {
            Connection con = DAO.conectar();

            String sql = "DELETE FROM morador WHERE cpf = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, mor.getCpf());
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
    public boolean inserir(Morador morador){
        String sql = "INSERT INTO morador (nome, cpf, datanascimento, planomedico, responsavel, nome_mae, endereco, condicoes, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdlardeidosos", "root", "admin");
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, morador.getNome());
            pstmt.setString(2, morador.getCpf());
            pstmt.setString(3, morador.getDataNasc());
            pstmt.setString(4, morador.getPlanoMedico());
            pstmt.setString(5, "teste");
            pstmt.setString(6, morador.getNomeMae());
            pstmt.setString(7, morador.getEndereco());
            pstmt.setString(8, morador.getCondicaoEspecial());
            pstmt.setString(9, morador.getEstado());
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
    public ArrayList<Morador> listarTodos()throws SQLException, ClassNotFoundException{

	String sql = "SELECT * FROM morador ORDER BY nome";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Morador> listAll = new ArrayList<>();
            while (rs.next()) {

                String nome = rs.getString(1);
                String cpf = rs.getString(2);
                String dataNasc = rs.getString(3);
                String planoMedico = rs.getString(4);
                String responsaveis = rs.getString(5);
                String nomeMae = rs.getString(6);
                String endereco = rs.getString(7);
                String condicao = rs.getString(8);
                String estado = rs.getString(9);

                Morador mor = new Morador(nome, cpf, dataNasc, planoMedico, responsaveis, nomeMae, endereco, condicao, estado);

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
    public Morador pesquisar(String cpf) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM morador ORDER BY nome";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            Morador pesquisado = null;
            while (rs.next()) {
                if(rs.getString(2).equals(cpf)){
                    String nome = rs.getString(1);
                    String cpfN = rs.getString(2);
                    String dataNasc = rs.getString(3);
                    String planoMedico = rs.getString(4);
                    String responsaveis = rs.getString(5);
                    String nomeMae = rs.getString(6);
                    String endereco = rs.getString(7);
                    String condicao = rs.getString(8);
                    String estado = rs.getString(9);
                    pesquisado = new Morador(nome, cpfN, dataNasc, planoMedico, responsaveis, nomeMae, endereco, condicao, estado);
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

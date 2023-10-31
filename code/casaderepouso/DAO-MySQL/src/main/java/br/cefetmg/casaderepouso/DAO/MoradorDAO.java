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


public class MoradorDAO implements IMoradorDAO {
    @Override
    public boolean atualizar(Morador morador) throws ClassNotFoundException, SQLException{ /* incompleta */
         String sqlMorador = "INSERT INTO morador VALUES('" + morador.getNome() + "', '" + morador.getNomeMae() + "', '" + morador.getCondicaoEspecial() + "', '" + morador.getCpf() + "', '"
                + morador.getDataNasc()+ "', '" + morador.getPlanoMedico() + "', '" + morador.getVetorResponsaveis()+ "', '" + morador.getEstado() + "')";
         Connection conexao = null;

        Statement comando = null;

        int resultado = 0;

        try {
            conexao = DAO.conectar();

            comando = conexao.createStatement();

            resultado = comando.executeUpdate(sqlMorador);

        } finally {
            DAO.fecharConexao(conexao, comando);
        }

        return resultado > 0;
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
    public void inserir(Morador morador) throws ClassNotFoundException ,SQLException {    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DAO.conectar();
            String sql = "INSERT INTO morador (nome, cpf,rg, nascimento, planoMedico, responsavel, nome_mae, endereco, condicoes, estado) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, morador.getNome());
            pstmt.setString(2, morador.getCpf());
            pstmt.setString(3, morador.getRg());
            pstmt.setDate(4, new java.sql.Date(morador.getDataNasc().getTime()));
            pstmt.setString(5, morador.getPlanoMedico());
            pstmt.setString(6, morador.getVetorResponsaveis());
            pstmt.setString(7, morador.getNomeMae());
            pstmt.setString(8, morador.getEndereco());
            pstmt.setString(9, morador.getCondicaoEspecial());
            pstmt.setString(10, morador.getEstado());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
      
        }
        catch(SQLException e){
            throw new SQLException(e.getMessage(), e);       
        }
        catch(ClassNotFoundException e){
            throw new ClassNotFoundException(e.getMessage(), e);       
        }
    }
  
    @Override
    public ArrayList<Morador> listarTodos()throws SQLException, ClassNotFoundException{

	String sql = "SELECT * FROM morador ORDER BY nome";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Morador> listAll = null;
            while (rs.next()) {

                String nome = rs.getString(1);
                String cpf = rs.getString(2);
                String rg = rs.getString(3);
                Date dataNasc = rs.getDate(4);
                String planoMedico = rs.getString(5);
                String responsaveis = rs.getString(6);
                String nomeMae = rs.getString(7);
                String endereco = rs.getString(8);
                String condicao = rs.getString(9);
                String estado = rs.getString(10);

                Morador mor = new Morador(nome, cpf,rg, dataNasc, planoMedico, responsaveis, nomeMae, endereco, condicao, estado);

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
    public Morador pesquisar(String nome) throws SQLException, ClassNotFoundException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Morador pesquisar(String nome, String cpf) throws SQLException, ClassNotFoundException{
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

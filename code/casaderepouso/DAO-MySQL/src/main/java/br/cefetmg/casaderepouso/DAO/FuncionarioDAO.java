/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

/**
 *
 * @author rafael-igor-vilaca
 */
import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Funcionario;
import br.cefetmg.casaderepouso.idao.IFuncionarioDAO;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FuncionarioDAO implements IFuncionarioDAO{
    
    @Override
    public void inserir(Funcionario func) throws SQLException, ClassNotFoundException{
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DAO.conectar();
            String sql = "INSERT INTO funcionario (id, nome, cpf, rg, telefone, nascimento, endereco, pis, funcao, periodoTrabalho) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, func.getId());
            pstmt.setString(2, func.getNome());
            pstmt.setString(3, func.getCpf());
            pstmt.setString(4, func.getRg());
            pstmt.setString(5, func.getFone());
            pstmt.setDate(6, new java.sql.Date(func.getDataNasc().getTime()));
            pstmt.setString(7, func.getEndereco());
            pstmt.setString(8, func.getPis());
            pstmt.setString(9, func.getFuncao());
            pstmt.setString(10, func.getPeriodoTrabalho());

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
    public boolean atualizar(Funcionario func) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean deletar(Funcionario func) throws SQLException, ClassNotFoundException {
         try {
            Connection con = DAO.conectar();

            String sql = "DELETE FROM funcionario WHERE id = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, func.getId());
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
    public ArrayList<Funcionario> listarTodos()throws SQLException, ClassNotFoundException{
        
	String sql = "SELECT * FROM funcionario ORDER BY nome";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Funcionario> listAll = null;
            while (rs.next()) {

                String id = rs.getString(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String rg = rs.getString(4);
                String fone = rs.getString(5);

                //Não sei se funciona o getDate()
                Date dataNasc = rs.getDate(6);


                String endereco = rs.getString(7);
                String pis = rs.getString(8);
                String funcao = rs.getString(9);
                String periodoTrabalho = rs.getString(10);

                Funcionario func = new Funcionario(nome, cpf, rg, dataNasc, endereco,
                     fone,  pis, funcao, periodoTrabalho, id);

                listAll.add(func);
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
    public Funcionario pesquisar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

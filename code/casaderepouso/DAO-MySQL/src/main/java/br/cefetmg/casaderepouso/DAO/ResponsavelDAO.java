package br.cefetmg.casaderepouso.DAO;


import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.idao.IResponsavel;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class ResponsavelDAO implements IResponsavel {
    
    @Override
    public void inserir(Responsavel responsavel) throws SQLException, ClassNotFoundException{
        
        try{
            Connection con = DAO.conectar();
            String sql = "INSERT INTO responsavel(id, nome, cpf, rg, telefone, datanascimento, endereco, morador_responsavel) VALUES(?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(2, responsavel.getNome());
            pstmt.setString(3, responsavel.getCpf());
            pstmt.setString(4, responsavel.getRg());
            pstmt.setString(5, responsavel.getTelefone());
            pstmt.setDate(6, new java.sql.Date(responsavel.getDataNascimento().getTime()));
            pstmt.setString(7, responsavel.getEndereco());
            pstmt.setString(10, responsavel.getResponsavelPor());

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
    public boolean atualizar(Responsavel responsavel) throws SQLException, ClassNotFoundException{
         String sqlResponsavel = "INSERT INTO produtos VALUES('" + responsavel.getNome() + "', '" + responsavel.getRg() + "', '"
                + responsavel.getTelefone() + "', '" + responsavel.getDataNascimento() + "', '" + responsavel.getEndereco() + "')";
         Connection conexao = null;
        
        Statement comando = null;
        
        int resultado = 0;
        
        try {
            conexao = DAO.conectar();
            
            comando = conexao.createStatement();

            resultado = comando.executeUpdate(sqlResponsavel);
        
        }
        finally {
            DAO.fecharConexao(conexao, comando);
        }

        return resultado > 0;
    }
 
    @Override
    public boolean deletar(Responsavel responsavel) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
    @Override
    public ArrayList<Responsavel> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Responsavel pesquisar(String nome, String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

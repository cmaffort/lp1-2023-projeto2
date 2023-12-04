package br.cefetmg.casaderepouso.DAO;


import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.idao.IResponsavel;
import br.cefetmg.casaderepouso.dto.exception.*;
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
            String sql = "INSERT INTO responsavel (nome, cpf, rg, telefone, endereco, morador_responsavel, senha) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, responsavel.getNome());
            pstmt.setString(2, responsavel.getCpf());
            pstmt.setString(3, responsavel.getRg());
            pstmt.setString(4, responsavel.getTelefone());
            pstmt.setString(5, responsavel.getEndereco());
            pstmt.setString(6, responsavel.getResponsavelPor());
            pstmt.setString(7,responsavel.getSenha());
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
      
        }
        catch (SQLException e) {
            System.out.println(e);
            throw new SQLException(e.getMessage(), e);
        }
        catch (ClassNotFoundException ex) {
            System.out.println(ex);
            throw new ClassNotFoundException(ex.getMessage(), ex);  
        }
    }

    @Override
    public boolean atualizar(Responsavel responsavel) throws SQLException, ClassNotFoundException{
         String sqlResponsavel = "INSERT INTO produtos VALUES('" + responsavel.getNome() + "', '" + responsavel.getRg() + "', '"
                + responsavel.getTelefone() + "', '" + responsavel.getEndereco() + "')";
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
    public boolean deletar(Responsavel responsavel) throws SQLException, ClassNotFoundException{
        try {
            Connection con = DAO.conectar();

            String sql = "DELETE FROM responsavel WHERE nome = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, responsavel.getNome());
            pstmt.executeUpdate();

            pstmt.close();
            con.close();
            return true;
        } 
         catch(SQLException e){
             System.out.println(e);
            throw new SQLException(e.getMessage(), e);       
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
            throw new ClassNotFoundException(e.getMessage(), e);       
        }
    }

    
    @Override
    public ArrayList<Responsavel> listar() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM responsavel ORDER BY nome";
        try {
            
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Responsavel> lista = new ArrayList<Responsavel>();
            while (rs.next()) {

                String nome = rs.getString(1);
                String cpf = rs.getString(2);
                String rg = rs.getString(3);
                String telefone = rs.getString(4);
                String endereco = rs.getString(5);
                String responsavelPor = rs.getString(6);

                Responsavel responsavel = new Responsavel();
                
                responsavel.setNome(nome);
                responsavel.setCpf(cpf);
                responsavel.setRg(rg);
                responsavel.setTelefone(telefone);
                responsavel.setEndereco(endereco);
                responsavel.setResponsavelPor(responsavelPor);
                
                lista.add(responsavel);
            }
            rs.close();
            pst.close();
            con.close();
            return lista;

        } 
        catch(SQLException e){
            throw new SQLException(e.getMessage(), e);       
        }
        catch(ClassNotFoundException e){
            throw new ClassNotFoundException(e.getMessage(), e);       
        }
    }

    @Override
    public Responsavel pesquisar(String cpf) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM responsavel WHERE cpf = ?";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            Responsavel pesquisado = null;
            while (rs.next()) {
                if(rs.getString(3).equals(cpf)){
                    String id = rs.getString(1);
                    String nome = rs.getString(2);
                    String cpfN = rs.getString(3);
                    String rg = rs.getString(4);
                    String telefone = rs.getString(5);
                    String endereco = rs.getString(6);
                    String morador = rs.getString(7);
                    String senha = rs.getString(8);
                    
                    pesquisado = new Responsavel(nome,cpfN,rg,telefone,endereco,morador,id,senha);
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
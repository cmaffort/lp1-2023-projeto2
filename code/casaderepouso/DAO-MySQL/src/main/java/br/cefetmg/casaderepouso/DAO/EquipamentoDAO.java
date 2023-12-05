package br.cefetmg.casaderepouso.DAO;


import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Equipamento;
import br.cefetmg.casaderepouso.idao.IEquipamento;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class EquipamentoDAO implements IEquipamento {
    
    @Override
    public void inserir(Equipamento equipamento) throws SQLException, ClassNotFoundException{
        
        try{
            Connection con = DAO.conectar();
            String sql = "INSERT INTO equipamento (tipo, preco, quantidade, estado) VALUES(?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, equipamento.getTipo());
            pstmt.setString(2, equipamento.getPreco());
            pstmt.setInt(3, equipamento.getQuantidade());
            pstmt.setString(4, equipamento.getEstado());

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
    public boolean atualizar(Equipamento equipamento) throws SQLException, ClassNotFoundException{
         String sqlEquipamento = "";
         Connection conexao = null;
        
        Statement comando = null;
        
        int resultado = 0;
        
        try {
            conexao = DAO.conectar();
            
            comando = conexao.createStatement();

            resultado = comando.executeUpdate(sqlEquipamento);
        
        }
        finally {
            DAO.fecharConexao(conexao, comando);
        }

        return resultado > 0;
    }
 
    @Override
    public boolean deletar(Equipamento equipamento) throws SQLException, ClassNotFoundException{
        try {
            Connection con = DAO.conectar();

            String sql = "DELETE FROM equipamento WHERE nome = ?";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, equipamento.getTipo());
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
    public ArrayList<Equipamento> listar() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM equipamento ORDER BY tipo";
        try {
            
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Equipamento> lista = new ArrayList<Equipamento>();
            while (rs.next()) {

                String tipo = rs.getString(1);
                String preco = rs.getString(2);
                int quantidade = rs.getInt(3);
                String estado = rs.getString(4);

                Equipamento equipamento = new Equipamento();
                
                equipamento.setTipo(tipo);
                equipamento.setPreco(preco);
                equipamento.setQuantidade(quantidade);
                equipamento.setEstado(estado);
                
                lista.add(equipamento);
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
    public Equipamento pesquisar(String nome) throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM equipamento WHERE nome = ?";
        Equipamento equipamento = new Equipamento();
                
        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
                
            pstm.setString(1, nome);
            
            rset = pstm.executeQuery();
          
                     
                
        }
        catch(Exception e){
        e.printStackTrace();
        }finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
            return equipamento;
    }
}
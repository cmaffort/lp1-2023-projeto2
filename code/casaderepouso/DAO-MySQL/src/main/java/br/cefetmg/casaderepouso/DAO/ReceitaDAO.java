package br.cefetmg.casaderepouso.DAO;


import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Receita;
import br.cefetmg.casaderepouso.idao.IReceita;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Statement;

public class ReceitaDAO implements IReceita {
    
    @Override
    public void inserir(Receita receita) throws SQLException, ClassNotFoundException{
        
        try{
            Connection con = DAO.conectar();
            String sql = "INSERT INTO receita_medica (profissional_de_saude, morador, medicamentos, data, hora, quantidade, validade) "
                    + "VALUES(?,?,?,?,?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, receita.getProfissionalSaude());
            pstmt.setString(2, receita.getMorador());
            pstmt.setString(3, receita.getMedicamentos());
            pstmt.setString(4, receita.getData());
            pstmt.setString(5, receita.getHora());
            pstmt.setString(6, receita.getQuantidade());
            pstmt.setString(7, receita.getValidade());

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
    public boolean deletar(Receita receita) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM receita WHERE nome = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, receita.getMorador());
            pstm.execute();
            

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try{
                if(pstm != null)
                    pstm.close();
                if(conn != null)
                    conn.close();
            }catch(Exception e){
            e.printStackTrace();
            }
            return true;
        }
    }

    
    @Override
    public ArrayList<Receita> listar() throws SQLException, ClassNotFoundException{
        String sql = "SELECT * FROM receita_medica ORDER BY id";
        try {
            
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Receita> lista = new ArrayList<Receita>();
            while (rs.next()) {
                
                String id = rs.getString(1);
                String profissionalSaude = rs.getString(2);
                String morador = rs.getString(3);
                String medicamentos = rs.getString(4);
                String data = rs.getString(5);
                String hora = rs.getString(6);
                String quantidade = rs.getString(7);
                String validade = rs.getString(8);

                Receita receita = new Receita();
                
                receita.setId(id);
                receita.setProfissionalSaude(profissionalSaude);
                receita.setMorador(morador);
                receita.setMedicamentos(medicamentos);
                receita.setData(data);
                receita.setHora(hora);
                receita.setQuantidade(quantidade);
                receita.setValidade(validade);
                
                lista.add(receita);
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
}
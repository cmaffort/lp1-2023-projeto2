/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

/**
 *
 * @author Master
 */
import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Atualizacao;
import br.cefetmg.casaderepouso.idao.IAtualizacaoDAO;
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
public class AtualizacaoDAO implements IAtualizacaoDAO{
    

    public boolean inserir(Atualizacao atualizacao){
        String sql = "INSERT INTO atualizacao (cpf, dados, momento) VALUES(?, ?, ?)";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bdlardeidosos", "root", "admin");
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, atualizacao.getCpf());
            pstmt.setString(2, atualizacao.getDados());
            pstmt.setString(3, atualizacao.getMomento());
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
  
    public ArrayList<Atualizacao> listarTodos()throws SQLException, ClassNotFoundException{

	String sql = "SELECT * FROM atualizacao ORDER BY cpf";
        try {
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<Atualizacao> listAll = new ArrayList<>();
            while (rs.next()) {

                String cpf  = rs.getString(1);
                String dados = rs.getString(2);
                String momento = rs.getString(3);

                Atualizacao atu = new Atualizacao(cpf,dados, momento);    

                listAll.add(atu);
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

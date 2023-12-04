
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.SaidaTemporaria;
import br.cefetmg.casaderepouso.idao.ISaidaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rigor
 */
public class SaidaDAO implements ISaidaDAO {
    @Override
    public void inserir(SaidaTemporaria saida) throws SQLException, ClassNotFoundException{
        
        try{
            
            Connection con = DAO.conectar();
            String sql = "INSERT INTO saida (id, nome, cpf, motivo, diaSaida, horarioSaida, diaVolta, horarioVolta) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            
             
            
            PreparedStatement pstmt = con.prepareStatement(sql);
            
            pstmt.setString(1, saida.getId());
            pstmt.setString(2, saida.getNome());
            pstmt.setString(3, saida.getMoradorCpf());
            pstmt.setString(4, saida.getMotivo());
            pstmt.setString(5, saida.getDataSaida());
            pstmt.setString(6, saida.getHorarioSaida());
            pstmt.setString(7, saida.getDataVolta());
            
            pstmt.setString(8, saida.getHorarioVolta());
            
            
            pstmt.executeUpdate();
            pstmt.close();
            con.close();
      
        }
        catch(SQLException e){
            System.out.println("Essa é a exceção: "+e);
            throw new SQLException(e.getMessage(), e);       
        }
        catch(ClassNotFoundException e){
            System.out.println(e);
            throw new ClassNotFoundException(e.getMessage(), e);       
        }
    }
    
    @Override
    public boolean atualizar(SaidaTemporaria saida) throws SQLException, ClassNotFoundException {
       try {
             Connection con = DAO.conectar();

            String sql = "UPDATE saida "
                    + "   SET diaSaida = ?, "
                    + "       horarioSaida = ?, "
                    + "       motivo = ?, "
                    + "       diaVolta = ?, "
                    + "       horarioVolta = ? "
                    + " WHERE id = ?;";

            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, saida.getDataSaida());
            pstmt.setString(2, saida.getHorarioSaida());
            pstmt.setString(3, saida.getMotivo());
            pstmt.setString(4, saida.getDataVolta());
            pstmt.setString(5, saida.getHorarioVolta());
            pstmt.setString(6, saida.getId());
            
            
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
    public boolean deletar(SaidaTemporaria saida) throws SQLException, ClassNotFoundException {
        //Fazer depois 
        return true;
    }

    @Override
    public ArrayList<SaidaTemporaria> listarTodos()throws SQLException, ClassNotFoundException{
        
	String sql = "SELECT * FROM saida order by nome";
        try {
            
            Connection con = DAO.conectar();
            PreparedStatement pst = con.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            ArrayList<SaidaTemporaria> listAll = new ArrayList<SaidaTemporaria>();
            while (rs.next()) {

                //Recebendo os dados de cada saida armazenada na tabela
                String id = rs.getString(1);
                String nome = rs.getString(2);
                String cpf = rs.getString(3);
                String motivo = rs.getString(4);
                String diaS = rs.getString(5);
                String horaS = rs.getString(6);
                String diaV = rs.getString(7);
                String horaV = rs.getString(8);

                //Criando o objeto
                SaidaTemporaria saida = new SaidaTemporaria();
                
                //Setando cada atributo do objeto
                saida.setId(id);
                saida.setNome(nome);
                saida.setMoradorCpf(cpf);
                saida.setMotivo(motivo);
                saida.setDataSaida(diaS);
                saida.setHorarioSaida(horaS);
                saida.setDataVolta(diaV);
                saida.setHorarioVolta(horaV);
                
                //Adicionando o objeto na lista
                listAll.add(saida);
            }
            rs.close();
            pst.close();
            con.close();
            return listAll;

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
    public SaidaTemporaria pesquisar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

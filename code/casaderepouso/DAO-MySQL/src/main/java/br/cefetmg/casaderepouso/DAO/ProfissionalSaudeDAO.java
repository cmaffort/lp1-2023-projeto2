/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.ProfissionalSaude;
import br.cefetmg.casaderepouso.idao.IProfissionalSaudeDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author felli
 */
public class ProfissionalSaudeDAO implements IProfissionalSaudeDAO {

    @Override
    public boolean inserir(ProfissionalSaude profiSaude) {
        String sql = "INSERT INTO profissional_de_saude(nome, cpf, registro_medico, especializacao) VALUES(?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            System.out.println("crio conexao");
            
            pstm.setString(1, profiSaude.getNome());
            pstm.setString(2, profiSaude.getCpf());
            pstm.setString(3, profiSaude.getRegistro());
            pstm.setString(4, profiSaude.getEspecializacao().name());
            System.out.println("settou sql");

            pstm.execute();
            System.out.println("executou");

        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println("lassNotFoundException | SQLException");
            System.out.println(e);
            
            return false;
        } finally {
            try {
                if (pstm != null && conn != null) {
                    pstm.close();
                    conn.close();
                    System.out.println("fechando conexao");
                    System.out.println("olha o bd pq deu certo !");
                    return true;
                } else {
                    System.out.println("pstm == null && conn == null");
                }

            } catch (SQLException e) {
                return false;
            }

        }
        return false;

    }

    @Override
    public Boolean deletar(String cpf) {
        String sql = "DELETE FROM profissional_de_saude WHERE cpf = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, cpf);
            pstm.execute();

        } catch (Exception e) {
            return false;
        } finally {
            try {
                if (pstm != null && conn != null) {
                    pstm.close();
                    conn.close();
                }
                return true;

            } catch (Exception e) {
                return false;
            }
        }
    }

    @Override
    public ProfissionalSaude pesquisar(String cpf) {
        System.out.println("cpf:" + cpf);
        String sql = "SELECT * FROM profissional_de_saude WHERE cpf = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;
        ProfissionalSaude proSaude = new ProfissionalSaude();

        try {
            System.out.println("entrou Try");
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            
            
            
            pstm.setString(1, cpf);
            
            rset = pstm.executeQuery();
            
            if(rset != null && rset.next()){
                
            proSaude.setNome(rset.getString("nome"));
            proSaude.setCpf(rset.getString("cpf"));
            proSaude.setRegistro(rset.getString("registro_medico"));
            
            proSaude.setID(rset.getInt("id"));

            switch (rset.getString("especializacao")) {
                case "MEDICO":
                    proSaude.setEspecializacao(ProfissionalSaude.Especializacao.MEDICO);
                case "NUTRICIONISTA":
                    proSaude.setEspecializacao(ProfissionalSaude.Especializacao.NUTRICIONISTA);

                }
            }else {
                System.out.println("é null");
                return null;
                
            }
            return proSaude;

        } catch (Exception e) {
            System.out.println(e);

        }
        return proSaude;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.ProfissionalSaude;
import br.cefetmg.casaderepouso.dto.Prontuario;
import br.cefetmg.casaderepouso.idao.IProfissionalSaudeDAO;
import br.cefetmg.casaderepouso.idao.IProntuarioDAO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felli
 */
public class ProntuarioDAO implements IProntuarioDAO {

    @Override
    public boolean inserir(Prontuario prontuario) {
        String sql = "INSERT INTO prontuario(medico_responsavel, morador, observacoes, pressao, frequencia_cardiaca, frequencia_respiratoria, temperatura, refeicoes, observacao_refeicao, data) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {

            conn = DAO.conectar();

            pstm = conn.prepareStatement(sql);

            IProfissionalSaudeDAO DAOsaude = new ProfissionalSaudeDAO();

            ProfissionalSaude proSaude = DAOsaude.pesquisar(prontuario.getProfSaudeCPF());

            pstm.setString(2, prontuario.getMoradorCPF());

            pstm.setString(3, prontuario.getObservacoes());

            pstm.setString(4, prontuario.getPressao());

            pstm.setString(5, prontuario.getFrequenciaCardiaca());

            pstm.setString(6, prontuario.getFrequenciaRespiratoria());

            pstm.setString(7, prontuario.getTemperatura());
            System.out.println(prontuario.getRefeicoes());
            pstm.setString(8, prontuario.getRefeicoes());

            pstm.setString(9, prontuario.getObservacaoRefeicao());

            pstm.setDate(10, new Date(prontuario.getData().getTime()));

            pstm.setInt(1, proSaude.getID());
            System.out.println(proSaude.getID());

            pstm.execute();

        } catch (Exception e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                if (pstm != null && conn != null) {
                    pstm.close();
                    conn.close();
                    System.out.println("fechando conexao");

                } else {
                    System.out.println("pstm == null && conn == null");
                }
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }

        }
        return false;
    }

    @Override
    public List<Prontuario> listarProntuarioMed(String ProfSaudeCPF) {
        String sql = "SELECT * FROM prontuario WHERE medico_responsavel = ?";
        List<Prontuario> listaPront = null;

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);

            IProfissionalSaudeDAO DAOsaude = new ProfissionalSaudeDAO();

            ProfissionalSaude proSaude = DAOsaude.pesquisar(ProfSaudeCPF);

            pstm.setInt(1, proSaude.getID());
            rset = pstm.executeQuery();
            while (rset.next()) {
                Prontuario pront = new Prontuario();
                pront.setProfSaudeCPF(rset.getString("medico_responsavel"));
                pront.setMoradorCPF(rset.getString("morador"));
                pront.setPressao(rset.getString("pressao"));
                pront.setFrequenciaCardiaca(rset.getString("frequencia_cardiaca"));
                pront.setFrequenciaRespiratoria(rset.getString("frequencia_respiratoria"));
                pront.setRefeicoes(rset.getString("refeicoes"));
                pront.setTemperatura(rset.getString("temperatura"));
                pront.setObservacaoRefeicao(rset.getString("observacao_refeicao"));
                pront.setObservacoes(rset.getString("observacoes"));
                pront.setData(rset.getDate("data"));

                listaPront.add(pront);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        } finally {
            try {
                if (rset != null && pstm != null && conn != null) {
                    rset.close();
                    pstm.close();
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return null;
    }

    @Override
    public List<Prontuario> listarProntuarioMor(String moradorCPF) {
        String sql = "SELECT * FROM prontuario WHERE morador = ?";
        List<Prontuario> listaPront = new ArrayList<>();
        System.out.println(moradorCPF);
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, moradorCPF);
            rset = pstm.executeQuery();

            while (rset.next()) {

                Prontuario pront = new Prontuario();
                pront.setProfSaudeCPF(rset.getString("medico_responsavel"));
                pront.setMoradorCPF(rset.getString("morador"));
                pront.setPressao(rset.getString("pressao"));
                pront.setFrequenciaCardiaca(rset.getString("frequencia_cardiaca"));
                pront.setFrequenciaRespiratoria(rset.getString("frequencia_respiratoria"));
                pront.setRefeicoes(rset.getString("refeicoes"));
                pront.setTemperatura(rset.getString("temperatura"));
                pront.setObservacaoRefeicao(rset.getString("observacao_refeicao"));
                pront.setObservacoes(rset.getString("observacoes"));
                pront.setData(rset.getDate("data"));
                pront.setId(rset.getInt("id"));

                listaPront.add(pront);
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            try {
                if (rset != null && pstm != null && conn != null) {

                    rset.close();
                    pstm.close();
                    conn.close();

                    return listaPront;
                }
            } catch (SQLException e) {
                System.out.println(e);
                return null;
            }
        }
        return null;
    }

    @Override
    public void AtualizarProntuario(Prontuario prontuario) {
        String sql = "UPDATE prontuario SET morador = ? AND observacoes = ? AND pressao = ? AND frequencia_cardiaca = ? AND frequencia_respiratoria  = ? AND temperatura = ? AND refeicoes = ? AND observacao_refeicao = ?  WHERE id=?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            Prontuario pront = pesquisar(prontuario);

            pstm.setString(1, pront.getMoradorCPF());
            pstm.setString(2, pront.getObservacoes());
            pstm.setString(3, pront.getPressao());
            pstm.setString(4, pront.getFrequenciaCardiaca());
            pstm.setString(5, pront.getFrequenciaRespiratoria());
            pstm.setString(6, pront.getTemperatura());
            pstm.setString(7, pront.getRefeicoes());
            pstm.setString(8, pront.getObservacaoRefeicao());
            pstm.setInt(9, pront.getId());

            pstm.executeQuery();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Boolean deletar(Prontuario prontuario) {

        return null;

    }

    public Prontuario pesquisar(Prontuario prontuario) {
        String sql = "SELECT * FROM prontuario WHERE morador = ? AND observacoes = ? AND pressao = ? AND frequencia_cardiaca = ? AND frequencia_respiratoria  = ? AND temperatura = ? AND refeicoes = ? AND observacao_refeicao = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        Prontuario pront = prontuario;
        
        try {

            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            
            pstm.setString(1, prontuario.getMoradorCPF());
            pstm.setString(2, prontuario.getObservacoes());
            pstm.setString(3, prontuario.getPressao());
            pstm.setString(4, prontuario.getFrequenciaCardiaca());
            pstm.setString(5, prontuario.getFrequenciaRespiratoria());
            pstm.setString(6, prontuario.getTemperatura());
            pstm.setString(7, prontuario.getRefeicoes());
            pstm.setString(8, prontuario.getObservacaoRefeicao());

            rset = pstm.executeQuery();

            if (rset.next()) {

                pront.setProfSaudeCPF(rset.getString("medico_responsavel"));
                pront.setMoradorCPF(rset.getString("morador"));
                pront.setPressao(rset.getString("pressao"));
                pront.setFrequenciaCardiaca(rset.getString("frequencia_cardiaca"));
                pront.setFrequenciaRespiratoria(rset.getString("frequencia_respiratoria"));
                pront.setRefeicoes(rset.getString("refeicoes"));
                pront.setTemperatura(rset.getString("temperatura"));
                pront.setObservacaoRefeicao(rset.getString("observacao_refeicao"));
                pront.setObservacoes(rset.getString("observacoes"));
                pront.setData(rset.getDate("data"));
                pront.setId(rset.getInt("id"));
          
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rset != null && pstm != null && conn != null) {
                    rset.close();
                    pstm.close();
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
        }
        return pront;

        }
    }



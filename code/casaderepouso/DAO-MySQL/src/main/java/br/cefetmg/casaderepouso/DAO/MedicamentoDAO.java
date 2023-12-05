/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Medicamento;
import br.cefetmg.casaderepouso.dto.Medicamento.Condicao;
import br.cefetmg.casaderepouso.dto.Medicamento.Tarja;
import br.cefetmg.casaderepouso.idao.IMedicamentoDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.time.LocalDateTime;

/**
 *
 * @author felli
 */
public class MedicamentoDAO implements IMedicamentoDAO {

    @Override
    public Boolean inserir(Medicamento medicamento) {
        System.out.println("entrou em Inserir");
        String sql = "INSERT INTO medicamento(nome, valor, validade, morador, dose, condicao, intervalo, tarja) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, medicamento.getNome()); //nome
          
            pstm.setDouble(2, medicamento.getValor()); //valor
            
            pstm.setDate(3, new Date(medicamento.getValidade().getTime())); //validade
            
            pstm.setString(4, medicamento.getMoradorCPF()); //morador
            
            pstm.setString(5, medicamento.getDose()); //dose
            
            pstm.setTime(7, medicamento.getIntervalo()); //intervalo
            
            pstm.setString(6, "SOLICITADO"); //condicao
            
            pstm.setString(8, medicamento.getTarja().name());//tarja
            
            
            pstm.execute();
            
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        } finally {
            //fecha conexão
            try {
                if (pstm != null && conn != null) {
                    pstm.close();
                    conn.close();
                    return true;
                } 

            } catch (SQLException e) {
                 return false;
            }
        }
        return false;
    }

    @Override
    public void atualizarCondicao(Medicamento med) {

        String sql = "UPDATE medicamento SET condicao = ? WHERE id=?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            String novaCondicao = null;

            //serão atualizados SOLICITADO, COMPRADO, ESGOTADO
            switch (med.getCondicao().name()) {
                case "SOLICITADO":
                    novaCondicao = Condicao.COMPRADO.name();
                    System.out.println("solicitado -> comprado ");
                    break;
                case "COMPRADO":
                    novaCondicao = Condicao.ESGOTADO.name();
                    System.out.println("comprado -> esgotado");
                    break;
            }
            pstm.setString(1, novaCondicao);
            System.out.println("nova -> " + novaCondicao);
            pstm.setLong(2, med.getId());
            System.out.println("id -> " + med.getId());

            //atualizar
            pstm.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("ouve um erro de SQLException ao acessar o BD");
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.print("erro ao fechar conexão");
            }
        }
    }

    @Override
    public Boolean deletar(int Id) {

        String sql = "DELETE FROM medicamento WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, Id);
            pstm.execute();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("erro ao acessar o bd e/ou tentar deletar");
            return false;
        } finally {
            try {
                if (pstm != null && conn != null) {
                    pstm.close();
                    conn.close();
                    return true;
                }
            } catch (SQLException e) {
                System.out.println("erro ao fechar conexão");
                return false;
            }

        }
        return false;
    }

    @Override
    public List<Medicamento> listarTodos() {

        String sql = "SELECT * FROM medicamento";
        List<Medicamento> medicamentos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Medicamento med = new Medicamento();

                med.setNome(rset.getString("nome"));
                med.setValor(rset.getDouble("valor"));
                med.setValidade(rset.getDate("validade"));
                med.setMoradorCPF(rset.getString("morador"));
                med.setDose(rset.getString("dose"));
                med.setUltimaAplicacao((LocalDateTime) rset.getObject("ultimaAplicacao"));
                med.setIntervalo(rset.getTime("intervalo"));

                switch (rset.getString("tarja")) {
                    case "VERMELHA":
                        med.setTarja(Tarja.VERMELHA);
                        break;
                    case "SEM_TARJA":
                        med.setTarja(Tarja.SEM_TARJA);
                        break;
                    case "AMARELA":
                        med.setTarja(Tarja.AMARELA);
                        break;
                    case "PRETA":
                        med.setTarja(Tarja.PRETA);
                        break;
                }

                medicamentos.add(med);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("erro ao acessar o bd e/ou tentar listar medicamentos");
        } finally {
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
            } catch (SQLException e) {
                System.out.println("erro ao tentar fechar conexao");
            }
        }

        return medicamentos;
    }

    @Override
    public Medicamento pesquisar(int id) {
        String sql = "SELECT * FROM medicamento WHERE id = ?";
        Medicamento medicamento = new Medicamento();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();
            try {
                if (rset.next()) {
                    medicamento.setNome(rset.getString("nome"));

                    medicamento.setValor(rset.getDouble("valor"));

                    medicamento.setValidade(rset.getDate("validade"));

                    medicamento.setMoradorCPF(rset.getString("morador"));

                    medicamento.setDose(rset.getString("dose"));

                    medicamento.setUltimaAplicacao((LocalDateTime) rset.getObject("ultimaAplicacao"));

                    medicamento.setIntervalo(rset.getTime("intervalo"));

                    medicamento.setId(rset.getLong("id"));

                    switch (rset.getString("tarja")) {
                        case "VERMELHA":
                            medicamento.setTarja(Tarja.VERMELHA);
                            break;
                        case "SEM_TARJA":
                            medicamento.setTarja(Tarja.SEM_TARJA);
                            break;
                        case "AMARELA":
                            medicamento.setTarja(Tarja.AMARELA);
                            break;
                        case "PRETA":
                            medicamento.setTarja(Tarja.PRETA);
                            break;
                    }
                    switch (rset.getString("condicao")) {

                        case "SOLICITADO":
                            medicamento.setCondicao(Condicao.SOLICITADO);
                            break;
                        case "COMPRADO":
                            medicamento.setCondicao(Condicao.COMPRADO);
                            break;
                        case "ESGOTADO":
                            medicamento.setCondicao(Condicao.ESGOTADO);
                            break;
                    }
                } else {

                }
            } catch (SQLException e) {
                System.out.println(e);
                return null;
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
        return medicamento;
    }

    @Override
    public List<Medicamento> listarMedicamento(String moradorCPF, String condicao) {
        String sql = "SELECT * FROM medicamento WHERE morador = ? AND condicao = ?";
        List<Medicamento> medicamentos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, moradorCPF);
            pstm.setString(2, condicao);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Medicamento med = new Medicamento();

                med.setNome(rset.getString("nome"));
                med.setValor(rset.getDouble("valor"));
                med.setValidade(rset.getDate("validade"));
                med.setMoradorCPF(rset.getString("morador"));
                med.setDose(rset.getString("dose"));
                med.setIntervalo(rset.getTime("intervalo"));
                med.setId(rset.getInt("id"));
                java.sql.Timestamp timestamp = rset.getTimestamp("ultimaAplicacao");
                if(timestamp != null){
                med.setUltimaAplicacao(timestamp.toLocalDateTime());
                }

                switch (rset.getString("tarja")) {
                    case "VERMELHA":
                        med.setTarja(Tarja.VERMELHA);
                        break;
                    case "SEM_TARJA":
                        med.setTarja(Tarja.SEM_TARJA);
                        break;
                    case "AMARELA":
                        med.setTarja(Tarja.AMARELA);
                        break;
                    case "PRETA":
                        med.setTarja(Tarja.PRETA);
                        break;
                }

                medicamentos.add(med);
                System.out.println("adicionou o " + med.getNome() + "");
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("erro ao acessar o bd e/ou tentar buscar");
        } finally {
            try {
                if (rset != null && pstm != null && conn != null) {
                    rset.close();
                    pstm.close();
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("erro ao fechar conexao");
            }
        }

        return medicamentos;
    }

    @Override
    public void atualizarHorario(Medicamento medicamento, LocalDateTime horario) {

        String sql = "UPDATE medicamento SET ultimaAplicacao = ? WHERE id=?";

        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setObject(1, horario);
            pstm.setLong(2, medicamento.getId());

            pstm.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.print("ouve um erro de SQLException ao acessar o BD");
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.print("erro ao fechar conexão");
            }
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Medicamento;
import br.cefetmg.casaderepouso.dto.Medicamento.Tarja;
import br.cefetmg.casaderepouso.idao.IMedicamentoDAO;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author felli
 */
public class MedicamentoDAO implements IMedicamentoDAO {

    @Override
    public Boolean inserir(Medicamento medicamento) {

        String sql = "INSERT INTO medicamento(nome, valor, tarja, validade, morador, dose, data, hora) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, medicamento.getNome());
            pstm.setDouble(2, medicamento.getValor());
            pstm.setString(3, medicamento.getTarja().name());
            pstm.setDate(4, new Date(medicamento.getValidade().getTime()));
            pstm.setString(5, medicamento.getMoradorCPF());
            pstm.setString(6, medicamento.getDose());
            pstm.setDate(7, new Date(medicamento.getUltimaAplicacao().getTime()));
            pstm.setInt(8, medicamento.getIntervalo());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //fecha conexão
            try {
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }

                return true;

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public void atualizar(Medicamento med, String morador) {
        
        String sql="UPDATE medicamento SET dose = ?, ultimaAplicacao = ?, intervalo = ?" + "WHERE morador = ? AND nome = ?";
        
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try{
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, med.getDose());
            pstm.setDate(2, (Date) med.getUltimaAplicacao());
            pstm.setInt(3, med.getIntervalo());
            pstm.setString(4, med.getMoradorCPF());
            pstm.setString(5, med.getNome());
            
            pstm.execute();
            
            
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm != null)
                    pstm.close();
                if(conn != null)
                    conn.close();
            }catch(Exception e){
            e.printStackTrace();
            }
        } 
    }
    
    @Override
    public Boolean deletar(Medicamento med) {

        String sql = "DELETE FROM medicamento WHERE cpf = ? AND nome = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, med.getNome());
            pstm.setString(2, med.getMoradorCPF());

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
    public List<Medicamento> listarTodos() {

        String sql = "SELECT * FROM medicamento";
        List<Medicamento> medicamentos = new ArrayList<Medicamento>();

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
                med.setUltimaAplicacao(rset.getDate("ultimaAplicacao"));
                med.setIntervalo(rset.getInt("intervalo"));

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
        } catch (Exception e) {
            e.printStackTrace();

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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return medicamentos;
    }

    @Override
    public Medicamento pesquisar(String morador, String med) {
            String sql = "SELECT * FROM medicamento WHERE morador = ? AND nome= ?";
            Medicamento medicamento = new Medicamento();
            
            
            Connection conn = null;
            PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
                
            pstm.setString(1, morador);
            pstm.setString(2, med);
            
            rset = pstm.executeQuery();
            
            

                medicamento.setNome(rset.getString("nome"));
                medicamento.setValor(rset.getDouble("valor"));
                medicamento.setValidade(rset.getDate("validade"));
                medicamento.setMoradorCPF(rset.getString("morador"));
                medicamento.setDose(rset.getString("dose"));
                medicamento.setUltimaAplicacao(rset.getDate("ultimaAplicacao"));
                medicamento.setIntervalo(rset.getInt("intervalo"));

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
                
        }catch(Exception e){
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
            return medicamento;
    }

    @Override
    public List<Medicamento> MedicamentoMorador(String moradorCPF) {
        String sql = "SELECT * FROM medicamento WHERE morador = ?";
        List<Medicamento> medicamentos;
        medicamentos = new ArrayList<>();
 
        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, moradorCPF);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Medicamento med = new Medicamento();

                med.setNome(rset.getString("nome"));
                med.setValor(rset.getDouble("valor"));
                med.setValidade(rset.getDate("validade"));
                med.setMoradorCPF(rset.getString("morador"));
                med.setDose(rset.getString("dose"));
                med.setUltimaAplicacao(rset.getDate("ultimaAplicacao"));
                med.setIntervalo(rset.getInt("intervalo"));

                switch (rset.getString("tarja")) {
                    case "VERMELHA": med.setTarja(Tarja.VERMELHA); break;
                    case "SEM_TARJA": med.setTarja(Tarja.SEM_TARJA); break;
                    case "AMARELA": med.setTarja(Tarja.AMARELA); break;
                    case "PRETA": med.setTarja(Tarja.PRETA); break;
                }

                medicamentos.add(med);
            }
        } catch (Exception e) {
            e.printStackTrace();

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
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return medicamentos;
    }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Comodo;
import br.cefetmg.casaderepouso.idao.IComodoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felli
 */
public class ComodoDAO implements IComodoDAO {

    @Override
    public boolean inserir(Comodo comodo) {
        System.out.println("entrou em Inserir");
        String sql = "INSERT INTO comodo(nome, condicao, capacidade, descricao, revisao) VALUES(?, ?, ?, ?, ?)";
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, comodo.getNome()); 
            pstm.setString(2, comodo.getCondicao().name());
            pstm.setInt(3, comodo.getCapacidade());
            pstm.setString(4, comodo.getDescricao());
            
            pstm.setString(5, comodo.getRevisao());
            

            pstm.execute();
            System.out.println("executou");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
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
    public boolean atualizar(Comodo comodo) {
       
        String sql = "UPDATE comodo SET nome = ?, condicao = ?, capacidade = ?, descricao = ?, revisao = ? WHERE id=?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
           
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, comodo.getNome());
        
            pstm.setString(2, comodo.getCondicao().name());
           
            pstm.setInt(3, comodo.getCapacidade());
        
            pstm.setString(4, comodo.getDescricao());

            pstm.setString(5, comodo.getRevisao());
            
            pstm.setInt(6, comodo.getId());
            
            pstm.execute();
           

        } catch (Exception e) {
            e.printStackTrace();
            return false;
            
        } finally {
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
    public boolean deletar(int id) {

        String sql = "DELETE FROM comodo WHERE id = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);
            pstm.execute();
        } catch (ClassNotFoundException | SQLException e) {
            return false;
        } finally {
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
    public List<Comodo> listarTodos(String condicao) {
        String sql = "SELECT * FROM comodo WHERE condicao = ?";
        List<Comodo> comodos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, condicao);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Comodo comodo = new Comodo();

                comodo.setNome(rset.getString("nome"));
                comodo.setCapacidade(rset.getInt("capacidade"));
                comodo.setDescricao(rset.getString("descricao"));
                comodo.setRevisao(rset.getString("revisao"));

                switch (rset.getString("condicao")) {
                    case "OCUPADO":
                        comodo.setCondicao(Comodo.Condicao.OCUPADO);
                        break;
                    case "MANUTENCAO":
                        comodo.setCondicao(Comodo.Condicao.MANUTENCAO);
                        break;
                    case "LIVRE":
                        comodo.setCondicao(Comodo.Condicao.LIVRE);
                        break;
                    case "OUTRO":
                        comodo.setCondicao(Comodo.Condicao.OUTRO);
                        break;
                }
                comodo.setId(rset.getInt("id"));
                comodos.add(comodo);
            }

        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally {
            try {
                if (rset != null && pstm != null && conn != null) {
                    rset.close();
                    pstm.close();
                    conn.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
        return comodos;

    }

    @Override
    public List<Comodo> pesquisar(String nome) {
        String sql = "SELECT * FROM comodo WHERE nome = ?";
        List<Comodo> comodos = new ArrayList<>();

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = DAO.conectar();
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, nome);
            rset = pstm.executeQuery();
            while (rset.next()) {
                Comodo comodo = new Comodo();

                comodo.setNome(rset.getString("nome"));
                comodo.setCapacidade(rset.getInt("capacidade"));
                comodo.setDescricao(rset.getString("descricao"));

                switch (rset.getString(rset.getString("condicao"))) {
                    case "OCUPADO":
                        comodo.setCondicao(Comodo.Condicao.OCUPADO);
                        break;
                    case "MANUTENCAO":
                        comodo.setCondicao(Comodo.Condicao.MANUTENCAO);
                        break;
                    case "LIVRE":
                        comodo.setCondicao(Comodo.Condicao.LIVRE);
                        break;
                    case "OUTRO":
                        comodo.setCondicao(Comodo.Condicao.OUTRO);
                        break;
                }
                comodos.add(comodo);
            }

        } catch (ClassNotFoundException | SQLException e) {
            return null;
        } finally {
            try {
                if (rset != null && pstm != null && conn != null) {
                    rset.close();
                    pstm.close();
                    conn.close();
                }
            } catch (SQLException e) {
                return null;
            }
        }
        return comodos;
    }

}

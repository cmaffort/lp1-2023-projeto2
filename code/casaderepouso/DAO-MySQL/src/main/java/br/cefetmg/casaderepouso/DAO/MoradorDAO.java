/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;
/**
 *
 * @author Aluno
 */

import br.cefetmg.casaderepouso.DAO.connection.DAO;
import br.cefetmg.casaderepouso.dto.Morador;
import br.cefetmg.casaderepouso.idao.IMoradorDAO;
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


public class MoradorDAO implements IMoradorDAO {
    @Override
    public boolean atualizar(Morador morador) throws ClassNotFoundException, SQLException{
         String sqlMorador = "INSERT INTO morador VALUES('" + morador.getNome() + "', '" + morador.getNomeMae() + "', '" + morador.getCondicaoEspecial() + "', '" + morador.getCpf() + "', '"
                + morador.getDataNasc()+ "', '" + morador.getVetorResponsaveis()+ "', '" + morador.getEstado() + "')";
         Connection conexao = null;

        Statement comando = null;

        int resultado = 0;

        try {
            conexao = DAO.conectar();

            comando = conexao.createStatement();

            resultado = comando.executeUpdate(sqlMorador);

        } finally {
            DAO.fecharConexao(conexao, comando);
        }

        return resultado > 0;
    }
    @Override
    public boolean deletar(Morador morador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Long inserir(Morador morador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
  
    @Override
    public ArrayList<Morador> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Morador pesquisar(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Morador pesquisar(String nome, String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

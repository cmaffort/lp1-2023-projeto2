/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

import br.cefetmg.casaderepouso.dto.Visitante;
import java.sql.SQLException;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.DAO.connection.DAO;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Aluno
 */


public class VisitanteDAO {
    
    public boolean atualizar(Visitante visitante) throws ClassNotFoundException, SQLException{
         String sqlVisitante = "INSERT INTO produtos VALUES('" + visitante.getNome() + "', '" + visitante.getRg() + "', '"
                + visitante.getTelefone() + "', '" + visitante.getMorador() + "', '" + visitante.getVinculo() + "')";
         Connection conexao = null;
        
        Statement comando = null;
        
        int resultado = 0;
        
        try {
            conexao = DAO.conectar();
            
            comando = conexao.createStatement();

            resultado = comando.executeUpdate(sqlVisitante);
        
        } finally {
            DAO.fecharConexao(conexao, comando);
        }

        return resultado > 0;
    }

    public boolean deletar(Visitante visitante) {
        return false;
    }

    public void inserir(Visitante visitante) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
    public ArrayList<Visitante> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
    public Visitante pesquisar(String nome) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
        public Visitante pesquisar(String nome, String cpf) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}

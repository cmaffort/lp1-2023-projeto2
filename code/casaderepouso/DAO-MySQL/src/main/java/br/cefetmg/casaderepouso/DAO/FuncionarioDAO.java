/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.DAO;

/**
 *
 * @author rafael-igor-vilaca
 */
import br.cefetmg.casaderepouso.dto.Funcionario;
import br.cefetmg.casaderepouso.idao.IFuncionarioDAO;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.Date;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class FuncionarioDAO implements IFuncionarioDAO{
    @Override
    public String atualizar(Funcionario func) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean deletar(Funcionario func) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Long inserir(Funcionario func) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public ArrayList<Funcionario> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }


    @Override
    public Funcionario pesquisar(String cpf) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.service.IManterFuncionario;
import br.cefetmg.casaderepouso.dto.Funcionario;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.DAO.FuncionarioDAO;
import br.cefetmg.casaderepouso.idao.IFuncionarioDAO;
import java.sql.SQLException;

/**
 *
 * @author rafael-igor-vilaca
 */
public class ManterFuncionario implements IManterFuncionario {
    private IFuncionarioDAO funcionarioDAO;
    
    public ManterFuncionario() {
        funcionarioDAO = new FuncionarioDAO();
    }
    
    @Override
    public String cadastrar(Funcionario func) throws CadastroException, SQLException, ClassNotFoundException{        
        funcionarioDAO.inserir(func);
        return func.getCpf();
    }

    @Override
    public String excluir(Funcionario func) throws Exception {
        boolean verifica = funcionarioDAO.deletar(func);
        if(verifica)
            return "true";
        else
            return "false";
    }

    @Override
    public String atualizar(Funcionario func) throws Exception {
       funcionarioDAO.atualizar(func);
       return "true";
    }
    
    
    
    @Override
    public List<Funcionario> pesquisarTodos() throws Exception {
        List<Funcionario> lista = funcionarioDAO.listarTodos();
        
        return lista;
    }
    
    
    @Override
    public Funcionario pesquisar(String cpf) throws Exception {
        Funcionario func = funcionarioDAO.pesquisar(cpf);
        
        return func;
    }
}

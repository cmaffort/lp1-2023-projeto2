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
    public String cadastrar(Funcionario func) throws CadastroException {        
        funcionarioDAO.inserir(func);
        return func.getCpf();
    }

    @Override
    public String excluir(Funcionario func) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String atualizar(Funcionario func) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    @Override
    public List<Funcionario> pesquisar(Funcionario func) throws Exception {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        /*if(func.getNome() == null || func.getNome().equals("")) {;
            funcionarios.addAll(funcionarioDAO.pesquisar(func.getNome()));
        }*/
        if(func.getCpf() == null || func.getCpf().equals("")) {
        }
        if(func.getDataNasc() == null || func.getDataNasc().toString().equals("")) {
        }
        if(func.getEndereco() == null || func.getEndereco().equals("")) {
        }
        return null;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.dto.Refeicao;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.DAO.RefeicaoDAO;
import br.cefetmg.casaderepouso.idao.IRefeicaoDAO;
import java.sql.SQLException;
import br.cefetmg.casaderepouso.service.IManterRefeicao;

/**
 *
 * @author Master
 */
public class ManterRefeicao implements IManterRefeicao{
    private IRefeicaoDAO refeicaoDAO;
    
    public ManterRefeicao() {
        refeicaoDAO = new RefeicaoDAO();
    }
    
    @Override
    public String cadastrar(Refeicao refeicao) throws CadastroException{        
        refeicaoDAO.inserir(refeicao);
        return refeicao.getCpfMorador();
    }

    @Override
    public String excluir(Refeicao refeicao) throws Exception {
        boolean verifica = refeicaoDAO.deletar(refeicao);
        if(verifica)
            return "true";
        else
            return "false";
    }

    @Override
    public String atualizar(Refeicao refeicao) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public List<Refeicao> pesquisarTodos() throws Exception {
        List<Refeicao> lista = refeicaoDAO.listarTodos();
        
        return lista;
    }

    @Override
    public List<Refeicao> pesquisar(String cpf) throws Exception {
        List<Refeicao> lista = refeicaoDAO.pesquisar(cpf);
        return lista;
    }
    
}

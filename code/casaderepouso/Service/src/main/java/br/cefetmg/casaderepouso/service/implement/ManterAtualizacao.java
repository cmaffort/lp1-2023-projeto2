/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

/**
 *
 * @author Master
 */
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.dto.Atualizacao;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.DAO.AtualizacaoDAO;
import br.cefetmg.casaderepouso.idao.IAtualizacaoDAO;
import java.sql.SQLException;
import br.cefetmg.casaderepouso.service.IManterAtualizacao;

/**
 *
 * @author Master
 */
public class ManterAtualizacao implements IManterAtualizacao{
    private IAtualizacaoDAO atualizacaoDAO;
    
    public ManterAtualizacao() {
        atualizacaoDAO = new AtualizacaoDAO();
    }
    
    @Override
    public String cadastrar(Atualizacao atualizacao) throws CadastroException{        
        atualizacaoDAO.inserir(atualizacao);
        return atualizacao.getCpf();
    }
    @Override
        public List<Atualizacao> pesquisarTodos() throws Exception {
        List<Atualizacao> lista = atualizacaoDAO.listarTodos();
        
        return lista;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.dto.Mensalidade;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.DAO.MensalidadeDAO;
import br.cefetmg.casaderepouso.idao.IMensalidadeDAO;
import java.sql.SQLException;
import br.cefetmg.casaderepouso.service.IManterMensalidade;
/**
 *
 * @author Master
 */
public class ManterMensalidade implements IManterMensalidade {
    
    private IMensalidadeDAO mensalidadeDAO;
    
    public ManterMensalidade() {
        mensalidadeDAO = new MensalidadeDAO();
    }
    
    @Override
    public String cadastrar(Mensalidade mensalidade) throws CadastroException{        
        mensalidadeDAO.inserir(mensalidade);
        return mensalidade.getCpfMorador();
    }

    @Override
    public String excluir(Mensalidade mensalidade) throws Exception {
        boolean verifica = mensalidadeDAO.deletar(mensalidade);
        if(verifica)
            return "true";
        else
            return "false";
    }

    @Override
    public String atualizar(Mensalidade mensalidade) throws Exception {
        mensalidadeDAO.atualizar(mensalidade);
        return mensalidade.getCpfMorador();
    }
    
    
    public List<Mensalidade> pesquisarTodos() throws Exception {
        List<Mensalidade> lista = mensalidadeDAO.listarTodos();
        
        return lista;
    }
    
    @Override
    public Mensalidade pesquisar(String cpf) throws Exception {
        Mensalidade mor = mensalidadeDAO.pesquisar(cpf);
        return mor;
    }
}
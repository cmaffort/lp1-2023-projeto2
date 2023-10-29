package br.cefetmg.casaderepouso.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.service.ICadastrarResponsavel;
import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.DAO.ResponsavelDAO;
import br.cefetmg.casaderepouso.idao.IResponsavel;
/**
 *
 * @author Aluno
 */
public class CadastrarResponsavel implements ICadastrarResponsavel {
    
    private IResponsavel responsavelDAO;
    
    public CadastrarResponsavel() {
        responsavelDAO = new ResponsavelDAO();
    }
    
    @Override
    public String cadastrar(Responsavel responsavel) throws CadastroException {        
        responsavelDAO.inserir(responsavel);
        return responsavel.getCpf();
    }

    @Override
    public String excluir(Responsavel responsavel) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String atualizar(Responsavel responsavel) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    @Override
    public List<Responsavel> pesquisar(Responsavel responsavel) throws Exception {
        List<Responsavel> responsaveis = new ArrayList<Responsavel>();
        /*if(morador.getNome() == null || morador.getNome().equals("")) {
            moradores.addAll(moradorDAO.pesquisar(morador.getNome()));
        }*/
        if(responsavel.getCpf() == null || responsavel.getCpf().equals("")) {
        }
        if(responsavel.getDataNascimento() == null || responsavel.getDataNascimento().toString().equals("")) {
        }
        if(responsavel.getEndereco() == null || responsavel.getEndereco().equals("")) {
        }
        return null;
    }
}

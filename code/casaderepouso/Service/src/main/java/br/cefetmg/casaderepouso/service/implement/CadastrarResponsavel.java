package br.cefetmg.casaderepouso.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.service.ICadastrarResponsavel;
import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.DAO.ResponsavelDAO;
import br.cefetmg.casaderepouso.idao.IResponsavel;
import java.sql.SQLException;
/**
 *
 * @author Aluno
 */
public class CadastrarResponsavel implements ICadastrarResponsavel{
    
    private IResponsavel responsavelDAO;
    
    public CadastrarResponsavel() {
        responsavelDAO = new ResponsavelDAO();
    }
    
    @Override
    public String cadastrar(Responsavel responsavel) throws CadastroException, SQLException, ClassNotFoundException{        
        responsavelDAO.inserir(responsavel);
        return responsavel.getCpf();
    }

    @Override
    public String excluir(Responsavel responsavel) throws SQLException, ClassNotFoundException{
        boolean verifica = responsavelDAO.deletar(responsavel);
        if(verifica)
            return "true";
        else
            return "false";
    }

    @Override
    public String atualizar(Responsavel responsavel) throws SQLException, ClassNotFoundException{
       responsavelDAO.atualizar(responsavel);
       return "true";
    }
    
    
    
    @Override
    public List<Responsavel> listar() throws Exception {
        List<Responsavel> lista = responsavelDAO.listar();
        
        return lista;
    }
    @Override
    public Responsavel pesquisar(String cpf) throws Exception{
        Responsavel pesquisado = responsavelDAO.pesquisar(cpf);
        return pesquisado;
    }
}
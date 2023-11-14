package br.cefetmg.casaderepouso.service.implement;


import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.service.ICadastrarReceita;
import br.cefetmg.casaderepouso.dto.Receita;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.DAO.ReceitaDAO;
import br.cefetmg.casaderepouso.idao.IReceita;
import java.sql.SQLException;
/**
 *
 * @author Aluno
 */
public class CadastrarReceita implements ICadastrarReceita{
    
    private IReceita receitaDAO;
    
    public CadastrarReceita() {
        receitaDAO = new ReceitaDAO();
    }
    
    @Override
    public String cadastrar(Receita receita) throws CadastroException, SQLException, ClassNotFoundException{        
        receitaDAO.inserir(receita);
        return receita.getId();
    }

    @Override
    public String excluir(Receita receita) throws SQLException, ClassNotFoundException{
        boolean verifica = receitaDAO.deletar(receita);
        if(verifica)
            return "true";
        else
            return "false";
    } 
    @Override
    public List<Receita> listar() throws Exception {
        List<Receita> lista = receitaDAO.listar();
        
        return lista;
    }
}


package br.cefetmg.casaderepouso.service.implement;

import br.cefetmg.casaderepouso.DAO.SaidaDAO;
import br.cefetmg.casaderepouso.dto.SaidaTemporaria;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.idao.ISaidaDAO;
import br.cefetmg.casaderepouso.service.IManterSaida;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rigor
 */
public class ManterSaida implements IManterSaida {
    private ISaidaDAO saidaDAO;
    
    public ManterSaida() {
        saidaDAO = new SaidaDAO();
    }
    
    @Override
    public String cadastrar(SaidaTemporaria saida) throws CadastroException, SQLException, ClassNotFoundException{        
        saidaDAO.inserir(saida);
        return saida.getMoradorCpf();
    }

    @Override
    public String excluir(SaidaTemporaria saida) throws Exception {
        boolean verifica = saidaDAO.deletar(saida);
        if(verifica)
            return "true";
        else
            return "false";
    }

    @Override
    public String atualizar(SaidaTemporaria saida) throws Exception {
       saidaDAO.atualizar(saida);
       return "true";
    }
    
    
    
    @Override
    public List<SaidaTemporaria> pesquisarTodos() throws Exception {
        List<SaidaTemporaria> lista = saidaDAO.listarTodos();
        
        return lista;
    }
}

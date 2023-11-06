package br.cefetmg.casaderepouso.service.implement;

import br.cefetmg.casaderepouso.dto.Visitante;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.ICadastrarVisitante;
import br.cefetmg.casaderepouso.idao.IVisitanteDAO;
import br.cefetmg.casaderepouso.DAO.VisitanteDAO;
import java.util.List;
/**
 *
 * @author Júlia
 */
public class CadastrarVisitanteService implements ICadastrarVisitante{

    private IVisitanteDAO VisitanteDAO;
    
    public CadastrarVisitanteService() {
        VisitanteDAO =  new VisitanteDAO();
    }
    @Override
    public String cadastrar(Visitante visitante) throws CadastroException {
        VisitanteDAO.cadastrar(visitante);
        return visitante.getNome();
    }   

    @Override
    public List<Visitante> listarTodos() {
        List<Visitante> lista= VisitanteDAO.listarTodos();
        System.out.println("chegoiu aqui no service");
        return lista;
    }
}

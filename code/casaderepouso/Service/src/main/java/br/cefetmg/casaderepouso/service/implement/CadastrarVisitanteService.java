package br.cefetmg.casaderepouso.service.implement;

import br.cefetmg.casaderepouso.dto.Visitante;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.ICadastrarVisitante;
import br.cefetmg.casaderepouso.idao.IVisitanteDAO;
import br.cefetmg.casaderepouso.DAO.VisitanteDAO;
/**
 *
 * @author jujua
 */
public class CadastrarVisitanteService implements ICadastrarVisitante{

    private IVisitanteDAO VisitanteDAO;
    
    public CadastrarVisitanteService() {
        VisitanteDAO =  new VisitanteDAO();
    }
    @Override
    public String cadastrar(Visitante visitante) throws CadastroException {
        VisitanteDAO.cadastrar(visitante);
        System.out.println("chegoiu aqui no serviço" + visitante.getNome());
        return visitante.getNome();
    }   
}

package br.cefetmg.casaderepouso.service.implement;

import br.cefetmg.casaderepouso.DAO.ConsultaDAO;
import br.cefetmg.casaderepouso.dto.Consulta;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.idao.IConsultaDAO;
import br.cefetmg.casaderepouso.service.ICadastrarConsulta;
import java.util.List;

/**
 *
 * @author Júlia
 */
public class CadastrarConsultaS  implements ICadastrarConsulta{

    private IConsultaDAO ConsultaDAO;
    
    public CadastrarConsultaS() {
       ConsultaDAO = new ConsultaDAO();
    }
    @Override
    public String cadastrar(Consulta consulta) throws CadastroException {
        ConsultaDAO.cadastrar(consulta);
        return consulta.getProfissional();
    }   

    @Override
    public List<Consulta> listarTodos() {
        List<Consulta> list = ConsultaDAO.listarTodos();
        return list;
    }
    
}

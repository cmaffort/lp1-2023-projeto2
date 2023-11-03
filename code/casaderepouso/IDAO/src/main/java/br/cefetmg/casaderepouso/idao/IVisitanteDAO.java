package br.cefetmg.casaderepouso.idao;
import br.cefetmg.casaderepouso.dto.Visitante;
import java.util.List;
/**
 *
 * @author rigor
 */
public interface IVisitanteDAO {
    

    public boolean cadastrar(Visitante visitante);
    public List<Visitante> listarTodos();

}

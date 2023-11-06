package br.cefetmg.casaderepouso.service;
/**
 *
 * @author Aluno
 */
import br.cefetmg.casaderepouso.dto.Visitante;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.List;

public interface ICadastrarVisitante {
    
    public String cadastrar(Visitante visitante) throws CadastroException;
    public List<Visitante> listarTodos();

        
}

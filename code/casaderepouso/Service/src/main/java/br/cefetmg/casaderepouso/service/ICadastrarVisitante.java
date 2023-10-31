package br.cefetmg.casaderepouso.service;
/**
 *
 * @author Aluno
 */
import br.cefetmg.casaderepouso.dto.Visitante;
import br.cefetmg.casaderepouso.dto.exception.*;

public interface ICadastrarVisitante {
    
    public String cadastrar(Visitante visitante) throws CadastroException;

        
}

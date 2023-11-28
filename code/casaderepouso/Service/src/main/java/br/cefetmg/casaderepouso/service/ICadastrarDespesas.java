package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.Despesas;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import java.util.List;

/**
 *
 * @author Júlia
 */
public interface ICadastrarDespesas {

    public String cadastrar(Despesas pagamento) throws CadastroException;

    public List<Despesas> listarTodos();

}

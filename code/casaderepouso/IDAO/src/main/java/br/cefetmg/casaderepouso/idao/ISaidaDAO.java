
package br.cefetmg.casaderepouso.idao;

import br.cefetmg.casaderepouso.dto.SaidaTemporaria;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rigor
 */
public interface ISaidaDAO {
        public void inserir(SaidaTemporaria saida) throws SQLException, ClassNotFoundException;

    public boolean atualizar(SaidaTemporaria saida) throws SQLException, ClassNotFoundException;

    public boolean deletar(SaidaTemporaria saida) throws SQLException, ClassNotFoundException;

    public ArrayList<SaidaTemporaria> listarTodos() throws SQLException, ClassNotFoundException;

    public SaidaTemporaria pesquisar(String cpf);

}


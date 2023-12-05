package br.cefetmg.casaderepouso.service;
import br.cefetmg.casaderepouso.dto.Receita;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.SQLException;
import java.util.List;

public interface ICadastrarReceita {
    public String cadastrar(Receita receita) throws CadastroException, SQLException, ClassNotFoundException;
    public String excluir(Receita receita) throws SQLException, ClassNotFoundException;
    public List<Receita> listar() throws Exception;
    public String atualizar(Receita receita) throws SQLException, ClassNotFoundException;
}

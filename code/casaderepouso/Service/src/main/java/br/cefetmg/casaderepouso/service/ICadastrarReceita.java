package br.cefetmg.casaderepouso.service;
import br.cefetmg.casaderepouso.dto.Receita;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface ICadastrarReceita {
    public String cadastrar(Receita receita) throws CadastroException, SQLException, ClassNotFoundException;
    public String excluir(Receita responsavel) throws SQLException, ClassNotFoundException;
    public List<Receita> listar() throws Exception;
}

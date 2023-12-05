package br.cefetmg.casaderepouso.idao;

import br.cefetmg.casaderepouso.dto.Receita;
import java.sql.SQLException;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.ArrayList;

public interface IReceita {

    public void inserir(Receita receita) throws SQLException, ClassNotFoundException;

    public boolean deletar(Receita receita) throws SQLException, ClassNotFoundException;

    public ArrayList<Receita> listar() throws SQLException, ClassNotFoundException;

    public boolean atualizar(Receita receita) throws SQLException, ClassNotFoundException;

}

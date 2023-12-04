package br.cefetmg.casaderepouso.idao;
import br.cefetmg.casaderepouso.dto.Responsavel;
import java.sql.SQLException;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.ArrayList;

public interface IResponsavel {
    

    public void inserir(Responsavel responsavel) throws SQLException, ClassNotFoundException;

    public boolean atualizar(Responsavel responsavel) throws SQLException, ClassNotFoundException;

    public boolean deletar(Responsavel responsavel) throws SQLException, ClassNotFoundException;

    public ArrayList<Responsavel> listar() throws SQLException, ClassNotFoundException;

    public Responsavel pesquisar(String cpf) throws SQLException, ClassNotFoundException;
}
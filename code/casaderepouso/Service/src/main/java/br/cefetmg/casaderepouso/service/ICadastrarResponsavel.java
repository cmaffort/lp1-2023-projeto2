package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public interface ICadastrarResponsavel {
    public String cadastrar(Responsavel responsavel) throws SQLException, ClassNotFoundException;
    public String atualizar(Responsavel responsavel) throws SQLException, ClassNotFoundException;
    public String excluir(Responsavel responsavel) throws SQLException, ClassNotFoundException;
    public List<Responsavel> listar() throws Exception;
}
package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.Date;
import java.util.List;


public interface ICadastrarResponsavel {
    public String cadastrar(Responsavel responsavel) throws CadastroException;
    public String atualizar(Responsavel responsavel) throws Exception;
    public String excluir(Responsavel responsavel) throws Exception;
    
    public List<Responsavel> pesquisar(Responsavel responsavel) throws Exception;
}
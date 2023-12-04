/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

/**
 *
 * @author Master
 */
import br.cefetmg.casaderepouso.dto.Mensalidade;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IManterMensalidade {
    
    public String cadastrar(Mensalidade mensalidade) throws CadastroException;
    public String atualizar(Mensalidade mensalidade) throws Exception;
    public String excluir(Mensalidade mensalidade) throws Exception;
    
    public List<Mensalidade> pesquisarTodos() throws Exception;
    public Mensalidade pesquisar(String cpf) throws Exception;
    
}

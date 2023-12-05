/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.SaidaTemporaria;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rigor
 */
public interface IManterSaida {
    public String cadastrar(SaidaTemporaria saida) throws CadastroException, SQLException,ClassNotFoundException;
    public String atualizar(SaidaTemporaria saida) throws Exception;
    public String excluir(SaidaTemporaria saida) throws Exception;
    
    public List<SaidaTemporaria> pesquisarTodos() throws Exception;
}

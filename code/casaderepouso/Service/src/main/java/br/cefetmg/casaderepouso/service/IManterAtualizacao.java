/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

/**
 *
 * @author Master
 */
import br.cefetmg.casaderepouso.dto.Atualizacao;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import java.util.List;

public interface IManterAtualizacao {
    public String cadastrar(Atualizacao atualizacao) throws CadastroException;
    public List<Atualizacao> pesquisarTodos() throws Exception;
}

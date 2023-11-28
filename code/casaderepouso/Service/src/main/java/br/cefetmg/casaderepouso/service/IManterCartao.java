/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.Cartao;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import java.util.List;

/**
 *
 * @author Master
 */
public interface IManterCartao {
    public String cadastrar(Cartao cartao) throws CadastroException;
    public String excluir(Cartao cartao) throws Exception;
    public List<Cartao> pesquisarTodos() throws Exception;
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.Refeicao;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import java.util.List;

/**
 *
 * @author Master
 */
public interface IManterRefeicao {
    public String cadastrar(Refeicao refeicao) throws CadastroException;
    public String atualizar(Refeicao refeicao) throws Exception;
    public String excluir(Refeicao refeicao) throws Exception;
    
    public List<Refeicao> pesquisarTodos() throws Exception;
    public List<Refeicao> pesquisar(String cpf) throws Exception;
}

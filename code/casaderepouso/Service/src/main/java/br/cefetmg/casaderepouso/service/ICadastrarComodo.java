/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.Comodo;
import java.util.List;

/**
 *
 * @author felli
 */
public interface ICadastrarComodo {
    public boolean cadastrar(Comodo comodo);
    public boolean atualizar(Comodo comodo);
    public boolean deletar(int id);
    public List<Comodo> ListarTodos(String condicao);
    public List<Comodo> pesquisar(String nome);
        
}

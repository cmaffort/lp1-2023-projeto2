/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;

import br.cefetmg.casaderepouso.dto.Comodo;
import java.util.Date;
import java.util.List;

/**
 *
 * @author felli
 */
public interface IComodoDAO {
    public boolean inserir(Comodo comodo);

    public boolean atualizar(Comodo comodo);

    public boolean deletar(int id);

    public List<Comodo> listarTodos(String condicao);

    public List<Comodo> pesquisar(String nome);

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import br.cefetmg.casaderepouso.DAO.ComodoDAO;
import br.cefetmg.casaderepouso.dto.Comodo;
import br.cefetmg.casaderepouso.idao.IComodoDAO;
import java.util.List;

/**
 *
 * @author felli
 */
public class CadastraComodo {

    private IComodoDAO DAO = new ComodoDAO();

    public boolean inserir(Comodo comodo) {
        if (comodo != null)
            return DAO.inserir(comodo);
        else 
            return false;
    }

    public boolean atualizar(Comodo comodo) {
        if (comodo != null) 
            return DAO.atualizar(comodo);
        else {
            return false;
        }
        

    }

    public boolean deletar(int id) {
        return DAO.deletar(id);
    }

    public List<Comodo> listarTodos(String condicao) {
        if (!condicao.equals("")) 
            return DAO.listarTodos(condicao);
        else 
            return null;
    }

    public List<Comodo> pesquisar(String nome) {
        if (!nome.equals("")) 
            return DAO.pesquisar(nome);
        else 
            return null;
         }

}
   

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import br.cefetmg.casaderepouso.DAO.EventoDAO;
import br.cefetmg.casaderepouso.dto.Evento;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.idao.IEventoDAO;
import br.cefetmg.casaderepouso.service.IManterEvento;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author rigor
 */
public class ManterEvento implements IManterEvento {
    private IEventoDAO eventoDAO;
    
    public ManterEvento() {
        eventoDAO = new EventoDAO();
    }
    
    @Override
    public String cadastrar(Evento event) throws CadastroException, SQLException, ClassNotFoundException{        
        eventoDAO.inserir(event);
        return event.getRg();
    }
    
    @Override
    public String atualizar(Evento event) throws SQLException, ClassNotFoundException{        
        eventoDAO.atualizar(event);
        return event.getRg();
    }
    @Override
    public String excluir(Evento event) throws Exception {
        boolean verifica = eventoDAO.deletar(event);
        if(verifica)
            return "true";
        else
            return "false";
    }

    
   
    
    @Override
    public List<Evento> pesquisarTodos() throws Exception {
        List<Evento> lista = eventoDAO.listarTodos();
        
        return lista;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

/**
 *
 * @author rigor
 */
import br.cefetmg.casaderepouso.dto.Evento;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.SQLException;
import java.util.List;

public interface IManterEvento {
    public String cadastrar(Evento event) throws CadastroException, SQLException,ClassNotFoundException;
    public String excluir(Evento event) throws Exception;
    public String atualizar(Evento event) throws SQLException, ClassNotFoundException;
    public List<Evento> pesquisarTodos() throws Exception;
}

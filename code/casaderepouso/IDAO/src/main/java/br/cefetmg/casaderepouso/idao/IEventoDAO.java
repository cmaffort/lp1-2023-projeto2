/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;

import br.cefetmg.casaderepouso.dto.Evento;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author rigor
 */
public interface IEventoDAO {
    public void inserir(Evento event) throws SQLException, ClassNotFoundException;

    public boolean deletar(Evento event) throws SQLException, ClassNotFoundException;

    public ArrayList<Evento> listarTodos() throws SQLException, ClassNotFoundException;

    public Evento pesquisar(String cpf);
}

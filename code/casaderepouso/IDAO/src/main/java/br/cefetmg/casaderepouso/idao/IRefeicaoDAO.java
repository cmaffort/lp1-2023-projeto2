/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;

/**
 *
 * @author Master
 */
import br.cefetmg.casaderepouso.dto.Refeicao;
import java.sql.SQLException;
import java.util.ArrayList;
public interface IRefeicaoDAO {
    
    public boolean inserir(Refeicao refeicao);

    public boolean deletar(Refeicao refeicao) throws SQLException, ClassNotFoundException;

    public ArrayList<Refeicao> listarTodos() throws SQLException, ClassNotFoundException;

    public ArrayList<Refeicao> pesquisar(String cpf) throws SQLException, ClassNotFoundException;
}
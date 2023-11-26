/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;

/**
 *
 * @author Master
 */
import br.cefetmg.casaderepouso.dto.Cartao;
import java.sql.SQLException;
import java.util.ArrayList;
public interface ICartaoDAO {
    
    public boolean inserir(Cartao refeicao);

    public boolean deletar(Cartao refeicao) throws SQLException, ClassNotFoundException;

    public ArrayList<Cartao> listarTodos() throws SQLException, ClassNotFoundException;

}
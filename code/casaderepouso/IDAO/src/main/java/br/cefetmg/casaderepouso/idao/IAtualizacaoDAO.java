/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;

/**
 *
 * @author Master
 */
import br.cefetmg.casaderepouso.dto.Atualizacao;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IAtualizacaoDAO {
    public boolean inserir(Atualizacao atualizacao);
    public ArrayList<Atualizacao> listarTodos() throws SQLException, ClassNotFoundException;
}

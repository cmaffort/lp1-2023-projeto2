/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;

/**
 *
 * @author Master
 */
import br.cefetmg.casaderepouso.dto.Mensalidade;
import java.sql.SQLException;
import java.util.ArrayList;
public interface IMensalidadeDAO {
    
    public boolean inserir(Mensalidade mensalidade);

    public boolean atualizar(Mensalidade mensalidade) throws ClassNotFoundException,SQLException;

    public boolean deletar(Mensalidade mensalidade) throws SQLException, ClassNotFoundException;

    public ArrayList<Mensalidade> listarTodos() throws SQLException, ClassNotFoundException;

    public Mensalidade pesquisar(String cpf) throws SQLException, ClassNotFoundException;
}
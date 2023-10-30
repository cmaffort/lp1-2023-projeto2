/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;
import br.cefetmg.casaderepouso.dto.Funcionario;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author rigor
 */
public interface IFuncionarioDAO {
    

    public void inserir(Funcionario funcionario) throws SQLException, ClassNotFoundException;

    public boolean atualizar(Funcionario funcionario);

    public boolean deletar(Funcionario funcionario) throws SQLException, ClassNotFoundException;

    public ArrayList<Funcionario> listarTodos() throws SQLException, ClassNotFoundException;

    public Funcionario pesquisar(String cpf);

}

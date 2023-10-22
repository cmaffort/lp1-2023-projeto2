/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;
import br.cefetmg.casaderepouso.dto.Funcionario;
import java.util.ArrayList;
/**
 *
 * @author rigor
 */
public interface IFuncionarioDAO {
    

    public Long inserir(Funcionario funcionario);

    public boolean atualizar(Funcionario funcionario);

    public boolean deletar(Funcionario funcionario);

    public ArrayList<Funcionario> listarTodos();

    public Funcionario pesquisar(String cpf);

}

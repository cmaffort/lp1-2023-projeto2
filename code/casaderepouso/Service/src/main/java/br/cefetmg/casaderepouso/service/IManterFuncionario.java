/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

/**
 *
 * @author rafael-igor-vilaca
 */
import br.cefetmg.casaderepouso.dto.Funcionario;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public interface IManterFuncionario {
    public String cadastrar(Funcionario func) throws CadastroException, SQLException,ClassNotFoundException;
    public String atualizar(Funcionario func) throws Exception;
    public String excluir(Funcionario func) throws Exception;
    
    public List<Funcionario> pesquisar(Funcionario func) throws Exception;
}

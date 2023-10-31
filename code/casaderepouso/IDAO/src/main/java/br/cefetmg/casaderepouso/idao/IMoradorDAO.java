package br.cefetmg.casaderepouso.idao;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Aluno
 */
import br.cefetmg.casaderepouso.dto.Morador;
import java.sql.SQLException;
import java.util.ArrayList;
public interface IMoradorDAO {
    
    public void inserir(Morador morador) throws SQLException, ClassNotFoundException;

    public boolean atualizar(Morador morador) throws ClassNotFoundException,SQLException;

    public boolean deletar(Morador morador) throws SQLException, ClassNotFoundException;

    public ArrayList<Morador> listarTodos() throws SQLException, ClassNotFoundException;

    public Morador pesquisar(String nome) throws SQLException, ClassNotFoundException;
    
    public Morador pesquisar(String nome, String cpf) throws SQLException, ClassNotFoundException;
}
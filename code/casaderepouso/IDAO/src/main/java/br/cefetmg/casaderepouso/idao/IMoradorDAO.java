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
    
    public Long inserir(Morador morador);

    public boolean atualizar(Morador morador) throws ClassNotFoundException,SQLException;

    public boolean deletar(Morador morador);

    public ArrayList<Morador> listarTodos();

    public Morador pesquisar(String nome);
    
    public Morador pesquisar(String nome, String cpf);
}
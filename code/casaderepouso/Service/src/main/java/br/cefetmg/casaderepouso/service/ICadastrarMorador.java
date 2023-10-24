/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

/**
 *
 * @author Aluno
 */
import br.cefetmg.casaderepouso.dto.Morador;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.Date;
import java.util.List;

public interface ICadastrarMorador {
    
    public String cadastrar(Morador morador) throws CadastroException;
    public String atualizar(Morador morador) throws Exception;
    public String excluir(Morador morador) throws Exception;
    
    public List<Morador> pesquisar(Morador morador) throws Exception;
    
}

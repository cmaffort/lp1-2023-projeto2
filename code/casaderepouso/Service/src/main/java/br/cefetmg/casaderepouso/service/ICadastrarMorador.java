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
    
    public String cadastrar(Morador paciente) throws CadastroException;
    public String atualizar(Morador paciente) throws Exception;
    public String excluir(Morador paciente) throws Exception;
    
    public List<Morador> pesquisar(Morador morador) throws Exception;
    
}
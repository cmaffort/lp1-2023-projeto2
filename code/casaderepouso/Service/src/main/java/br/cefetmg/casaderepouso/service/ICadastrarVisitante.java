/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

/**
 *
 * @author Aluno
 */
import br.cefetmg.casaderepouso.dto.Visitante;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.Date;
import java.util.List;

public interface ICadastrarVisitante {
    
    public String cadastrar(Visitante visitante) throws CadastroException;
    public String atualizar(Visitante visitante) throws Exception;
    
    public List<Visitante> pesquisar(Visitante visitante) throws Exception;
    
}

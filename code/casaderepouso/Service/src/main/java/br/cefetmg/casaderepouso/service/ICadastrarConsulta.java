/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.Consulta;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import java.util.List;

/**
 *
 * @author Júlia
 */
public interface ICadastrarConsulta {
        public String cadastrar(Consulta consulta) throws CadastroException;
        public List<Consulta> listarTodos();

    
}

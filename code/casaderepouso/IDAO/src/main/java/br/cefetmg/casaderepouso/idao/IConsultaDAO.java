/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;

import br.cefetmg.casaderepouso.dto.Consulta;
import java.util.List;

/**
 *
 * @author Júlia
 */
public interface IConsultaDAO {
        public boolean cadastrar(Consulta consulta);
        public List<Consulta> listarTodos();

}

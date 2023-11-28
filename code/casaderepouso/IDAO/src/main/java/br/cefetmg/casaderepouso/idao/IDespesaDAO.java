/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;

import br.cefetmg.casaderepouso.dto.Despesas;
import java.util.List;

/**
 *
 * @author jujua
 */
public interface IDespesaDAO {
        public boolean cadastrar(Despesas pagamento);
        public List<Despesas> listarTodos();

}

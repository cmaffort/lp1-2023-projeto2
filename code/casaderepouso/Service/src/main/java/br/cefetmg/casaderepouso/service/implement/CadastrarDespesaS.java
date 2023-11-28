/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import br.cefetmg.casaderepouso.DAO.DespesaDAO;
import br.cefetmg.casaderepouso.dto.Despesas;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.idao.IDespesaDAO;
import br.cefetmg.casaderepouso.service.ICadastrarDespesas;
import java.util.List;

/**
 *
 * @author Júlia
 */
public class CadastrarDespesaS implements ICadastrarDespesas {

    private IDespesaDAO DespesaDAO;

    public CadastrarDespesaS() {
        DespesaDAO = new DespesaDAO();
    }

    @Override
    public String cadastrar(Despesas pagamento) throws CadastroException {
        DespesaDAO.cadastrar(pagamento);
        System.out.println("Service teste");
        return pagamento.getDestinatario();
    }

    @Override
    public List<Despesas> listarTodos() {
        List<Despesas> list = DespesaDAO.listarTodos();
        return list;
        
    }

}

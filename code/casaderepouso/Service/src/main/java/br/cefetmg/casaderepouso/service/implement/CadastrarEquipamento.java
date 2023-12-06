package br.cefetmg.casaderepouso.service.implement;

import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.service.ICadastrarEquipamento;
import br.cefetmg.casaderepouso.dto.Equipamento;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.DAO.EquipamentoDAO;
import br.cefetmg.casaderepouso.idao.IEquipamento;
import java.sql.SQLException;
/**
 *
 * @author Aluno
 */
public class CadastrarEquipamento implements ICadastrarEquipamento{
    
    private IEquipamento equipamentoDAO;
    
    public CadastrarEquipamento() {
        equipamentoDAO = new EquipamentoDAO();
    }
    
    @Override
    public String cadastrar(Equipamento equipamento) throws CadastroException, SQLException, ClassNotFoundException{        
        equipamentoDAO.inserir(equipamento);
        return equipamento.getTipo();
    }

    @Override
    public String excluir(Equipamento equipamento) throws SQLException, ClassNotFoundException{
        boolean verifica = equipamentoDAO.deletar(equipamento);
        if(verifica)
            return "true";
        else
            return "false";
    }

    @Override
    public String atualizar(Equipamento equipamento) throws SQLException, ClassNotFoundException{
       equipamentoDAO.atualizar(equipamento);
       return "true";
    }
    
    
    
    @Override
    public List<Equipamento> listar() throws Exception {
        List<Equipamento> lista = equipamentoDAO.listar();
        
        return lista;
    }
}
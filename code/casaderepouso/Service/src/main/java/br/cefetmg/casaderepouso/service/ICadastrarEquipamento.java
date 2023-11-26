package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.Equipamento;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;


public interface ICadastrarEquipamento {
    public String cadastrar(Equipamento equipamento) throws CadastroException, SQLException, ClassNotFoundException;
    public String atualizar(Equipamento responsavel) throws SQLException, ClassNotFoundException;
    public String excluir(Equipamento responsavel) throws SQLException, ClassNotFoundException;
    public List<Equipamento> listar() throws Exception;
}

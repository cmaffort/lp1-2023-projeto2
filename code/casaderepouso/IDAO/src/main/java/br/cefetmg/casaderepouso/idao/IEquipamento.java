package br.cefetmg.casaderepouso.idao;
import br.cefetmg.casaderepouso.dto.Equipamento;
import java.sql.SQLException;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.util.ArrayList;

public interface IEquipamento {
    
    public void inserir(Equipamento equipamento) throws SQLException, ClassNotFoundException;
    
    public boolean atualizar(Equipamento equipamento) throws SQLException, ClassNotFoundException;
    
    public boolean deletar(Equipamento equipamento) throws SQLException, ClassNotFoundException;

    public ArrayList<Equipamento> listar() throws SQLException, ClassNotFoundException;
    
    public Equipamento pesquisar(String tipo) throws SQLException, ClassNotFoundException;
}

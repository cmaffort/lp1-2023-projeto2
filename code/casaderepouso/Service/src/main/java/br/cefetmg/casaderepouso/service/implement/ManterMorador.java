/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.dto.Morador;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.DAO.MoradorDAO;
import br.cefetmg.casaderepouso.idao.IMoradorDAO;
import java.sql.SQLException;
import br.cefetmg.casaderepouso.service.IManterMorador;
/**
 *
 * @author Aluno
 */
public class ManterMorador implements IManterMorador {
    
    private IMoradorDAO moradorDAO;
    
    public ManterMorador() {
        moradorDAO = new MoradorDAO();
    }
    
    @Override
    public String cadastrar(Morador morador) throws CadastroException, SQLException, ClassNotFoundException{        
        moradorDAO.inserir(morador);
        return morador.getCpf();
    }

    @Override
    public String excluir(Morador morador) throws Exception {
        boolean verifica = moradorDAO.deletar(morador);
        if(verifica)
            return "true";
        else
            return "false";
    }

    @Override
    public String atualizar(Morador morador) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public List<Morador> pesquisarTodos() throws Exception {
        List<Morador> lista = moradorDAO.listarTodos();
        
        return lista;
    }
    
    @Override
    public List<Morador> pesquisar(Morador morador) throws Exception {
        List<Morador> moradores = new ArrayList<Morador>();
        /*if(morador.getNome() == null || morador.getNome().equals("")) {
            moradores.addAll(moradorDAO.pesquisar(morador.getNome()));
        }*/
        if(morador.getCpf() == null || morador.getCpf().equals("")) {
        }
        if(morador.getDataNasc() == null || morador.getDataNasc().toString().equals("")) {
        }
        if(morador.getEndereco() == null || morador.getEndereco().equals("")) {
        }
        return null;
    }
}
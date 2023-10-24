/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.service.ICadastrarMorador;
import br.cefetmg.casaderepouso.dto.Morador;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.service.util.Util;
import br.cefetmg.casaderepouso.DAO.MoradorDAO;
import br.cefetmg.casaderepouso.idao.IMoradorDAO;
/**
 *
 * @author Aluno
 */
public class CadastrarMorador implements ICadastrarMorador {
    
    private IMoradorDAO moradorDAO;
    
    public CadastrarMorador() {
        moradorDAO = new MoradorDAO();
    }
    
    @Override
    public String cadastrar(Morador morador) throws CadastroException {        
        moradorDAO.inserir(morador);
        return morador.getCpf();
    }

    @Override
    public String excluir(Morador paciente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String atualizar(Morador paciente) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
    @Override
    public List<Morador> pesquisar(Morador morador) throws Exception {
        List<Morador> moradores = new ArrayList<Morador>();
        if(morador.getNome() == null || morador.getNome().equals("")) {
            moradores.addAll(moradorDAO.pesquisar(morador.getNome()));
        }
        if(morador.getCpf() == null || morador.getCpf().equals("")) {
        }
        if(morador.getDataNasc() == null || morador.getDataNasc().toString().equals("")) {
        }
        if(morador.getEndereco() == null || morador.getEndereco().equals("")) {
        }
        return null;
    }
}
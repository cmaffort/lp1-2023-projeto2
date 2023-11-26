/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import br.cefetmg.casaderepouso.dto.Cartao;
import br.cefetmg.casaderepouso.dto.exception.*;
import br.cefetmg.casaderepouso.DAO.CartaoDAO;
import br.cefetmg.casaderepouso.idao.ICartaoDAO;
import java.sql.SQLException;
import br.cefetmg.casaderepouso.service.IManterCartao;

/**
 *
 * @author Master
 */
public class ManterCartao implements IManterCartao{
    private ICartaoDAO cartaoDAO;
    
    public ManterCartao() {
        cartaoDAO = new CartaoDAO();
    }
    
    @Override
    public String cadastrar(Cartao cartao) throws CadastroException{        
        cartaoDAO.inserir(cartao);
        return cartao.getCpf();
    }

    @Override
    public String excluir(Cartao cartao) throws Exception {
        boolean verifica = cartaoDAO.deletar(cartao);
        if(verifica)
            return "true";
        else
            return "false";
    }
    
}
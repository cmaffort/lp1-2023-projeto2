/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import br.cefetmg.casaderepouso.DAO.ProntuarioDAO;
import br.cefetmg.casaderepouso.dto.Prontuario;
import br.cefetmg.casaderepouso.idao.IProntuarioDAO;
import br.cefetmg.casaderepouso.service.ICadastraProntuario;
import java.util.List;

/**
 *velho
 * @author felli
 */
public class CadastraProntuario implements ICadastraProntuario {

    IProntuarioDAO DAO = new ProntuarioDAO();
    
    @Override
    public Boolean cadastrar(Prontuario prontuario) {

        if (prontuario != null) {
            if (prontuario.getData() != null && !prontuario.getFrequenciaCardiaca().equals("") && !prontuario.getFrequenciaRespiratoria().equals("") && !prontuario.getMoradorCPF().equals("") && !prontuario.getObservacaoRefeicao().equals("") && !prontuario.getObservacoes().equals("") && !prontuario.getPressao().equals("") && !prontuario.getProfSaudeCPF().equals("") && !prontuario.equals("") && !prontuario.getTemperatura().equals("")) {
                System.out.println(prontuario.getRefeicoes());
                return DAO.inserir(prontuario);
            }
            System.out.println("ouve algo null ou vazio");
            return false;
        }
        return false;
    }

    @Override
    public List<Prontuario> listarPorMorador(String moradorCPF) {
    if(!moradorCPF.equals("")){
        return DAO.listarProntuarioMor(moradorCPF);
    }
    return null;
    }

    @Override
    public List<Prontuario> listarPorSaude(String medicoCPF) {
         if(!medicoCPF.equals("")){
        return DAO.listarProntuarioMed(medicoCPF);
    }
    return null;
    }

}

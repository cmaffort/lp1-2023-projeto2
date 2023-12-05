/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import br.cefetmg.casaderepouso.idao.IProfissionalSaudeDAO;
import br.cefetmg.casaderepouso.DAO.ProfissionalSaudeDAO;
import br.cefetmg.casaderepouso.dto.ProfissionalSaude;
import br.cefetmg.casaderepouso.service.ICadastraProfissionalSaude;

/**
 *
 * @author felli
 */
public class CadastraProfissionalSaude implements ICadastraProfissionalSaude{

    private IProfissionalSaudeDAO DAO = new ProfissionalSaudeDAO();
    
    @Override
    public boolean inserir(ProfissionalSaude profiSaude) {
        System.out.println("entrou service");
        if(profiSaude != null && !profiSaude.getCpf().equals("") && !profiSaude.getNome().equals("") && !profiSaude.getRegistro().equals("") && !profiSaude.getEspecializacao().name().equals("")){
            System.out.println("entrou service");
            System.out.println("não é null");
            return DAO.inserir(profiSaude);
        }
        System.out.println(profiSaude.getCpf());
        System.out.println(profiSaude.getNome());
        System.out.println(profiSaude.getRegistro());
        System.out.println(profiSaude.getEspecializacao().name());
        System.out.println(profiSaude.getEspecializacao());

        System.out.println("é null");
        return false;
    }

    @Override
    public Boolean deletar(String cpf) {
        if(!cpf.equals("")){
            return DAO.deletar(cpf);
        }
        return false;
    }

    @Override
    public ProfissionalSaude pesquisar(String cpf) {
        if(!cpf.equals("")){
            ProfissionalSaude  pro = DAO.pesquisar(cpf);
            return pro;
        }
        return null;
    }


}

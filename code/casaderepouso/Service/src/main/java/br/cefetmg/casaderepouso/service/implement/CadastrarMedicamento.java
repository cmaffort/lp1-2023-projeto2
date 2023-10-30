/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.service.implement;

import br.cefetmg.casaderepouso.dto.Medicamento;
import java.util.List;
import br.cefetmg.casaderepouso.idao.IMedicamentoDAO;
import br.cefetmg.casaderepouso.DAO.MedicamentoDAO;
import br.cefetmg.casaderepouso.service.ICadastrarMedicamento;

/**
 *
 * @author felli
 */
public class CadastrarMedicamento implements ICadastrarMedicamento {

    private IMedicamentoDAO DAO;
    
    public CadastrarMedicamento() {
        DAO = new MedicamentoDAO();
    }

    @Override
    public Boolean cadastrar(Medicamento med) {
        if (!med.getDose().equals("")) {
            if (med.getIntervalo() != null) {
                if (med.getMoradorCPF() != null) {
                    if (!med.getNome().equals("")) {
                        if (med.getTarja() != null) {
                            if (med.getValidade() != null) {
                                if (med.getValor() != null) {
                                    Boolean ret = DAO.inserir(med);
                                    return ret;
                                } else {
                                    return null;
                                }
                            } else {
                                return null;
                            }
                        } else {
                            return null;
                        }
                    } else {
                        return null;
                    }
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public void atualizar(Medicamento med) {
        DAO.atualizar(med);
    }

    @Override
    public Boolean excluir(Medicamento med) {
        boolean ret = DAO.deletar(med);
        return ret;
    }

    @Override
    public Medicamento pesquisar(String morador, String med) {
        Medicamento medicamento;
        if (!morador.equals("") || morador != null) {
            if (!med.equals("") || med != null) {
                medicamento = DAO.pesquisar(morador, med);
                return medicamento;
            }else{
            return null;
            }
        }else{
        return null;
        }
    }
    
    @Override
    public List<Medicamento> MedicamentoMorador(String moradorCPF) {
      if(!moradorCPF.equals("") || moradorCPF != null){
          return DAO.MedicamentoMorador(moradorCPF);
    }else
        return null;
        }

    @Override
    public List<Medicamento> listarTodos() {
        return DAO.listarTodos();
    }
}

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
import java.time.LocalDateTime;

/**
 *
 * @author felli
 */
public class CadastrarMedicamento implements ICadastrarMedicamento {

    private IMedicamentoDAO DAO = new MedicamentoDAO();

    @Override
    public Boolean cadastrar(Medicamento med) {
        
        System.out.println("chegou no cadastrar service");
        if (!med.getDose().equals("")) {
            if (med.getIntervalo() != null) {
                if (med.getMoradorCPF() != null) {
                    if (!med.getNome().equals("")) {
                        if (med.getTarja() != null) {
                            if (med.getValidade() != null) {
                                if (med.getValor() != null) {
                                    try {
                                        Boolean ret = DAO.inserir(med);
                                        if(ret == true){System.out.println("sucesso no cadastrar service");
                                        }else{
                                            System.out.println("erro no cadastrar service");
                                        }
                                        return ret;
                                    } catch (Exception e) {
                                        System.out.println("erro no cadastrar service");
                                    }
                                } else {
                                    return false;
                                }
                            } else {
                                return false;
                            }
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return null;
    }

    @Override
    public void atualizar(Medicamento med) {
        DAO.atualizarCondicao(med);
    }
    
    public void atualizar(Medicamento medicamento, LocalDateTime horario){
        if(medicamento != null && horario != null){
        DAO.atualizarHorario(medicamento, horario);
        }else{
            System.out.println("deu null");
        }
        
        }
    
    @Override
    public Boolean excluir(Integer id) {
        boolean ret = DAO.deletar(id);
        return ret;
    }

    @Override
    public Medicamento pesquisar(int id) {
        Medicamento medicamento;
            medicamento = DAO.pesquisar(id);
            return medicamento;
    }

    @Override
    public List<Medicamento> listarMedicamento(String moradorCPF, String condicao) {
        if (!moradorCPF.equals("") && !condicao.equals("")) {
            System.out.println(condicao);
          
            return DAO.listarMedicamento(moradorCPF, condicao);
        } else {
       
            return null;
        }
    }
    

    @Override
    public List<Medicamento> listarTodos() {
        return DAO.listarTodos();
    }
}

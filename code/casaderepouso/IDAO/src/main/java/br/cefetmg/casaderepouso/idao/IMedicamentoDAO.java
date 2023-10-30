/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;

import br.cefetmg.casaderepouso.dto.Medicamento;
import br.cefetmg.casaderepouso.dto.Morador;
import java.util.List;

/**
 *
 * @author felli
 */
public interface IMedicamentoDAO {
    
    public Boolean inserir(Medicamento medicamento);

    public void atualizar(Medicamento medicamento, String morador);

    public Boolean deletar(Medicamento med);

    public List<Medicamento> listarTodos();

    public Medicamento pesquisar(String morador, String medicamento);
    
    public List<Medicamento> MedicamentoMorador(String MoradorCPF);
}

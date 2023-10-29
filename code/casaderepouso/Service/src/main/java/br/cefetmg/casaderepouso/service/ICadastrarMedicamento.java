/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.dto.Medicamento;
import java.util.List;
/**
 *
 * @author felli
 */
public interface ICadastrarMedicamento {
    public Boolean cadastrar(Medicamento med);
    public void atualizar(Medicamento med);
    public Boolean excluir(Medicamento med);
    public Medicamento pesquisar(String morador, String med);
    public List<Medicamento> MedicamentoMorador(String moradorCPF);
    public List<Medicamento> listarTodos();
    
}

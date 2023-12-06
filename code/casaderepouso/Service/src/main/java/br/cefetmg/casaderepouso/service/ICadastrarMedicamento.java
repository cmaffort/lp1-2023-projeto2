/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.dto.Medicamento;
import java.time.LocalDateTime;
import java.util.List;
/**
 *
 * @author felli
 */
public interface ICadastrarMedicamento {
    public Boolean cadastrar(Medicamento med);
    public void atualizar(Medicamento med);
    public void atualizar(Medicamento medicamento, LocalDateTime horario);
    public Boolean excluir(Integer id);
    public Medicamento pesquisar(int Id);
    public List<Medicamento> listarMedicamento(String moradorCPF, String condicao);
    public List<Medicamento> listarTodos();
    
}

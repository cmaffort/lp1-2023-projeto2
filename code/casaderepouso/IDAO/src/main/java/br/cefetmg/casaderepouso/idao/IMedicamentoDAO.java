/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;

import br.cefetmg.casaderepouso.dto.Medicamento;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author felli
 */
public interface IMedicamentoDAO {
    
    public Boolean inserir(Medicamento medicamento);

    public void atualizarCondicao(Medicamento medicamento);
    
    public void atualizarHorario(Medicamento medicamento, LocalDateTime horario);

    public Boolean deletar(int id);

    public List<Medicamento> listarTodos();

    public Medicamento pesquisar(int id);
    
    public List<Medicamento> listarMedicamento(String MoradorCPF, String condicao);
    
}

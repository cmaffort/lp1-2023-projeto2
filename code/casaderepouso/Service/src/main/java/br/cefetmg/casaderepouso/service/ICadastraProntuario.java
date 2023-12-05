/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.Prontuario;
import java.util.List;

/**
 *
 * @author felli
 */
public interface ICadastraProntuario {
    public Boolean cadastrar(Prontuario prontuario);
    public List<Prontuario> listarPorMorador(String moradorCPF);
    public List<Prontuario> listarPorSaude(String MedicoCPF);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.cefetmg.casaderepouso.service;

import br.cefetmg.casaderepouso.dto.ProfissionalSaude;

/**
 *
 * @author felli
 */
public interface ICadastraProfissionalSaude {

    public boolean inserir(ProfissionalSaude profiSaude);

    public Boolean deletar(String cpf);

    public ProfissionalSaude pesquisar(String cpf);
}

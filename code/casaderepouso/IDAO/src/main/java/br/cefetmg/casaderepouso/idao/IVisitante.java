/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.idao;
import br.cefetmg.casaderepouso.dto.Visitante;
import java.util.ArrayList;
/**
 *
 * @author rigor
 */
public interface IVisitante {
    

    public Long inserir(Visitante visitante);

    public String atualizar(Visitante visitante);


}

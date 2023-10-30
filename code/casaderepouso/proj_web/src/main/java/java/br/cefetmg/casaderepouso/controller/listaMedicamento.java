/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package java.br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Medicamento;
import br.cefetmg.casaderepouso.service.ICadastrarMedicamento;
import br.cefetmg.casaderepouso.service.implement.CadastrarMedicamento;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

/**
 *
 * @author felli
 */
public class listaMedicamento{
    
    public static String execute(HttpServletRequest request, String morador) {
    String jsp = "";
    try{
        Medicamento med = new Medicamento();
        ICadastrarMedicamento servico = new CadastrarMedicamento();
        List<Medicamento> listaMedicamentos = servico.MedicamentoMorador(morador);
        
        if(listaMedicamentos != null){
            request.setAttribute("listaMedicamentos", listaMedicamentos);
            jsp = "/GestãoMedicamento.jsp";
        }else{
        String erro = "não existe medicamento";
        request.setAttribute("erro", erro);
        jsp = "/erro.jsp";
        }
    }catch(Exception e){
        e.printStackTrace();
        jsp = "";
    }
        return jsp;
    }
}

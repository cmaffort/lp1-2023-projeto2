/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Medicamento;
import br.cefetmg.casaderepouso.service.implement.CadastrarMedicamento;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author felli
 */
@WebServlet(name = "ExcluirMedicamento", urlPatterns = {"/ExcluirMedicamento"})
public class ExcluirMedicamento extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
    try{
        CadastrarMedicamento servico = new CadastrarMedicamento();
        Integer id = Integer.valueOf(request.getParameter("ID"));
            
            if(servico.excluir(id)){
                System.out.println("medicamento de id:" + id +" foi excluído");
                
            }else{
                System.out.println("Ocorreu algum erro ao exluir o medicamento");
            }
            jsp = "/GestãoMedicamento.jsp";
        
        
    }catch(Exception e){
        
    e.printStackTrace();
    jsp="";
    
    }
        
        
        
    return jsp;
    }
}

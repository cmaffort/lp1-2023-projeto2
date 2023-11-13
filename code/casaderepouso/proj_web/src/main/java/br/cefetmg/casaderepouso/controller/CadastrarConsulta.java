/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Consulta;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.ICadastrarConsulta;
import br.cefetmg.casaderepouso.service.implement.CadastrarConsultaS;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Júlia
 */
@WebServlet(name = "CadastrarConsulta", urlPatterns = {"/CadastrarConsulta"})
public class CadastrarConsulta extends HttpServlet {

    static String execute(HttpServletRequest request) {
        String jsp = "";

        String especialista = request.getParameter("especialista");
        String medico = request.getParameter("medico");
        String tipoConsulta = request.getParameter("tipoConsulta");
        String dataConsulta = request.getParameter("dataConsulta");
        String horaConsulta = request.getParameter("horaConsulta");
        
        Consulta consulta = new Consulta(dataConsulta, horaConsulta, medico, especialista, tipoConsulta);
        
        
        ICadastrarConsulta service = new CadastrarConsultaS();
        try {
            service.cadastrar(consulta);
        } catch (CadastroException ex) {
            System.out.println("Erro" + ex);
        }
        return jsp;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

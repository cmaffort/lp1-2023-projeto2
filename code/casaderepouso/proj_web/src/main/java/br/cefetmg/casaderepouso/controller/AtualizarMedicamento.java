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
@WebServlet(name = "AtualizarMedicamento", urlPatterns = {"/AtualizarMedicamento"})
public class AtualizarMedicamento extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        System.out.println("chegou no servlet");
        String jsp = "";
        CadastrarMedicamento servico = new CadastrarMedicamento();
        try {
            Integer id = Integer.valueOf(request.getParameter("ID"));

            Medicamento med = servico.pesquisar(id);
            
            if (med != null) {
                servico.atualizar(med);
                System.out.println(med.getCondicao().name());
                System.out.println("pegou id:" + id);
                jsp = "/GestãoMedicamento.jsp";
            } else {
                return null;
            }

        } catch (Exception e) {
            System.out.println("erro:");
            e.printStackTrace();
        }

        return jsp;
    }

}

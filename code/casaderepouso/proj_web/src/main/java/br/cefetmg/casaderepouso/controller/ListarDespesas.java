/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Despesas;
import br.cefetmg.casaderepouso.service.ICadastrarDespesas;
import br.cefetmg.casaderepouso.service.implement.CadastrarDespesaS;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author jujua
 */
@WebServlet(name = "ListarDespesas", urlPatterns = {"/ListarDespesas"})
public class ListarDespesas extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "ExibirDespesas.jsp";

        try {
            ICadastrarDespesas IDespesas = new CadastrarDespesaS();
            List<Despesas> lista = IDespesas.listarTodos();
            if (lista != null) {
                request.setAttribute("listDes", lista);
                System.out.println("Controller");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return jsp;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

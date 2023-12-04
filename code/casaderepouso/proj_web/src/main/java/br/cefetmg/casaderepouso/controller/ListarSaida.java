package br.cefetmg.casaderepouso.controller;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.cefetmg.casaderepouso.dto.SaidaTemporaria;
import br.cefetmg.casaderepouso.service.implement.ManterSaida;
import br.cefetmg.casaderepouso.service.IManterSaida;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/ListarSaida"})
public class ListarSaida extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
     
        try {
            IManterSaida iSaida =  new ManterSaida();
            List<SaidaTemporaria> lista = iSaida.pesquisarTodos();
            if (lista != null) {
                request.setAttribute("listSaida", lista);
                jsp = "/gestaoSaida.jsp";
            }
        } catch (Exception e) {
            System.out.println(e);
            jsp = "";
        }
        
        
        return jsp;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

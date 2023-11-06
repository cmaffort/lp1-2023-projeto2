package br.cefetmg.casaderepouso.controller;


import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import br.cefetmg.casaderepouso.dto.Evento;
import br.cefetmg.casaderepouso.service.implement.ManterEvento;
import br.cefetmg.casaderepouso.service.IManterEvento;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/ListarEvento"})
public class ListarEvento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
     
        try {
            IManterEvento iEvent =  new ManterEvento();
            List<Evento> lista = iEvent.pesquisarTodos();
            if (lista != null) {
                request.setAttribute("listEvent", lista);
                jsp = "/telaEvento.jsp";
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

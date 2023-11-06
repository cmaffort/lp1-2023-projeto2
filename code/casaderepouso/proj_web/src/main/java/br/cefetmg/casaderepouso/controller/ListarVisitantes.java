package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Visitante;
import br.cefetmg.casaderepouso.service.ICadastrarVisitante;
import br.cefetmg.casaderepouso.service.implement.CadastrarVisitanteService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/ListarVisitantes"})
public class ListarVisitantes extends HttpServlet {
    public static String execute(HttpServletRequest request) {
        String jsp = "GestaoVisitantes.jsp";
     
        try {
            ICadastrarVisitante IVisitante =  new CadastrarVisitanteService();
            List<Visitante> lista = IVisitante.listarTodos();
            if (lista != null) {
                request.setAttribute("listVis", lista);
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

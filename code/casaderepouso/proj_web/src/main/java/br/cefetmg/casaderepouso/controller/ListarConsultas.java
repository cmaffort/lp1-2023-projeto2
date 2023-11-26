package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Consulta;
import br.cefetmg.casaderepouso.service.ICadastrarConsulta;
import br.cefetmg.casaderepouso.service.implement.CadastrarConsultaS;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.util.List;

@WebServlet(urlPatterns = {"/ListarConsultas"})
public class ListarConsultas extends HttpServlet {
    public static String execute(HttpServletRequest request) {
        String jsp = "consultas.jsp";
     
        try {
            ICadastrarConsulta IConsulta = new CadastrarConsultaS();
            List<Consulta> lista = IConsulta.listarTodos();
            if (lista != null) {
                request.setAttribute("listCons", lista);
                //System.out.println("Controller");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return jsp;
    }
    
}

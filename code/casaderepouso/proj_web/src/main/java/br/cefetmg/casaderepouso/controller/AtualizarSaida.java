package br.cefetmg.casaderepouso.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.casaderepouso.dto.SaidaTemporaria;
import br.cefetmg.casaderepouso.service.IManterSaida;
import br.cefetmg.casaderepouso.service.implement.ManterSaida;


@WebServlet(urlPatterns = {"/AtualizarSaida"})
public class AtualizarSaida extends HttpServlet {

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

            String dataS = request.getParameter("dataSaida");
            String horarioS = request.getParameter("horarioSaida");
            String dataV = request.getParameter("dataVolta");
            String horarioV = request.getParameter("horarioVolta");
            
            String id = request.getParameter("idSaida");
            
            SaidaTemporaria saida = new SaidaTemporaria();
            
            saida.setDataSaida(dataS);
            saida.setHorarioSaida(horarioS);
            saida.setDataVolta(dataV);
            saida.setHorarioVolta(horarioV);
            saida.setId(id);
            
            IManterSaida iSaida = new ManterSaida();
            iSaida.atualizar(saida);
            
            jsp = "/gestaoSaida.jsp";
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

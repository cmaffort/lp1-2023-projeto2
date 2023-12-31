package br.cefetmg.casaderepouso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.service.implement.CadastrarResponsavel;
import br.cefetmg.casaderepouso.service.ICadastrarResponsavel;
import java.util.ArrayList;
import java.util.List;;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "ListarResponsavel", urlPatterns = {"/ListarResponsavel"})
public class ListarResponsavel extends HttpServlet {

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
            CadastrarResponsavel iResponsavel =  new CadastrarResponsavel();
            List<Responsavel> responsaveis =  iResponsavel.listar();
            if (responsaveis != null) {
                request.setAttribute("listResp", responsaveis);
                jsp = "/gestaoResponsavel.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }
        
        
        return jsp;
    }
   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

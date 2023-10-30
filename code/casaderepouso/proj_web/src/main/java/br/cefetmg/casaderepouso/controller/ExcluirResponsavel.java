package java.br.cefetmg.casaderepouso.controller;

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
@WebServlet(name = "ExcluirResponsavel", urlPatterns = {"/ExcluirResponsavel"})
public class ExcluirResponsavel extends HttpServlet {

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
            String id = request.getParameter("id");
            CadastrarResponsavel iResponsavel =  new CadastrarResponsavel();
            Responsavel responsavel = new Responsavel();
            responsavel.setId(id);
            String str = iResponsavel.excluir(responsavel);
            if (str.equals("true")) {
                jsp = "/telaGerente.jsp";
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

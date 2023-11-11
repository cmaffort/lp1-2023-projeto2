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
import br.cefetmg.casaderepouso.dto.Receita;
import br.cefetmg.casaderepouso.service.implement.CadastrarReceita;
import br.cefetmg.casaderepouso.service.ICadastrarReceita;
import java.util.ArrayList;
import java.util.List;;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "ListarReceita", urlPatterns = {"/ListarReceita"})
public class ListarReceita extends HttpServlet {

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
            CadastrarReceita iReceita =  new CadastrarReceita();
            List<Receita> receitas =  iReceita.listar();
            if (receitas != null) {
                request.setAttribute("listReceitas", receitas);
                jsp = "/ListarReceitas.jsp";
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

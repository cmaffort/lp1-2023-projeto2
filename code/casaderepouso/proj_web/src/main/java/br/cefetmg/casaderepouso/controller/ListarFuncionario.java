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
import br.cefetmg.casaderepouso.dto.Funcionario;
import br.cefetmg.casaderepouso.service.implement.ManterFuncionario;
import br.cefetmg.casaderepouso.service.IManterFuncionario;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/ListarFuncionario"})
public class ListarFuncionario extends HttpServlet {

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
            IManterFuncionario iFuncionario =  new ManterFuncionario();
            List<Funcionario> lista = iFuncionario.pesquisarTodos();
            if (lista != null) {
                request.setAttribute("listFunc", lista);
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

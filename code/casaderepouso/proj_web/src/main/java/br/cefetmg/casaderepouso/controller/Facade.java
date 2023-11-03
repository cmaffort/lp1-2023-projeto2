package br.cefetmg.casaderepouso.controller;


import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
@WebServlet(urlPatterns = {"/Facade","/deleteFunc"})
public class Facade extends HttpServlet {
    private String jsp;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String encaminha = request.getServletPath();
        
        String act = request.getParameter("act");
        

        if(act.equals("CadastrarMorador")) {
            jsp = CadastrarMorador.execute(request);
        }
        else if(act.equals("cadastrarFuncionario"))
            jsp = CadastrarFuncionario.execute(request);
        else if(act.equals("listarFuncionario"))
            jsp = ListarFuncionario.execute(request);        
        else if(act.equals("/deleteFunc")){
            jsp = ExcluirFuncionario.execute(request);
            jsp = ListarFuncionario.execute(request);
        }
        else if(act.equals("CadastrarVisitante")){
            jsp = CadastrarVisitante.execute(request);
        }
        else if(act.equals("CadastraMedicamentos")){
            jsp = CadastraMedicamento.execute(request);
        }
        else if(act.equals("ListarVisitante")){
            System.out.println("facade");
            jsp = ListarVisitantes.execute(request);
        }
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Facade</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Facade at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

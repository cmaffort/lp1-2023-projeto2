package java.br.cefetmg.casaderepouso.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
@WebServlet(urlPatterns = {"/Facade","/delete"})
public class Facade extends HttpServlet {
    private String jsp;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String encaminha = request.getServletPath();
        
        String act = request.getParameter("act");
        
        if(act.equals("cadastrarMorador")) {
            jsp = CadastrarMorador.execute(request);
        }
        else if(act.equals("cadastrarFuncionario")){
             jsp = CadastrarFuncionario.execute(request);
        }
        else if(act.equals("CadastraMedicamento")){
             jsp = CadastraMedicamento.execute(request);
        }
        
        
        
        
        else if(act.equals("cadastrarFuncionario"))
            jsp = CadastrarFuncionario.execute(request);
        else if(act.equals("listarFuncionario"))
            jsp = ListarFuncionario.execute(request);
        else if(encaminha.equals("/delete"))
            jsp = ExcluirFuncionario.execute(request);
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
}

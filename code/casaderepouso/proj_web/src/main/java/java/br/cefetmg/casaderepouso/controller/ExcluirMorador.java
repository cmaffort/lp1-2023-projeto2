/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java.br.cefetmg.casaderepouso.controller;

/**
 *
 * @author Aluno
 */
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
import br.cefetmg.casaderepouso.dto.Morador;
import br.cefetmg.casaderepouso.service.implement.CadastrarMorador;
import br.cefetmg.casaderepouso.service.ICadastrarMorador;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/ExcluirFuncionario"})
public class ExcluirMorador extends HttpServlet {

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
            String cpf = request.getParameter("cpf");
            ICadastrarMorador iMorador =  new CadastrarMorador();
            Morador mor = new Morador();
            mor.setCpf(cpf);
            String str = iMorador.excluir(mor);
            if (str.equals("true")) {
                jsp = "/telaFuncionario.jsp";
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


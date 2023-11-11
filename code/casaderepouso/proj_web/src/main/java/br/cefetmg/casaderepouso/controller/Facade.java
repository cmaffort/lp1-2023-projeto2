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
        else if(act.equals("ListarMorador")) {
            jsp = ListarMorador.execute(request);
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
        else if(act.equals("listarVisitante")){
            jsp = ListarVisitantes.execute(request);
        }
        else if(act.equals("AgendarConsulta")){
            jsp = CadastrarConsulta.execute(request);
        }
        
        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

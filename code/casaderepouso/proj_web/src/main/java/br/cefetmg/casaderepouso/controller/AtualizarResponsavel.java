
package br.cefetmg.casaderepouso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.service.implement.CadastrarResponsavel;
import br.cefetmg.casaderepouso.service.ICadastrarResponsavel;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "AtualizarResponsavel", urlPatterns = {"/AtualizarResponsavel"})
public class AtualizarResponsavel extends HttpServlet {

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

            String nome = request.getParameter("nomeResponsavel");
            String cpf = request.getParameter("cpf");
            String rg = request.getParameter("rg");
            String telefone = request.getParameter("telefone");
            String endereco = request.getParameter("endereco");
            String responsavelPor = request.getParameter("responsavelPor");
            
            Responsavel responsavel = new Responsavel();
            
            responsavel.setNome(nome);
            responsavel.setRg(rg);
            responsavel.setCpf(cpf);
            responsavel.setTelefone(telefone);
            responsavel.setEndereco(endereco);
            responsavel.setResponsavelPor(responsavelPor);
                    
            ICadastrarResponsavel iResponsavel = new CadastrarResponsavel();
            iResponsavel.atualizar(responsavel);
            
            jsp = "/gestaoResponsavel.jsp";
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

package java.br.cefetmg.casaderepouso.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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


@WebServlet(urlPatterns = {"/CadastrarMorador"})
public class CadastrarMorador extends HttpServlet {

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

            String nome = request.getParameter("nomeMorador");
            String cpf = request.getParameter("cpf");

            String dataStr = request.getParameter("dataNasc");
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNasc = formatter.parse(dataStr);
            
            
            String nomeMae = request.getParameter("nome_mae");
            String endereco = request.getParameter("endereco");
            String condicoes = request.getParameter("condicoes_especiais");
            
            Morador morador = new Morador();
            
            morador.setNome(nome);
            morador.setNomeMae(nomeMae);
            morador.setCpf(cpf);
            morador.setDataNasc(dataNasc);
            morador.setEndereco(endereco);
            morador.setCondicaoEspecial(condicoes);
            
            
            
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

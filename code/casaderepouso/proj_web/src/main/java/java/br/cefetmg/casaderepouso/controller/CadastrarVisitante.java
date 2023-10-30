/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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
import br.cefetmg.casaderepouso.dto.Visitante;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "CadastrarVisitante", urlPatterns = {"/CadastrarVisitante"})
public class CadastrarVisitante extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
     
        try {

            String nome = request.getParameter("nomeVisitante");
            String rg = request.getParameter("identidade");
            String telefone = request.getParameter("telefone");
            String vinculo = request.getParameter("vinculo");
            String morador = request.getParameter("morador");
            
            String dataStr = request.getParameter("dataVisita");
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dataVisita = formatter.parse(dataStr);
            
            Visitante visitante = new Visitante();
            
            visitante.setNome(nome);
            visitante.setRg (rg);
            visitante.setTelefone(telefone);
            visitante.setVinculo(vinculo);
            visitante.setMorador(morador);
            visitante.setDataVisita(dataVisita);
              
            
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
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;


import br.cefetmg.casaderepouso.DAO.VisitanteDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import br.cefetmg.casaderepouso.dto.Visitante;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.ICadastrarVisitante;
import br.cefetmg.casaderepouso.service.implement.CadastrarVisitanteService;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "CadastrarVisitante", urlPatterns = {"/CadastrarVisitante"})
public class CadastrarVisitante extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
     
        String nome = request.getParameter("nomeVisitante");
        String rg = request.getParameter("identidade");
        String telefone = request.getParameter("telefone");
        String vinculo = request.getParameter("vinculo");
        String morador = request.getParameter("morador");
        String dataStr = request.getParameter("dataVisita");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Visitante visitante = new Visitante();
        visitante.setNome(nome);
        visitante.setRg (rg);
        visitante.setTelefone(telefone);
        visitante.setVinculo(vinculo);
        visitante.setMorador(morador);
        
        System.out.println("Controller");
        
        ICadastrarVisitante service = new CadastrarVisitanteService();
        try {
            service.cadastrar(visitante);
        } catch (CadastroException ex) {
            System.out.println("Erro" + ex);
        }
        
        
        
        return jsp;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
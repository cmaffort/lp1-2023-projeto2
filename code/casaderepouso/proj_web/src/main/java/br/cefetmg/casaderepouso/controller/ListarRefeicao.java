/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
import br.cefetmg.casaderepouso.dto.Refeicao;
import br.cefetmg.casaderepouso.service.implement.ManterRefeicao;
import java.util.ArrayList;
import java.util.List;
import br.cefetmg.casaderepouso.service.IManterRefeicao;
/**
 *
 * @author Master
 */
@WebServlet(urlPatterns = {"/ListarRefeicao"})
public class ListarRefeicao extends HttpServlet {

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
            IManterRefeicao iRefeicao =  new ManterRefeicao();
            List<Refeicao> lista = iRefeicao.pesquisarTodos();
            if (lista != null) {
                request.setAttribute("listRef", lista);
                jsp = "/prontuario.jsp";
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
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import java.sql.SQLException;
import java.text.ParseException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.cefetmg.casaderepouso.dto.Equipamento;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.ICadastrarEquipamento;
import br.cefetmg.casaderepouso.service.implement.CadastrarEquipamento;;

/**
 *
 * @author Particular
 */
@WebServlet(name = "ExcluirEquipamento", urlPatterns = {"/ExcluirEquipamento"})
public class ExcluirEquipamento extends HttpServlet {

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
            String id = request.getParameter("equipamentoDelete");
            CadastrarEquipamento iEquipamento =  new CadastrarEquipamento();
            Equipamento equipamento = new Equipamento();
            equipamento.setId(id);
            String str = iEquipamento.excluir(equipamento);
            if (str.equals("true")) {
                jsp = "/inventario.jsp";
            }
        } catch (Exception e) {
            System.out.println(e);
            jsp = "";
        }
        
        
        return jsp;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}

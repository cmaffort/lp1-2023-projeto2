/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Medicamento;
import br.cefetmg.casaderepouso.service.implement.CadastrarMedicamento;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author felli
 */
@WebServlet(name = "AtualizaHorarioMedicamento", urlPatterns = {"/AtualizaHorarioMedicamento"})
public class AtualizaHorarioMedicamento extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        System.out.println("chegou no servlet");
        String jsp = "";
        CadastrarMedicamento servico = new CadastrarMedicamento();

        try {
            String horaStr = request.getParameter("novaAplicacao");

     
            if (!horaStr.equals("")) {

                DateTimeFormatter formata = DateTimeFormatter.ofPattern("HH:mm");
            

                LocalTime hora = LocalTime.parse(horaStr, formata);
           

                LocalDateTime DataHora = LocalDateTime.of(LocalDate.now(), hora);
            

                Integer id = Integer.valueOf(request.getParameter("medicamento"));
    
                Medicamento medicamento = servico.pesquisar(id);
               

                servico.atualizar(medicamento, DataHora);
          
                jsp = "/CadastroProntuario.jsp";
            } else {
                jsp = "/CadastroProntuario.jsp";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            jsp = "";
        }

        return jsp;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AtualizaHorarioMedicamento</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AtualizaHorarioMedicamento at " + request.getContextPath() + "</h1>");
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.service.implement.CadastraProntuario;
import br.cefetmg.casaderepouso.dto.Prontuario;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Date;
import java.time.LocalDate;

/**
 *
 * @author felli
 */
@WebServlet(name = "CadastraProntuario", urlPatterns = {"/CadastraProntuario"})
public class CadastroProntuario extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
        
            HttpSession session = request.getSession();
            String ProfSaude = (String) session.getAttribute("cpfFuncionario");
            
            
            Prontuario pront = new Prontuario();
            CadastraProntuario service = new CadastraProntuario();

            
            pront.setProfSaudeCPF(ProfSaude);

            String morador = request.getParameter("morador");
            pront.setMoradorCPF(morador);

            String pressao = request.getParameter("pressao");
            pront.setPressao(pressao);

            String Cardiaca = request.getParameter("FreCardiaca");
            pront.setFrequenciaCardiaca(Cardiaca);

            String Respiratoria = request.getParameter("FreRespiratoria");
            pront.setFrequenciaRespiratoria(Respiratoria);

            String temperatura = request.getParameter("temperatura");
            pront.setTemperatura(temperatura);

            String Obsrefeicao = request.getParameter("ObsRefeicao");
            pront.setObservacaoRefeicao(Obsrefeicao);

            String ObsMedicamento = request.getParameter("ObsMedicamento");
            pront.setObservacoes(ObsMedicamento);

            LocalDate dataAtual = LocalDate.now();
            Date datahoje = Date.valueOf(dataAtual);

            pront.setData(datahoje);

            System.out.println("settou os dados");
            try {
                System.out.println("entrou no try");
                jsp = "/CadastroProntuario.jsp";
                service.cadastrar(pront);
                System.out.println("cadastrou");
            } catch (Exception e) {
                System.out.println("erro ao cadastrar");
                System.out.println(e);
            }

        } catch (Exception e) {
            
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
            out.println("<title>Servlet CadastraProntuario</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastraProntuario at " + request.getContextPath() + "</h1>");
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

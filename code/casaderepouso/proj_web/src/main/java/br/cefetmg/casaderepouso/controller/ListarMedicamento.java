/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Medicamento;
import br.cefetmg.casaderepouso.service.implement.CadastrarMedicamento;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author felli
 */
@WebServlet(name = "ListarMedicamento", urlPatterns = {"/ListarMedicamento"})
public class ListarMedicamento extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        String origem = request.getParameter("origem");
        System.out.println(origem+ "\n\n");
        if (origem.contains("GestaoMedicamento")) {
            System.out.println(origem);
            jsp = "/GestãoMedicamento.jsp";
        } else if (origem.contains("Prontuario")) {
            jsp = "/CadastroProntuario.jsp";
            System.out.println(origem);
        }

        try {
            CadastrarMedicamento servico = new CadastrarMedicamento();
            String moradorCPF = request.getParameter("moradorCPF");
            System.out.println("cpf:" + moradorCPF);
            String STRsolicitados = "SOLICITADO";
            String STRcomprado = "COMPRADO";

            List<Medicamento> solicitado = servico.listarMedicamento(moradorCPF, STRsolicitados);
            List<Medicamento> comprado = servico.listarMedicamento(moradorCPF, STRcomprado);

            if (solicitado != null || comprado != null) {

                request.setAttribute("solicitado", solicitado);
                System.out.println("solicitado");
                System.out.println("tamanho solicitado " + solicitado.size());

                request.setAttribute("comprado", comprado);
                System.out.println("comprado");
                System.out.println("tamanho comprado " + comprado.size());

            } else {
                System.out.println("não achou medicamentos");

            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("deu erro:" + e);
            jsp = "ouve alguma Exceção";
        }

        return jsp;
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

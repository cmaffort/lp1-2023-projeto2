/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.ProfissionalSaude;
import br.cefetmg.casaderepouso.service.implement.CadastraProfissionalSaude;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author felli
 */
@WebServlet(name = "CadastraProfSaude", urlPatterns = {"/CadastraProfSaude"})
public class CadastraProfSaude extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        System.out.println("chegou servlet");
        String jsp = "";
        try {
            CadastraProfissionalSaude servico = new CadastraProfissionalSaude();
            ProfissionalSaude saude = new ProfissionalSaude();
            System.out.println("crio variaveis 1");

            
            String nome = request.getParameter("nome");
            String cpf = request.getParameter("cpf");
            String registro = request.getParameter("registro");
            saude.setNome(nome);
            saude.setCpf(cpf);
            saude.setRegistro(registro);
            System.out.println("crio variaveis 2");
            String especializacao = request.getParameter("especializacao");
            

            switch (especializacao) {
                case "MEDICO":
                    saude.setEspecializacao(ProfissionalSaude.Especializacao.MEDICO);
                    break;
                case "NUTRICIONISTA":
                    saude.setEspecializacao(ProfissionalSaude.Especializacao.NUTRICIONISTA);
                    break;
                case "ENFERMEIRO":
                    saude.setEspecializacao(ProfissionalSaude.Especializacao.ENFERMEIRO);
                    break;
            }
           System.out.println("pegou especialização");
            System.out.println(especializacao);
            
            try{
                if(servico.inserir(saude)){
                    System.out.println("true no metodo inserir");
                }else{
                System.out.println("false no metodo inserir");
                return jsp = "/CadastroProfSaude.jsp";
                      
                }
                
                System.out.println("inseriu");
                jsp = "/CadastroProfSaude.jsp";
            }catch(Exception e){
                
                System.out.println(e);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return jsp;
    }
        /**
         * Processes requests for both HTTP <code>GET</code> and
         * <code>POST</code> methods.
         *
         * @param request servlet request
         * @param response servlet response
         * @throws ServletException if a servlet-specific error occurs
         * @throws IOException if an I/O error occurs
         */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastraProfSaude</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastraProfSaude at " + request.getContextPath() + "</h1>");
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

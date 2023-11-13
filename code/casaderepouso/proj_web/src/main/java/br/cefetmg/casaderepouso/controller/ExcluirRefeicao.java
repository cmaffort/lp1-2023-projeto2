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
import br.cefetmg.casaderepouso.service.IManterRefeicao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Master
 */
@WebServlet(urlPatterns = {"/ExcluirRefeicao"})
public class ExcluirRefeicao extends HttpServlet {

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
            String cpf = request.getParameter("cpfDelete");
            String hora = request.getParameter("horaDelete");
            String cardapio = request.getParameter("cardapioDelete");
            String tipo = request.getParameter("tipoDelete");
            String dia = request.getParameter("diaDelete");
            IManterRefeicao iRefeicao =  new ManterRefeicao();
            Refeicao ref = new Refeicao();
            ref.setCpfMorador(cpf);
            ref.setHora(hora);
            ref.setCardapio(cardapio);
            ref.setTipo(tipo);
            ref.setDia(dia);
            String str = iRefeicao.excluir(ref);
            if (str.equals("true")) {
                jsp = "/dieta.jsp";
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
    }// </editor-fold>

}

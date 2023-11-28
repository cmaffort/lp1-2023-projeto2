/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

/**
 *
 * @author Master
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
import br.cefetmg.casaderepouso.dto.Cartao;
import br.cefetmg.casaderepouso.service.implement.ManterCartao;
import br.cefetmg.casaderepouso.service.IManterCartao;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "CadastrarCartao", urlPatterns = {"/CadastrarCartao"})
public class CadastrarCartao extends HttpServlet {
    
    public static String execute(HttpServletRequest request){
        String jsp = "/TelaInicalResponsavel.jsp"; 
    
            String numero = request.getParameter("numero");
            String nome = request.getParameter("nome");
            String validade = request.getParameter("validade");
            String cpf = request.getParameter("cpf");
            String cardtype = request.getParameter("cardtype");
                
            
            Cartao cartao = new Cartao(cpf,numero,nome,validade,cardtype);
            
            System.out.println("Controller");

            IManterCartao iCartao = new ManterCartao();
            try {
                iCartao.cadastrar(cartao); 
            } catch (CadastroException ex) {
                System.out.println("Erro" + ex);
            }
        return jsp;
    }
    @Override
    public String getServletInfo(){
        return "Short description";
    }// </editor-fold>
}
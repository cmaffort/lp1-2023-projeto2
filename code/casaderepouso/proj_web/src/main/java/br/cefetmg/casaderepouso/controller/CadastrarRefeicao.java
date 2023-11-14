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
import br.cefetmg.casaderepouso.dto.Refeicao;
import br.cefetmg.casaderepouso.service.implement.ManterRefeicao;
import br.cefetmg.casaderepouso.service.IManterRefeicao;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "CadastrarRefeicao", urlPatterns = {"/CadastrarRefeicao"})
public class CadastrarRefeicao extends HttpServlet {
    
    public static String execute(HttpServletRequest request){
        String jsp = "/dieta.jsp"; 
    
            String cpf = request.getParameter("cpf");
            String hora = request.getParameter("hora");
            String dia = request.getParameter("dia");
            String tipo = request.getParameter("tipo");
            String cardapio = request.getParameter("cardapio");
            
            
            Refeicao refeicao = new Refeicao(cpf,hora,cardapio,tipo,dia);
            
            System.out.println("Controller");

            IManterRefeicao iRefeicao = new ManterRefeicao();
            try {
                iRefeicao.cadastrar(refeicao); 
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

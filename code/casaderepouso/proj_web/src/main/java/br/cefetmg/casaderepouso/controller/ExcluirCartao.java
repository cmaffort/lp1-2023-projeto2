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
import br.cefetmg.casaderepouso.dto.Cartao;
import br.cefetmg.casaderepouso.service.implement.ManterCartao;
import java.util.ArrayList;
import java.util.List;
import br.cefetmg.casaderepouso.service.IManterCartao;

@WebServlet(urlPatterns = {"/ExcluirCartao"})
public class ExcluirCartao extends HttpServlet {
    public static String execute(HttpServletRequest request) {
        String jsp = "";
     
        try {
            String cpf = request.getParameter("cpf");
            IManterCartao iCartao =  new ManterCartao();
            Cartao car = new Cartao();
            car.setCpf(cpf);
            String str = iCartao.excluir(car);
            if (str.equals("true")) {
                jsp = "/pagamento.jsp";
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
    }// </editor-fold>

}

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
/**
 *
 * @author Master
 */
@WebServlet(urlPatterns = {"/ListarCartao"})
public class ListarCartao extends HttpServlet {    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
     
        try {
            IManterCartao iCartao =  new ManterCartao();
            List<Cartao> lista = iCartao.pesquisarTodos();
            if (lista != null) {
                request.setAttribute("listCar", lista);
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
    }
}
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
import br.cefetmg.casaderepouso.service.implement.CadastrarEquipamento;
/**
 *
 * @author Particular
 */
@WebServlet(name = "CadastraEquipamento", urlPatterns = {"/CadastraEquipamento"})
public class CadastraEquipamento extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
        try{
            String nome = request.getParameter("tipoEquipamento");
            String preco = request.getParameter("preco");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));         
            String estado = request.getParameter("estado");
            
            Equipamento equipamento = new Equipamento();
            
            equipamento.setTipo(nome);
            equipamento.setPreco(preco);
            equipamento.setQuantidade(quantidade);
            equipamento.setEstado(estado);
            
            ICadastrarEquipamento iEquipamento = new CadastrarEquipamento();
            iEquipamento.cadastrar(equipamento);
            
            jsp = "/equipamentos.jsp";
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

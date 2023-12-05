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
import br.cefetmg.casaderepouso.dto.Receita;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.ICadastrarReceita;
import br.cefetmg.casaderepouso.service.implement.CadastrarReceita;


@WebServlet(urlPatterns = {"/AtualizarReceita"})
public class AtualizarReceita extends HttpServlet {

    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
        try{
            String profissionalSaude = request.getParameter("nomeProfissional");
            String morador = request.getParameter("morador");
            String medicamentos = request.getParameter("medicamentos");         
            String data = request.getParameter("data");
            String hora = request.getParameter("hora");
            String quantidade = request.getParameter("quantidade");
            String validade = request.getParameter("validade");
            String id = request.getParameter("id");
            
            Receita receita = new Receita();
            
            receita.setProfissionalSaude(profissionalSaude);
            receita.setMorador(morador);
            receita.setMedicamentos(medicamentos);
            receita.setData(data);
            receita.setHora(hora);
            receita.setQuantidade(quantidade);
            receita.setValidade(validade);
            receita.setId(id);
            
            ICadastrarReceita iReceita = new CadastrarReceita();
            iReceita.atualizar(receita);
            
            jsp = "/ListarReceitas.jsp";
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
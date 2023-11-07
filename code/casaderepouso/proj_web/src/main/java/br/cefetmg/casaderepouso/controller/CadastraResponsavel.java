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
import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.ICadastrarResponsavel;
import br.cefetmg.casaderepouso.service.implement.CadastrarResponsavel;


@WebServlet(urlPatterns = {"/CadastraResponsavel"})
public class CadastraResponsavel extends HttpServlet {

    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        
        try{
            String nome = request.getParameter("nomeResponsavel");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");         
            String endereco = request.getParameter("endereco");
            String telefone = request.getParameter("telefone");
            String responsavelPor = request.getParameter("responsavelPor");
            
            Responsavel responsavel = new Responsavel();
            
            responsavel.setNome(nome);
            responsavel.setRg(rg);
            responsavel.setCpf(cpf);
            responsavel.setEndereco(endereco);
            responsavel.setTelefone(telefone);
            responsavel.setResponsavelPor(responsavelPor);
            
            String id = responsavel.getCpf() + responsavel.getNome().charAt(0);
            responsavel.setId(id);
            ICadastrarResponsavel iResponsavel = new CadastrarResponsavel();
            iResponsavel.cadastrar(responsavel);
            
            jsp = "/gestaoResponsavel.jsp";
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
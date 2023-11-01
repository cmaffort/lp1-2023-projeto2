package br.cefetmg.casaderepouso.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
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
import br.cefetmg.casaderepouso.dto.Morador;
import br.cefetmg.casaderepouso.service.implement.ManterMorador;
import br.cefetmg.casaderepouso.service.IManterMorador;
import br.cefetmg.casaderepouso.dto.exception.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


@WebServlet(name = "CadastrarMorador", urlPatterns = {"/CadastrarMorador"})
public class CadastrarMorador extends HttpServlet {
    
    public static String execute(HttpServletRequest request){
        String jsp = "/CadastroMorador.jsp"; 
    
            String nome = request.getParameter("nomeMorador");
            String cpf = request.getParameter("cpf");

            String dataStr = request.getParameter("dataNasc");
            String planoMedico = request.getParameter("plano_medico");
            String nomeMae = request.getParameter("nome_mae");
            String endereco = request.getParameter("endereco");
            String condicoes = request.getParameter("condicoes_especiais");
            
            Morador morador = new Morador();
            
            morador.setNome(nome);
            morador.setNomeMae(nomeMae);
            morador.setCpf(cpf);
            morador.setPlanoMedico(planoMedico);
            morador.setDataNasc(dataStr);
            morador.setEndereco(endereco);
            morador.setCondicaoEspecial(condicoes);
            
            System.out.println("Controller");

            IManterMorador iMorador = new ManterMorador();
            try {
                iMorador.cadastrar(morador);
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Mensalidade;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.IManterMensalidade;
import br.cefetmg.casaderepouso.service.implement.ManterMensalidade;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Master
 */
@WebServlet(name = "EfetuarPagamento", urlPatterns = {"/EfetuarPagamento"})
public class EfetuarPagamento extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "/TelaInicialResponsavel.jsp";


        String cpfResponsavel = request.getParameter("cpf");
        String cpfMorador = request.getParameter("cpfMorador");
        String inicio = request.getParameter("inicio");
        String fim = request.getParameter("fim");


        Mensalidade mensalidade = new Mensalidade();
        mensalidade.setCpfMorador(cpfMorador);
        mensalidade.setCpfResponsavel(cpfResponsavel);
        mensalidade.setInicio(inicio);
        mensalidade.setFim(fim);
        
        IManterMensalidade iMensalidade = new ManterMensalidade();
        try {
            iMensalidade.atualizar(mensalidade);
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
        }
        return jsp;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}


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

import br.cefetmg.casaderepouso.dto.Despesas;
import br.cefetmg.casaderepouso.service.ICadastrarDespesas;
import br.cefetmg.casaderepouso.service.implement.CadastrarDespesaS;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        String preco = request.getParameter("preco");
        Mensalidade mensalidade = new Mensalidade();
        mensalidade.setCpfMorador(cpfMorador);
        mensalidade.setCpfResponsavel(cpfResponsavel);
        mensalidade.setInicio(inicio);
        mensalidade.setFim(fim);

        LocalDate dataAtual = LocalDate.now();
        String dataFormatada = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime horarioAtual = LocalTime.now();
        String horarioFormatado = horarioAtual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));


        Despesas pagamento = new Despesas("Gerente", cpfResponsavel, null, cpfMorador, "Pagamento mensalidade do " + cpfMorador + " por " + cpfResponsavel, preco,dataFormatada,horarioFormatado);
        ICadastrarDespesas iDespesas = new CadastrarDespesaS();
        IManterMensalidade iMensalidade = new ManterMensalidade();
        try {
            iMensalidade.atualizar(mensalidade);
            iDespesas.cadastrar(pagamento);
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

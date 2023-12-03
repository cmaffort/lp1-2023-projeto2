package br.cefetmg.casaderepouso.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import br.cefetmg.casaderepouso.dto.Atualizacao;
import br.cefetmg.casaderepouso.dto.Mensalidade;
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
import br.cefetmg.casaderepouso.service.IManterAtualizacao;
import br.cefetmg.casaderepouso.service.IManterMensalidade;
import br.cefetmg.casaderepouso.service.implement.ManterAtualizacao;
import br.cefetmg.casaderepouso.service.implement.ManterMensalidade;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CadastrarMorador", urlPatterns = {"/CadastrarMorador"})
public class CadastrarMorador extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "/telaFuncionario.jsp";
        try {
            String nome = request.getParameter("nomeMorador");
            String cpf = request.getParameter("cpf");
            String responsavel = request.getParameter("responsavel");
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
            morador.setResponsaveis(responsavel);
            morador.setDataNasc(dataStr);
            morador.setEndereco(endereco);
            morador.setCondicaoEspecial(condicoes);

            System.out.println("Controller");

            Atualizacao atualizacao = new Atualizacao();
            atualizacao.setCpf(cpf);

            LocalDate dataAtual = LocalDate.now();
            String dataFormatada = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalTime horarioAtual = LocalTime.now();
            String horarioFormatado = horarioAtual.format(DateTimeFormatter.ofPattern("HH:mm"));
            atualizacao.setMomento(dataFormatada + " " + horarioFormatado);

            String dados = "Nome:" + nome + "\nResponsável:" + responsavel + "\nNomeMae:" + nomeMae + "\nEstado:" + "disponível" + "\nPlano:" + planoMedico + "\nNascimento:" + dataStr + "\nEndereço:" + endereco + "\nCondições:" + condicoes;
            atualizacao.setDados(dados);
            IManterAtualizacao iAtualizacao = new ManterAtualizacao();

            IManterMorador iMorador = new ManterMorador();

            IManterMensalidade iMensalidade = new ManterMensalidade();
            if (iMensalidade.pesquisar(cpf) == null) {
                Mensalidade mensalidade = new Mensalidade(cpf, responsavel, null, null);
                iMensalidade.cadastrar(mensalidade);
            }

            iMorador.cadastrar(morador);
            iAtualizacao.cadastrar(atualizacao);
        } catch (CadastroException ex) {
            System.out.println("Erro" + ex);
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

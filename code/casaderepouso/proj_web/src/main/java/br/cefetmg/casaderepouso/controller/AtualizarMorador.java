/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Morador;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.IManterMorador;
import br.cefetmg.casaderepouso.service.implement.ManterMorador;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import br.cefetmg.casaderepouso.dto.Atualizacao;
import br.cefetmg.casaderepouso.service.IManterAtualizacao;
import br.cefetmg.casaderepouso.service.implement.ManterAtualizacao;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Master
 */
@WebServlet(name = "AtualizarMorador", urlPatterns = {"/AtualizarMorador"})
public class AtualizarMorador extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "/telaFuncionario.jsp";

        String nome = request.getParameter("nomeMorador");
        String cpf = request.getParameter("cpf");
        String estado = request.getParameter("estado");
        String dataStr = request.getParameter("dataNasc");
        String planoMedico = request.getParameter("plano_medico");
        String nomeMae = request.getParameter("nome_mae");
        String responsavel = request.getParameter("responsavel");
        String endereco = request.getParameter("endereco");
        String condicoes = request.getParameter("condicoes_especiais");

        Morador morador = new Morador();

        morador.setNome(nome);
        morador.setNomeMae(nomeMae);
        morador.setCpf(cpf);
        morador.setResponsaveis(responsavel);
        morador.setEstado(estado);
        morador.setPlanoMedico(planoMedico);
        morador.setDataNasc(dataStr);
        morador.setEndereco(endereco);
        morador.setCondicaoEspecial(condicoes);

        Atualizacao atualizacao = new Atualizacao();
        atualizacao.setCpf(cpf);
        
        LocalDate dataAtual = LocalDate.now();
        String dataFormatada = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalTime horarioAtual = LocalTime.now();
        String horarioFormatado = horarioAtual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
        atualizacao.setMomento(dataFormatada +" " + horarioFormatado);
        
        String dados = "Nome: " + nome + "\nNome da Mae: " + nomeMae + "\nEstado: " + estado + "\nPlano-médico: " + planoMedico + "\nNascimento: " + dataStr + "\nEndereço: " + endereco + "\nCondições: " + condicoes + "\nCPF-responsável: " + responsavel;
        atualizacao.setDados(dados);

        IManterAtualizacao iAtualizacao = new ManterAtualizacao();
        IManterMorador iMorador = new ManterMorador();
        try {
            iMorador.atualizar(morador);
            iAtualizacao.cadastrar(atualizacao);
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

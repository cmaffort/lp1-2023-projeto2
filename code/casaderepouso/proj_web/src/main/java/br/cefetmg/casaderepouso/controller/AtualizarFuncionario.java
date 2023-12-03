/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Atualizacao;
import br.cefetmg.casaderepouso.dto.Funcionario;

import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.IManterAtualizacao;
import br.cefetmg.casaderepouso.service.IManterFuncionario;
import br.cefetmg.casaderepouso.service.implement.ManterAtualizacao;

import br.cefetmg.casaderepouso.service.implement.ManterFuncionario;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Master
 */
@WebServlet(name = "AtualizarFuncionario", urlPatterns = {"/AtualizarFuncionario"})
public class AtualizarFuncionario extends HttpServlet {
    
    public static String execute(HttpServletRequest request){
        String jsp = "";
     
        try {

            String nome = request.getParameter("nomeFuncionario");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");
            
            String nasc = request.getParameter("dataNasc");
            
           
            
            
            String pis = request.getParameter("pis");
            String endereco = request.getParameter("endereco");
            String fone = request.getParameter("telefone");
           
            String periodo = request.getParameter("periodo");
            String id = request.getParameter("idFuncionario");
            
            Funcionario func = new Funcionario();
            
            func.setNome(nome);
            func.setRg(rg);
            func.setCpf(cpf);
            func.setDataNasc(nasc);
            func.setPis(pis);
            func.setEndereco(endereco);
            func.setFone(fone);
          
            func.setPeriodoTrabalho(periodo);

            func.setId(id);
            
            IManterFuncionario iFuncionario = new ManterFuncionario();
            iFuncionario.atualizar(func);
            
            Atualizacao atualizacao = new Atualizacao();
            atualizacao.setCpf(cpf);

            LocalDate dataAtual = LocalDate.now();
            String dataFormatada = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalTime horarioAtual = LocalTime.now();
            String horarioFormatado = horarioAtual.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            atualizacao.setMomento(dataFormatada + " " + horarioFormatado);

            String dados = "Nome: " + nome + "\nRg: " + rg + "\nCpf: " + cpf + "\nNascimento: " + nasc + "\nPis: " + pis + "\nEndereço: " + endereco + "\nFone: " + fone + "\nFunção: "+ "Padrão " + "\nPeríodo: " + periodo;
            atualizacao.setDados(dados);
            
            IManterAtualizacao iAtualizacao = new ManterAtualizacao();
            iAtualizacao.cadastrar(atualizacao);
            
            jsp = "/telaGerente.jsp";
        } catch (Exception e) {
            System.out.println(e);
            jsp = "";
        }
        
        return jsp;
    }
    @Override
    public String getServletInfo(){
        return "Short description";
    }// </editor-fold>
}
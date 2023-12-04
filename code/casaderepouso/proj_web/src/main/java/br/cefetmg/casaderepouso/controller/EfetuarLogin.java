/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Funcionario;
import br.cefetmg.casaderepouso.dto.Responsavel;
import br.cefetmg.casaderepouso.service.IManterFuncionario;
import br.cefetmg.casaderepouso.service.ICadastrarResponsavel;
import br.cefetmg.casaderepouso.service.implement.ManterFuncionario;
import br.cefetmg.casaderepouso.service.implement.CadastrarResponsavel;
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
@WebServlet(name = "EfetuarLogin", urlPatterns = {"/EfetuarLogin"})
public class EfetuarLogin extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "index.jsp";
        
        try {
            IManterFuncionario iFuncionario = new ManterFuncionario();
            ICadastrarResponsavel iResponsavel = new CadastrarResponsavel();
            String cpf = request.getParameter("cpf");
            String senha = request.getParameter("senha");
            Responsavel responsavel = iResponsavel.pesquisar(cpf);
            Funcionario funcionario = iFuncionario.pesquisar(cpf);
            if(responsavel != null){
                if(responsavel.getSenha().equals(senha)){
                    jsp = "TelaInicialResponsavel.jsp";
                }
            }
            if(funcionario != null){
                if(funcionario.getSenha().equals(senha)){
                    if(funcionario.getFuncao().equals("Gerente")){
                        jsp = "telaGerente.jsp";
                    }
                    if(funcionario.getFuncao().equals("Funcionario Da Casa") || funcionario.getFuncao().equals("Nutricionista") || funcionario.getFuncao().equals("Medico")){
                        jsp = "telaFuncionario.jsp";
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println("Erro" + ex);
            System.out.println("erroERRO");
        }
        return jsp;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}

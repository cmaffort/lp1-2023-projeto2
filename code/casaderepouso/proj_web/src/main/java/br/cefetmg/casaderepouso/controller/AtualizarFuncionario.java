/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Funcionario;

import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.IManterFuncionario;

import br.cefetmg.casaderepouso.service.implement.ManterFuncionario;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

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
            String senha = request.getParameter("senha");
            String nasc = request.getParameter("dataNasc");
            String funcao = request.getParameter("funcao");
           
            
            
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
            func.setSenha(senha);
            func.setPeriodoTrabalho(periodo);
            func.setFuncao(funcao);
            func.setId(id);
            
            IManterFuncionario iFuncionario = new ManterFuncionario();
            iFuncionario.atualizar(func);
            
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
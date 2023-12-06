/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Comodo;
import br.cefetmg.casaderepouso.service.implement.CadastraComodo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author felli
 */
@WebServlet(name = "CadastrarComodo", urlPatterns = {"/CadastrarComodo"})
public class CadastrarComodo extends HttpServlet {
 
    
    public static String execute(HttpServletRequest request) {
        
        String jsp = "";
        try {
           Comodo comodo = new Comodo();
           CadastraComodo servico = new CadastraComodo();
            
           String nome = request.getParameter("nome");
           comodo.setNome(nome);
            
           int capacidade = Integer.parseInt(request.getParameter("capacidade"));
           comodo.setCapacidade(capacidade);
                    
           String descricao = request.getParameter("descricao");
           comodo.setDescricao(descricao);

           String condicao = request.getParameter("condicao");
           
         
    
           switch(condicao){
            case "OCUPADO":
                comodo.setCondicao(Comodo.Condicao.OCUPADO);
                break;
            case "MANUTENCAO":
                comodo.setCondicao(Comodo.Condicao.MANUTENCAO);
                break;
            case "LIVRE":
                comodo.setCondicao(Comodo.Condicao.LIVRE);
                break;
            case "OUTRO":
                comodo.setCondicao(Comodo.Condicao.OUTRO);
                break;
                
        }
           
            String revisao = request.getParameter("revisao");
            comodo.setRevisao(revisao);
            System.out.println("revisão");
            System.out.println(revisao);
           
           try{
           servico.inserir(comodo);
           jsp = "/GestaoComodos.jsp";
 
           }catch(Exception e){
               e.printStackTrace();
               return null;
           }   
        }catch(NumberFormatException e){
            e.printStackTrace();
            return null;
        }
        return jsp;
}
}

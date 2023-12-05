/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.service.implement.CadastraComodo;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author felli
 */
@WebServlet(name = "ExcluirComodo", urlPatterns = {"/ExcluirComodo"})
public class ExcluirComodo extends HttpServlet {
    
    public static String execute(HttpServletRequest request) {
    String jsp = "";
        System.out.println("servlet");
      CadastraComodo service = new CadastraComodo();
      int Id = Integer.parseInt(request.getParameter("ID"));
      
      try{
          service.deletar(Id);
          jsp = "/GestaoComodo.jsp";
      }catch(Exception e){
           e.printStackTrace();
           return null;
        }
    return jsp;
    }

}

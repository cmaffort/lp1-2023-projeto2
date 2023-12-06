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
import java.util.List;

/**
 *
 * @author felli
 */
@WebServlet(name = "ListarComodos", urlPatterns = {"/ListarComodos"})
public class ListarComodos extends HttpServlet {

    public static String execute(HttpServletRequest request) {
      String jsp = "";

      CadastraComodo service = new CadastraComodo();
        
  
      try{
          
      List<Comodo> comodosOcupado = service.listarTodos("OCUPADO");
 
      List<Comodo> comodosManutencao = service.listarTodos("MANUTENCAO");
   
      List<Comodo> comodosLivre = service.listarTodos("LIVRE");

      List<Comodo> comodosOutro = service.listarTodos("OUTRO");
   
      
      if(comodosOcupado != null)
        request.setAttribute("ocupado", comodosOcupado);
      if( comodosLivre != null)
        request.setAttribute("livre", comodosLivre);
      if(comodosOutro!= null)
        request.setAttribute("outros", comodosOutro);
      if(comodosManutencao != null)
      request.setAttribute("manutencao", comodosManutencao);
        
        jsp = "/GestaoComodos.jsp";   

        
      }catch(Exception e){
          e.printStackTrace();
          return null;
      }
    
    return jsp;
    }
}

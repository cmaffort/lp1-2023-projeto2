package br.cefetmg.casaderepouso.controller;


import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.casaderepouso.dto.Visitante;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.ICadastrarVisitante;
import br.cefetmg.casaderepouso.service.implement.CadastrarVisitanteService;
import java.lang.String;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "CadastrarVisitante", urlPatterns = {"/CadastrarVisitante"})
public class CadastrarVisitante extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
     
        String nome = request.getParameter("nomeVisitante");
        String rg = request.getParameter("identidade");
        String telefone = request.getParameter("numero");
        String vinculo = request.getParameter("vinculo");
        String morador = request.getParameter("morador");
        String dataVisita = request.getParameter("dataVisita");
        String horaVisita = request.getParameter("horaVisita");
        System.out.println("Data e hora " + dataVisita + horaVisita);
        Visitante visitante = new Visitante(nome, rg, telefone, morador, vinculo, dataVisita, horaVisita);

        
        //System.out.println("Controller");
        
        ICadastrarVisitante service = new CadastrarVisitanteService();
        try {
            service.cadastrar(visitante);
        } catch (CadastroException ex) {
            System.out.println("Erro" + ex);
        }
        
        return jsp;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
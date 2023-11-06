package br.cefetmg.casaderepouso.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.casaderepouso.dto.Evento;
import br.cefetmg.casaderepouso.service.IManterEvento;
import br.cefetmg.casaderepouso.service.implement.ManterEvento;


@WebServlet(urlPatterns = {"/CadastrarEvento"})
public class CadastrarEvento extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
     
        try {

            String nome = request.getParameter("nomeOrganizador");
            String rg = request.getParameter("rg");
            String desc = request.getParameter("descricao");
            String lugar = request.getParameter("local");
            String data = request.getParameter("data");
            String hora = request.getParameter("horario");
            String fone = request.getParameter("telefone");
            String email = request.getParameter("email");
           
            
            Evento event = new Evento();
            
            event.setNome(nome);
            event.setRg(rg);
            event.setDescricao(desc);
            event.setLocal(lugar);
            event.setData(data);
            event.setHorario(hora);
            event.setFone(fone);
            event.setEmail(email);
            
            String id = event.getRg() + event.getNome().charAt(0);
            event.setId(id);
            IManterEvento iEvento = new ManterEvento();
            iEvento.cadastrar(event);
            
            jsp = "/telaEvento.jsp";
        } catch (Exception e) {
            System.out.println(e);
            jsp = "";
        }
        
        return jsp;
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

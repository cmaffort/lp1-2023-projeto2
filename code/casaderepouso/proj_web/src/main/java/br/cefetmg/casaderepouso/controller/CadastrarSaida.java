package br.cefetmg.casaderepouso.controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.casaderepouso.dto.SaidaTemporaria;
import br.cefetmg.casaderepouso.service.implement.ManterSaida;
import br.cefetmg.casaderepouso.service.IManterSaida;


@WebServlet(urlPatterns = {"/CadastrarSaida"})
public class CadastrarSaida extends HttpServlet {

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

            String nome= request.getParameter("nomeMorador");
            String cpf = request.getParameter("cpf");
            
            String motivo = request.getParameter("motivo");
            
           
            
            
            String diaS = request.getParameter("dataSaida");
            String diaV = request.getParameter("dataVolta");
            String horaS = request.getParameter("horarioSaida");
            String horaV = request.getParameter("horarioVolta");
            
            
            SaidaTemporaria saida = new SaidaTemporaria();
            
            saida.setNome(nome);
            saida.setMoradorCpf(cpf);
            saida.setMotivo(motivo);
            saida.setDataSaida(diaS);
            saida.setDataVolta(diaV);
            saida.setHorarioSaida(horaS);
            saida.setHorarioVolta(horaV);

            
            String id = saida.getMoradorCpf()+ saida.getMotivo().charAt(0) + saida.getDataSaida();
            saida.setId(id);
            IManterSaida iSaida = new ManterSaida();
            iSaida.cadastrar(saida);
            
            jsp = "/gestaoSaida.jsp";
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

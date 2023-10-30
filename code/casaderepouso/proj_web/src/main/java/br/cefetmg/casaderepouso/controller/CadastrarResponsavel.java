package java.br.cefetmg.casaderepouso.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.cefetmg.casaderepouso.dto.Responsavel;


@WebServlet(name = "CadastrarResponsavel", urlPatterns = {"/CadastrarResponsavel"})
public class CadastrarResponsavel extends HttpServlet {

    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
     
        try {

            String nome = request.getParameter("nomeResponsavel");
            String cpf = request.getParameter("cpf");
            
            String dataStr = request.getParameter("dataNascimento");
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNasc = formatter.parse(dataStr);
            
            String rg = request.getParameter("rg");
            String telefone = request.getParameter("telefone");
            String endereco = request.getParameter("endereco");
            String responsavelPor = request.getParameter("responsavelPor");
            
            Responsavel responsavel = new Responsavel();
            
            responsavel.setNome(nome);
            responsavel.setCpf(cpf);
            responsavel.setRg(rg);
            responsavel.setTelefone(telefone);
            responsavel.setDataNascimento(dataNasc);
            responsavel.setEndereco(endereco);
            responsavel.setResponsavelPor(responsavelPor);
                
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

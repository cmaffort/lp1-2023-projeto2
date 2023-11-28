package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Despesas;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.ICadastrarDespesas;
import br.cefetmg.casaderepouso.service.implement.CadastrarDespesaS;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Júlia
 */
@WebServlet(name = "CadastrarDespesa", urlPatterns = {"/CadastrarDespesa"})
public class CadastrarDespesa extends HttpServlet {

    static String execute(HttpServletRequest request) {
        String jsp = "cadastroPagamento.jsp";

        String destinatario = request.getParameter("nomeDestinatario");
        String pagante = request.getParameter("nomePagante");
        String telefone = request.getParameter("numero");
        String identidade = request.getParameter("identidade");
        String descricao = request.getParameter("descricao");
        String data = request.getParameter("data");
        String hora = request.getParameter("hora");
        String valor = request.getParameter("valor");

        Despesas pagamento = new Despesas(destinatario, pagante, telefone, identidade, descricao, valor, data, hora);

        ICadastrarDespesas service = new CadastrarDespesaS();

        try {
            service.cadastrar(pagamento);
            System.out.println("Teste controller");

        } catch (CadastroException ex) {
            Logger.getLogger(CadastrarDespesa.class.getName()).log(Level.SEVERE, null, ex);
        }

        return jsp;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

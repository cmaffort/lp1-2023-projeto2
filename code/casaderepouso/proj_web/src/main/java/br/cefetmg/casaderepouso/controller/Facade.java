package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import jakarta.servlet.RequestDispatcher;
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
 * @author Aluno
 */
@WebServlet(urlPatterns = {"/Facade"})
public class Facade extends HttpServlet {

    private String jsp;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String act = request.getParameter("act");

        if (act.equals("CadastrarMorador")) {
            jsp = CadastrarMorador.execute(request);
        } else if (act.equals("ListarMorador")) {
            jsp = ListarMorador.execute(request);
        } else if (act.equals("AtualizarEstado")) {
            jsp = AtualizarMorador.execute(request);
            jsp = ListarMorador.execute(request);
        } else if (act.equals("CadastrarRefeicao")) {
            jsp = CadastrarRefeicao.execute(request);
            jsp = ListarRefeicao.execute(request);
        } else if (act.equals("ListarRefeicao")) {
            jsp = ListarRefeicao.execute(request);
        } else if (act.equals("deleteRef")) {
            jsp = ExcluirRefeicao.execute(request);
            jsp = ListarRefeicao.execute(request);
        }
        else if(act.equals("CadastrarCartao")){
            jsp = CadastrarCartao.execute(request);
        }
        else if(act.equals("ListarCartao")){
            jsp = ListarCartao.execute(request);
        }
        else if(act.equals("ExcluirCartao")){
            jsp = ExcluirCartao.execute(request);
        }
        else if(act.equals("ListarAtualizacao")){
            jsp = ListarAtualizacao.execute(request);
        }
        else if(act.equals("EfetuarPagamento")){
            jsp = EfetuarPagamento.execute(request);
        }
        else if(act.equals("cadastrarFuncionario")){
            jsp = CadastrarFuncionario.execute(request);
        } else if (act.equals("listarFuncionario")) {
            jsp = ListarFuncionario.execute(request);
        } else if (act.equals("deleteFunc")) {
            jsp = ExcluirFuncionario.execute(request);
            jsp = ListarFuncionario.execute(request);
        } else if (act.equals("AtualizarFuncionario")) {
            jsp = AtualizarFuncionario.execute(request);
            jsp = ListarFuncionario.execute(request);
        } else if (act.equals("AtualizarEvento")) {
            jsp = AtualizarEvento.execute(request);
            jsp = ListarEvento.execute(request);
        } else if (act.equals("CadastrarVisitante")) {
            System.out.println("cadastra");
            jsp = CadastrarVisitante.execute(request);
        } else if (act.equals("CadastraMedicamentos")) {
            jsp = CadastraMedicamento.execute(request);
        } else if (act.equals("listarVisitante")) {
            jsp = ListarVisitantes.execute(request);
        } else if (act.equals("cadastrarResponsavel")) {
            jsp = CadastraResponsavel.execute(request);
        } else if (act.equals("listarResponsavel")) {
            jsp = ListarResponsavel.execute(request);
        } else if (act.equals("AgendarConsulta")) {
            jsp = CadastrarConsulta.execute(request);
        } else if (act.equals("listarEventos")) {
            jsp = ListarEvento.execute(request);
        } else if (act.equals("cadastrarEvento")) {
            jsp = CadastrarEvento.execute(request);
        } else if (act.equals("CadastrarReceita")) {
            jsp = CadastraReceita.execute(request);
        } else if (act.equals("ListarReceita")) {
            jsp = ListarReceita.execute(request);
        } else if (act.equals("deleteEvento")) {
            jsp = ExcluirEvento.execute(request);
            jsp = ListarEvento.execute(request);
        } else if (act.equals("deleteReceita")) {
            jsp = ExcluirReceita.execute(request);
            jsp = ListarReceita.execute(request);
        } else if (act.equals("deleteResponsavel")) {
            jsp = ExcluirResponsavel.execute(request);
            jsp = ListarResponsavel.execute(request);
        } else if (act.equals("listarConsultas")) {
            jsp = ListarConsultas.execute(request);
        } else if (act.equals("CadastrarPagamento")) {
            jsp = CadastrarDespesa.execute(request);
        }else if(act.equals("listarDespesas")){
            jsp = ListarDespesas.execute(request); 
        }

        else if(act.equals("CadastroSaida")){
            jsp = AtualizarMorador.execute(request);
            jsp = CadastrarSaida.execute(request);
        }
        else if(act.equals("listarSaida")){
            jsp = ListarSaida.execute(request);
        }
        else if(act.equals("atualizarSaida")){
            jsp = AtualizarSaida.execute(request);
            jsp = ListarSaida.execute(request);
        }

        RequestDispatcher rd = request.getRequestDispatcher(jsp);
        rd.forward(request, response);

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

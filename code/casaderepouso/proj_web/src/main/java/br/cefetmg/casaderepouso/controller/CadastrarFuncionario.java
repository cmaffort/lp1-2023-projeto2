package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Atualizacao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import br.cefetmg.casaderepouso.dto.Funcionario;
import br.cefetmg.casaderepouso.service.IManterAtualizacao;
import br.cefetmg.casaderepouso.service.implement.ManterFuncionario;
import br.cefetmg.casaderepouso.service.IManterFuncionario;
import br.cefetmg.casaderepouso.service.implement.ManterAtualizacao;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet(urlPatterns = {"/CadastrarFuncionario"})
public class CadastrarFuncionario extends HttpServlet {

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

            String nome = request.getParameter("nomeFuncionario");
            String rg = request.getParameter("rg");
            String cpf = request.getParameter("cpf");

            String senha = request.getParameter("senha");

            String nasc = request.getParameter("dataNasc");

            String pis = request.getParameter("pis");
            String endereco = request.getParameter("endereco");
            String fone = request.getParameter("telefone");
            String funcao = request.getParameter("funcao");
            String periodo = request.getParameter("periodo");

            Funcionario func = new Funcionario();

            
            func.setSenha(senha);

            func.setNome(nome);
            func.setRg(rg);
            func.setCpf(cpf);
            func.setDataNasc(nasc);
            func.setPis(pis);
            func.setEndereco(endereco);
            func.setFone(fone);
            func.setFuncao(funcao);
            func.setPeriodoTrabalho(periodo);

            String id = func.getCpf() + func.getNome().charAt(0);
            func.setId(id);
            IManterFuncionario iFuncionario = new ManterFuncionario();
            iFuncionario.cadastrar(func);

            Atualizacao atualizacao = new Atualizacao();
            atualizacao.setCpf(cpf);

            LocalDate dataAtual = LocalDate.now();
            String dataFormatada = dataAtual.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            LocalTime horarioAtual = LocalTime.now();
            String horarioFormatado = horarioAtual.format(DateTimeFormatter.ofPattern("HH:mm"));
            atualizacao.setMomento(dataFormatada + " " + horarioFormatado);

            String dados = "Nome:" + nome + "\nRg:" + rg + "\nCpf:" + cpf + "\nNascimento:" + nasc + "\nPis:" + pis + "\nEndereço:" + endereco + "\nFone:" + fone + "\nFunção:"+ funcao + "\nPeríodo:" + periodo;
            atualizacao.setDados(dados);
            
            IManterAtualizacao iAtualizacao = new ManterAtualizacao();
            iAtualizacao.cadastrar(atualizacao);
            jsp = "/telaGerente.jsp";
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

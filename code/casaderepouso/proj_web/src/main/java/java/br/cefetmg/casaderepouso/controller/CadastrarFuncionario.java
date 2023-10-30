package java.br.cefetmg.casaderepouso.controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.cefetmg.casaderepouso.dto.Funcionario;
import br.cefetmg.casaderepouso.service.implement.ManterFuncionario;
import br.cefetmg.casaderepouso.service.IManterFuncionario;

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
            
            
            String dataStr = request.getParameter("dataNasc");
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dataNasc = formatter.parse(dataStr);
            
            
            String pis = request.getParameter("pis");
            String endereco = request.getParameter("endereco");
            String fone = request.getParameter("telefone");
            String funcao = request.getParameter("funcao");
            String periodo = request.getParameter("periodo");
            
            Funcionario func = new Funcionario();
            
            func.setNome(nome);
            func.setRg(rg);
            func.setCpf(cpf);
            func.setDataNasc(dataNasc);
            func.setPis(pis);
            func.setEndereco(endereco);
            func.setFone(fone);
            func.setFuncao(funcao);
            func.setPeriodoTrabalho(periodo);
            
            String id = func.getCpf() + func.getNome().charAt(0);
            func.setId(id);
            IManterFuncionario iFuncionario = new ManterFuncionario();
            iFuncionario.cadastrar(func);
            
            jsp = "/CadastroFuncionario.jsp";
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

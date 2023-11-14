/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Morador;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.IManterMorador;
import br.cefetmg.casaderepouso.service.implement.ManterMorador;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Master
 */
@WebServlet(name = "AtualizarMorador", urlPatterns = {"/AtualizarMorador"})
public class AtualizarMorador extends HttpServlet {
    
    public static String execute(HttpServletRequest request){
        String jsp = "/telaFuncionario.jsp"; 
    
            String nome = request.getParameter("nomeMorador");
            String cpf = request.getParameter("cpf");
            String estado = request.getParameter("estado");
            String dataStr = request.getParameter("dataNasc");
            String planoMedico = request.getParameter("plano_medico");
            String nomeMae = request.getParameter("nome_mae");
            String endereco = request.getParameter("endereco");
            String condicoes = request.getParameter("condicoes_especiais");
            
            System.out.println(estado);
            Morador morador = new Morador();
            
            morador.setNome(nome);
            morador.setNomeMae(nomeMae);
            morador.setCpf(cpf);
            morador.setEstado(estado);
            morador.setPlanoMedico(planoMedico);
            morador.setDataNasc(dataStr);
            morador.setEndereco(endereco);
            morador.setCondicaoEspecial(condicoes);
            

            IManterMorador iMorador = new ManterMorador();
            try {
                iMorador.atualizar(morador); 
            } catch (Exception ex) {
                System.out.println("Erro" + ex);
            }
        return jsp;
    }
    @Override
    public String getServletInfo(){
        return "Short description";
    }// </editor-fold>
}

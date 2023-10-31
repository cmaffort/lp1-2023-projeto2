/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

package br.cefetmg.casaderepouso.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import br.cefetmg.casaderepouso.dto.Medicamento;
import br.cefetmg.casaderepouso.dto.Medicamento.Tarja;
import br.cefetmg.casaderepouso.service.implement.CadastrarMedicamento;
/**
 *
 * @author felli
 */
@WebServlet(name = "CadastrarMedicamento", urlPatterns = {"/CadastrarMedicamento"})
public class CadastraMedicamento extends HttpServlet{
    
    
    
    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try{
            Medicamento med = new Medicamento();
            
            String nome = request.getParameter("nome");
            med.setNome(nome);
           
            
            String dose = request.getParameter("dose");
            med.setDose(dose);
            
            
            Double valor = Double.valueOf(request.getParameter("valor"));
            med.setValor(valor);
            
            
            String morador = request.getParameter("morador");
            med.setMoradorCPF(morador);
            
            
            Integer intervalo = Integer.valueOf(request.getParameter("intervalo"));
            med.setIntervalo(intervalo);           
            
            
            String dataStr = request.getParameter("validade");
            DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
            Date validade = data.parse(dataStr);
            med.setValidade(validade);
            
            
            String horario = request.getParameter("hora");
            DateFormat hora = new SimpleDateFormat("HH:mm");
            Date ultApli = hora.parse(horario);
            med.setUltimaAplicacao(ultApli);
            
            String tarjastr = request.getParameter("tarja");
            
               switch (tarjastr) {
                    case "VERMELHA":
                        med.setTarja(Tarja.VERMELHA);
                        break;
                    case "SEM_TARJA":
                        med.setTarja(Tarja.SEM_TARJA);
                        break;
                    case "AMARELA":
                        med.setTarja(Tarja.AMARELA);
                        break;
                    case "PRETA":
                        med.setTarja(Tarja.PRETA);
                        break;
                }
               
        CadastrarMedicamento servico = new CadastrarMedicamento();
        boolean resp = servico.cadastrar(med);
        if(resp){
        jsp = "/GestãoMedicamento.jsp";
        }else{
        String erro = "erro ao realizar cadastro";
        request.setAttribute("erro", erro);
        
        }
            
            
            
        }catch(Exception e){
        e.printStackTrace();
        }
        return jsp;
    }
}

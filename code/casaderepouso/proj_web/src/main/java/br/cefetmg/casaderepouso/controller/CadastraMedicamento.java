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
import java.sql.Time;
import java.text.ParseException;

/**
 *
 * @author felli
 */
@WebServlet(name = "CadastrarMedicamento", urlPatterns = {"/CadastrarMedicamento"})
public class CadastraMedicamento extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";
        try {
            Medicamento med = new Medicamento();
            CadastrarMedicamento servico = new CadastrarMedicamento();

            String nome = request.getParameter("nome");
            med.setNome(nome);
         
            
            Double valor = Double.valueOf(request.getParameter("valor"));
            med.setValor(valor);
           

            String dose = request.getParameter("dose");
            med.setDose(dose);
           

            String morador = request.getParameter("morador");
            med.setMoradorCPF(morador);
            

            
            
            
            String intervalo = request.getParameter("intervalo");
            DateFormat hora = new SimpleDateFormat("HH:mm");
            Date intervaloTempo = hora.parse(intervalo);
            Time tempoIntervalo = new Time(intervaloTempo.getTime());
            
            
            med.setIntervalo(tempoIntervalo);
            
            

            String dataStr = request.getParameter("validade");
            DateFormat data = new SimpleDateFormat("yyyy-MM-dd");
            Date validade = data.parse(dataStr);
    
            med.setValidade(validade);

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
            System.out.println("pegou tarja");

            try{
                servico.cadastrar(med);
                jsp = "/CadastroMedicamento.jsp";
                return jsp;
            } catch(Exception e){
                return null;
            }

        } catch (NumberFormatException | ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}

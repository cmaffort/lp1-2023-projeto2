/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Equipamento;
import br.cefetmg.casaderepouso.service.implement.CadastrarEquipamento;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "ListarEquipamentos", urlPatterns = {"/ListarEquipamentos"})
public class ListarEquipamentos extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";

        try {
            CadastrarEquipamento iEquipamento = new CadastrarEquipamento();
            List<Equipamento> equipamentos = iEquipamento.listar();
            if (equipamentos != null) {
                request.setAttribute("listEquipamentos", equipamentos);
                jsp = "/inventario.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
            jsp = "";
        }

        return jsp;
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}

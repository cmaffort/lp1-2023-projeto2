/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.controller;

import br.cefetmg.casaderepouso.dto.Equipamento;
import br.cefetmg.casaderepouso.dto.exception.CadastroException;
import br.cefetmg.casaderepouso.service.ICadastrarEquipamento;
import br.cefetmg.casaderepouso.service.implement.CadastrarEquipamento;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

/**
 *
 * @author Master
 */
@WebServlet(name = "AtualizarEquipamento", urlPatterns = {"/AtualizarEquipamento"})
public class AtualizarEquipamento extends HttpServlet {

    public static String execute(HttpServletRequest request) {
        String jsp = "";

        try {
            
            String id = request.getParameter("id");
            String tipo = request.getParameter("tipoEquipamento");
            String preco = request.getParameter("preco");
            int quantidade = Integer.parseInt(request.getParameter("quantidade"));
            String estado = request.getParameter("estado");
            String fornecedor = request.getParameter("fornecedor");

            Equipamento equipamento = new Equipamento();

            equipamento.setId(id);
            equipamento.setTipo(tipo);
            equipamento.setPreco(preco);
            equipamento.setQuantidade(quantidade);
            equipamento.setEstado(estado);
            equipamento.setFornecedor(fornecedor);

            ICadastrarEquipamento iEquipamento = new CadastrarEquipamento();
            iEquipamento.atualizar(equipamento);

            jsp = "/inventario.jsp";
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

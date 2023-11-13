/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.dto;

import java.util.ArrayList;

/**
 *
 * @author Aluno
 */
public class Refeicao {
    
    String hora;
    String cardapio;
    String tipo;
    String dia;
    String cpfMorador;
    public Refeicao(){
        
    }
    public Refeicao(String cpf, String hora, String cardapio, String tipo, String dia) {
        this.hora = hora;
        this.cardapio = cardapio;
        this.tipo = tipo;
        this.dia = dia;
        this.cpfMorador = cpf;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCardapio() {
        return cardapio;
    }

    public String getDia() {
        return dia;
    }
    public String getCpfMorador() {
        return cpfMorador;
    }
    public void setCardapio(String cardapio) {
        this.cardapio = cardapio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    public void setCpfMorador(String cpfMorador) {
        this.cpfMorador = cpfMorador;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.dto;

/**
 *
 * @author Master
 */
public class Mensalidade {
    String cpfMorador;
    String cpfResponsavel;
    String inicio;
    String fim;

    public Mensalidade() {
    }

    public Mensalidade(String cpfMorador, String cpfResponsavel, String inicio, String fim) {
        this.cpfMorador = cpfMorador;
        this.cpfResponsavel = cpfResponsavel;
        this.inicio = inicio;
        this.fim = fim;
    }

    public String getCpfMorador() {
        return cpfMorador;
    }

    public void setCpfMorador(String cpfMorador) {
        this.cpfMorador = cpfMorador;
    }

    public String getCpfResponsavel() {
        return cpfResponsavel;
    }

    public void setCpfResponsavel(String cpfResponsavel) {
        this.cpfResponsavel = cpfResponsavel;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFim() {
        return fim;
    }

    public void setFim(String fim) {
        this.fim = fim;
    }
    
    
}

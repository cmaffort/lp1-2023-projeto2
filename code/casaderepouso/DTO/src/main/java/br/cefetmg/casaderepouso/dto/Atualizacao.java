/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.dto;

/**
 *
 * @author Master
 */
public class Atualizacao {
   String cpf;
   String dados;
   String momento;

    public Atualizacao() {
    }

    public Atualizacao(String cpf, String dados, String momento) {
        this.cpf = cpf;
        this.dados = dados;
        this.momento = momento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDados() {
        return dados;
    }

    public void setDados(String dados) {
        this.dados = dados;
    }

    public String getMomento() {
        return momento;
    }

    public void setMomento(String momento) {
        this.momento = momento;
    }
    
}

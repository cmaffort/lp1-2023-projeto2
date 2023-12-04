/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.dto;

/**
 *
 * @author Master
 */
public class Cartao {
    String cpf;
    String numero;
    String nome;
    String validade;
    String cardtype;
    public Cartao(){
    
    }
    public Cartao(String cpf, String numero, String nome, String validade, String cardtype) {
        this.cpf = cpf;
        this.numero = numero;
        this.nome = nome;
        this.validade = validade;
        this.cardtype = cardtype;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }
    
    
}

package br.cefetmg.casaderepouso.dto;

import java.util.Date;

public class Medicamento {
    
    public enum Tarja {
        SEM_TARJA, VERMELHA, AMARELA, PRETA;
    }
    public enum Condicao{
        COMPRADO,SOLICITADO,ESGOTADO;
    }
    

    public Medicamento( String nome, Double valor, Tarja tarja, Date validade, String morador, String dose, Date ultimaAplicacao, Integer intervalo, Condicao condicao) {
        this.nome = nome;
        this.valor = valor;
        this.tarja = tarja;
        this.validade = validade;
        this.moradorCPF = morador;
        this.dose = dose;
        this.ultimaAplicacao = ultimaAplicacao;
        this.intervalo = intervalo;
        this.condicao = condicao;
    }
    public Medicamento(){}

    private String nome;
    private Double valor;
    private Tarja tarja;
    private Date validade;
    private String moradorCPF;
    private String dose;
    private Date ultimaAplicacao;
    private Integer intervalo;
    private Condicao condicao;
    
    
    public Condicao getCondicao() {
        return condicao;
    }

    public void setCondicao(Condicao condicao) {
        this.condicao = condicao;
    }
    public Date getUltimaAplicacao() {
        return ultimaAplicacao;
    }

    //dataHora vai ser usada para poder calcular a hora da proxima aplicação do medicamento, usando como base a variavel intervalomed
    public void setUltimaAplicacao(Date ultimaAplicacao) {
        this.ultimaAplicacao = ultimaAplicacao;
    }
    
    public String getMoradorCPF() {
        return moradorCPF;
    }

    public void setMoradorCPF(String moradorCPF) {
        this.moradorCPF = moradorCPF;
    }

    public Integer getIntervalo() {
        return intervalo;
    }

    public void setIntervalo(Integer intervalo) {
        this.intervalo = intervalo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Enum getTarja() {
        return tarja;
    }

    public void setTarja(Tarja tarja) {
        this.tarja = tarja;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

}

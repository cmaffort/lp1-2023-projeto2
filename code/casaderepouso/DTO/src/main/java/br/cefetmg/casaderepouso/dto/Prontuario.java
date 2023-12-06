/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package br.cefetmg.casaderepouso.dto;

import java.sql.Date;

/**
 *
 * @author felli
 */
public class Prontuario{

    Date data;
    String profSaudeCPF;
    String moradorCPF;
    String observacoes;
    String pressao;
    String frequenciaCardiaca;
    String frequenciaRespiratoria;
    String temperatura;
    String refeicoes;
    String observacaoRefeicao;
    Integer Id;
    
    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }
    
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getProfSaudeCPF() {
        return profSaudeCPF;
    }

    public void setProfSaudeCPF(String profSaudeCPF) {
        this.profSaudeCPF = profSaudeCPF;
    }

    public String getMoradorCPF() {
        return moradorCPF;
    }

    public void setMoradorCPF(String moradorCPF) {
        this.moradorCPF = moradorCPF;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getPressao() {
        return pressao;
    }

    public void setPressao(String pressao) {
        this.pressao = pressao;
    }

    public String getFrequenciaCardiaca() {
        return frequenciaCardiaca;
    }

    public void setFrequenciaCardiaca(String frequenciaCardiaca) {
        this.frequenciaCardiaca = frequenciaCardiaca;
    }

    public String getFrequenciaRespiratoria() {
        return frequenciaRespiratoria;
    }

    public void setFrequenciaRespiratoria(String frequenciaRespiratoria) {
        this.frequenciaRespiratoria = frequenciaRespiratoria;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(String refeicoes) {
        this.refeicoes = refeicoes;
    }

    public String getObservacaoRefeicao() {
        return observacaoRefeicao;
    }

    public void setObservacaoRefeicao(String observacaoRefeicao) {
        this.observacaoRefeicao = observacaoRefeicao;
    }

 
    
    //Registros diários de sinais vitais, como pressão arterial, frequência cardíaca, frequência respiratória e temperatura.

}
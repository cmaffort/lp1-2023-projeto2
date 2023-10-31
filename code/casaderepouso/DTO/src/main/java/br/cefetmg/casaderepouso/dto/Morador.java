/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Master
 */
package br.cefetmg.casaderepouso.dto;
import java.util.Date;
import br.cefetmg.casaderepouso.dto.Responsavel;
import java.util.ArrayList;
enum EstadoMorador{
    DISPONIVEL("Disponível"),
    SAIDA_TEMPORARIA("Saída Temporária"),
    INTERNADO("Internado"),
    FALECIDO("Falecido");
    private String descricao;
    EstadoMorador(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return descricao;
    }
}
public class Morador {
    private String nome;
    private String cpf;
    private String rg;
    private String dataNasc;
    private String endereco;
    private String responsaveis;
    private String condicaoEspecial;
    private String nomeMae;
    private String planoMedico;
    private EstadoMorador estado = EstadoMorador.DISPONIVEL;
    public Morador(){
    
    }
    public Morador(String nome, String cpf, String rg, String dataNasc,String planoMedico, String responsaveis, String nomeMae, String endereco, String condicaoEspecial, String estado) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.planoMedico = planoMedico;
        this.endereco = endereco;
        this.responsaveis = responsaveis;
        this.condicaoEspecial = condicaoEspecial;
        this.nomeMae = nomeMae;
        this.estado = this.estado.valueOf(estado);
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public String getCondicaoEspecial() {
        return condicaoEspecial;
    }

    public String getEstado() {
        return estado.getDescricao();
    }
    public String getNomeMae(){
        return nomeMae;
    }

    public String getEndereco() {
        return endereco;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public void setCondicaoEspecial(String condicaoEspecial) {
        this.condicaoEspecial = condicaoEspecial;
    }

    public void setEstado(EstadoMorador estado) {
        this.estado = estado;
    }
    public void setNomeMae(String nomeMae){
        this.nomeMae = nomeMae;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getVetorResponsaveis() {
        return responsaveis;
    }

    public String getPlanoMedico() {
        return planoMedico;
    }

    public void setPlanoMedico(String planoMedico) {
        this.planoMedico = planoMedico;
    }  
}

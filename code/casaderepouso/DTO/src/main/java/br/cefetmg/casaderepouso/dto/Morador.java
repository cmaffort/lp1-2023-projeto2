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
    private Date dataNasc;
    private String endereco;
    private ArrayList<Responsavel> vetorResponsaveis;
    private String condicaoEspecial;
    private String nomeMae;
    private EstadoMorador estado = EstadoMorador.DISPONIVEL;
    
    public Responsavel adicionarResponsavel(Responsavel responsavel){
        vetorResponsaveis.add(responsavel);
        return responsavel;
    }
    // adicionar um remover
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public String getCondicaoEspecial() {
        return condicaoEspecial;
    }

    public EstadoMorador getEstado() {
        return estado;
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

    public void setDataNasc(Date dataNasc) {
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

    public ArrayList<Responsavel> getVetorResponsaveis() {
        return vetorResponsaveis;
    } 
}
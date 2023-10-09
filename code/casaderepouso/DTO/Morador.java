/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Master
 */
import java.util.Date;
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
    // Adicionar vetor de Responsaveis
    private String condicaoEspecial;
    private EstadoMorador estado = EstadoMorador.DISPONIVEL;

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
}

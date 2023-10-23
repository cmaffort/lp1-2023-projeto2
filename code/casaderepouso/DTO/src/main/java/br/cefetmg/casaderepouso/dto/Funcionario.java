package br.cefetmg.casaderepouso.dto;
import java.util.Date;

public class Funcionario {
    
    private String nome;
    private String cpf;
    private String rg;
    private Date dataNasc;
    private String endereco;
    private String fone;
    private String pis;
    private String funcao;
    private String periodoTrabalho;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }
    
     public Date getDataNasc() {
        return dataNasc;
    }
     
     public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }
    
    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getPeridoTrabalho() {
        return periodoTrabalho;
    }

    public void setPeriodoTrabalho(String periodoTrabalho) {
        this.periodoTrabalho = periodoTrabalho;
    }
}
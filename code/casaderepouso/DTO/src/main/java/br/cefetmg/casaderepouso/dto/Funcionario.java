package br.cefetmg.casaderepouso.dto;


public class Funcionario {
    
    private String nome;
    private String cpf;
    private String rg;
    private String dataNasc;
    private String endereco;
    private String fone;
    private String pis;
    private String funcao;
    private String periodoTrabalho;
    private String id;
    private String senha;
    public Funcionario(){
    
    }
    public Funcionario(String nome, String cpf, String rg, String dataNasc, String endereco,
            String fone, String pis, String funcao, String periodoTrabalho, String id){
        
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.dataNasc = dataNasc;
        this.endereco = endereco;
        this.fone = fone;
        this.pis = pis;
        this.funcao = funcao;
        this.periodoTrabalho = periodoTrabalho;
        this.id = id;
        
    }
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
    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String data) {
        this.dataNasc = data;
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

    public String getPeriodoTrabalho() {
        return periodoTrabalho;
    }

    public void setPeriodoTrabalho(String periodoTrabalho) {
        this.periodoTrabalho = periodoTrabalho;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getSenha(){
        return senha;
    }
}

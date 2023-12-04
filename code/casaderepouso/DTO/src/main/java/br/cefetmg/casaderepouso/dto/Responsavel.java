package br.cefetmg.casaderepouso.dto;

public class Responsavel {
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private String endereco;
    private String responsavelPor;
    private String id;
    private String senha;

    public Responsavel() {
    }
    
    public Responsavel(String nome, String cpf, String rg, String telefone, String endereco, String responsavelPor, String id, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
        this.endereco = endereco;
        this.responsavelPor = responsavelPor;
        this.id = id;
        this.senha = senha;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    
    public String getRg(){
        return rg;
    }
    public void setRg(String rg){
        this.rg = rg;
    }
    
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getResponsavelPor(){
        return responsavelPor;
    }
    public void setResponsavelPor(String responsavelPor){
        this.responsavelPor = responsavelPor;
    }
    
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
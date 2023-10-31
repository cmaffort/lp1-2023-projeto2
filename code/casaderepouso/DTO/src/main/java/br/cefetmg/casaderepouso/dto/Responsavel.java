package br.cefetmg.casaderepouso.dto;
import java.util.Date;

public class Responsavel {
    private String nome;
    private String cpf;
    private String rg;
    private String telefone;
    private Date dataNascimento;
    private String endereco;
    private String responsavelPor;
    private String id;
    
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
    
    public Date getDataNascimento(){
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
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
}

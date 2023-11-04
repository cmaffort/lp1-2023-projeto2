/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.cefetmg.casaderepouso.dto;

/**
 *
 * @author rigor
 */
public class Evento {
    private String nome;
    private String rg;
    private String descricao;
    private String local;
    private String data;
    private String horario;
    private String fone;
    private String email;
    private String id;
    
    public Evento(){
    }
    public Evento(String nome, String rg, String desc, String local, String data, String hora,
            String telefone, String email, String id){
            
            this.nome = nome;
            this.rg = rg;
            this.descricao = desc;
            this.local = local;
            this.data = data;
            this.horario = hora;
            this.fone = telefone;
            this.email = email;
            this.id = id;
    
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome(){
        return nome;
    }
    
    public void setRg(String rg){
        this.rg = rg;
    }
    
    public String getRg(){
        return rg;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setLocal(String local){
        this.local= local;
    }
    
    public String getLocal(){
        return local;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public String getData(){
        return data;
    }
    
    public void setHorario(String hora){
        this.horario = hora;
    }
    
    public String getHorario(){
        return horario;
    }
    
    public void setFone(String telefone){
        this.fone = telefone;
    }
    
    public String getFone(){
        return fone;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
}

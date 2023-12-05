package br.cefetmg.casaderepouso.dto;

public class Equipamento {
    private String tipo;
    private String preco;
    private int quantidade;
    private String estado;
    
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    
    public String getPreco(){
        return preco;
    }
    public void setPreco(String preco){
        this.preco = preco;
    }
    
    public int getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
}

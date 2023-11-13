package br.cefetmg.casaderepouso.dto;


public class Receita {
    private String profissionalSaude;
    private String morador;
    private String medicamentos;
    private String data;
    private String hora;
    private String quantidade;
    private String validade;
    private String id;
    
    public String getProfissionalSaude(){
        return profissionalSaude;
    }
    public void setProfissionalSaude(String profissionalSaude){
        this.profissionalSaude = profissionalSaude;
    }
    
    public String getMorador(){
        return morador;
    }
    public void setMorador(String morador){
        this.morador = morador;
    }
    
    public String getMedicamentos(){
        return medicamentos;
    }
    public void setMedicamentos(String medicamentos){
        this.medicamentos = medicamentos;
    }
    
    public String getData(){
        return data;
    }
    public void setData(String data){
        this.data = data;
    }
    
    public String getHora(){
        return hora;
    }
    public void setHora(String hora){
        this.hora = hora;
    }
    
    public String getQuantidade(){
        return quantidade;
    }
    public void setQuantidade(String quantidade){
        this.quantidade = quantidade;
    }
    
    public String getValidade(){
        return validade;
    }
    public void setValidade(String validade){
        this.validade = validade;
    }
    
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id = id;
    }
}
package br.cefetmg.casaderepouso.dto;

/**
 *
 * @author Júlia
 */
public class Consulta {
    private String morador;
    private String data;
    private String hora;
    private String profissional;
    private String especializacao;
    private String tipo;
    
    public Consulta(String data, String hora, String profissional, String especializacao, String tipo) {
        this.data = data;
        this.hora = hora;
        this.profissional = profissional;
        this.especializacao = especializacao;
        this.tipo = tipo;
    }
    
    public String getMorador() {
        return morador;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getProfissional() {
        return profissional;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setMorador(String morador) {
        this.morador = morador;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setProfissional(String profissional) {
        this.profissional = profissional;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}

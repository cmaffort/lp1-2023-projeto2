package br.cefetmg.casaderepouso.dto;

/**
 *
 * @author Júlia
 */
public class Despesas {
    
    private String destinatario;
    private String pagante;
    private String telefone;
    private String identidade;
    private String descricao;
    private String valor;
    private String data;
    private String hora;

    public Despesas() {
    }
    
    public Despesas(String destinatario, String pagante, String telefone, String identidade, String descricao, String valor, String data, String hora) {
        this.destinatario = destinatario;
        this.pagante = pagante;
        this.telefone = telefone;
        this.identidade = identidade;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.hora = hora;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getPagante() {
        return pagante;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getIdentidade() {
        return identidade;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public String getValor(){
        return valor;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setPagante(String pagante) {
        this.pagante = pagante;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setIdentidade(String identidade) {
        this.identidade = identidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public void setValor(String valor){
        this.valor = valor;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
}

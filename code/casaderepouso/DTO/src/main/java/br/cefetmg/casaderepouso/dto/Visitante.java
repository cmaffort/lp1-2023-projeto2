package br.cefetmg.casaderepouso.dto;

/**
 *
 * @author Júlia
 */



public class Visitante {

    private String nome;
    private String rg;
    private String telefone;
    private String morador;
    private String vinculo;
    private String dataVisita;
    private String horaVisita;
    private int id;

    public Visitante(String nome, String rg, String telefone, String morador, String vinculo, String dataVisita, String horaVisita) {
        this.nome = nome;
        this.rg = rg;
        this.telefone = telefone;
        this.morador = morador;
        this.vinculo = vinculo;
        this.dataVisita = dataVisita;
        this.horaVisita = horaVisita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
        public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMorador() {
        return morador;
    }

    public void setMorador(String morador) {
        this.morador = morador;
    }

    public String getVinculo() {
        return vinculo;
    }

    public void setVinculo(String vinculo) {
        this.vinculo = vinculo;
    }

    public String getDataVisita() {
        return dataVisita;
    }

    public void setDataVisita(String dataVisita) {
        this.dataVisita = dataVisita;
    }

    public String getHoraVisita() {
        return horaVisita;
    }

}
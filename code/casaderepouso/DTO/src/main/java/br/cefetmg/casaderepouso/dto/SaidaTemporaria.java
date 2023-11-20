
package br.cefetmg.casaderepouso.dto;

/**
 *
 * @author rigor
 */
public class SaidaTemporaria {
    private String id;
    private String moradorCpf; 
    private String motivo;
    private String diaSaida;
    private String horarioSaida;
    private String diaVolta;
    private String horarioVolta;
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getId(){
        return id;
    }
    
    public void setMoradorCpf(String cpf){
        this.moradorCpf = cpf;
    }
    
    public String getMoradorCpf(){
        return moradorCpf;
    }
    
    public void setMotivo(String motivo){
        this.motivo = motivo;
    }
    
    public String getMotivo(){
        return motivo;
    }
    
    public void setDataSaida(String dataS){
        this.diaSaida = dataS;
    }
    
    public String getDataSaida(){
        return diaSaida;
    }
    
    public void setHorarioSaida(String horaS){
        this.horarioSaida = horaS;
    }
    
    public String getHorarioSaida(){
        return horarioSaida;
    }
    
    public void setDataVolta(String dataV){
        this.diaVolta = dataV;
    }
    
    public String getDataVolta(){
        return diaVolta;
    }
    
    public void setHorarioVolta(String horaV){
        this.horarioVolta = horaV;
    }
    
    public String getHorarioVolta(){
        return horarioVolta;
    }
    
    
}


import java.util.Calendar;
import 

public class Medicamento implements IMedicamento{

    public Medicamento(Medico medico, String nome, Double valor, String tarja, Calendar validade, Morador morador, String dose, Calendar dataHora) {
        this.nome = nome;
        this.valor = valor;
        this.tarja = tarja;
        this.validade = validade;
        this.morador = morador;
        this.dose = dose;
        this.dataHora = dataHora;
        this.medico = medico;
    }
    
    private Medico medico;
    private String nome;
    private Double valor;
    private String tarja;
    private Calendar validade;
    private Morador morador;
    private String dose;
    private Calendar dataHora;

    
    
    public Medico getMedico() {
        return medico;
    } 

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getTarja() {
        return tarja;
    }

    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public Morador getMorador() {
        return morador;
    }

    public void setMorador(Morador morador) {
        this.morador = morador;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public Calendar getDataHora() {
        return dataHora;
    }

    public void setDataHora(Calendar dataHora) {
        this.dataHora = dataHora;
    }


}

package br.cefetmg.casaderepouso.idao;


import java.util.Calendar;
import br.cefetmg.casaderepouso.dto.Morador;

public interface IMedicamento {
    void SetNome(String nomeRemedio);
    void setMedico(Medico medico);
    void setMorador(Morador morador);
    void setTarja(String tarja);
    void setDose(String dose);
    void setHora(Calendar dataHora);
    void setValor(Double valor);
}

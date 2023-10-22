package br.cefetmg.casaderepouso.idao;


import java.util.Calendar;
import br.cefetmg.casaderepouso.dto.Morador;

public interface IProntuario {
    void setMorador(Morador morador);
    void setMedico(Medico medico);
    void setHora(Calendar dataHora);
    void setRelatorio(String string);
    Morador getMorador();
    Medico getMedico();
    Calendar getHora();
    String getRelatorio();
    
    
}


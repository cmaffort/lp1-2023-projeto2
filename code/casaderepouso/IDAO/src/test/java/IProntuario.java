
import java.util.Calendar;

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

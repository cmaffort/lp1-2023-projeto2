package br.cefetmg.casaderepouso.idao;



import br.cefetmg.casaderepouso.dto.Prontuario;
import java.util.List;
//VELHO
public interface IProntuarioDAO {
    
    public boolean inserir(Prontuario prontuario);
    public List<Prontuario> listarProntuarioMed(String ProfSaudeCPF);
    public List<Prontuario> listarProntuarioMor(String moradorCPF);
    public void AtualizarProntuario(Prontuario prontuario);
    public Boolean deletar(Prontuario prontuario);
    
}


package br.cefetmg.casaderepouso.idao;
import br.cefetmg.casaderepouso.dto.Responsavel;
import java.util.ArrayList;

public interface IResponsavel {
    

    public Long inserir(Responsavel responsavel);

    public boolean atualizar(Responsavel responsavel);

    public boolean deletar(Responsavel responsavel);

    public ArrayList<Responsavel> listarTodos();

    public Responsavel pesquisar(String cpf);

}
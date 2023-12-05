package br.cefetmg.casaderepouso.idao;

import br.cefetmg.casaderepouso.dto.ProfissionalSaude;


public interface IProfissionalSaudeDAO {
    
  public boolean inserir(ProfissionalSaude profiSaude);
  
  public Boolean deletar(String cpf);
  
  public ProfissionalSaude pesquisar(String cpf);
  
}

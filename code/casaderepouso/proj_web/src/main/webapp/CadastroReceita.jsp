<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
      <title>Cadastro de Receita Médica</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">
    </head>
    <body>
      <article>
        <h1>Cadastro de Receita</h1>
        <form id="meuForm" class="form-container" action="Facade" method="POST">
            <input type='hidden' name='act' value='CadastrarReceita'>
          <div class="form-group">
            <label>Profissional de Saúde:</label>
            <input type="text" name="nomeProfissional" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Morador:</label>
            <input type="text" name="morador" class="texto" placeholder="Digite aqui uma data dd/mm/aa ..." required>
          </div>

          <div class="form-group">
            <label>Medicamentos:</label>
            <input type="text" name="medicamentos" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Data:</label>
            <input type="date" name="data" class="texto" placeholder="Digite aqui..." required>
          </div>
          <div class="form-group">
            <label>Hora:</label>
            <input type="time" name="hora" class="texto" placeholder="Digite aqui..." required>
          </div>
            <div class="form-group">
            <label>Quantidade:</label>
            <input type="text" name="quantidade" class="texto" placeholder="Digite aqui..." required>
          </div>
          <div class="form-group">
            <label>Validade:</label>
            <input type="date" name="validade" class="texto" placeholder="Digite aqui..." required>
          </div>
          
            
            <input type="submit" value="Próximo" class="envio">
        </form>
      </article>

    </body> 
</html>
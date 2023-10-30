<%-- 
    Document   : CadastroMorador
    Created on : 9 de out. de 2023, 11:01:34
    Author     : Master
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
      <title>Cadastro de Morador</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">
    </head>
    <body>
      <article>
        <h1>Cadastro de Morador</h1>
        <form id="meuForm" class="form-container" method="POST">
          <div class="form-group">
            <label>Seu nome completo:</label>
            <input type="text" name="nomeMorador" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Data de Nascimento:</label>
            <input type="date" name="dataNasc" class="texto" required>
          </div>

          <div class="form-group">
            <label>Endereço completo:</label>
            <input type="text" name="endereco" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Nome da mãe:</label>
            <input type="text" name="nome_mae" class="texto" placeholder="Digite aqui..." required>
          </div>
          <div class="form-group">
            <label>CPF:</label>
            <input type="text" name="cpf" class="texto" placeholder="Digite aqui..." required>
          </div>
            <div class="form-group">
            <label>Plano médico:</label>
            <input type="text" name="plano_medico" class="texto" placeholder="Digite aqui..." required>
          </div>
          <div class="form-group">
            <label>Condições especiais:</label>
            <input type="text" name="condicoes_especiais" class="texto" placeholder="Digite aqui..." required>
          </div>
          
            
            <input type="submit" value="Próximo" class="envio">
        </form>
      </article>

    </body> 
</html>
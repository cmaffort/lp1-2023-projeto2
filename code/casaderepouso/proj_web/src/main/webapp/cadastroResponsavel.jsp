<%-- 
    Document   : CadastroMorador
    Created on : 9 de out. de 2023, 11:01:34
    Author     : Master
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
      <title>Cadastro de Responsável</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">
    </head>
    <body>
      <article>
        <h1>Cadastro de Responsável</h1>
        <form id="meuForm" action="Facade" class="form-container" method="POST">
          <div class="form-group">
            <label>Nome completo:</label>
            <input type="text" name="nomeResponsavel" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>CPF:</label>
            <input type="text" name="cpf" class="texto" placeholder="Digite aqui..." required>
          </div>
          
          <div class="form-group">
            <label>RG:</label>
            <input type="text" name="rg" class="texto" placeholder="Digite aqui..." required>
          </div>
            
          <div class="form-group">
            <label>Endereço completo:</label>
            <input type="text" name="endereco" class="texto" placeholder="Digite aqui..." required>
          </div>
           
          <div class="form-group">
            <label>CPF do morador a qual é responsável por:</label>
            <input type="text" name="responsavelPor" class="texto" placeholder="Digite aqui..." required>
          </div>
            
          <div class="form-group">
            <label>Senha do morador:</label>
            <input type="text" name="senha" class="texto" placeholder="Digite aqui..." required>
          </div>
            
          <div>
            <label>Telefone de contato:</label>
            <input type="text" name="telefone" class="texto" placeholder="Digite aqui..." required required
              onblur="verificarTelefone()">
          </div>
          <p id="resultado"></p>
      
            <input type="submit" name="act" value="cadastrarResponsavel" class="envio">
        </form>
      </article>

        <script>
        function verificarTelefone() {
          let numero = document.querySelector("#telefone").value;
          numero = numero.replace(/[^a-zA-Z0-9]/g, "");

          if (numero.length !== 11) {
            document.getElementById("resultado").innerHTML = "O telefone não está no formato correto: (DDD + 9 dígitos)";
          }
          else document.getElementById("resultado").innerHTML = "";
        }
      </script>
    </body> 
</html>
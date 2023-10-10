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
            <input type="text" id="nomeVisitante" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Data de Nascimento:</label>
            <input type="date" id="dataNasc" class="texto" required>
          </div>

          <div calss="form-group">
            <label>Endereço completo:</label>
            <input type="text" id="endereco" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Nome da mãe:</label>
            <input type="text" id="nome_mae" class="texto" placeholder="Digite aqui..." required>
          </div>
            
          <div class="form-group">
            <p>Foto frente e verso do RG, CPF e outros caso seja necessário</p>
            <input type="file" name="fotoidentidade" id="identidade" accept="image/*" required/>
            <label class="oculto" id="label_escolheu_identidade" for="identidade" style="color:greenyellow">Imagem escolhida</label>   
          </div>
            
            <input type="submit" value="Próximo" onclick="window.location.href='';"> <!-- atualizar com o arquivo da tela de cadastro de respónsavel -->
        </form>
      </article>
      <script>
            function verificarPreenchimento() {
                let inputArquivo = document.getElementById('identidade');
                let inputEscolheu = document.getElementById('label_escolheu_identidae');
                
                if (inputArquivo.files.length > 0){
                    alert('O campo de arquivo de imagem foi preenchido.');
                    inputEscolheu.classList.add('mostrar');
                    inputEscolheu.classList.remove('oculto');
                } else {
                }
            }
       </script>
    </body> 
</html>
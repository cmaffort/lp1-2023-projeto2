<!DOCTYPE html>
<html>

    <head>
      <title>Cadastro de Morador</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">>
    </head>
    <body>
      <article>
        <h1>Cadastro de Morador</h1>
        <form id="meuForm" class="form-container" method="POST">
          <div class="form-group">
            <label>Nome completo:</label>
            <input type="text" id="nomeVisitante" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>CPF:</label>
            <input type="text" id="CPF" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div calss="form-group">
            <label>Endereço completo:</label>
            <input type="text" id="endereco" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Número de contato:</label>
            <input type="text" id="numero_contato" class="texto" placeholder="Digite aqui..." required>
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
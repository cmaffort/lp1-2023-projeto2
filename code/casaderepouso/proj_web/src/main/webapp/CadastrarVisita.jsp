<%-- Document : CadastroVisitante Created on : 8 de out. de 2023, 11:19:21 Author : Aluno --%>

  <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <title>Agendar visita</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">
    </head>

    <body>
      <article>
        <h1>Cadastro de visita</h1>
        <form class="form-container" action="Facade" method="POST">
           <input type='hidden' name='act' value='CadastrarVisitante'>
          <div class="form-group">
            <label>Seu nome completo:</label>
            <input type="text" name="nomeVisitante" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Sua identidade:</label>
            <input type="text" name="identidade" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div>
            <label>Telefone de contato:</label>
            <input type="tel" name="numero" class="texto" placeholder="Digite aqui..." required required
              onblur="verificarTelefone()">
          </div>
          <p id="resultado"></p>


          <div class="form-group">
            <label>Nome do morador:</label>
            <input type="text" name="morador" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Vínculo com o morador</label>
            <select class="escolha" name="vinculo">
              <option value="Neto">Neto/neta</option>
              <option value="irmao">Irmão/Irmã</option>
              <option value="filho">Filho/filha</option>
              <option value="amigo">Amigo/amiga</option>
              <option value="Sobrinho">Sobrinho/Sobrinha</option>

            </select>
          </div>

          <p>Quando será a visita?</p>
          <div class="form-group" id="marcar">
              <div>
                <label id="calendario" required>Data:</label>
                <input type="date" name="data">
              </div>
              <div>
                <label id="Hora" required>Hora:</label>
                <input type="time" name="hora">
              </div>
          </div>

          <input type="submit" value="AdicionarVisitante">

        </form>
      </article>

      <script>
        function verificarTelefone() {
          let numero = document.querySelector("#numero").value;
          numero = numero.replace(/[^a-zA-Z0-9]/g, "");

          if (numero.length !== 11) {
            document.getElementById("resultado").innerHTML = "O telefone não está no formato correto: (DDD + 9 dígitos)";
          }
          else document.getElementById("resultado").innerHTML = "";
        }
      </script>
    </body>
    </html>
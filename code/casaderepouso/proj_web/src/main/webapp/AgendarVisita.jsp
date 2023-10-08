<%-- Document : CadastroVisitante Created on : 8 de out. de 2023, 11:19:21 Author : Aluno --%>

  <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <title>Agendar visita</title>
      <meta charset="UTF-8">
      <meta name="viewport" content="width=device-width, initial-scale=1.0">
      <link rel="stylesheet" type="text/css" href="cssFiles/AgendarVisita.css">
    </head>

    <body>
      <article>
        <h1>Cadastro de visita</h1>
        <form class="form-container" method="POST">
          <div class="form-group">
            <label>Seu nome completo:</label>
            <input type="text" id="nomeVisitante" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Sua identidade:</label>
            <input type="text" for="identidade" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div>
            <label>Telefone de contato:</label>
            <input type="tel" id="numero" class="texto" placeholder="Digite aqui..." required required
              onblur="verificarTelefone()">
          </div>
          <p id="resultado"></p>


          <div class="form-group">
            <label>Nome do morador:</label>
            <input type="text" id="morador" class="texto" placeholder="Digite aqui..." required>
          </div>

          <div class="form-group">
            <label>Vínculo com o morador</label>
            <select id="parentesco">
              <option value="pais">Pai/mãe</option>
              <option value="irmao">Irmão/Irmã</option>
              <option value="filho">Filho/filha</option>
              <option value="amigo">Amigo/amiga</option>
            </select>
          </div>

          <p>Quando será a visita?</p>
          <div class="form-group" id="marcar">
            <label id="calendario" required>Data:</label>
            <input type="date" for="data">
            <label id="Hora" required>Hora:</label>
            <input type="time" for="hora">
          </div>

          <input type="submit" value="Agendar">

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
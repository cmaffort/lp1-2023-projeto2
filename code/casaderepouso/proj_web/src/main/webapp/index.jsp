<%-- 
    Document   : index
    Created on : 9 de out. de 2023, 19:20:06
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <title>Login</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="cssFiles/index.css">
</head>

<body>
  <div id="branco"></div>
  <form action="Facade" class="form-container" method="POST">
    <h1>Faça login</h1>
    <div class="form-group" class="apertar">
        <label>Usuário:</label>
        <input type="text" id="nomeVisitante" name="cpf" class="texto" placeholder="Digite aqui..." required>
    </div>
    <div class="form-group">
        <label>Senha:</label>
        <input type="password" for="identidade" name="senha" class="texto" placeholder="Digite aqui..." required>
    </div>
    
    <a href="CadastrarVisita.jsp">Sou visitante</a>
    <a>Agendar atividade</a>
    <div id="botao">
      <button value="EfetuarLogin" name="act">Entrar</button>
    </div>
    </form>
  <script>
      let botao = document.querySelector("#botao");
      botao.addEventListener('click', () =>{
         localStorage.setItem("cpfResponsavel", document.querySelector("#nomeVisitante").value); 
      });
  </script>
</body>

</html>
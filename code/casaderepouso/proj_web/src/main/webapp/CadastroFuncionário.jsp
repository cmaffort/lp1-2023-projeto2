<%-- 
    Document   : CadastroFuncionário
    Created on : 3 de out. de 2023, 10:56:43
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionário</title>
        <link rel="stylesheet" type="text/css" href="cssFiles/AgendarVisita.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Gabarito:wght@500&family=Sofia+Sans:wght@500&display=swap" rel="stylesheet">
    </head>
    <body>
        <article>
        <div>
          <h1>Cadastro de funcionário</h1>
            <form class="form-container">
                <label>Nome completo:<br><input type="text" required></label><br>
                <label>CPF:<br><input type="text"required></label><br>
                <label>Endereço completo:<br><input type="text" required></label><br>
                <label>Número de contato:<br><input type="text" required></label><br>
                <label>PIS:<br><input type="number" required></label><br>
                <label>Função:<br><input type="text" required></label><br>
                <label>Período de trabalho:<br><input type="text" required></label><br>
                <label>Anexar Identidade:<br><input type="file" required></label><br>
                <label>Anexar Carteira de Trabalho Digital:<br><input type="file" required></label><br>
                <label>Cadastrar:<input type="submit"></label>
            </form>
        </div>
        </article>
        
        
    </body>
</html>

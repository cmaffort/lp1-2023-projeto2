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
        <link rel="stylesheet" type="text/css" href="/cssFiles/cadastroFuncionario.css">
    </head>
    <body>
        <div class="fundoAzul">
            <h1>Cadastro de funcionário</h1>
            <form>
                <label>Nome completo:<br><input type="text"></label><br>
                <label>CPF:<br><input type="text"></label><br>
                <label>Endereço completo:<br><input type="text"></label><br>
                <label>Número de contato:<br><input type="text"></label><br>
                <label>PIS:<br><input type="number"></label><br>
                <label>Função:<br><input type="text"></label><br>
                <label>Período de trabalho:<br><input type="text"></label><br>
                <label>Anexar Identidade:<br><input type="file"></label><br>
                <label>Anexar Carteira de Trabalho Digital:<br><input type="file"></label><br>
                <label>Cadastrar:<input type="submit"></label>
            </form>
        </div>
        <div class="fundoBranco"></div>
        
    </body>
</html>

<%-- 
    Document   : CadastroMorador
    Created on : 9 de out. de 2023, 11:01:34
    Author     : Master
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
                <label>Nascimento<br><input type="date"></label><br>
                <label>Endereço completo:<br><input type="text"></label><br>
                <label>Nome da mãe<br><input type="text"></label><br>
                <label>Anexar Identidade:<br><input type="file"></label><br>
                <label>Próximo<input type="submit"></label>
            </form>
        </div>
        <div class="fundoBranco"></div>
    </body>
</html>
<%-- 
    Document   : telaGerente
    Created on : 9 de out. de 2023, 14:31:44
    Author     : rigor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="cssFiles/telaGerente.css">
    </head>
    <body>
        <h1>Bem vindo</h1>
        <div id = "botoes">
            <input type="button" value="Novo Funcionário" name="novoFunc" />
            <input type="button" value="Eventos Solicitados" name="eventos" />
            <input type="button" value="Equipamentos" name="equipamentos" />
            <input type="button" value="Inventario" name="inventario" />    
        </div>
        <div id="dadosFunc"></div>
    </body>
</html>

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
            <input type="button" class="btn" value="Novo Funcionário" name="novoFunc" />
            <input type="button" class="btn" value="Eventos Solicitados" name="eventos" />
            <input type="button" class="btn" value="Equipamentos" name="equipamentos" />
            <input type="button" class="btn" value="Inventario" name="inventario" />    
        </div>
        <div id="Func">
            <div class="dadosFunc">
                <p class="info" onclick="mostraInfo()" > mostrar</p>
            </div>
            
        </div>
        
        <script>
            function mostraInfo() {
          
        }
        </script>
    </body>
</html>

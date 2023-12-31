<%-- 
    Document   : nav Funcionario
    Created on : 2 de nov. de 2023, 22:16:55
    Author     : Júlia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            display: flex;
            height: 100vh;
            background-color: #76A5DC;
        }

        .nav {
            width: 18%;
            background-color: white;
            color: black;
            text-align: center;
            padding: 20px;
            box-sizing: border-box;
            padding-top: 15%;
        }
        .button {
            display: block;
            width: 90%;
            padding: 10px;
            margin: 5%;
            background-color: #76A5DC;
            color: #fff;
            border: none;
            text-align: center;
            text-decoration: none;
            cursor: pointer;
            border-radius: 36px;
            box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
        }
        .button:hover{
            background-color: #486F9D;  
        }
        </style>
    </head>
    <body>
        <div class="nav">    
            <a class="button" href="CadastroMorador.jsp">Novo Morador</a>
            <a class="button" href="CadastroSaida.jsp">Cadastro de Saída</a>
            <a class="button" href="#">Inventário</a>
            <a class="button" href="#">Cardápios</a>
            <a class="button" href="#">Equipamentos</a>
            <a class="button" href="GestaoVisitantes.jsp">Visitas</a>
        </div>    
    </body>
</html>

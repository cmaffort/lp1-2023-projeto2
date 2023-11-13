<%-- 
    Document   : navMorador
    Created on : 2 de nov. de 2023, 22:18:26
    Author     : Júlia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>

        .profile-image {
            width: 150px;
            height: 150px;
            border-radius: 50%;
            margin: 10px auto;
        }

        .name {
            font-size: 24px;
            margin: 10px 0;
        }
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
        }
        .button {
            display: block;
            width: 90%;
            padding: 10px;
            margin: 5% 0;
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
            <img class="profile-image" src="./imgs/perfil.png">
            <p class="name">Nome Sobrenome do morador</p>
            <a class="button" href="#">Prontuário</a>
            <a class="button" href="#">Receitas Médicas</a>
            <a class="button" href="AgendarConsulta.jsp">>Solicitar Consulta</a>
            <a class="button" href="gestaoResponsavel.jsp">Responsáveis</a>
            <a class="button" href="cadastroResponsavel.jsp">Novo responsável</a>
        </div>    
    </body>
    <script>
        let nome = localStorage.getItem("nome");
        document.querySelector(".name").innerHTML = nome;
    </script>
</html>

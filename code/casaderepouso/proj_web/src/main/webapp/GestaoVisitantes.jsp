<%-- 
    Document   : GestaoVisitantes
    Created on : 12 de out. de 2023, 01:07:47
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/GestaoVisitante.css">

        <title>Visitas</title>
    </head>
    <body>
        <div class="branco">    
        <img class="profile-image" src="imgs/perfil.png">
        <div class="name">Nome Sobrenome</div>
        <a class="button" href="CadastroMorador.jsp">Novo Morador</a>
        <a class="button" href="#">Inventário</a>
        <a class="button" href="#">Cardápios</a>
        <a class="button" href="#">Equipamentos</a>
        <a class="button" href="GestaoVisitantes.jsp">Visitas</a>
    </div>
    <div class="content">
        <a class="back-button" href="javascript:history.back()""><img src="./imgs/Voltar.png"></a>
        <div class="title">Visitas Agendadas</div>
        <!-- Conteúdo da página de visitas agendadas aqui -->
    </div>
    </body>
</html>

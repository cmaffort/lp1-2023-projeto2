<%-- 
    Document   : gestaoResponsavel
    Created on : 9 de out. de 2023, 13:19:26
    Author     : Particular
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/gestaoResponsavel.css">
        <title>Responsáveis</title>
    </head>
    <body>
        <%@include file="Padrão/navMorador.jsp" %>

    <div class="lista"> 
        <div class="dados">
            <h1>Nome do responsável</h1>
            <p>Número de contato: </p>
            <p>CPF: </p>
            <p>Vínculo com o morador: </p>
            <p>Endereço: </p>
        </div>
        
        <div class="links">
            <p>Acessar documentos</p>
            <p>Acessar histórico médico</p>
        </div>
    </div> 
</body>
</html>

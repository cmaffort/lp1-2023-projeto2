<%-- 
    Document   : telaMudancaStatus
    Created on : 16 de out. de 2023, 18:34:07
    Author     : Master
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/telaMudancaStatus.css">

        <title>Morador</title>
    </head>
    <body>
        <%@include file="Padrão/navMorador.jsp" %>

        <div class="content">
            <a class="back-button" href="telaInfoMorador.jsp""><img src="./imgs/Voltar.png"></a>
            <h1 class="title">Mudança de Status</h1>
            <div id="status-container">
                <div class="state-container">
                    <span class="state-cor" style="background-color: #14FF00;"></span><p>Disponível</p><span class="marks"id="mark-disponivel"></span>
                </div>
                <div class="state-container">
                    <span class="state-cor" style="background-color: #2882EB;"></span><p>Saída Temporária</p><span class="marks"id="mark-saida"></span>
                </div>
                <div class="state-container">
                    <span class="state-cor" style="background-color: #FF0000;"></span><p>Internado</p><span class="marks"id="mark-internado"></span>
                </div>
                <div class="state-container">
                    <span class="state-cor" style="background-color: #1E1E1E;"></span><p>Falecido</p><span class="marks"id="mark-falecido"></span>
                </div>
                <a id="update-status" href=''>Atualizar status</a>
            </div>
        </div>
        <script>
            let marcadores = document.querySelectorAll(".marks");
            let elementoSelecionado = null;
            marcadores.forEach(marc => {
            marc.addEventListener("click", () =>{
                    if (elementoSelecionado) {
                    elementoSelecionado.style.backgroundColor = "#D9D9D9"; 
                }
                marc.style.backgroundColor = "black";  
                elementoSelecionado = marc;  
            });
        });
        </script>
    </body>
</html>

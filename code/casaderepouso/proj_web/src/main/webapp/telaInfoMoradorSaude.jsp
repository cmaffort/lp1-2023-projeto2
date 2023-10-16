<%-- 
    Document   : telaInfoMoradorSaude
    Created on : 16 de out. de 2023, 18:13:21
    Author     : Master
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/telaInfoMorador.css">

        <title>Morador</title>
    </head>
    <body>
        <div class="branco">    
            <img class="profile-image" src="imgs/perfil.png">
            <a class="button" href="#">Adicionar Prontuário</a>
            <a class="button" href="#">Adicionar Receita</a>
            <a class="button" href="#">Adicionar Dieta</a>
            <a class="button" href="#">Consultas Marcadas</a>
        </div>
        <div class="content">
            <a class="back-button" href="javascript:history.back()"">←</a>
            <div id="title-container">
                <h1 id="name">Nome do Morador</h1>
                <div id="state-container">
                    <span id="state-cor"></span><p id="state-nome">Status</p>
                </div>
                <h2 id="nascimento">XX/XX/XXXX</h2>       
            </div>
            <div id="info-container">
                <p class="info-content" id="med-res">Médico Responsável</p>
                <p class="info-content" id="nutri-res">Nutricionista Responsável</p>
                <p class="info-content" id="plano-medico">Plano Médico</p>
            </div>
            <div id="info-access">  
                <a class="links-acessos">Acessar documentos</a>
                <a class="links-acessos">Acessar receitas médicas</a>
                <a class="links-acessos">Acessar resultados de exames</a>
                <a class="links-acessos">Acessar histórico médico</a>
            </div>
        </div>
    </body>
</html>

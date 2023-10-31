<%-- 
    Document   : telaInfoMorador
    Created on : 16 de out. de 2023, 14:26:59
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
            <a class="button" href="CadastroMorador.jsp">Prontuário</a>
            <a class="button" href="#">Receitas Médicas</a>
            <a class="button" href="#">Dieta</a>
            <a class="button" href="#">Solicitar Consulta</a>
            <a class="button" href="GestaoVisitantes.jsp">Responsáveis</a>
            <a class="button" href="cadastroResponsavel.jsp">Novo Responsável</a>
        </div>
        <div class="content">
            <a class="back-button" href="telaFuncionario.jsp""><img src="./imgs/Voltar.png"></a>
            <div id="title-container">
                <h1 id="name">Nome do Morador</h1>
                <a href='telaMudancaStatus.jsp' style='text-decoration: none; color: black;'><div id="state-container">
                    <span id="state-cor"></span><p id="state-nome">Status</p>
                </div></a>
                <h2 id="nascimento">XX/XX/XXXX</h2>       
            </div>
            <div id="info-container">
                <p class="info-content" id="cpf">CPF:</p>
                <p class="info-content" id="mae-nome">Nome da Mãe:</p>
                <p class="info-content" id="estado-civil">Estado civil:</p>
                <p class="info-content" id="endereco">Endereço:</p>
                <p class="info-content" id="plano-medico">Plano médico:</p>
                <p class="info-content" id="condicoes">Condições especiais:</p>
            </div>
            <div id="info-access">  
                <!-- comment <a class="links-acessos">Acessar documentos</a> -->
                <a class="links-acessos">Acessar receitas médicas</a>
                <a class="links-acessos">Acessar resultados de exames</a>
                <a class="links-acessos">Acessar histórico médico</a>
            </div>
            <div>
                <button id="botao-deletar">Deletar</button>
            </div>
        </div>
    <script src="scripts/enviarInfoMorador.js"></script>
    </body>
</html>

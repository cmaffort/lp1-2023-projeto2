<%-- 
    Document   : TelaInicialMorador
    Created on : 9 de out. de 2023, 15:51:04
    Author     : Master
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tela Inicial Morador</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="cssFiles/TelaInicialResponsavel.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Gabarito:wght@500&family=Sofia+Sans:wght@500&display=swap" rel="stylesheet">
    </head>       
    <body>
        <header id="perfil">
                <img src="./imgs/perfil.png" class="imagemDoPerfil">
                 <strong><p id="bemvindo">Seja bem vindo, Nome.</p> </strong>
        </header>
        <article>
            <div id="container-opcoes">
                <div id="container-botoes">
                    <div>
                        <button class="Botao">Pagamento da mensalidade</button>
                    </div>
                    <div>
                        <button class="Botao">Cancelamento de vinculo</button>
                    </div>
                    <div>
                        <button class="Botao">Agendar Saída Temporária</button>
                    </div>
                </div>
                <div id="texto">
                    <p>“Nosso maior compromisso é com o bem estar da sua pessoa querida”</p>
                </div>
                <div id="container-imagens">
                    <div>
                        <img class="imgmoradores" src="./imgs/imagemmorador1.png">
                    </div>
                    <div>
                        <img class="imgmoradores" src="./imgs/imagemmorador2.jpg">
                    </div>
                </div>
            </div>
        </article>
    </body>
</html>

<%-- 
    Document   : GestãoMedicamento
    Created on : 15 de out. de 2023, 14:51:58
    Author     : felli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="import br.cefetmg.casaderepouso.dto.Medicamento"%>
<%@page import="java.util.List" %>

<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gestão de Medicamentost</title>
        <link href="https://fonts.googleapis.com/css2?family=Gabarito:wght@400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="cssFiles/.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

    <div id="main">
    <div id="solicitados">
        <h1>Medicamento solicitados</h1>
        <div>
            <article>
                <div id="medicamento">
                    <p class="nome">nome</p>
                    <p class="quant">quantidade</p>
                    <p class="fornecedor">fornecedor</p>
                    <button class="bot">X</button>
                </div>
            </article>
            <article>
                <div id="medicamento">
                    <p class="nome">nome</p>
                    <p class="quant">quantidade</p>
                    <p class="fornecedor">fornecedor</p>
                    <button class="bot">X</button>
                </div>
            </article>
            <article>
                <div id="medicamento">
                    <p class="nome">nome</p>
                    <p class="quant">quantidade</p>
                    <p class="fornecedor">fornecedor</p>
                    <button class="bot">X</button>
                </div>
            </article>
            


            
        </div>  
        <a href="CadastroMedicamento.jsp" id="solicitar">Visitas</a>
    </div>

    <div id="estoque">
        <h1>Medicamento estoque</h1>
        <div>
            <article>
                <div id="medicamentoEstoque">
                    <p class="nome">nome</p>
                    <p class="quant">quantidade</p>
                    <p class="fornecedor">fornecedor</p>
                    <p class="dataCompra">dd/mm/nn</p>
                </div>
            </article>
            <article>
                <div id="medicamentoEstoque">
                    <p class="nome">nome</p>
                    <p class="quant">quantidade</p>
                    <p class="fornecedor">fornecedor</p>
                    <p class="dataCompra">dd/mm/nn</p>
                </div>
            </article>
            <article>
                <div id="medicamentoEstoque">
                    <p class="nome">nome</p>
                    <p class="quant">quantidade</p>
                    <p class="fornecedor">fornecedor</p>
                    <p class="dataCompra">dd/mm/nn</p>
                </div>
            </article>

        </div>
    </div>
        
    </div>
</body>
</html>

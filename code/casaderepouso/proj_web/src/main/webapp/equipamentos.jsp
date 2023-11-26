<%-- 
    Document   : equipamentos
    Created on : 25 de nov. de 2023, 17:21:50
    Author     : Particular
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/equipamento.css">
        <title>Equipamentos</title>
    </head>
    <body>
        <%@include file="Padrão/navGerente.jsp" %>
        
        <div class="titles">
            <h1>Bem vindo, nome</h1>
            <h2>Inventário</h2>
        </div>
        <button class="botao-cadastrar">Cadastrar Equipamento</button>
        <div class="cadastrar-container">
            <form class="form-container"  action="Facade" method="POST">
                <div class="form-group">
                    <label>Tipo:</label>
                    <input type="text" name="tipoEquipamento" class="texto" placeholder="Digite aqui..." >
                </div>

                <div class="form-group">
                    <label>Preço:</label>
                    <input type="text" name="preco" class="texto" placeholder="Digite aqui..." >
                </div>

                <div class="form-group">
                    <label>Quantidade:</label>
                    <input type="text" name="quantidade" class="texto" placeholder="Digite aqui..." >
                </div>

                <div class="form-group">
                    <label>Estado:</label>
                    <input type="text" name="estado" class="texto" placeholder="Digite aqui..." >
                </div>
                
                <div>
                    <button name="act" value="cadastrarEquipamento" style="width: 100%;" class="cadastro">Cadastrar Equipamento</button>
                    <a class="cancelarCadastro" style="width: 100%; background-color: #FF0000; cursor: pointer;">Cancelar</a>
                </div>

                <script src="scripts/equipamento.js"></script>
            </form>
        </div>
    </body>
</html>

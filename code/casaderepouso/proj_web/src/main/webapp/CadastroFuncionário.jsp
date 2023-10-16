<%-- 
    Document   : CadastroFuncionário
    Created on : 3 de out. de 2023, 10:56:43
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionário</title>
        <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Gabarito:wght@500&family=Sofia+Sans:wght@500&display=swap" rel="stylesheet">
    </head>
    <body>
        <article>
        <div>
          <h1>Cadastro de funcionário</h1>
          <form class="form-container">
            <div class="form-group">
                <label>Nome completo:</label>
                <input type="text" id="nomeFuncionário" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label>CPF:</label>
                <input type="text" id="cpf" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label>Endereço completo:</label>
                <input type="text" id="endereco" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label>Numero de contato:</label>
                <input type="tel" id="telefone" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label>PIS:</label>
                <input type="tel" id="pis" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label> Função:</label>
                <input type="text" id="funcao" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label>Periodo de trabalho:</label>
                <input type="text" id="periodo" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label>Anexar identidade:</label>
                <input type="file" required>               
            </div>
            <div class="form-group">
                <label>Anexar carteira de trabalho digital:</label>
                <input type="file" required>               
            </div>
            <label>Cadastrar:</label>
            <input type="submit" class="envio">
            </form>
        </div>
        </article>
        
        
    </body>
</html>

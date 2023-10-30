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
          <form class="form-container" action="facade" method="POST">
            <div class="form-group">
                <label>Nome completo:</label>
                <input type="text" name="nomeFuncionario" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label>CPF:</label>
                <input type="text" name="cpf" class="texto" placeholder="Digite aqui..." required>                
            </div>
              <div class="form-group">
                <label>RG:</label>
                <input type="text" name="rg" class="texto" placeholder="Digite aqui..." required>                
            </div>
             <div class="form-group">
                <label>Data de Nascimento:</label>
                <input type="date" name="dataNasc" class="texto" placeholder="Digite aqui..." required>                
            </div> 
            <div class="form-group">
                <label>Endereço completo:</label>
                <input type="text" name="endereco" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label>Numero de contato:</label>
                <input type="text" name="telefone" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label>PIS:</label>
                <input type="text" name="pis" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label> Função:</label>
                <input type="text" name="funcao" class="texto" placeholder="Digite aqui..." required>                
            </div>
            <div class="form-group">
                <label>Periodo de trabalho:</label>
                <input type="text" name="periodo" class="texto" placeholder="Digite aqui..." required>                
            </div>
            
            <label>Cadastrar:</label>
            <input type="submit" class="envio" name="act" value="cadastrarFuncionario">
            </form>
        </div>
        </article>
        
        
    </body>
</html>

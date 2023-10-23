<%-- 
    Document   : cadastroMedicamento
    Created on : 11 de out. de 2023, 10:22:30
    Author     : felli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Gabarito:wght@400;500;700&display=swap" rel="stylesheet">
     <link rel="stylesheet" type="text/css" href="cssFiles/cadastroMedicamentos.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro medicamento</title>
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

    
    <form action="post" id="formulario">
        <h1>SOLICITAR NOVO MEDICAMENTO</h1>
        <label>Nome do medicamento<br><input type="text" id="nome"></label><br>
        <label class="tarja">Tarjeta<br><select name="tarja">
                <option value="livre">sem tarja</option>
                <option value="vermelha" selected>vermelha</option>
                <option value="amarela">amarela</option>
                <option value="preta">preta</option>
            </select>
        </label>
        <br>
        <label>Medico Responsavel<br>
            <select>
                <option value="livre">Ronaldo Nazario</option>
                <option value="vermelha" selected>Cristiano Madeira Ronaldo</option>
                <option value="amarela">Lionel Messi</option>
                <option value="preta">Neymar dos Santos Junior</option></label><br>
        </select>
        <label>dosagem<br><input type="text" id="dose"></label><br>
        <label>horario de aplicação<br><input type="time" id="hora"></label>
        <label>intervalo de aplicação<br><input type="time"></input></label>
        <button type="submit" name="submit">cadastrar</button>
    </form>
</body>
</html>

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
        <label>Nome do medicamento<br><input type="text" id="nome" name="nome"></label><br>
        <label class="tarja">Tarjeta<br><select name="tarja">
                <option value="livre">sem tarja</option>
                <option value="vermelha" selected>vermelha</option>
                <option value="amarela">amarela</option>
                <option value="preta">preta</option>
            </select>
        </label>
        <br>
        <label>dosagem<br><input type="text" id="dose" name="dose"></label><br>
        <label>horario da primeira aplicação<br><input type="time" id="hora" name="hora"></label>
        <label>intervalo de aplicação<br><input type="time" id="intervalo" name="intervalo"></input></label>
        <label>validade<br><input type="date" id="validade" name="validade"></input></label>
        <label>valor<br><input type="number" id="valor" name="valor"></label>
        <label>morador<br><input type="text" id="morador" name="morador"></label>
        <button type="submit" name="submit">cadastrar</button>
    </form>
</body>
</html>

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
     <link rel="stylesheet" type="text/css" href="cssFiles/cadastroMedicamento.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro medicamento</title>
</head>
    <body>
         <%@include file="Padrão/navFuncionario.jsp" %>


    
    <form action="Facade" method="POST" id="formulario">
        <input type="hidden" name="act" value="CadastraMedicamentos">
        
        <h1>SOLICITAR NOVO MEDICAMENTO</h1>
        <label>Nome do medicamento<br><input type="text" id="nome" name="nome" required></label><br>
        <label class="tarja">Tarjeta<br><select name="tarja"  required>
                <option value="SEM_TARJA">sem tarja</option>
                <option value="VERMELHA" selected>vermelha</option>
                <option value="AMARELA">amarela</option>
                <option value="PRETA">preta</option>
            </select>
        </label>
        <br>
        <div class="dados">
        <label>dosagem<br><input type="text" id="dose" name="dose"  required></label><br>
        </div>
        <div class="dados">
        <label>intervalo de aplicação<br><input type="time" id="intervalo" name="intervalo"  required></label>
        </div>
        <div class="dados">
        <label>validade<br><input type="date" id="validade" name="validade"  required></label>
        </div>
        <div class="dados">
        <label>valor<br><input type="text" id="valor" name="valor" required></label>
        </div>
        <div class="dados">
        <label>morador<br><input type="hidden" iid="morador" name="morador" required></label>
        </div>
        <input type="submit" >
        
    </form>
         <script>
             window.onload = function() {
             let morador = document.getElementById("morador");
             morador.value = localStorage.getItem('cpf');
         }
         </script>
        
</body>
</html>
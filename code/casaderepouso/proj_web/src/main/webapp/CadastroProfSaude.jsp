<%-- 
    Document   : CadastroProfSaude
    Created on : 11 de nov. de 2023, 10:51:51
    Author     : felli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Profissinal de Saude</title>
        <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">
    </head>
    <body>
        <div>
        <h1>Cadastro Profissional de Saude</h1>
        <form action="Facade" method="POST" id="formulario">
        <input type="hidden" name="act" value="CadastraProfSaude">
            
       <label>nome<br><input type="text" id="nome" name="nome"  required></label><br>
       <label class="especializao">especializacao<br><select name="especializacao"  required>
                <option value="MEDICO">MEDICO</option>
                <option value="NUTRICIONISTA" selected>NUTRICIONISTA</option>
                <option value="ENFERMEITO">ENFERMEITO</option>
            </select>
        </label>

        <label>CPF<br><input type="text" id="cpf" name="cpf"  required></label>
        <label>Registro<br><input type="text" id="registro" name="registro" placeholder="CRM, CRN, COFEN" required></label>
        <input type="submit">
        
        
        </form>
        </div>
    </body>
</html>

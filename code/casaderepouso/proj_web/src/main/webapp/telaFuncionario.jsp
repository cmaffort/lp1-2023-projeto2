<%-- 
    Document   : telaFuncionario
    Created on : 27 de out. de 2023, 08:04:42
    Author     : rigor
--%>

<%@page import="br.cefetmg.casaderepouso.dto.Morador" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/telaFuncionario.css">

        <title>Home-Funcionário</title>
    </head>
    <body>
        
        <div class="branco">
        <img class="profile-image" src="imgs/perfil.png">
        <div class="name">Bem vindo</div>
        <a class="button" href="CadastroMorador.jsp">Novo morador</a>
        <a class="button" href="#">Inventário</a>
        <a class="button" href="#">Cardápio</a>
        <a class="button" href="#">Equipamentos</a>
        <a class="button" href="GestaoVisitantes.jsp">Visitas</a>
        
    </div>
    <div class="content">
        <div class="title">Dados dos moradores</div>
        <form action="Facade" method="POST">
            <input type="submit" name="act" value="listarMorador">   
        </form>
        <div id="container-lista-moradores">
                    <div class="morador-container">
			<p class="nome-cpf">Nome</p>
                        <p class="nome-cpf">cpf</p>
                        <a href='telaMudancaStatus.jsp' style='text-decoration: none; color: black;'>
                            <div id="state-container">
                                <span id="state-cor"></span><p id="state-nome">Status</p>
                            </div>
                        </a>
                    </div>
                     <%
                        List<Morador> listaMoradores = (List<Morador>) request.getAttribute("listMor");
                        if(listaMoradores != null){
                        for (Morador mor: listaMoradores) {
                    %>
                    <a class="botao-morador" href="javascript: enviarInfo(<%=mor.getNome()%>,<%=mor.getCpf()%>,<%=mor.getEstado()%>,<%=mor.getNomeMae()%>, <%=mor.getCondicaoEspecial()%>)" href="telaInfoMorador.jsp">
                    <div class="morador-container">
			<p><%=mor.getNome()%></p>
                        <p><%=mor.getCpf()%></p>
                        <p><%=mor.getEstado()%></p>
                    </div>
                    </a>
			<%
				}
                        }
			%>
        </div>
    </div>
    <script src="scripts/enviarInfoMorador.js"></script>
    </body>
</html>


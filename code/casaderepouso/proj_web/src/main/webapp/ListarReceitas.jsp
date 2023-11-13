<%-- 
    Document   : ListarReceitas
    Created on : 11 de nov. de 2023, 15:33:31
    Author     : Particular
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Receita"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/ListarReceitas.css">
        <title>Receitas</title>
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
                <a class="button" href="CadastroReceita.jsp">Nova Receita</a>
        </div>
        
        <form action="Facade" method="POST">
            <input type="submit" name="act" value="ListarReceita">   
        </form>
        <%
            List<Receita> listReceita = (List<Receita>) request.getAttribute("listReceitas");
            if(listReceita != null){
            for (Receita receita: listReceita) {
        %>
        <div class="lista"> 
            <div class="dados">
                <p>Profissional de Saúde: <%=receita.getProfissionalSaude()%></p>
                <p>Morador: <%=receita.getMorador()%></p>
                <p>Medicamentos: <%=receita.getMedicamentos()%></p>
                <p>Data: <%=receita.getData()%></p>
                <p>Hora: <%=receita.getHora()%></p>
                <p>Quantidade: <%=receita.getQuantidade()%></p>
                <p>Validade: <%=receita.getValidade()%></p>
            </div>
        </div>
        <%
                }
            }
        %>
    </body>
</html>

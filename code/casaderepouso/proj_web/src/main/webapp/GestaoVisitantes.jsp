<%-- 
    Document   : GestaoVisitantes
    Created on : 12 de out. de 2023, 01:07:47
    Author     : Júlia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Visitante"%>
<%@page import="br.cefetmg.casaderepouso.DAO.VisitanteDAO"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="cssFiles/gestaoVisitante.css">

        <title>Visitas</title>
        
    </head>
    <body>
    <%@include file="Padrão/navFuncionario.jsp" %>
    <article>
        <a class="back-button" href="javascript:history.back()"><img src="./imgs/Voltar.png"></a>
        <div class="title">Visitas Agendadas</div>
        
        <form action="Facade" method="POST">
            <button name="act" value="listarVisitante">Todos os visitantes</button>
        </form>
		
                    <%
                        List<Visitante> listaVisitantes = (List<Visitante>) request.getAttribute("listVis");
                        if(listaVisitantes != null){
                            for (Visitante vis: listaVisitantes){
                    %>
                    <div id="visita-info">
                        <div id="data">
                            <p><%=vis.getDataVisita()%></p>
                            <p><%=vis.getHoraVisita()%></p>
                        </div>
                        <div id="info">
                            <p>Visitante: <%=vis.getNome()%></p>
                            <p>Rg: <%=vis.getRg()%></p>
                            <p>Morador: <%=vis.getMorador()%> - <%=vis.getVinculo()%></p>
                            <a>Entrar em contato</a>
                        </div>
                     </div>
			<%
				}
                        }
			%>
    </article>

    </body>
</html>
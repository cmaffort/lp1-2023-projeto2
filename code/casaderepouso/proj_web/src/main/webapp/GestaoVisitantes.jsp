<%-- 
    Document   : GestaoVisitantes
    Created on : 12 de out. de 2023, 01:07:47
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Visitante"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/GestaoVisitante.css">

        <title>Visitas</title>
    </head>
    <body>
    <%@include file="Padrão/navFuncionario.jsp" %>
    <div class="content">
        <a class="back-button" href="javascript:history.back()""><img src="./imgs/Voltar.png"></a>
        <div class="title">Visitas Agendadas</div>
        
        <form action="Facade" method="POST">
            <button name="act" value="listarVisitantes">Visitante</button>
        </form>
        <table id="tabela">
		<thead>
                    <tr>
                        <th>Nome</th>
                        <th>RG</th>
                        <th>Telefone</th>
                        <th>vinculo</th>
                        <th>Morador</th>
                        <th>Data/hora</th>
                    </tr>
		</thead>
		<tbody>
                     <%
                        List<Visitante> listVisitantes = (List<Visitante>)request.getAttribute("visitanteList");
                            for(Visitante vis: listVisitantes) {
                    %>
                                <tr>
                                    <td><%=vis.getNome()%></td>
                                    <td><%=vis.getRg()%></td>
                                    <td><%=vis.getTelefone()%></td>
                                    <td><%=vis.getVinculo()%></td>
                                    <td><%=vis.getDataVisita()%></td>
                                </tr>
			<%
                            }
			%>
		</tbody>
	</table>    </div>
    </body>
</html>

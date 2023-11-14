<%-- 
    Document   : consultas
    Created on : 13 de nov. de 2023, 18:17:48
    Author     : jujua
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Consulta"%>
<%@page import="br.cefetmg.casaderepouso.DAO.ConsultaDAO"%>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consultas</title>
        <link rel="stylesheet" href="cssFiles/gestaoVisitante.css">

    </head>
    <body>
        <%@include file="Padrão/navMorador.jsp" %>
        <article>
        <a class="back-button" href="javascript:history.back()"><img src="./imgs/Voltar.png"></a>
        <div class="title">Consultas agendadas</div>
        
        <form action="Facade" method="POST">
            <button name="act" value="listarConsultas">Todos as consultas</button>
        </form>
        
        		
                    <%
                        List<Consulta> listaConsultas = (List<Consulta>)request.getAttribute("listCons");
                        if(listaConsultas != null){
                            for (Consulta cons: listaConsultas){
                    %>
                    <div id="visita-info">
                        <div id="data">
                            <p><%=cons.getData()%></p>
                            <p><%=cons.getHora()%></p>
                        </div>
                        <div id="info">
                            <p>Nome do profissional: <%=cons.getProfissional()%></p>
                            <p>Especialização: <%=cons.getEspecializacao()%></p>
                            <p>Tipo de consulta: <%=cons.getTipo()%></p>
                        </div>
                     </div>
			<%
				}
                        }
			%>
    </article>
    </body>
</html>
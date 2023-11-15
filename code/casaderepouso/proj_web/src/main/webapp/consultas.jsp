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
        <style>
            button{
                width: 40vw;
                height: 4vh;
                box-shadow: 0px 4px 4px 0px rgba(0, 0, 0, 0.25);
                background: #FFF;
                border-radius: 0%;
                padding: 1%;
                font-size: 100%;
                margin-top: 1%;
                border: none;
                width: 30%;
            }
        </style>
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
                    <p>Tipo de consulta: <%=cons.getProfissional()%></p>
                    <p>Nome do profissional: <%=cons.getEspecializacao()%></p>
                    <p>Especialização: <%=cons.getTipo()%></p>
                </div>
            </div>
            <%
                    }
            }
            %>
        </article>
         </body>
</html>
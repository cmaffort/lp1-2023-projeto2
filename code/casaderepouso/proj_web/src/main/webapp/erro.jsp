<%-- 
    Document   : erro
    Created on : 29 de out. de 2023, 17:46:33
    Author     : felli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%!
String erro = "";
%>
<%
erro = (String)request.getAttribute("erro");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Locadora xxx</title>
    </head>
    <body>
        <h2><%=erro%></h2>
    </body>
</html>
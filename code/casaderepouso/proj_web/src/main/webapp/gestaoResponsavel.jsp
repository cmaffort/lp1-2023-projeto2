

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Responsavel"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/gestaoResponsavel.css">
        <title>Responsáveis</title>
    </head>
    <body>
        <%@include file="Padrão/navMorador.jsp" %>
    
    <form action="Facade" method="POST">
        <input type="submit" name="act" value="listarResponsavel">   
    </form>
    
        <%
            List<Responsavel> listResponsavel = (List<Responsavel>) request.getAttribute("listResp");
            if(listResponsavel != null){
            for (Responsavel responsavel: listResponsavel) {
        %>
        <div class="lista"> 
            <div class="dados">
                <h1><%=responsavel.getNome()%></h1>
                <p>Número de contato: <%=responsavel.getTelefone()%></p>
                <p>CPF: <%=responsavel.getCpf()%></p>
                <p>Vínculo com o morador: <%=responsavel.getResponsavelPor()%></p>
                <p>Endereço: <%=responsavel.getEndereco()%></p>
            </div>

            <div class="links">
                <p>Acessar documentos</p>
                <p>Acessar histórico médico</p>
            </div>
            <%
                }
            }
            %>
    </div> 
</body>
</html>

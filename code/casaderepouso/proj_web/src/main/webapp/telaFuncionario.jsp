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
        <link rel="stylesheet" type="text/css" href="cssFiles/telaGerente.css">

        <title>Home-Funcionário</title>
    </head>
    <body>
        <div class="branco">    
        <div class="name">Bem vindo</div>
        <a class="button" href="CadastroMorador.jsp">Novo morador</a>
        <a class="button" href="#">Inventário</a>
        <a class="button" href="#">Cardápio</a>
        <a class="button" href="#">Equipamentos</a>
        <a class="button" href="GestaoVisitantes.jsp">Visitas</a>
        
    </div>
    <div class="content">
        <a class="back-button" href="javascript:history.back()""><img src="./imgs/Voltar.png"></a>
        <div class="title">Dados dos moradores</div>
        <table id="tabela">
		<thead>
                    <tr>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>Estado</th>
                    </tr>
		</thead>
		<tbody>
                     <%
                        List<Morador> listaMoradores = (List<Morador>) request.getAttribute("listMor");
                        if(listaMoradores != null){
                        for (Morador mor: listaMoradores) {
                    %>
                        <a href="telaInfoMorador.jsp"><tr class="morador-container">
				<td><%=mor.getNome()%></td>
                                <td><%=mor.getCpf()%></td>
				<td><%=mor.getEstado()%></td>         
			</tr>
                        </a>
			<%
				}
                        }
			%>
		</tbody>
	</table>
    </div>
    <script src="scripts/enviarInfoMorador.js"></script>
    </body>
</html>


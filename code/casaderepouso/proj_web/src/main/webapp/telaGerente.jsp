
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Funcionario" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/telaGerente.css">

        <title>Home-Gerente</title>
    </head>
    <body>
        <div class="branco">    
        <div class="name">Bem vindo</div>
        <a class="button" href="CadastroFuncionario.jsp">Novo funcionário</a>
        <a class="button" href="#">Eventos solicitados</a>
        <a class="button" href="#">Inventário</a>
        <a class="button" href="#">Equipamentos</a>
        
    </div>
    <div class="content">
        <a class="back-button" href="javascript:history.back()""><img src="./imgs/Voltar.png"></a>
        <div class="title">Dados dos funcionários</div>
        <form action="Facade" method="POST">
            <input type="submit" name="act" value="listarFuncionario">   
        </form>
        <table id="tabela">
		<thead>
                    <tr>
                        <th>Id</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Telefone</th>
                        <th>Nascimento</th>
                        <th>Endereço</th>
                        <th>PIS</th>
                        <th>Função</th>
                        <th>Período de Trabalho</th>
                        <th>Opções</th>
                    </tr>
		</thead>
		<tbody>
                     <%
                        List<Funcionario> listFuncionarios = (List<Funcionario>) request.getAttribute("listFunc");
                        for (Funcionario func: listFuncionarios) {
                    %>
			<tr>
                            <td><%=func.getId()%></td>
                            <td><%=func.getNome()%></td>
                            <td><%=func.getCpf()%></td>
                            <td><%=func.getRg()%></td>
                            <td><%=func.getFone()%></td>
                            <td><%=func.getDataNasc()%></td>
                            <td><%=func.getEndereco()%></td>
                            <td><%=func.getPis()%></td>
                            <td><%=func.getFuncao()%></td>
                            <td><%=func.getPeriodoTrabalho()%></td>
                            <td>
                            <a href="select?id=<%=func.getId()%>"
                            class="Botao1">Editar</a>
                            <a href="javascript: confirma(<%=func.getId()%>)"
                            class="Botao2">Excluir</a>
                            </td>
			</tr>
			<%
                            }
			%>
		</tbody>
	</table>
        
        
    </div>
    <script src="scripts/confirmador.js"></script>
    </body>
</html>

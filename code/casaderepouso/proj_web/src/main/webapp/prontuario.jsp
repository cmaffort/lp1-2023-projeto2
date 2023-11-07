<%-- 
    Document   : prontuario
    Created on : 6 de nov. de 2023, 10:23:57
    Author     : Aluno
--%>
<%@page import="br.cefetmg.casaderepouso.dto.Refeicao" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Prontuário</title>
    </head>
    <body>
        <%@include file="Padrão/navFuncionario.jsp" %>
    <thead>
        <tr>
            <th style="display:none;">CPF</th>
            <th>Hora</th>
            <th>Cardapio</th>
            <th>tipo</th>
            <th>dia</th>
        </tr>
    </thead>
    <tbody>
        <%
           List<Refeicao> listRefeicao = (List<Refeicao>) request.getAttribute("listRef");
           if(listRefeicao != null){
               for (Refeicao ref: listRefeicao) {
        %>
        <tr>
            <td style="display:none;"><%=ref.getCpfMorador()%></td>
            <td><%=ref.getHora()%></td>
            <td><%=ref.getCardapio()%></td>
            <td><%=ref.getTipo()%></td>
            <td><%=ref.getDia()%></td>
            <!--
            <td>
                <a href="select?id=
                   class="Botao1">Editar</a>
            </td>
            -->
        </tr>
        <%
            }
            }
        }
        %>
    <form id="meuForm" class="form-container" action="Facade" method="POST">
        <input type='hidden' name='act' value='CadastrarRefeicao'>
        <div style="display:none;" class="form-group">
            <input id="inputcpf"type="text" name="cpf" class="texto">
        </div>
        <div class="form-group">
            <label>Dia da semana:</label>
            <select name="dia">
                <option value="domingo">domingo</option>
                <option value="segunda">segunda</option>
                <option value="terca">terça</option>
                <option value="quarta">quarta</option>
                <option value="quinta">quinta</option>
                <option value="sexta">sexta</option>
                <option value="sabado">sabado</option>
            </select>
        </div>
        <div class="form-group">
            <label>Hora:</label>
            <input type="text" name="hora" class="texto" placeholder="Digite aqui uma data dd/mm/aa ..." required>
        </div>
        <div class="form-group">
            <label>Tipo:</label>
            <input type="text" name="tipo" class="texto" placeholder="Digite aqui..." required>
        </div>
        <div class="form-group">
            <label>Cardapio:</label>
            <input type="text" name="cardapio" class="texto" placeholder="Digite aqui..." required>
        </div>
        <input type="submit" value="Adicionar" class="envio">
    </form>
</tbody>
<script src="refeicao.js"></script>
</body>
</html>

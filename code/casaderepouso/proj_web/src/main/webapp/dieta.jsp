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
        <link rel="stylesheet" type="text/css" href="cssFiles/dieta.css">
        <title>Prontuário</title>
    </head>
    <body>
        <%@include file="Padrão/navMorador.jsp" %>
        <div id="content">
            <a class="back-button" href="telaFuncionario.jsp""><img src="./imgs/Voltar.png"></a>
            <h2 style="margin: 0;" id="title"></h2>
            <script>document.querySelector("#title").innerHTML = "Dieta de " + localStorage.getItem("nome");</script>
            <form action="Facade" method="POST">
                <input id="ListarRefeicao"type="submit" name="act" value="ListarRefeicao">   
            </form>
            <div id="container-info">
                <table id="tabela">
                    <thead>
                        <tr>
                            <th style="display:none;">CPF</th>
                            <th>dia</th>
                            <th>Hora</th>
                            <th>tipo</th>
                            <th>Cardapio</th>
                            <th>x</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                           List<Refeicao> listRefeicao = (List<Refeicao>) request.getAttribute("listRef");
                           if(listRefeicao != null){
                               for (Refeicao ref: listRefeicao) {
                        %>
                        <tr>
                            <td class="cpf-refeicoes"style="display:none;"><%=ref.getCpfMorador()%></td>
                            <td><%=ref.getDia()%></td>
                            <td><%=ref.getHora()%></td>
                            <td><%=ref.getTipo()%></td>
                            <td><%=ref.getCardapio()%></td>
                            <td class="tdDelete">
                                <a onclick="window.location = '/proj_web/Facade?act=deleteRef&cpfDelete=<%=ref.getCpfMorador()%>&horaDelete=<%=ref.getHora()%>&cardapioDelete=<%=ref.getCardapio()%>&tipoDelete=<%=ref.getTipo()%>&diaDelete=<%=ref.getDia()%>'">Deletar</a>
                            </td>
                        </tr>
                        <%
                            }
                            }
                        %>
                    </tbody>
                </table>

                <form id="meuForm" class="form-container" action="Facade" method="POST">
                    <input type='hidden' name='act' value='CadastrarRefeicao'>
                    <div style="display:none;" class="form-group">
                        <input id="inputcpf"type="text" name="cpf" class="texto">
                    </div>
                    <div class="form-group">
                        <label>Dia da semana:</label>
                        <select class="escolha" name="dia">
                            <option value="domingo">domingo</option>
                            <option value="segunda">segunda</option>
                            <option value="terça">terça</option>
                            <option value="quarta">quarta</option>
                            <option value="quinta">quinta</option>
                            <option value="sexta">sexta</option>
                            <option value="sábado">sábado</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>Hora:</label>
                        <input type="text" name="hora" class="texto" placeholder="Digite aqui um horario hh/mm ..." required>
                    </div>
                    <div class="form-group">
                        <label>Tipo:</label>
                        <input type="text" name="tipo" class="texto" placeholder="Digite aqui..." required>
                    </div>
                    <div class="form-group">
                        <label>Cardapio:</label>
                        <input type="text" name="cardapio" class="texto" placeholder="Digite aqui..." required>
                    </div>
                    <input id="envioAdd" type="submit" value="Adicionar" class="envio">
                </form>
            </div>
        </div>
        <style>[name="act"], #envioAdd {
                background-color: #008CBA;
                color: white;
                margin-top: 5px;
                margin-bottom: 5px;
            }
            [name="act"], #envioAdd {
                padding: 10px 20px;
                font-size: 16px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }</style>
        <script src="scripts/refeicao.js"></script>
    </body>
</html>

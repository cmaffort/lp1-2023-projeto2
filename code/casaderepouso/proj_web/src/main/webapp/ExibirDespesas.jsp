<%-- 
    Document   : ExibirDespesas
    Created on : 26 de nov. de 2023, 10:41:50
    Author     : Júlia
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Despesas"%>
<%@page import="br.cefetmg.casaderepouso.DAO.DespesaDAO"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/Exibedespesas.css">

        <title>Despesas</title>
    </head>
    <body>
        <%@include file="Padrão/navGerente.jsp" %>
        <button id="baixar" style="    margin: 2% 3% 0% 0%;
                width: 7vw;
                height: 5vh;
                position: absolute;
                left: 30%;
                top: -1%">Baixar PDF</button>

        <form action="Facade" method="POST">
            <button name="act" value="listarDespesas" style="margin: 2% 3% 0% 5%;">Listar</button>

            <article>
                <%
                    List<Despesas> listaDespesas = (List<Despesas>) request.getAttribute("listDes");
                    if(listaDespesas != null){
                        for (Despesas des: listaDespesas){
                %>
                <div id="despesas">
                    <div id="data">
                        <p>Pagante: <%=des.getPagante()%></p>
                        <p>Destinatário: <%=des.getDestinatario()%></p>
                        <p>Tel. de contato: <%=des.getTelefone()%></p>
                        <p>Identidade: <%=des.getIdentidade()%></p>

                    </div>
                    <div id="info">
                        <p id="descricao"><%=des.getDescricao()%></p>

                        <p style="background-color: red; color:white">Valor: R$<%=des.getValor()%></p>
                    </div>
                </div>
                <%
                        }
                }
                %>

            </article>
        </article>
    </form>

    <script src="scripts/baixar.js" charset="utf-8"></script>
    <script src="scripts/html2canvas.js"></script>

</body>
</html>

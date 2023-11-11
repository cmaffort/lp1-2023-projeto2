<%-- 
    Document   : telaEvento
    Created on : 6 de nov. de 2023, 18:10:32
    Author     : rigor
--%>

<%@page import="br.cefetmg.casaderepouso.dto.Evento" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/telaEventos.css">

        <title>Gestão de Eventos</title>
    </head>

    <body>

        <div class="branco">
            <a class="button" href="CadastroEvento.jsp">Novo evento</a>
            <a class="button" href="CadastroFuncionario.jsp">Novo Funcionário</a>
            <a class="button" href="#">Relatórios</a>
            <a class="button" href="#">Equipamentos</a>
            <a class="button" href="#">Inventário</a>
            <a class="button" href="#">Pagamentos</a>

        </div>
        <div class="content">
            <div id="status-container">
                <div class="state1-container">
                    <span class="state1-cor" style="background-color: #14FF00;"></span><p>Disponível</p><span class="marks"id="mark-disponivel"></span>
                </div>
                <div class="state1-container">
                    <span class="state1-cor" style="background-color: #2882EB;"></span><p>Saída Temporária</p><span class="marks"id="mark-saida"></span>
                </div>
                <div class="state1-container">
                    <span class="state1-cor" style="background-color: #FF0000;"></span><p>Internado</p><span class="marks"id="mark-internado"></span>
                </div>
                <div class="state1-container">
                    <span class="state1-cor" style="background-color: #1E1E1E;"></span><p>Falecido</p><span class="marks"id="mark-falecido"></span>
                </div>
                <div id="container-botoes-status">
                    <a style="background-color: #14FF00;" class="update-status">Atualizar status</a>
                    <a id="cancelar"style="background-color: #FF0000;" class="update-status">Cancelar</a>
                </div>
            </div>

            <div class="title">Dados dos eventos</div>
            <form action="Facade" method="POST">
                <input type="submit" name="act" value="listarEventos">   
            </form>
            <div id="container-lista-eventos">
                <%
                   List<Evento> listaEventos = (List<Evento>) request.getAttribute("listEvent");
                   
                   if(listaEventos != null){
                   for (Evento ev: listaEventos) {
                %>
                <div class="evento-container">
                    <img class="seta" src="imgs/Voltar.png">    
                    <p class="nome-rg"><%=ev.getNome()%> - RG: <span class="cpf"><%=ev.getRg()%></span></p>

                    <div style="display: none;" class="container-info"> 

                        <div class="info-container">
                            <p class="info-content" >Data: <%=ev.getData()%></p>
                            <p class="info-content" >Horário: <%=ev.getHorario()%></p>
                            <p class="info-content" >Local: <%=ev.getLocal()%></p>
                            <p class="info-content" >Email: <%=ev.getEmail()%></p>
                            <p class="info-content">Telefone: <%=ev.getFone()%></p>
                            <p class="info-content" >Descrição do evento: <%=ev.getDescricao()%></p>
                        </div>
                        <div class="info-access">     
                            <a class="excluir" onclick="window.location='/proj_web/Facade?act=deleteEvento&eventoDelete=<%=ev.getId()%>'">Deletar</a>
                        </div>
                    </div>
                </div>   
                <%
                        }
                }
                %>
            </div>
        </div>
        <script src="scripts/eventos.js"></script>
    </body>
</html>

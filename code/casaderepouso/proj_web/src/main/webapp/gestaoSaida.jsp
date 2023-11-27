<%-- 
    Document   : gestaoSaida
    Created on : 26 de nov. de 2023, 09:32:09
    Author     : rigor
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.SaidaTemporaria" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/gestaoSaida.css">

        <title>Saídas Temporárias</title>

    </head>
    <body>
        <%@include file="Padrão/navFuncionario.jsp" %>

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


            <div class="title"><h2>Saídas agendadas</h2>
                <input type="text" id="pesquisa" placeholder="Pesquise o nome ou cpf aqui...">
            </div>

            <form action="Facade" method="POST">
                <input type="submit" name="act" value="listarSaida">   
            </form>
            <div id="container-lista-saidas">
                <%
                   List<SaidaTemporaria> listaSaidas = (List<SaidaTemporaria>) request.getAttribute("listSaida");
                   
                   if(listaSaidas != null){
                   for (SaidaTemporaria saida: listaSaidas) {
                %>
                <div class="saida-container" data-retorno="<%=saida.getDataVolta()%>">
                    <img class="seta" src="imgs/Voltar.png">    
                    <p class="nome-cpf">Nome: <%=saida.getNome()%> - CPF: <span class="cpf"><%=saida.getMoradorCpf()%></span></p>

                    <div style="display: none;" class="container-info"> 
                        <div class="title-container">
                            <h2 class="nascimento">Data de retorno: <%=saida.getDataVolta()%></h2>     
                        </div>
                        <div class="info-container">
                            <p class="info-content" >CPF: <span><%=saida.getMoradorCpf()%></span></p>
                            <p class="info-content" >Data de saída: <span><%=saida.getDataSaida()%></span></p>
                            <p class="info-content" >Horário: <span><%=saida.getHorarioSaida()%></span></p>
                            <p class="info-content" >Data de retorno: <span><%=saida.getDataVolta()%></span></p>
                            <p class="info-content" >Horário de retorno: <span><%=saida.getHorarioVolta()%></span></p>
                        </div>

                        <div class="info-access">
                            <button class="botao-atualizar">Atualizar</button>
                        </div>
                    </div>

                </div>
                <div class="atualizar-container">
                    <form class="form-container"  action="Facade" method="POST">
                        <div class="form-group">
                            <input type="hidden" name="idSaida" value="<%=saida.getId()%>">

                        </div>
                        <div class="form-group">
                            <label>Data de Saída:</label>
                            <input type="text" name="dataSaida" value="<%=saida.getDataSaida()%>" class="texto" placeholder="Digite aqui..." >
                        </div>
                        <div class="form-group">
                            <label>Horario Saida:</label>
                            <input type="text" name="horarioSaida" class="texto" value="<%=saida.getHorarioSaida()%>" placeholder="Digite aqui..." >
                        </div>
                        <div class="form-group">
                            <label>Data Retorno:</label>
                            <input type="text" name="dataVolta" value="<%=saida.getDataVolta()%>" class="texto" placeholder="Digite aqui..." >
                        </div>

                        <div class="form-group">
                            <label>Horario Retorno:</label>
                            <input type="text" name="horarioVolta" value="<%=saida.getHorarioVolta()%>" class="texto" placeholder="Digite aqui..." >
                        </div>
                        <div>
                            <button name="act" value="atualizarSaida" style="width: 100%;" class="update-status">Atualizar saída</button>
                            <a class="cancelUpdate" style="width: 100%; background-color: #FF0000; cursor: pointer;">Cancelar</a>
                        </div>


                    </form>
                </div>

                <%
                        }
                }
                %>

            </div>
            <script>
                // Função que deixa cinza e tira o botão atualizar das saídas que já ocorreram
                function ajustarAparencia() {
                    var saidaContainers = document.querySelectorAll('.saida-container');

                    saidaContainers.forEach(function (saidaContainer) {
                        var dataRetorno = saidaContainer.getAttribute('data-retorno');
                        var dataRetornoObj = new Date(dataRetorno);
                        var dataAtual = new Date();

                        if (dataAtual >= dataRetornoObj) {
                            var botaoAtualizar = saidaContainer.querySelector('.botao-atualizar');
                            var containerInfo = saidaContainer.querySelector('.container-info');

                            botaoAtualizar.style.display = 'none';
                            containerInfo.style.backgroundColor = '#A9A9A9';
                            saidaContainer.style.backgroundColor = '#A9A9A9';
                        }
                    });
                }

                // Chama a função depois de renderizar a página
                window.onload = function () {
                    ajustarAparencia();
                };
            </script>
        </div>

        <script src="scripts/gestaoSaida.js"></script>
    </body>
</html>

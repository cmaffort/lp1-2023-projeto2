
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
        <%@include file="Padrão/navGerente.jsp" %>

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

            <div class="title">Dados dos funcionários</div>
            <form action="Facade" method="POST">
                <input type="submit" name="act" value="listarFuncionario">   
            </form>
            <div id="container-lista-funcionarios">
                <%
                   List<Funcionario> listaFuncionarios = (List<Funcionario>) request.getAttribute("listFunc");
                   
                   if(listaFuncionarios != null){
                   for (Funcionario func: listaFuncionarios) {
                %>
                <div class="funcionario-container">
                    <img class="seta" src="imgs/Voltar.png">    
                    <p class="nome-cpf"><%=func.getNome()%> - CPF: <span class="cpf"><%=func.getCpf()%></span></p>

                    <div style="display: none;" class="container-info"> 

                        <div class="info-container">
                            <p class="info-content" >RG: <%=func.getRg()%></p>
                            <p class="info-content" >PIS: <%=func.getPis()%></p>
                            <p class="info-content" >Endereço: <%=func.getEndereco()%></p>
                            <p class="info-content" >Nascimento: <%=func.getDataNasc()%></p>
                            <p class="info-content" >Função: <%=func.getFuncao()%></p>
                            <p class="info-content" >Horário de trabalho: <%=func.getPeriodoTrabalho()%></p>
                            <p class="info-content">Telefone: <%=func.getFone()%></p>
                        </div>
                        <div class="info-access">     
                            <button class="botao-deletar">Deletar</button>
                        </div>
                    </div>
                </div>   
                <%
                        }
                }
                %>
            </div>
        </div>
        
    </div>
    <script src="scripts/gerente.js"></script>
    </body>
</html>

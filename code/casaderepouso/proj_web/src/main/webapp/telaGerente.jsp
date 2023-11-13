
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
            <div id="atualizar-container">
                <form id="atualizarForm" class="form-container" action="Facade" method="POST">
                    <div class="form-group">
                        <label>Seu nome completo:</label>
                        <input type="text" name="nomeMorador" class="texto" placeholder="Digite aqui..." >
                    </div>

                    <div class="form-group">
                        <label>CPF:</label>
                        <input type="text" name="dataNasc" class="texto" placeholder="Digite aqui uma data dd/mm/aa ..." >
                    </div>

                    <div class="form-group">
                        <label>RG:</label>
                        <input type="text" name="endereco" class="texto" placeholder="Digite aqui..." >
                    </div>

                    <div class="form-group">
                        <label>PIS:</label>
                        <input type="text" name="nome_mae" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Endereço:</label>
                        <input type="text" name="cpf" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Nascimento:</label>
                        <input type="text" name="plano_medico" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Função:</label>
                        <input type="text" name="condicoes_especiais" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Horario de trabalho:</label>
                        <input type="text" name="condicoes_especiais" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Telefone:</label>
                        <input type="text" name="condicoes_especiais" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <button name="act" value="AtualizarFuncionario"style="background-color: #14FF00;" class="update-status">Atualizar funcioanrio</button>
                    <a id="cancelarUpdate"style="background-color: #FF0000;" class="update-status">Cancelar</a>
                </form>
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
                        <div class="title-container">
                            <h1 class="name"><%=func.getNome()%></h1>
                            <h2 class="nascimento"><%=func.getDataNasc()%></h2>     
                        </div>
                        <div class="info-container">
                            <p class="info-content" >CPF: <span><%=func.getCpf()%></span></p>
                            <p class="info-content" >RG: <span><%=func.getRg()%></span></p>
                            <p class="info-content" >PIS: <span><%=func.getPis()%></span></p>
                            <p class="info-content" >Endereço: <span><%=func.getEndereco()%></span></p>
                            <p class="info-content" >Função: <span><%=func.getFuncao()%></span></p>
                            <p class="info-content" >Horário de trabalho: <span><%=func.getPeriodoTrabalho()%></span></p>
                            <p class="info-content">Telefone: <span><%=func.getFone()%></span></p>
                        </div>
                        
                        <div class="info-access">
                            <button class="botao-atualizar">Atualizar</button>
                            <a class="excluir" onclick="window.location='/proj_web/Facade?act=deleteFunc&idDelete=<%=func.getId()%>'">Deletar</a>
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

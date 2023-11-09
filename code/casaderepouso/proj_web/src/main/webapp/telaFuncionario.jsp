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
        <link rel="stylesheet" type="text/css" href="cssFiles/telaFuncionario.css">

        <title>Home-Funcionário</title>
    </head>

    <body>

        <div class="branco">
            <img class="profile-image" src="imgs/perfil.png">
            <div class="name">Bem vindo</div>
            <a class="button" href="CadastroMorador.jsp">Novo morador</a>
            <a class="button" href="#">Inventário</a>
            <a class="button" href="#">Cardápio</a>
            <a class="button" href="#">Equipamentos</a>
            <a class="button" href="GestaoVisitantes.jsp">Visitas</a>

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
                    <form id="form-atualizar"action="Facade" method="POST">
                        <input style="display: none;" name="estado" id="enviarEstado"value="">
                        <input style="display: none;" name="cpf" id="enviarCpf"value="">
                        <input style="display: none;" name="nomeMorador"id="enviarNome"value="">
                        <input style="display: none;" name="dataNasc" id="enviarNasc"value="">
                        <input style="display: none;" name="plano_medico"id="enviarPlano"value="">
                        <input style="display: none;" name="nome_mae" id="enviarMae"value="">
                        <input style="display: none;" name="endereco" id="enviarEndereco"value="">
                        <input style="display: none;" name="condicoes_especiais" id="enviarCondic"value="">
                        
                        <button name="act" value="AtualizarEstado"style="background-color: #14FF00;" class="update-status">Atualizar status</button>
                    </form>
                    <a id="cancelar"style="background-color: #FF0000;" class="update-status">Cancelar</a>                 
                </div>
            </div>

            <div class="title">Dados dos moradores</div>
            <form action="Facade" method="POST">
                <input id="listarMoradores"type="submit" name="act" value="ListarMorador">   
            </form>
            <div id="container-lista-moradores">
                <%
                   List<Morador> listaMoradores = (List<Morador>) request.getAttribute("listMor");
                   
                   if(listaMoradores != null){
                   for (Morador mor: listaMoradores) {
                %>
                <div class="morador-container">
                    <img class="seta" src="imgs/Voltar.png">    
                    <p class="nome-cpf"><%=mor.getNome()%> - CPF: <span class="cpf"><%=mor.getCpf()%></span></p>
                    <div class="state-container">
                        <span class="state-cor"></span><p class="state-nome"><%=mor.getEstado()%></p>
                    </div>
                    <div style="display: none;" class="container-info"> 
                        <div class="title-container">
                            <h1 class="name"><%=mor.getNome()%></h1>
                            <h2 class="nascimento"><%=mor.getDataNasc()%></h2>       
                        </div>
                        <div class="info-container">
                            <p class="info-content" class="cpf1">CPF: <span><%=mor.getCpf()%></span></p>
                            <p class="info-content" class="mae-nome">Nome da Mãe: <span><%=mor.getNomeMae()%></span></p>
                            <p class="info-content" class="endereco">Endereço: <span><%=mor.getEndereco()%></span></p>
                            <p class="info-content" class="plano-medico">Plano médico: <span><%=mor.getPlanoMedico()%></span></p>
                            <p class="info-content" class="condicoes">Condições especiais: <span><%=mor.getCondicaoEspecial()%></span></p>
                        </div>
                        <div class="info-access">     
                            <!-- comment <a class="links-acessos">Acessar documentos</a> -->
                            <a class="links-acessos">Acessar receitas médicas</a>
                            <a class="links-acessos">Acessar resultados de exames</a>
                            <a class="links-acessos">Acessar histórico médico</a>
                            <a class="links-acessos">Acessar prontuário</a>
                            <a class="links-acessos">Acessar responsáveis</a>
                            <a class="links-acessos">Solicitar consulta</a>
                            <a class="links-acessos">Novo responsável</a>
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
        <script src="scripts/containerMoradores.js"></script>
    </body>
</html>


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
                    <a style="background-color: #14FF00;" class="update-status">Atualizar status</a>
                    <a id="cancelar"style="background-color: #FF0000;" class="update-status">Cancelar</a>
                </div>
            </div>
            
            <div class="title">Dados dos moradores</div>
            <form action="Facade" method="POST">
                <input type="submit" name="act" value="listarMorador">   
            </form>
            <div id="container-lista-moradores">
                    <div class="morador-container">
                        <img class="seta" src="imgs/Voltar.png">
                        <p class="nome-cpf">Fulano da Silva Silveiro - CPF: 12345678910</p>
                            <div class="state-container">
                                <span class="state-cor"></span><p class="state-nome">Status</p>
                            </div>
                        <div style="display: none;" class="container-info">
                        <div class="title-container">
                            <h1 class="name">Nome do Morador</h1>
                            <h2 class="nascimento">XX/XX/XXXX</h2>       
                        </div>
                        <div class="info-container">
                            <p class="info-content" class="cpf">CPF:</p>
                            <p class="info-content" class="mae-nome">Nome da Mãe:</p>
                            <p class="info-content" class="estado-civil">Estado civil:</p>
                            <p class="info-content" class="endereco">Endereço:</p>
                            <p class="info-content" class="plano-medico">Plano médico:</p>
                            <p class="info-content" class="condicoes">Condições especiais:</p>
                        </div>
                        <div class="info-access">  
                            <!-- comment <a class="links-acessos">Acessar documentos</a> -->
                            <a class="links-acessos">Acessar receitas médicas</a>
                            <a class="links-acessos">Acessar resultados de exames</a>
                            <a class="links-acessos">Acessar histórico médico</a>
                        </div>
                        <div>
                            <button class="botao-deletar">Deletar</button>
                        </div>
                    </div>
                    </div>
                <%
                   List<Morador> listaMoradores = (List<Morador>) request.getAttribute("listMor");
                   if(listaMoradores != null){
                   for (Morador mor: listaMoradores) {
                %>
                <a class="botao-morador" href="javascript: enviarInfo(<%=mor.getNome()%>,<%=mor.getCpf()%>,<%=mor.getEstado()%>,<%=mor.getNomeMae()%>, <%=mor.getCondicaoEspecial()%>)" href="telaInfoMorador.jsp">
                    <div class="morador-container">
                        <p><%=mor.getNome()%></p>
                        <p><%=mor.getCpf()%></p>
                        <p><%=mor.getEstado()%></p>
                    </div>
                </a>
                <%
                        }
                }
                %>
            </div>
        </div>
        <script src="scripts/enviarInfoMorador.js"></script>
        <script src="scripts/containerMoradores.js"></script>
    </body>
</html>


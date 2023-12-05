<%-- 
    Document   : ListarReceitas
    Created on : 11 de nov. de 2023, 15:33:31
    Author     : Particular
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Receita"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/ListarReceitas.css">
        <title>Receitas</title>
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
            <a class="button" href="CadastroReceita.jsp">Nova Receita</a>
        </div>
        <div class="content">
            <div class="title"><h1>Receitas</h1>
                <input type="text" id="pesquisa" placeholder="Pesquise o id aqui..."><input type="submit" id="btnPesquisar" value="🔎">
            </div>
            <form action="Facade" method="POST">
                <input type="submit" name="act" value="ListarReceita">   
            </form>
            <div id="containter-lista-receitas">
                <%
                    List<Receita> listReceita = (List<Receita>) request.getAttribute("listReceitas");
                    if(listReceita != null){
                    for (Receita receita: listReceita) {
                %>
                <div class="lista"> 
                    <img class="seta" src="imgs/Voltar.png">
                    <p class="receita-id"> Receita <%=receita.getId()%></p>

                    <div style="display: none;" class="container-info">
                        <div class="dados">
                            <p class="info-content">Profissional de Saúde: <%=receita.getProfissionalSaude()%></p>
                            <p class="info-content">Morador: <%=receita.getMorador()%></p>
                            <p class="info-content">Medicamentos: <%=receita.getMedicamentos()%></p>
                            <p class="info-content">Data: <%=receita.getData()%></p>
                            <p class="info-content">Hora: <%=receita.getHora()%></p>
                            <p class="info-content">Quantidade: <%=receita.getQuantidade()%></p>
                            <p class="info-content">Validade: <%=receita.getValidade()%></p>
                            <div class="info-access">     
                                <button class="botao-atualizar">Atualizar</button>
                                <a class="excluir" onclick="window.location = '/proj_web/Facade?act=deleteReceita&receitaDelete=<%=receita.getId()%>'">Deletar</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="atualizar-container">
                    <form class="form-container"  action="Facade" method="POST">
                        <div class="form-group">
                            <input type="hidden" name="id" value="<%=receita.getId()%>">
                            <label>Profissional de saúde:</label>
                            <input type="text" name="nomeProfissional" value="<%=receita.getProfissionalSaude()%>" class="texto" placeholder="Digite aqui..." >
                        </div>

                        <div class="form-group">
                            <label>Morador:</label>
                            <input type="text" name="morador" value="<%=receita.getMorador()%>" class="texto" placeholder="Digite aqui..." >
                        </div>

                        <div class="form-group">
                            <label>Medicamentos:</label>
                            <input type="text" name="medicamentos" value="<%=receita.getMedicamentos()%>" class="texto" placeholder="Digite aqui..." >
                        </div>
                        
                        <div class="form-group">
                            <label>Data:</label>
                            <input type="text" name="data" value="<%=receita.getData()%>" class="texto" placeholder="Digite aqui..." >
                        </div>
                        <div class="form-group">
                            <label>Hora:</label>
                            <input type="text" name="hora" value="<%=receita.getHora()%>" class="texto" placeholder="Digite aqui..." >
                        </div>
                        <div class="form-group">
                            <label>Quantidade:</label>
                            <input type="text" name="quantidade" value="<%=receita.getQuantidade()%>" class="texto" placeholder="Digite aqui..." >
                        </div>
                     
                        <div class="form-group">
                            <label>Validade:</label>
                            <input type="text" name="validade" value="<%=receita.getValidade()%>" class="texto" placeholder="Digite aqui..." >
                        </div>
                        <div>
                            <button name="act" value="AtualizarReceita" style="width: 100%;" class="update-status">Atualizar receita</button>
                            <a class="cancelUpdate" style="width: 100%; background-color: #FF0000; cursor: pointer;">Cancelar</a>
                        </div>
                    </form>
                </div>
                <%
                    }
                }
                %>
            </div>
        </div>
        <script src="scripts/receita.js"></script>
    </body>
</html>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Responsavel"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/gestaoResponsavel.css">
        <title>Responsáveis</title>
    </head>
    <body>
        <%@include file="Padrão/navMorador.jsp" %>



        <div class="content">
            <div class="title"><h1>Responsaveis</h1>
                <input type="text" id="pesquisa" placeholder="Pesquise o nome aqui..."><input type="submit" id="btnPesquisar" value="🔎">
            </div>
            <form action="Facade" method="POST">
                <input type="submit" name="act" value="listarResponsavel">   
            </form>
            <div id="containter-lista-responsaveis">
                <%
                    List<Responsavel> listResponsavel = (List<Responsavel>) request.getAttribute("listResp");
                    if(listResponsavel != null){
                    for (Responsavel responsavel: listResponsavel) {
                %>
                <div class="lista"> 
                    <img class="seta" src="imgs/Voltar.png">
                    <p class="responsavel-nome"> Responsavel <%=responsavel.getNome()%></p>

                    <div style="display: none;" class="container-info">
                        <div class="dados">
                            <p class="info-content">Número de contato: <%=responsavel.getTelefone()%></p>
                            <p class="info-content">CPF: <%=responsavel.getCpf()%></p>
                            <p class="info-content">RG: <%=responsavel.getRg()%></p>
                            <p class="info-content">Vínculo com o morador: <%=responsavel.getResponsavelPor()%></p>
                            <p class="info-content">Endereço: <%=responsavel.getEndereco()%></p>
                            <div class="info-access">  
                                <button class="botao-atualizar">Atualizar</button>
                                <a class="excluir" onclick="window.location = '/proj_web/Facade?act=deleteResponsavel&responsavelDelete=<%=responsavel.getNome()%>'">Deletar</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="atualizar-container">
                    <form class="form-container"  action="Facade" method="POST">
                        <div class="form-group">
                            <label>Nome completo:</label>
                            <input type="text" name="nomeResponsavel" value="<%=responsavel.getNome()%>" class="texto" placeholder="Digite aqui..." required>
                        </div>

                        <div class="form-group">
                            <label>CPF:</label>
                            <input type="text" name="cpf" class="texto" value="<%=responsavel.getCpf()%>" placeholder="Digite aqui..." required>
                        </div>

                        <div class="form-group">
                            <label>RG:</label>
                            <input type="text" name="rg" value="<%=responsavel.getRg()%>" class="texto" placeholder="Digite aqui..." required>
                        </div>

                        <div class="form-group">
                            <label>Endereço completo:</label>
                            <input type="text" name="endereco" value="<%=responsavel.getEndereco()%>" class="texto" placeholder="Digite aqui..." required>
                        </div>

                        <div class="form-group">
                            <label>Responsável por:</label>
                            <input type="text" name="responsavelPor" value="<%=responsavel.getResponsavelPor()%>" class="texto" placeholder="Digite aqui..." required>
                        </div>

                        <div>
                            <label>Telefone de contato:</label>
                            <input type="text" name="telefone" class="texto" value="<%=responsavel.getTelefone()%>" placeholder="Digite aqui..." required required
                                   onblur="verificarTelefone()">
                        </div>
                        <p id="resultado"></p>

                        <button name="act" value="AtualizarResponsavel" style="width: 100%;" class="update-status">Atualizar responsavel</button>
                        <a class="cancelUpdate" style="width: 100%; background-color: #FF0000; cursor: pointer;">Cancelar</a>
                    </form>
                </div>
            </div>     
            <%
                }
            }
            %>
        </div>
    </div>
    <script src="scripts/responsavel.js"></script>
</body>
</html>

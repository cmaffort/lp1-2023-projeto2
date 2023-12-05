
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Equipamento"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/inventario.css">
        <title>Inventário</title>
    </head>
    <body>
        <%@include file="Padrão/navGerente.jsp" %>
        <div class="content">
            <div class="titles">
                <h1>Bem vindo, nome</h1>
                <h2>Inventário</h2>
                <input type="text" id="pesquisa" placeholder="Pesquise o nome aqui..."><input type="submit" id="btnPesquisar" value="🔎">
                <select type="text" id="estados" name="estado">
                    <option value="Usando">Em uso</option>
                    <option value="Disponivel">Disponível</option>
                    <option value="Aguardando">Necessitando de manutenção</option>
                    <option value="Manutencao">Em manutenção</option>
                </select>
                <input type="submit" id="pesquisaEstado" value="🔎">
            </div>

            <div class="cadastrar-container">
                <form class="form-container"  action="Facade" method="POST">
                    <div class="form-group">
                        <label>Tipo:</label>
                        <input type="text" name="tipoEquipamento" class="texto" placeholder="Digite aqui..." >
                    </div>

                    <div class="form-group">
                        <label>Preço:</label>
                        <input type="text" name="preco" class="texto" placeholder="Digite aqui..." >
                    </div>

                    <div class="form-group">
                        <label>Quantidade:</label>
                        <input type="text" name="quantidade" class="texto" placeholder="Digite aqui..." >
                    </div>

                    <div class="form-group">
                        <label>Estado:</label>
                        <select type="text" class="estados" name="estado">
                            <option value="Usando">Em uso</option>
                            <option value="Disponivel">Disponível</option>
                            <option value="Aguardando">Necessitando de manutenção</option>
                            <option value="Manutencao">Em manutenção</option>
                        </select>
                    </div>

                    <div class="form-group">
                        <label>Fornecedor:</label>
                        <input type="text" name="fornecedor" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div>
                        <button name="act" value="cadastrarEquipamento" style="width: 100%;" class="cadastro">Cadastrar Equipamento</button>
                        <a class="cancelarCadastro" style="width: 100%; background-color: #FF0000; cursor: pointer;">Cancelar</a>
                    </div>
                </form>
            </div>


            <div id="containter-lista-equipamentos">
                <div class="buttons">
                    <button class="botao-cadastrar">Cadastrar Equipamento</button>
                    <form action="Facade" method="POST">
                        <button class="botao-listar" type="submit" name="act" value="listarEquipamentos">Listar Equipamentos</button>
                    </form>
                </div>
                <%
                    List<Equipamento> listEquipamento = (List<Equipamento>) request.getAttribute("listEquipamentos");
                    if(listEquipamento != null){
                    for (Equipamento equipamento: listEquipamento) {
                %>
                <div class="equipamento">
                    <div class="cor-status"></div>
                    <p class="info-container"><%=equipamento.getTipo()%></p>
                    <div style="display: none;" class="container-info">
                        <div class="dados">
                            <p class="info-content"><%=equipamento.getTipo()%></p>
                            <p class="info-content">Preço: <%=equipamento.getPreco()%></p>
                            <p class="info-content">Quantidade: <%=equipamento.getQuantidade()%></p>
                            <p class="estado">Estado: <%=equipamento.getEstado()%></p>
                            <p class="info-content">Fornecedor: <%=equipamento.getFornecedor()%></p>
                            <div class="info-access">  
                                <button class="cancelarExibicao" style="width: 100%; background-color: #FF0000; cursor: pointer;">Cancelar</button>
                                <button class="botao-atualizar">Atualizar</button>
                                <button class="excluir" onclick="window.location = '/proj_web/Facade?act=deleteEquipamento&equipamentoDelete=<%=equipamento.getId()%>'">Deletar</button>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="atualizar-container">
                    <form class="form-container"  action="Facade" method="POST">
                        <div class="form-group">
                            <input type="hidden" name="id" value="<%=equipamento.getId()%>">
                            <label>Tipo:</label>
                            <input type="text" name="tipoEquipamento" value="<%=equipamento.getTipo()%>" class="texto" placeholder="Digite aqui..." >
                        </div>

                        <div class="form-group">
                            <label>Preço:</label>
                            <input type="text" name="preco" value="<%=equipamento.getPreco()%>" class="texto" placeholder="Digite aqui..." >
                        </div>

                        <div class="form-group">
                            <label>Quantidade:</label>
                            <input type="text" name="quantidade" value="<%=equipamento.getQuantidade()%>" class="texto" placeholder="Digite aqui..." >
                        </div>

                        <div class="form-group">
                            <label>Estado:</label>
                            <select type="text" value="<%=equipamento.getEstado()%>" class="estado" name="estado">
                                <option value="Usando">Em uso</option>
                                <option value="Disponivel">Disponível</option>
                                <option value="Aguardando">Necessitando de manutenção</option>
                                <option value="Manutencao">Em manutenção</option>
                            </select>
                        </div>

                        <div class="form-group">
                            <label>Fornecedor:</label>
                            <input type="text" name="fornecedor" value="<%=equipamento.getFornecedor()%>" class="texto" placeholder="Digite aqui..." >
                        </div>
                        <div>
                            <button name="act" value="AtualizarEquipamento" style="width: 100%;" class="update-status">Atualizar equipamento</button>
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
        <script src="scripts/equipamento.js"></script>
    </form>
</body>
</html>

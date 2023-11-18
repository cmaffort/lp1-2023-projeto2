
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.casaderepouso.dto.Funcionario" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/telaGerente.css">

        <title>Home-Gerente</title>
       
        <script>
            document.addEventListener("DOMContentLoaded", function () {
       

                var campoPesquisa = document.getElementById("pesquisa");
                var btnPesquisar = document.getElementById("btnPesquisar");
                var funcionarios = document.querySelectorAll(".funcionario-container");


                btnPesquisar.addEventListener("click", function () {

                    var termoPesquisa = campoPesquisa.value.toLowerCase();


                    funcionarios.forEach(function (funcionario) {
                        var nomeFuncionario = funcionario.querySelector(".nome-cpf").innerText.toLowerCase();


                        if (nomeFuncionario.includes(termoPesquisa)) {
                            funcionario.style.display = "grid";
                        } else {
                            funcionario.style.display = "none";
                    }
                    });
                });
            });
        </script>

        <style>

            #btnPesquisar, [name="act"] {
                padding: 10px 20px;
                font-size: 16px;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s ease;
            }

            #btnPesquisar {
                background-color: #4682B4;
                color: white;
            }

            [name="act"] {
                background-color: #008CBA;
                color: white;
                margin-top: 15px;
                margin-bottom: 15px;
            }

            #pesquisa {
                padding: 10px;
                font-size: 16px;
                border: 1px solid #ccc;
                border-radius: 5px;
                transition: border-color 0.3s ease;

            }
        </style>

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
            

            <div class="title"><h2>Dados dos funcionários</h2>
                <input type="text" id="pesquisa" placeholder="Pesquise o nome aqui..."><input type="submit" id="btnPesquisar" value="🔎">
            </div>

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
                                 <div class="atualizar-container">
                <form class="form-container"  action="Facade" method="POST">
                    <div class="form-group">
                        <input type="hidden" name="idFuncionario" value="<%=func.getId()%>">
                        <label>Seu nome completo:</label>
                        <input type="text" name="nomeFuncionario" value="<%=func.getNome()%>" class="texto" placeholder="Digite aqui..." >
                    </div>

                    <div class="form-group">
                        <label>CPF:</label>
                        <input type="text" name="cpf" value="<%=func.getCpf()%>" class="texto" placeholder="Digite aqui uma data dd/mm/aa ..." >
                    </div>

                    <div class="form-group">
                        <label>RG:</label>
                        <input type="text" name="rg" value="<%=func.getRg()%>" class="texto" placeholder="Digite aqui..." >
                    </div>

                    <div class="form-group">
                        <label>PIS:</label>
                        <input type="text" name="pis" value="<%=func.getPis()%>" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Endereço:</label>
                        <input type="text" name="endereco" class="texto" value="<%=func.getEndereco()%>" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Nascimento:</label>
                        <input type="text" name="dataNasc" value="<%=func.getDataNasc()%>" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Função:</label>
                        <input type="text" name="funcao" value="<%=func.getFuncao()%>" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Horario de trabalho:</label>
                        <input type="text" name="periodo" value="<%=func.getPeriodoTrabalho()%>" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Telefone:</label>
                        <input type="text" name="telefone" value="<%=func.getFone()%>" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <button name="act" value="AtualizarFuncionario"style="background-color: #14FF00;" class="update-status">Atualizar funcioanrio</button>
                    <a class="cancelUpdate" style="background-color: #FF0000;" class="update-status">Cancelar</a>
                </form>
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


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

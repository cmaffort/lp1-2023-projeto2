<%-- 
    Document   : atualizacoes
    Created on : 28 de nov. de 2023, 11:24:05
    Author     : Master
--%>
<%@page import="br.cefetmg.casaderepouso.dto.Atualizacao" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/atualizacoes.css">
        <title>Atualizações</title>
    </head>
    <body>

        <div class="branco">
            <img class="profile-image" src="imgs/perfil.png">
        </div>
        <div class="content">
            <a class="back-button" href="telaFuncionario.jsp""><img src="./imgs/Voltar.png"></a>
            <div class="title"><h2>Atualizações feitas pelo Sistema</h2>
                <input type="text" id="pesquisa" placeholder="Pesquise o CPF aqui..."><input type="submit" id="btnPesquisar" value="🔎">
            </div>
            <div id="containerheader" style="margin: 1vh;">
                <form action="Facade" method="POST">
                    <input id="listarAtualizacao"type="submit" name="act" value="ListarAtualizacao">   
                </form>
            </div>

            <div id="listagemAtu">
                <%
                    List<Atualizacao> listaAtualizacao = (List<Atualizacao>) request.getAttribute("listAtu");
                   
                   if(listaAtualizacao != null){
                   for (Atualizacao atu: listaAtualizacao) {
                %>
                <div class="atualizacao-container">
                    <h1 class="cpf"><%=atu.getCpf()%></h1>
                    <p><%=atu.getDados()%></p>
                    <p><%=atu.getMomento()%></p>
                </div>
                <% }
                } %>
            </div>
        </div>
        <script>
            document.addEventListener("DOMContentLoaded", function () {

                var campoPesquisa = document.getElementById("pesquisa");
                var btnPesquisar = document.getElementById("btnPesquisar");
                var atualizacao = document.querySelectorAll(".atualizacao-container");
                btnPesquisar.addEventListener("click", function () {
                    var termoPesquisa = campoPesquisa.value;
                    atualizacao.forEach(function (atu) {
                        var cpfAtu = atu.querySelector(".cpf").innerHTML;
                        if (cpfAtu.includes(termoPesquisa)) {
                            atu.style.display = "grid";
                        } else {
                            atu.style.display = "none";
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
    </body>
</html>

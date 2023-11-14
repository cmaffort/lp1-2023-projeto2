<%-- 
    Document   : telaEvento
    Created on : 6 de nov. de 2023, 18:10:32
    Author     : rigor
--%>

<%@page import="br.cefetmg.casaderepouso.dto.Evento" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/telaEventos.css">

        <title>Gestão de Eventos</title>
        <script>
            document.addEventListener("DOMContentLoaded", function () {
       

       
            var campoPesquisa = document.getElementById("pesquisa");
            var btnPesquisar = document.getElementById("btnPesquisar");
            var eventos = document.querySelectorAll(".evento-container");


            btnPesquisar.addEventListener("click", function () {

                var termoPesquisa = campoPesquisa.value.toLowerCase();


                eventos.forEach(function (event) {
                    var nomeEvento = event.querySelector(".nome-rg").innerText.toLowerCase();


                    if (nomeEvento.includes(termoPesquisa)) {
                        event.style.display = "grid";
                    } else {
                        event.style.display = "none";
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

        <div class="branco">
            <a class="button" href="CadastroEvento.jsp">Novo evento</a>
            <a class="button" href="telaGerente.jsp">Funcionários Cadastrados</a>
            <a class="button" href="#">Relatórios</a>
            <a class="button" href="#">Equipamentos</a>
            <a class="button" href="#">Inventário</a>
            <a class="button" href="#">Pagamentos</a>

        </div>
        <div class="content">
            

            <div class="title"><h2>Dados dos eventos</h2>
                <input type="text" id="pesquisa" placeholder="Pesquise o nome aqui..."><input type="submit" id="btnPesquisar" value="🔎">
            </div>
            <form action="Facade" method="POST">
                <input type="submit" name="act" value="listarEventos">   
            </form>
            <div id="container-lista-eventos">
                <%
                   List<Evento> listaEventos = (List<Evento>) request.getAttribute("listEvent");
                   
                   if(listaEventos != null){
                   for (Evento ev: listaEventos) {
                %>
                <div class="evento-container">
                    <img class="seta" src="imgs/Voltar.png">    
                    <p class="nome-rg"><%=ev.getNome()%> - RG: <span class="cpf"><%=ev.getRg()%></span></p>

                    <div style="display: none;" class="container-info"> 

                        <div class="info-container">
                            <p class="info-content" >Data: <%=ev.getData()%></p>
                            <p class="info-content" >Horário: <%=ev.getHorario()%></p>
                            <p class="info-content" >Local: <%=ev.getLocal()%></p>
                            <p class="info-content" >Email: <%=ev.getEmail()%></p>
                            <p class="info-content">Telefone: <%=ev.getFone()%></p>
                            <p class="info-content" >Descrição do evento: <%=ev.getDescricao()%></p>
                        </div>
                        <div class="info-access">     
                            <a class="excluir" onclick="window.location='/proj_web/Facade?act=deleteEvento&eventoDelete=<%=ev.getId()%>'">Deletar</a>
                        </div>
                    </div>
                </div>   
                <%
                        }
                }
                %>
            </div>
        </div>
        <script src="scripts/eventos.js"></script>
    </body>
</html>

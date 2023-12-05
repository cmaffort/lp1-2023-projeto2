<%-- 
    Document   : TelaInicialMorador
    Created on : 9 de out. de 2023, 15:51:04
    Author     : Master
--%>
<%@page import="br.cefetmg.casaderepouso.DAO.MoradorDAO" %>
<%@page import="br.cefetmg.casaderepouso.dto.Morador" %>
<%@page import="br.cefetmg.casaderepouso.DAO.MensalidadeDAO" %>
<%@page import="br.cefetmg.casaderepouso.dto.Mensalidade" %>
<%@page import="java.util.ArrayList" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Tela Inicial Responsável</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="cssFiles/TelaInicialResponsavel.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Gabarito:wght@500&family=Sofia+Sans:wght@500&display=swap" rel="stylesheet">
    </head>       
    <body>
        <div style="display:none;"id="listagem-de-moradores">
            <%
                MoradorDAO moradorDAO = new MoradorDAO();
                ArrayList<Morador> listaMoradores = moradorDAO.listarTodos();
                   
                if(listaMoradores != null){
                   for (Morador mor: listaMoradores) {
            %>
            <div class="morador">
                <p style="display:none;"><%=mor.getVetorResponsaveis()%></p>
                <p style="display:none;"><%=mor.getNome()%></p>
            </div>
            <%
                }
            }
            %>
        </div>
        <div style="display:none;" id="listagem-de-mensalidade">
            <%
                MensalidadeDAO mensalidadeDAO = new MensalidadeDAO();
                ArrayList<Mensalidade> listaMensalidade = mensalidadeDAO.listarTodos();
                
                if(listaMensalidade != null){
                    for(Mensalidade men : listaMensalidade){
            %>
            <div class="mensalidade">
                <p><%=men.getCpfResponsavel()%></p>
                <p><%=men.getCpfMorador()%></p>
                <p><%=men.getInicio()%></p>
                <p><%=men.getFim()%></p>
            </div>
            <%    
                }
                }
            %>
        </div>
        <header id="perfil">
            <img src="./imgs/perfil.png" class="imagemDoPerfil">
            <strong><p id="bemvindo">Seja bem vindo, Nome.</p> </strong>
        </header>
        <article>
            <div id="container-opcoes">
                <div id="container-botoes">
                    <div>
                        <a href="pagamento.jsp" style="text-decoration: none; color:black;"><button class="Botao">Pagamento da mensalidade</button></a>
                    </div>
                    <div>
                        <button class="Botao"><a href="" style="text-decoration: none; color:black;">Cancelamento de vinculo</a></button>
                    </div>
                    <div>
                        <button class="Botao"><a href="CadastroSaida.jsp" style="text-decoration: none; color:black;">Agendar Saída Temporária</a></button>
                    </div>
                    <div>
                        <button class="Botao"><a href="SaidaMorador.jsp" style="text-decoration: none; color:black;">Saídas Agendadas</a></button>
                    </div>
                </div>
                <div id="texto">
                    <p>“Nosso maior compromisso é com o bem estar da sua pessoa querida”</p>
                </div>
                <div id="container-imagens">
                    <div>
                        <img class="imgmoradores" src="./imgs/imagemmorador1.png">
                    </div>
                    <div>
                        <img class="imgmoradores" src="./imgs/imagemmorador2.jpg">
                    </div>
                </div>
            </div>
        </article>
        <script src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
        <script src="./scripts/telaResponsavel.js"></script>
    </body>
</html>

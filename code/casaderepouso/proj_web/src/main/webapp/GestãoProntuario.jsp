<%-- 
    Document   : GestãoProntuario
    Created on : 12 de nov. de 2023, 23:43:29
    Author     : felli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "br.cefetmg.casaderepouso.dto.Prontuario"%>
<%@page import = "java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestão Prontuario Morador</title>
        <link rel="stylesheet" type="text/css" href="cssFiles/GestaoProntuario.css">
    </head>
    <body>
        <div class="branco">    
            <img class="profile-image" src="imgs/perfil.png">
            <div class="name">Nome Sobrenome</div>
            <a class="button" href="CadastroMorador.jsp">Novo Morador</a>
            <a class="button" href="#">Inventário</a>
            <a class="button" href="#">Cardápios</a>
            <a class="button" href="#">Equipamentos</a>
            <a class="button" href="GestaoVisitantes.jsp">Visitas</a>
        </div>
        <div class="content">
            <a class="back-button" href="javascript:history.back()"><img src="./imgs/Voltar.png"><div class="title">Gestão de prontuarios</div></a>
           
            <!-- tela para o funcionario/medico ver os prontuarios do morador -->
            
            <div id="prontuarios">
                <form action="Facade" method="POST">
                    <input type="hidden" name="act" value="ListarProntuario">
                    <input type="hidden" name="moradorCPF" value="" class = "cpfSolicitado" id="cpfMorador">      
                    <input type="hidden" name="origem" value = "Morador"> 
                    <input type="submit">  
                </form>
                <div id="conteudo">
                    
                  <% 
         
                    List<Prontuario> prontuarios = (List<Prontuario>)request.getAttribute("prontuarios");
   
                    if(prontuarios == null){
                    %>
                        <article id="aviso">
                        <div>
                            <p>não há prontuarios relacionadas a esse morador</p>
                        </div>
                        </article>
                          <%
                    }else{
              
                    for(Prontuario pront: prontuarios){
                    %>
                    <article id="prontuario" class="prontuario">
                        <div id="DadosProntuario">
                            <div id="data">
                            <p id="date"><%=pront.getData()%></p>
                            </div>
                            <div id="dados">
                            <p id="pressao">Pressao: <%=pront.getPressao()%></p>
                            <p id="temperatura">Temperatura: <%=pront.getTemperatura()%></p>
                            <p id="refeicao">Descrição das Refeicoes: <%=pront.getObservacaoRefeicao()%></p>
                            <p id="respiracao">Respiracao: <%=pront.getFrequenciaRespiratoria()%></p>
                            <p id="obs">Observacoes: <%=pront.getObservacoes()%></p>
                            
                            </div>
                        </div>
                    </article>
                        
                        <%
                        }
        }
                    %>
                </div>
            </div>
                <script>
                    window.onload = function() {
                    let cpf = document.getElementById("cpfMorador");
                    cpf.value = localStorage.getItem('cpf');
                    console.log(cpf.value);
                };
                </script>
    </body>
</html>

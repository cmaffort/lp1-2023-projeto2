<%-- 
    Document   : GestãoComodos
    Created on : 28 de nov. de 2023, 10:58:55
    Author     : felli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "br.cefetmg.casaderepouso.dto.Comodo"%>
<%@page import = "java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/GestaoComodos.css">
        
        <title>GestaoComodo</title>
    </head>
    <body>
        <%@include file="Padrão/navFuncionario.jsp" %>

        <div id="content">
            <article>

                <a class="back-button" href="javascript:history.back()"><img src="./imgs/Voltar.png"></a>
                <div class="title">Gestão de Comodos</div>
                <div id="cabecalho">
                    <form action="Facade" method="POST">
                        <input type="hidden" name="act" value="ListarComodos">
                        <label class="condicao">Condição<br><select id="condicao" required>
                                <option value="OCUPADO">ocupado</option>
                                <option value="MANUTENCAO" selected>manutenção</option>
                                <option value="LIVRE">livre</option>
                            </select>
                            <input type='submit' value='recarregar'>
                        </label>
                    </form>
                    <button onclick="MostraCondicao()">filtrar</button>
                    <button id="botao" onclick="ToggleForm()">cadastrar</button>

                </div>

                <%   
List<Comodo> ocupado = (List<Comodo>)request.getAttribute("ocupado");
List<Comodo> manutencao = (List<Comodo>)request.getAttribute("manutencao");
List<Comodo> livre = (List<Comodo>)request.getAttribute("livre");

int quant = 0;
if(ocupado != null)
    quant += ocupado.size();                   
if(manutencao != null)
    quant += manutencao.size();
if(livre != null)
    quant += livre.size();
                    


int capacidade = 0;
                %>


                <div id="listar">

                    <%
               
                                        if(ocupado != null){
                                      for(Comodo ocu: ocupado){
                                        capacidade += ocu.getCapacidade();
                    %>

                    <article class="ocupado">
                        <div class="comodoDIV">
                            <input type="hidden" name="ID" value="<%=ocu.getId()%>">
                            <p class="nome">Nome: <%=ocu.getNome()%></p>
                            <p class="condi">Condição: <%=ocu.getCondicao()%></p>
                            <p class="capac">Capacidade: <%=ocu.getCapacidade()%></p>
                            <p class="desc">Descrição: <%=ocu.getDescricao()%></p> 
                            <p class="revi">ultima revisão: <%=ocu.getRevisao()%></p> 

                            <div>
                                <form action="Facade" method="POST" class="apagar">
                                    <input type="hidden" name="act" value="deleteComodo">
                                    <input type="hidden" name="ID" value="<%=ocu.getId()%>">
                                    <button type="submit" class="bot" id="excluir">EXCLUIR</button>
                                </form>
                            </div>
                        </div>
                    </article>   
                    <%
                        }
}       %>

                    <%
                if(manutencao != null){
                        for(Comodo manu: manutencao){
                        capacidade += manu.getCapacidade();
                    %> 

                    <article class="manutencao">
                        <div class="comodoDIV">
                            <input type="hidden" name="ID" value="<%=manu.getId()%>">
                            <p class="nome">Nome: <%=manu.getNome()%></p>
                            <p class="condi">Condição: <%=manu.getCondicao()%></p>
                            <p class="capac">Capacidade: <%=manu.getCapacidade()%></p>
                            <p class="desc">Descrição: <%=manu.getDescricao()%></p>   
                            <p class="revi">ultima revisão: <%=manu.getRevisao()%></p> 

                            <div>
                                <form action="Facade" method="POST" class="apagar">
                                    <input type="hidden" name="act" value="deleteComodo">
                                    <input type="hidden" name="ID" value="<%=manu.getId()%>">
                                    <button type="submit" class="bot" id="excluir">EXCLUIR</button>
                                </form>
                            </div>
                        </div>
                    </article> 


                    <%
                        }
                    %>


                    <%
}if(livre != null){
for(Comodo liv: livre){
            capacidade += liv.getCapacidade();
                    %>

                    <article class="livre">
                        <div class="comodoDIV">
                            <input type="hidden" name="ID" value="<%=liv.getId()%>">
                            <p class="nome">Nome: <%=liv.getNome()%></p>
                            <p class="condi">Condição: <%=liv.getCondicao()%></p>
                            <p class="capac">Capacidade: <%=liv.getCapacidade()%></p>
                            <p class="desc">Descrição: <%=liv.getDescricao()%></p> 
                            <p class="revi">ultima revisão: <%=liv.getRevisao()%></p> 

                            <div>
                                <form action="Facade" method="POST" class="apagar">
                                    <input type="hidden" name="act" value="deleteComodo">
                                    <input type="hidden" name="ID" value="<%=liv.getId()%>">
                                    <button type="submit" class="bot" id="excluir">EXCLUIR</button>
                                </form>
                            </div>
                        </div>
                    </article> 


                    <%
                        }}
                    %>
                </div>

        </div>



        <div id="casa-repouso">
            <p>quantidade de comodos: <%=quant%></p>
            <p>capacidade da casa: <%=capacidade%></p>
        </div>


        <div id="formulario">
            <form action="Facade" method="POST" id="Cadastro-form" >
                <input type="hidden" name="act" value="CadastrarComodo">
                <div class="inputs" >
                    <label> Nome:<input type="text" name="nome" class="nome" onchange="validarFormulario()"></label><br>
                    <span id="nomeErro" style="color: red;"></span>
                </div>
                <div class="inputs">
                    <label> capacidade do comodo:<input type="text" name="capacidade" class="capacidade" onchange="validarFormulario()"></label><br>
                    <span id="capaErro" style="color: red;"></span>
                </div>
                <div class="inputs">
                    <label> ultima revisão:<input type="date" name="revisao" class="revisao" onchange="validarFormulario()"></label><br>
                    <span id="reviErro" style="color: red;"></span>
                </div>
                <div class="inputs">
                    <label class="condicao">Condicao dos comodos<br><select name="condicao" class="condicao"><br>
                            <option value="OCUPADO">ocupado</option>
                            <option value="MANUTENCAO" selected>manutenção</option>
                            <option value="LIVRE">livre</option>

                        </select>
                        
                    </label>
                    <span id="condErro" style="color: red;"></span>
                </div>
                <div class="inputs">
                    <label>descricao do comodo<br>
                        <textarea id="texto" name="descricao" rows="10" cols="50" class="descricao" onchange="validarFormulario()"></textarea>
                    </label>
                    <span id="descErro" style="color: red;"></span>
                </div>


                <input type="submit">
            </form>
        </div>

    </article>
</div>  
<script src="scripts/gestaoComodos.js"></script>
</body>
</html>

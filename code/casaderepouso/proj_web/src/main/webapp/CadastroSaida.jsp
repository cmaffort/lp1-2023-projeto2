<%-- 
    Document   : CadastroSaida
    Created on : 20 de nov. de 2023, 08:58:54
    Author     : rigor
--%>

<%@page import="br.cefetmg.casaderepouso.service.IManterMorador" %>
<%@page import="br.cefetmg.casaderepouso.service.implement.ManterMorador" %>
<%@page import="br.cefetmg.casaderepouso.dto.Morador" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title>Cadastro de Saída Temporária</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">
    </head>
    <body>
        <article>
            <a class="back-button" href="telaFuncionario.jsp"><img src="./imgs/Voltar.png"></a>
            <h1>Cadastro de Saída Temporária</h1>
            <form class="form-container" action="Facade" method="POST">
                <div class="form-group">
                    <label>Motivo da saída:</label>
                    <input type="text" name="motivo" class="texto" placeholder="Digite aqui..." required>
                </div>
                <div class="form-group">
                    <label>Morador que sairá:</label>
                    <select id="moradorSelecionado" class="texto" onchange="atualizarAtributos()">
                        <%
                            IManterMorador iMorador = new ManterMorador();
                            List<Morador> listaMoradores = iMorador.pesquisarTodos(); 
                            String cpfMor = (String) session.getAttribute("cpfMorador");
                            if(cpfMor != null){
                                if(listaMoradores != null){
                                    for (Morador mor: listaMoradores) {
                                        if(mor.getCpf().equals(cpfMor)){
                        %>
                        <option nomeMorador="<%=mor.getNome()%>"
                                cpf="<%=mor.getCpf()%>"
                                dataNasc="<%=mor.getDataNasc()%>"
                                estado="Saída Temporária"
                                plano_medico="<%=mor.getPlanoMedico()%>"
                                nome_mae="<%=mor.getNomeMae()%>"
                                endereco="<%=mor.getEndereco()%>"
                                condicoes_especiais="<%=mor.getCondicaoEspecial()%>"
                                ><%=mor.getNome()%></option>       
                        <%
                                        }
                                    }
                                }
                            }
                                else{ 
                                    if(listaMoradores != null){
                                       for (Morador mor: listaMoradores) {

                        %>
                        <option nomeMorador="<%=mor.getNome()%>"
                                cpf="<%=mor.getCpf()%>"
                                dataNasc="<%=mor.getDataNasc()%>"
                                estado="Saída Temporária"
                                plano_medico="<%=mor.getPlanoMedico()%>"
                                nome_mae="<%=mor.getNomeMae()%>"
                                endereco="<%=mor.getEndereco()%>"
                                condicoes_especiais="<%=mor.getCondicaoEspecial()%>"
                                ><%=mor.getNome()%></option>
                        <%
                                        }
                                    }
                                }
                        %>
                    </select>
                    <input type="hidden" id="nomeHidden" name="nomeMorador" value="">
                    <input type="hidden" id="cpfHidden" name="cpf" value="">
                    <input type="hidden" id="dataNascHidden" name="dataNasc" value="">
                    <input type="hidden" id="estadoHidden" name="estado" value="">
                    <input type="hidden" id="planoHidden" name="plano_medico" value="">
                    <input type="hidden" id="maeHidden" name="nome_mae" value="">
                    <input type="hidden" id="enderecoHidden" name="endereco" value="">
                    <input type="hidden" id="condicaoHidden" name="condicoes_especiais" value="">

                </div>

                <div class="form-group">
                    <label>Dia da saída:</label>
                    <input type="date" name="dataSaida" class="texto" placeholder="Digite aqui uma data dd/mm/aa ..." required>
                    <label>Horário:</label>
                    <input type="time" name="horarioSaida" class="texto" placeholder="hh:mm..." required>
                </div>

                <div class="form-group">
                    <label>Dia da volta:</label>
                    <input type="date" name="dataVolta" class="texto" placeholder="Digite aqui uma data dd/mm/aa ..." required>
                    <label>Horário:</label>
                    <input type="time" name="horarioVolta" class="texto" placeholder="hh:mm..." required>
                </div>

                <button type="submit" name="act" value="CadastroSaida">Agendar</button>
            </form>
        </article>
        <script>
            function atualizarAtributos() {
                var select = document.getElementById("moradorSelecionado");
                var selectedOption = select.options[select.selectedIndex];

                document.getElementById("cpfHidden").value = selectedOption.getAttribute("cpf");
                document.getElementById("nomeHidden").value = selectedOption.getAttribute("nomeMorador");
                document.getElementById("dataNascHidden").value = selectedOption.getAttribute("dataNasc");
                document.getElementById("estadoHidden").value = selectedOption.getAttribute("estado");
                document.getElementById("planoHidden").value = selectedOption.getAttribute("plano_medico");
                document.getElementById("maeHidden").value = selectedOption.getAttribute("nome_mae");
                document.getElementById("enderecoHidden").value = selectedOption.getAttribute("endereco");
                document.getElementById("condicaoHidden").value = selectedOption.getAttribute("condicoes_especiais");
                console.log("teste");

            }

            window.onload = function () {
                atualizarAtributos();
            };
        </script>
    </body> 
</html>
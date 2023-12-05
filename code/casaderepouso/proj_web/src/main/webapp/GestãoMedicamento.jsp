<%-- 
    Document   : GestãoMedicamento
    Created on : 15 de out. de 2023, 14:51:58
    Author     : felli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "br.cefetmg.casaderepouso.dto.Medicamento"%>
<%@page import = "java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Gestão de Medicamentost</title>
        <link href="https://fonts.googleapis.com/css2?family=Gabarito:wght@400;500;700&display=swap" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="cssFiles/gestãoMedicamento.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <%@include file="Padrão/navFuncionario.jsp" %>

        <div id="main">
            
            <div id="solicitados">
                <form action="Facade" method="POST">
                    <input type="hidden" name="act" value="ListarMedicamento">
                    <input type="hidden" name="moradorCPF" value="12345687910" class = "cpfSolicitado">      
                    <input type="hidden" name="origem" value = "GestaoMedicamento"> 
                    <input type="submit" name="act" value="ListarMedicamento" id="listaSolicitado">  
                </form>
                <h1>Medicamento solicitados</h1>
                <div>
                    <% 
         
                    List<Medicamento> listaSolicitados = (List<Medicamento>)request.getAttribute("solicitado");
   
                    if(listaSolicitados == null){
                     System.out.println(request.getAttribute("solicitado"));
                     System.out.println("solicitados null");
                    
                    %>
                    <article class="alerta">
                        <div>
                            <p>não há solicitação de medicamentos relacionadas a esse morador</p>
                        </div>
                    </article>

                    <%
                    }else{
                    System.out.println("solicitados não null");
                    for(Medicamento medSol: listaSolicitados){
                    %>
                    <article>
                        <div id="medicamento">
                            <p class="nome"><%=medSol.getNome()%></p>
                            <p class="quant"><%=medSol.getTarja()%></p>
                            <p class="fornecedor"><%=medSol.getValor()%></p>

                            <form action="Facade" method="POST">
                                <input type="hidden" name="act" value="ExcluirMedicamento">
                                <input type="hidden" name="ID" value="<%=medSol.getId()%>">
                                <button type="submit" class="bot" id="excluir">X</button>
                            </form>

                            <form action="Facade" method="POST">
                                <input type="hidden" name="act" value="AtualizarMedicamento">
                                <input type="hidden" name="ID" value="<%=medSol.getId()%>">
                                <button type="submit" class="bot" id="atualizar" name="act" value="AtualizarMedicamento">-></button>
                            </form>
                        </div>
                    </article><%
                        }
        }
                    %>

                </div>  
                <a href="CadastroMedicamento.jsp" id="solicitar">Adicionar</a>
            </div>











            <div id="estoque">
                <form action="Facade" method="POST">
                    <input type="hidden" name="act" value="ListarMedicamento">
                    <input type="hidden" name="moradorCPF" value = "12345687910" id="cpfEstoque">
                    <input type="hidden" name="origem" value = "GestaoMedicamento"> 
                    <input type="submit" name="act" value="ListarMedicamento" id="listaEstoque">  
                </form>
                <h1>Medicamento estoque</h1>
                <div>
                    <% 
                       List<Medicamento> listaComprado = (List<Medicamento>)request.getAttribute("comprado");
        
                       if(listaComprado == null || listaComprado.size() == 0){
           
                    %>
                    <article class="alerta">
                        <div>
                            <p>não há medicamentos em estoque relacionadas a esse morador</p>
                        </div>
                    </article>

                    <%
                    }

        else {
        for(Medicamento medCom: listaComprado){
                    %>
                    <article>
                        <div id="medicamentoEstoque">
                            <p class="nome"><%=medCom.getNome()%></p>
                            <p class="quant"><%=medCom.getDose()%></p>
                            <p class="fornecedor"><%=medCom.getTarja()%></p>
                            <p class="dataCompra"><%=medCom.getValidade()%></p>

                            <form action="Facade" method="POST" class="formExcluirUnico">
                                <input type="hidden" name="act" value="ExcluirMedicamento">
                                <input type="hidden" name="ID" value="<%=medCom.getId()%>">
                                <button type="submit" class="bot" id="excluir">X</button>
                            </form>



                        </div>
                    </article><%
                        }
}
                    %>
                </div>
            </div>

        </div>
        <script>
            //document.getElementById('cpfSolicitado').value = '12345687910';
            //document.getElementById('cpfEstoque').value = '12345687910';
            //document.getElementbyId('moradorCPF').value = '12345687910';
            //localStorage.cpf//



        </script>
    </body>
</html>

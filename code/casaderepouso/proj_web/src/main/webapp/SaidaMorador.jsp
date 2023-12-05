<%@page import="br.cefetmg.casaderepouso.service.IManterSaida" %>
<%@page import="br.cefetmg.casaderepouso.service.implement.ManterSaida" %>
<%@page import="br.cefetmg.casaderepouso.dto.SaidaTemporaria" %>
<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saídas agendadas</title>
        <link rel="stylesheet" type="text/css" href="cssFiles/saidaMorador.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Gabarito:wght@500&family=Sofia+Sans:wght@500&display=swap" rel="stylesheet">
    
        
  
    
    </head>
    <body>
        <div class="container">
        <div class="nav">
            <a class="button" href="TelaInicialResponsavel.jsp">Tela Inicial</a>
            <a class="button" href="pagamento.jsp">Pagar mensalidade</a>
            <a class="button" href="CadastroSaida.jsp">Cadastro de Saída</a>
            <a class="button" href="#">Cancelar Vínculo</a>
        </div> 
        <div class = "content">
            <%
                 IManterSaida iSaida = new ManterSaida();
                 List<SaidaTemporaria> listaSaida = iSaida.pesquisarTodos();
                 String cpfMor = (String) session.getAttribute("cpfMorador");
                 if(listaSaida != null){
                    
                     for(SaidaTemporaria saida: listaSaida){
                         if(saida.getMoradorCpf().equals(cpfMor)){
                         /*Aqui terá um if(saida.getMoradorCpf == cpf)
                         Esse cpf é o cpf do morador vinculado ao responsável, 
                         que o atributo foi setado no cookie*/                         
            %>
            <div class="saida-div" data-retorno="<%=saida.getDataVolta()%>">
                
                <p>Nome do morador: <%= saida.getNome()%></p>
                <p>Motivo: <%=saida.getMotivo()%></p>
                <p>Data de saída: <%= saida.getDataSaida()%></p>
                <p>Horário da saída: <%= saida.getHorarioSaida()%></p>
                <p>Data de Retorno: <%= saida.getDataVolta()%></p>
                <p>Horário de retorno: <%= saida.getHorarioVolta()%></p>
               <button class="botao-atualizar" onclick="mostrarAtualizarContainer('<%=saida.getNome() + '_' + saida.getId()%>')">Atualizar</button>

            </div>

            <div class="atualizar-container" id="<%=saida.getNome() + '_' + saida.getId()%>">
                <form class="form-container"  action="Facade" method="POST">
                    <div class="form-group">
                        <input type="hidden" name="idSaida" value="<%=saida.getId()%>">

                    </div>
                        <div class="form-group">
                        <label>Motivo:</label>
                        <input type="text" name="motivo" value="<%=saida.getMotivo()%>" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Data de Saída:</label>
                        <input type="text" name="dataSaida" value="<%=saida.getDataSaida()%>" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Horario Saida:</label>
                        <input type="text" name="horarioSaida" class="texto" value="<%=saida.getHorarioSaida()%>" placeholder="Digite aqui..." >
                    </div>
                    <div class="form-group">
                        <label>Data Retorno:</label>
                        <input type="text" name="dataVolta" value="<%=saida.getDataVolta()%>" class="texto" placeholder="Digite aqui..." >
                    </div>

                    <div class="form-group">
                        <label>Horario Retorno:</label>
                        <input type="text" name="horarioVolta" value="<%=saida.getHorarioVolta()%>" class="texto" placeholder="Digite aqui..." >
                    </div>
                    <div>
                        <button name="act" value="atualizarSaidaMorador" style="width: 100%;" class="update-status">Atualizar saída</button>
                        <a class="cancelUpdate" onclick="esconderAtualizarContainer('<%=saida.getNome() + '_' + saida.getId()%>')">Cancelar</a>
                    </div>
                </form>
            </div>

            <%  
                }
                }
             }
            %>
        </div>
        </div>
        <script src="scripts/saidaMorador.js"></script>
    </body>
</html>

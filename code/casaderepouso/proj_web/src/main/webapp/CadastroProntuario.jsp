<%-- 
    Document   : cadastroProntuario
    Created on : 10 de nov. de 2023, 11:17:45
    Author     : felli
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "br.cefetmg.casaderepouso.dto.Medicamento"%>
<%@page import = "java.util.List" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <link rel="stylesheet" type="text/css" href="cssFiles/CadastroProntuario.css">
        <title>Gestão de prontuario</title>
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
        <div class="content" id="content">
            <a class="back-button" href="javascript:history.back()"><img src="./imgs/Voltar.png"></a>
            <div class="title">Cadastrar Prontuario</div>
            <form action="Facade" method="POST" id="formulario">
                <input type="hidden" name="act" value="CadastraProntuario">
                <div id="morador">
                    <input type="hidden" id="morador" name="morador" class="input" value="12345687910" required><br>
                </div>
                <div id="pressao">
                    <label>pressao arterial:<input type="text" id="pressao" name="pressao" class="input" required></label><br>
                </div>
                <div id="cardiaca">
                    <label>frequencia Cardiada:<input type="text" id="FreCardiaca" name="FreCardiaca" class="input" required></label><br>
                </div>
                <div id="respiratoria">
                    <label>Frequencia Respiratoria:<input type="text" id="FreRespiratoria" name="FreRespiratoria" class="input" required></label><br>
                </div>
                <div id="temperatura">
                    <label>Temperatura corporal<input type="text" id="temperatura" name="temperatura" class="input" required></label><br>
                </div>
                
                <div class="obs" id="obsRefeicao">
                    <label>Observações sobre a refeição<br>
                        <textarea id="texto" name="ObsRefeicao" rows="10" cols="50"></textarea>
                    </label><br>
                </div>
                <div class="obs" id="obsMedicamento">
                    <label>observação sobre medicamentos<br>
                        <textarea id="texto" name="ObsMedicamento" rows="10" cols="50"></textarea>
                    </label><br>
                </div>
                <input type="submit">
            </form>
            
            
            
            <div id = "listaMedicamentos">
            <div id="form">
                <form action="Facade" method="POST">
                    <input type="hidden" name="act" value="ListarMedicamento">
                    <input type="hidden" name="origem" value = "Prontuario"> 
                    <input type="hidden" name="moradorCPF" value = "12345687910" id="cpf">
                    <input type="submit" id="BotaoMedicamento">
                </form>
              
                <div id="medicamentos">           
                    <% 
                       List<Medicamento> lista = (List<Medicamento>)request.getAttribute("comprado");
                           if(lista == null || lista.size() == 0){
                    %>
                    <article id="aviso">
                        <div>
                            <p>não há medicamentos em estoque relacionadas a esse morador</p>
                        </div>
                    </article>
                    <%
                                       }

                           else {
                           for(Medicamento med: lista){
                    
                    %>
                    <article class="medicamentoLista" >
                        <input type="hidden" name="medicamento" class="id" value="<%=med.getId()%>">
                            <p id="nome"><%=med.getNome()%></p>
                            <p id="aplicacao">ultima Aplicação:<%=med.UltimaAplicacaoToString()%></p>
                            <p id="dose">dose:<%=med.getDose()%></p>
                        
                    </article>
                    <%
                                        }
                }
                    %>

                </div>
            </div>
        </div>
        </div>    


    </body>
    
    
    <script>

    


        //let morador = document.getElementById('cpf');
        //morador.value = localStorage.getItem('cpf');
        
        
       let content = document.getElementById('content');          
       let medicamentos = document.querySelectorAll(".medicamentoLista");
       
       let minhaDiv = document.getElementById('DIVcriada');
        medicamentos.forEach(med => {
        med.addEventListener("click", () => {
        // Remover div existente, se houver
        minhaDiv = document.getElementById('DIVcriada');
        
        if (minhaDiv) {
            minhaDiv.remove();
        }

        // Remover itens antigos do localStorage, se existirem
        if (localStorage.getItem("idMedicamento") && localStorage.getItem("nomeMedicamento")) {
            localStorage.removeItem("idMedicamento");
            localStorage.removeItem("nomeMedicamento");
            console.log("removido");
        }

        // Obter informações do medicamento
        let id = med.children[0].value;
        let nome = med.children[1].innerHTML;

        // Armazenar informações no localStorage
        localStorage.setItem("nomeMedicamento", nome);
        localStorage.setItem("idMedicamento", id);
        console.log(localStorage.getItem("idMedicamento") + "->" + localStorage.getItem("nomeMedicamento"));
     
        // Criar a div com estrutura HTML
        let divHtml = `
            
                <form class="meuForm" id="meuForm">
                    <input type="hidden" name="act" value="AtualizaHorarioMedicamento">
                    <p id="paragrafo"><p>
                    <input type="hidden" name="medicamento" id="medicamentoID">
                    <input type="time" name="novaAplicacao">
                    <input type="submit">
                </form>
                <div>
                  <button id="fechar">fechar</button>
                </div>
            
        `;

        // Converter a string HTML em elementos reais
        let div = document.createElement('div');
        div.class="DIVcriada";
        div.id="DIVcriada";
        div.innerHTML = divHtml;
        // Adicionar a div ao corpo do documento
        content.appendChild(div);
        
        document.getElementById('medicamentoID').value = localStorage.getItem("idMedicamento");
        document.getElementById('paragrafo').innerHTML = localStorage.getItem("nomeMedicamento");
        
        
         botaoFechar = document.getElementById('fechar');
            
            botaoFechar.addEventListener("click", () => {
                div = document.getElementById('DIVcriada');
                div.remove();
                
            });
    });
});

//pega o medico pelo cokkie usado no login
    </script>


</html>



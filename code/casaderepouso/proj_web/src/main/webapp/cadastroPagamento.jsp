<%-- 
    Document   : cadastroPagamento
    Created on : 25 de nov. de 2023, 09:09:08
    Author     : Júlia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/cadastroPagamento.css">
        <title>Novo pagamento</title>
    </head>
    <body>
        <h1>Adicionar novo pagamento</h1>
        <form action="Facade" method="POST">
            <input type='hidden' name='act' value='CadastrarPagamento'>
            <article class="form-container">
                <div class="form-esquerda">
                    <div class="form-group">
                        <label>Nome do destinatário</label>
                        <input type="text" name="nomeDestinatario" class="texto" placeholder="Digite aqui..." required>
                    </div>

                    <div class="form-group">
                        <label>Nome do pagante</label>
                        <input type="text" name="nomePagante" class="texto" placeholder="Digite aqui..." required>
                    </div>

                    <div class="form-group">
                        <label>Telefone de contato</label>
                        <input type="text" name="numero" class="texto" placeholder="Digite aqui..." required>
                    </div>

                    <div class="form-group">
                        <label>Identidade do pagante</label>
                        <input type="text" name="identidade" class="texto" placeholder="Digite aqui..." required>
                    </div>


                    <div class="form-group" id="marcar">
                        <div>
                            <label id="calendario" required>Data:</label>
                            <input type="date" name="data">
                        </div>
                        <div>
                            <label id="Hora" required>Hora:</label>
                            <input type="time" name="hora">
                        </div>
                    </div>
                </div>

                <div class="form-direita">
                    <label>Descrição do pagamento:</label>
                    <textarea class="descricao" name="descricao" placeholder="Digite aqui..." required></textarea>
                </div>
            </article>
            <div id="botoes">
                <input type="text" name="valor" class="texto" placeholder="Valor pago R$..." required style="width: 20%">
                <button style="background-color:#2882EB; color: white" type="submit">Adicionar</button>
            </div>
        </form>
    </body>
</html>

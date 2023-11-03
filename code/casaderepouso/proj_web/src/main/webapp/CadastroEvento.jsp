<%-- 
    Document   : CadastroEvento
    Created on : 3 de nov. de 2023, 15:05:50
    Author     : rigor
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            // Função que verifica o formato da data
            function validarData(input) {
                var dataRegex = /^(\d{2})\/(\d{2})\/(\d{4})$/;
                var mensagemErro = document.getElementById("dataErro");

                if (dataRegex.test(input.value)) {
                    input.style.borderColor = "green";
                    mensagemErro.textContent = "";
                } else {
                    input.style.borderColor = "red";
                    mensagemErro.textContent = "Formato de data inválido. Use dd/mm/aaaa.";
                }
            }
            //verifica o formato do horário
            function validarHorario(input) {
                var horarioRegex = /^(\d{2})\:(\d{2})$/;
                var mensagemErro = document.getElementById("horarioErro");

                if (horarioRegex.test(input.value)) {
                    input.style.borderColor = "green";
                    mensagemErro.textContent = "";
                } else {
                    input.style.borderColor = "red";
                    mensagemErro.textContent = "Formato de horário inválido. Use hh:mm.";
                }
            }
            //verifica o formato do numero
            function validarTelefone(input) {
                var telefoneRegex = /^\d{2} 9\d{4}-\d{4}$/;
                var mensagemErro = document.getElementById("foneErro");

                if (telefoneRegex.test(input.value)) {
                    input.style.borderColor = "green";
                    mensagemErro.textContent = "";
                } else {
                    input.style.borderColor = "red";
                    mensagemErro.textContent = "Formato de telefone inválido. Use XX 9XXXX-XXXX.";
                }
            }
            //verifica o formato do email
            function validarEmail(input) {
                var emailRegex = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
                var mensagemErro = document.getElementById("emailErro");

                if (emailRegex.test(input.value))
                    mensagemErro.textContent = "";
                else
                    mensagemErro.textContent = "Formato de e-mail inválido.";
            }

        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Evento</title>
        <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Gabarito:wght@500&family=Sofia+Sans:wght@500&display=swap" rel="stylesheet">
    </head>
    <body>
        <article>
            <div>
                <h1>Cadastro de evento</h1>
                <form class="form-container" action="Facade" method="POST">

                    <div class="form-group">
                        <label>Nome completo:</label>
                        <input type="text" name="nomeOrganizador" class="texto" placeholder="Digite aqui..." required>                
                    </div>
                    <div class="form-group">
                        <label>RG:</label>
                        <input type="text" name="rg" class="texto" placeholder="Digite aqui..." required>                
                    </div>
                    <div class="form-group">
                        <label>O que será o evento?</label>
                        <input type="text" name="descricao" class="texto" placeholder="Digite aqui..." required>                
                    </div>
                    <div class="form-group">
                        <label>Onde ocorrerá:</label>
                        <input type="text" name="local" class="texto" placeholder="Digite aqui..." required>                
                    </div>
                    <div class="form-group">
                        <label>Data do evento:</label>
                        <input type="text" onkeyup="validarData(this)" name="data" class="texto" placeholder="Digite aqui a data dd/mm/aaaa ..." required>
                        <p id="dataErro" style="color: #990000; font-weight: bold;"></p>
                    </div>
                    <div class="form-group">
                        <label>Horário:</label>
                        <input type="text" onkeyup="validarHorario(this)" name="horario" class="texto" placeholder="Digite aqui o horário hh:mm ..." required>                
                        <p id="horarioErro" style="color: #990000; font-weight: bold;"></p>
                    </div>

                    <div class="form-group">
                        <label>Número de contato:</label>
                        <input type="text" onkeyup="validarTelefone(this)" name="telefone" class="texto" placeholder="Digite aqui..." required>                
                        <p id="foneErro" style="color: #990000; font-weight: bold;"></p>
                    </div>
                    <div class="form-group">
                        <label>Email:</label>
                        <input type="text" name="email" onkeyup="validarEmail(this)" class="texto" placeholder="Digite aqui..." required>
                        <p id="emailErro" style="color: #990000; font-weight: bold;"></p>
                    </div>




                    <button type="submit" class="envio" name="act" value="cadastrarEvento">Cadastrar</button>
                </form>
            </div>
        </article>


    </body>
</html>

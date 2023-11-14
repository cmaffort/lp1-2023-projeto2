<%-- 
    Document   : CadastroFuncionário
    Created on : 3 de out. de 2023, 10:56:43
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
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
            function validarRg(input) {
                var rgRegex = /^\d{8}$/;
                var mensagemErro = document.getElementById("rgErro");

                if (rgRegex.test(input.value))
                    mensagemErro.textContent = ""; 
                else 
                    mensagemErro.textContent = "Formato de RG inválido. Deve ter 8 números.";
                
            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Funcionário</title>
        <link rel="stylesheet" type="text/css" href="cssFiles/Cadastro.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Gabarito:wght@500&family=Sofia+Sans:wght@500&display=swap" rel="stylesheet">
    </head>
    <body>
        <article>
            <div>
                <h1>Cadastro de funcionário</h1>
                <form class="form-container" action="Facade" method="POST">

                    <div class="form-group">
                        <label>Nome completo:</label>
                        <input type="text" name="nomeFuncionario" class="texto" placeholder="Digite aqui..." required>                
                    </div>
                    <div class="form-group">
                        <label>CPF:</label>
                        <input type="text" name="cpf" class="texto" placeholder="Digite aqui..." required>                
                    </div>
                    <div class="form-group">
                        <label>RG:</label>
                        <input type="text" onkeyup="validarRg(this)" name="rg" class="texto" placeholder="Digite aqui..." required>
                        <p id="rgErro" style="color: #990000; font-weight: bold;"></p>
                    </div>
                    <div class="form-group">
                        <label>Data de Nascimento:</label>
                        <input type="text" onkeyup="validarData(this)" name="dataNasc" class="texto" placeholder="dd/mm/aaaa..." required>
                        <p id="dataErro" style="color: #990000; font-weight: bold;"></p>
                    </div>
                    <div class="form-group">
                        <label>Endereço completo:</label>
                        <input type="text" name="endereco" class="texto" placeholder="Digite aqui..." required>                
                    </div>
                    <div class="form-group">
                        <label>Numero de contato:</label>
                        <input type="text" onkeyup="validarTelefone(this)" name="telefone" class="texto" placeholder="Digite aqui..." required>
                        <p id="foneErro" style="color: #990000; font-weight: bold;"></p>
                    </div>
                    <div class="form-group">
                        <label>PIS:</label>
                        <input type="text" name="pis" class="texto" placeholder="Digite aqui..." required>                
                    </div>
                    <div class="form-group">
                        <label> Função:</label>
                        <input type="text" name="funcao" class="texto" placeholder="Digite aqui..." required>                
                    </div>
                    <div class="form-group">
                        <label>Periodo de trabalho:</label>
                        <input type="text" name="periodo" class="texto" placeholder="Digite aqui..." required>                
                    </div>


                    <button type="submit" class="envio" name="act" value="cadastrarFuncionario">Cadastrar</button>
                </form>
            </div>
        </article>


    </body>
</html>

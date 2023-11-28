<%-- 
    Document   : pagamento
    Created on : 26 de nov. de 2023, 10:33:35
    Author     : Master
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="cssFiles/pagamento.css">
        <title>Tela de Pagamento</title>
    </head>
    <body>
        <div id="pagamento-info">
            <h1>Pagamento mensalidade</h1>
            <div id="pagamento-container">
                <div id="pagamento-descricao">
                    <span id="info-top">
                        <h2>Descrição do pagamento</h2>
                        <p><span id="meses">1x</span> - Mensalidade Asilo <span id="nome-morador">"Nome"</span>  De xx/xx/xxxx até xx/xx/xxxx</p>
                        <span id="botaoMes">
                            <img id="addMes" src="./imgs/+.png">
                            <img id="subMes" src="./imgs/-.png">
                        </span>
                    </span>
                    <p>Total a pagar:  <span id="preco-total">R$ 120,00</span></p>
                </div>
                <div id="pagamento-selecionar">
                    <h2>Selecione a forma de pagamento</h2>
                    <div id="pagamento-formas"><img src="./imgs/Visa.png"><img src="./imgs/MASTERCARD.png"><img src="./imgs/PIX.png"></div>
                </div>
            </div>
        </div>
        <div id="pagamentoCartao">
            <a class="back-button" href="telaFuncionario.jsp""><img src="./imgs/Voltar.png"></a>
            <div id="pagamento-container-cartao">
                <span>
                    <h2>Forma de pagamento</h2>
                    <img id="marca-cartao"src="./imgs/Visa.png">
                    <div id="botao-cartoes-salvos">
                        <p>Cartões Salvos</p>
                    </div>
                </span>
                <form id="cartao-info">
                    <div class="form-group">
                        <input type="text" name="numero" id="numero" class="texto" placeholder="Número do cartão" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="nome" id="nome" class="texto" placeholder="Nome do cartão" required>
                    </div>
                    <div class="form-group">
                        <input type="text" name="validade" id="validade" class="texto" placeholder="MM/AA" maxlenght="5" pattern="\d{2}/\d{2}" required>
                    </div>
                    <div class="form-group">
                        <input type="number" name="codigo" id="codigo" class="texto" placeholder="Código de Segurança" maxlenght="3" pattern="\d{3}"required>
                    </div>
                    <input style="display:none;" name="cpf" type="text" value="" id="cpf">
                    <input style="display:none;" name="cardtype" type="text" value="" id="cardtype">
                    <button id="efetua-pagamento"type="submit">Efetuar pagamento</button>
                </form>
            </div>
        </div>
        <div id="pagamentoPIX">
            <div id="qrcode"></div>
        </div>
        <script src="https://cdn.rawgit.com/davidshimjs/qrcodejs/gh-pages/qrcode.min.js"></script>
        <script src="scripts/pagamento.js"></script>
        <script>
            // formato de mm/aa na validade
            document.addEventListener("DOMContentLoaded", function () {
                let input = document.getElementById("validade");

                input.addEventListener("input", function () {
                    formatarData(input);
                });

                function formatarData(input) {
                    let valor = input.value;

                    valor = valor.replace(/\D/g, '');


                    if (valor.length > 2) {
                        valor = valor.substr(0, 2) + '/' + valor.substr(2);
                    }

                    if (valor.length > 5) {
                        valor = valor.substr(0, 5);
                    }

                    input.value = valor;
                }
            });
        </script>
    </body>
</html>

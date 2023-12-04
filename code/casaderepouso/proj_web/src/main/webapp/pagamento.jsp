<%-- 
    Document   : pagamento
    Created on : 26 de nov. de 2023, 10:33:35
    Author     : Master
--%>
<%@page import="br.cefetmg.casaderepouso.dto.Cartao" %>
<%@page import="java.util.List" %>
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
                        <p><span id="meses">1x</span> - Mensalidade Asilo - <span id="nome-morador">"Nome"</span>  De <span id="data-inicio">xx/xx/</span> até <span id="data-vencimento">xx/xx/xxxx</span></p>
                        <span id="botaoMes">
                            <img id="addMes" src="./imgs/+.png">
                            <img id="subMes" src="./imgs/-.png">
                        </span>
                    </span>
                    <p>Total a pagar:  <span id="preco-total">R$<span id="valor-preco">120</span>,00</span></p>
                </div>
                <div id="pagamento-selecionar">
                    <h2>Selecione a forma de pagamento</h2>
                    <div id="pagamento-formas"><img src="./imgs/visa.png"><img src="./imgs/mastercard.png"><img src=""></div>
                </div>
            </div>
        </div>
        <a class="back-button" href="TelaInicialResponsavel.jsp""><img src="./imgs/Voltar.png"></a>
        <div id="pagamentoCartao" style="display: none;">

            <div id="pagamento-container-cartao">
                <span>
                    <h2>Forma de pagamento</h2>
                    <img id="marca-cartao"src="./imgs/visa.png">
                    <div id="botao-cartoes-salvos">
                        <p>Cartões Salvos</p>
                    </div>
                </span>
                <form id="cartao-info" action="Facade" method="POST">
                    <div class="form-group" id="numero">
                        <input type="text" name="numero" id="numeroInput" class="texto" maxlenght="19" placeholder="Número do cartão" required>
                    </div>
                    <div class="form-group" id="nome">
                        <input type="text" name="nome" id="nomeInput" class="texto" placeholder="Nome no cartão" required>
                    </div>
                    <div class="form-group" id="validade">
                        <input type="text" name="validade" id="validadeInput" class="texto" placeholder="MM/AA" maxlenght="5" pattern="\d{2}/\d{2}" required>
                    </div>
                    <div class="form-group" id="codigo">
                        <input type="number" name="codigo" id="codigoInput" class="texto" placeholder="Código de Segurança" maxlenght="3" pattern="\d{3}"required>
                    </div>
                    <input style="display:none;" name="cpf" type="text" value="" id="cpf">
                    <input style="display:none;" name="cardtype" type="text" value="" id="cardtype">
                    <input style="display:none;" name="inicio" type="text" value="" id="inicioInput">
                    <input style="display:none;" name="fim" type="text" value="" id="fimInput">
                    <input style="display:none;" name="cpfMorador" type="text" value="" id="cpfMoradorInput">
                    <input style="display:none;" name="preco" type="text" value="" id="totalPagarInput">
                    <button name="act" value="CadastrarCartao" id="salvar-cartao" type="submit">Salvar cartão</button>
                    <button name="act" value="EfetuarPagamento" id="efetua-pagamento"type="submit">Efetuar pagamento</button>
                </form>
            </div>
        </div>
        <div id="lista-cartoes" style="display:none;">
            <form action="Facade" method="POST">
                <input id="listarCartoes"type="submit" name="act" value="ListarCartao">   
            </form>
            <%
                List<Cartao> cartoes = (List<Cartao>) request.getAttribute("listCar");
                if(cartoes != null){
                for (Cartao car : cartoes) {
            %>
            <div class="cartao-salvo">
                <p style="display:none;"><%=car.getNumero()%></p>
                <p class="numeroEscondido"></p>
                <p style="display:none;"><%=car.getCardtype()%></p>
                <img src="" class="mini-img-cardType">
                <p style="display:none;"><%=car.getNome()%></p>
                <p style="display:none;"><%=car.getValidade()%></p>
            </div>
            <%                   
                }}
            %>
        </div>
        <script src="https://cdn.jsdelivr.net/momentjs/latest/moment.min.js"></script>
        <script src="scripts/pagamento.js"></script>
        <script>
            // formato de mm/aa na validade
            document.addEventListener("DOMContentLoaded", function () {
                let input = document.getElementById("validadeInput");
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

            function formatCardNumber(input) {

                let cardNumber = input.value.replace(/\D/g, '');
                cardNumber = cardNumber.replace(/(\d{4})(?=\d)/g, '$1 ');
                input.value = cardNumber;
            }
            document.getElementById('numeroInput').addEventListener('input', function () {
                formatCardNumber(this);
            });
            document.querySelector('#cartao-info').addEventListener('submit', function (e) {
                // Remove espaços em branco antes de enviar o formulário
                let confirmaQnt = document.getElementById('cardNumber').value.replace(/\s/g, '');

                if (confirmaQnt.length !== 16) {
                    alert('O número do cartão deve ter 16 dígitos.');
                    e.preventDefault(); 
                }
            });
            
        </script>
    </body>
</html>
